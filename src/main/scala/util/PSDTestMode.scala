// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.util

import Chisel._
import freechips.rocketchipRT.config._
import freechips.rocketchipRT.diplomacy.{BundleBridgeEphemeralNode, ValName}

case object IncludePSDTest extends Field[Boolean](false)
case object PSDTestModeBroadcastKey extends Field(
  BundleBridgeEphemeralNode[PSDTestMode]()(ValName("global_psd_test_mode"))
)

class PSDTestMode extends Bundle {
  val test_mode       = Bool()
  val test_mode_reset = Bool()
  // TODO: Clocks?
}

trait CanHavePSDTestModeIO {
  implicit val p: Parameters
  val psd = p(IncludePSDTest).option(new PSDTestMode().asInput)
}
