// See LICENSE.SiFive for license details.
// See LICENSE.Berkeley for license details.

package freechips.rocketchipRT.groundtest

import Chisel._
import freechips.rocketchipRT.config._
import freechips.rocketchipRT.diplomacy._
import freechips.rocketchipRT.interrupts._
import freechips.rocketchipRT.rocket.{DCache, ICacheParams, NonBlockingDCache, RocketCoreParams}
import freechips.rocketchipRT.tile._
import freechips.rocketchipRT.tilelink._

trait GroundTestTileParams extends TileParams {
  val memStart: BigInt
  val maxRequests: Int
  val numGens: Int
  
  val icache = Some(ICacheParams())
  val btb = None
  val rocc = Nil
  val core = RocketCoreParams(nPMPs = 0) //TODO remove this
  val cached = if(dcache.isDefined) 1 else 0
  val dataScratchpadBytes = 0
}

abstract class GroundTestTile(
  params: GroundTestTileParams,
  crossing: ClockCrossingType,
  lookup: LookupByHartIdImpl,
  q: Parameters
) extends BaseTile(params, crossing, lookup, q)
  with SinksExternalInterrupts
  with SourcesExternalNotifications
{
  val cpuDevice: SimpleDevice = new SimpleDevice("groundtest", Nil)
  val intOutwardNode: IntOutwardNode = IntIdentityNode()
  val slaveNode: TLInwardNode = TLIdentityNode()
  val statusNode = BundleBridgeSource(() => new GroundTestStatus)

  val dcacheOpt = params.dcache.map { dc => LazyModule(
    if (dc.nMSHRs == 0) new DCache(staticIdForMetadataUseOnly, crossing)
    else new NonBlockingDCache(staticIdForMetadataUseOnly)
  )}

  dcacheOpt.foreach { _.hartIdSinkNodeOpt.foreach { _ := hartIdNexusNode } }

  override lazy val module = new GroundTestTileModuleImp(this)
}

class GroundTestTileModuleImp(outer: GroundTestTile) extends BaseTileModuleImp(outer) {
  val status = outer.statusNode.bundle
  val halt_and_catch_fire = None

  outer.dcacheOpt foreach { dcache =>
    val ptw = Module(new DummyPTW(1))
    ptw.io.requestors.head <> dcache.module.io.ptw
  }
}
