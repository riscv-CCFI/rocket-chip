// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.unittest

import Chisel._
import freechips.rocketchipRT.config.Parameters

class TestHarness(implicit val p: Parameters) extends Module {
  val io = new Bundle { val success = Bool(OUTPUT) }
  io.success := Module(new UnitTestSuite).io.finished
}
