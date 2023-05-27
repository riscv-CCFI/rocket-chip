// See LICENSE.SiFive for license details.
package freechips.rocketchipRT.prci

import freechips.rocketchipRT.config.Parameters
import freechips.rocketchipRT.diplomacy.{CrossingType, HasDomainCrossing, LazyModule}

trait HasResetDomainCrossing extends HasDomainCrossing { this: LazyModule =>
  type DomainCrossingType = ResetCrossingType
}

sealed trait ResetCrossingType extends CrossingType {
  def injectClockNode(implicit p: Parameters): ClockNode
}

case class NoResetCrossing() extends ResetCrossingType {
  def injectClockNode(implicit p: Parameters): ClockNode = ClockTempNode()
}

case class StretchedResetCrossing(cycles: Int) extends ResetCrossingType {
  def injectClockNode(implicit p: Parameters): ClockNode = {
    val rs = LazyModule(new ResetStretcher(cycles))
    rs.node
  }
}
