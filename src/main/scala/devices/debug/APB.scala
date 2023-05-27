// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.devices.debug
import freechips.rocketchipRT.config._
import freechips.rocketchipRT.diplomacy._
import freechips.rocketchipRT.regmapper._
import freechips.rocketchipRT.amba.apb.{APBRegisterNode}

case object APBDebugRegistersKey extends Field[Map[Int, Seq[RegField]]](Map())

object APBDebugConsts {
  def apbDebugRegBase = 0xF00
  def apbDebugRegSize = 0x100
}

class APBDebugRegisters()(implicit p: Parameters) extends LazyModule {

  val node = APBRegisterNode(
    address = AddressSet(base=APBDebugConsts.apbDebugRegBase, mask=APBDebugConsts.apbDebugRegSize-1),
    beatBytes = 4,
    executable = false
  )

  lazy val module = new LazyModuleImp(this){
    node.regmap(p(APBDebugRegistersKey).toList:_*)

  }
}


