// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.subsystem

import freechips.rocketchipRT.config.{Parameters}
import freechips.rocketchipRT.devices.tilelink._
import freechips.rocketchipRT.diplomacy._
import freechips.rocketchipRT.tilelink._
import freechips.rocketchipRT.util.{Location}

case class FrontBusParams(
    beatBytes: Int,
    blockBytes: Int,
    dtsFrequency: Option[BigInt] = None,
    zeroDevice: Option[BuiltInZeroDeviceParams] = None,
    errorDevice: Option[BuiltInErrorDeviceParams] = None)
  extends HasTLBusParams
  with HasBuiltInDeviceParams
  with TLBusWrapperInstantiationLike
{
  def instantiate(context: HasTileLinkLocations, loc: Location[TLBusWrapper])(implicit p: Parameters): FrontBus = {
    val fbus = LazyModule(new FrontBus(this, loc.name))
    fbus.suggestName(loc.name)
    context.tlBusWrapperLocationMap += (loc -> fbus)
    fbus
  }
}

class FrontBus(params: FrontBusParams, name: String = "front_bus")(implicit p: Parameters)
    extends TLBusWrapper(params, name)
    with HasTLXbarPhy {
  val builtInDevices: BuiltInDevices = BuiltInDevices.attach(params, outwardNode)
  val prefixNode = None
}
