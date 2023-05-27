// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.interrupts

import Chisel._
import freechips.rocketchipRT.util._

class SyncInterrupts(params: IntEdge) extends GenericParameterizedBundle(params)
{
  val sync = Vec(params.source.num, Bool())
}
