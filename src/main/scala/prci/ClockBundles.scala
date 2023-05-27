// See LICENSE.SiFive for license details.
package freechips.rocketchipRT.prci

import chisel3._
import freechips.rocketchipRT.util.RecordMap


class ClockBundle(val params: ClockBundleParameters) extends Bundle
{
  val clock = Output(Clock())
  val reset = Output(Reset())
}

class ClockGroupBundle(val params: ClockGroupBundleParameters) extends Bundle
{
  val member: RecordMap[ClockBundle] = RecordMap(params.members.map { case (k, v) =>
    k -> new ClockBundle(v)
  })
}
