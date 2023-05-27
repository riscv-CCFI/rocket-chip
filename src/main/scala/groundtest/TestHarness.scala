// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.groundtest

import Chisel._
import freechips.rocketchipRT.config.Parameters
import freechips.rocketchipRT.diplomacy.LazyModule
import freechips.rocketchipRT.system.SimAXIMem

class TestHarness(implicit p: Parameters) extends Module {
  val io = new Bundle { val success = Bool(OUTPUT) }
  val ldut = LazyModule(new GroundTestSubsystem)
  val dut = Module(ldut.module)
  io.success := dut.success
  SimAXIMem.connectMem(ldut)
}
