// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.diplomaticobjectmodel.model

import freechips.rocketchipRT.rocket.RocketCoreParams

case class OMPMP(
  specifications: Seq[OMSpecification],
  nRegions: Int,
  granularity: Int,
  _types: Seq[String] = Seq("OMPMP", "OMComponent", "OMCompoundType")
) extends OMComponent

object OMPMP {
  def pmp(coreParams: RocketCoreParams): Option[OMPMP] = {
    if (coreParams.pmpGranularity > 0 || coreParams.nPMPs > 0) {
      Some(OMPMP(
        specifications = List[OMSpecification](PrivilegedArchitectureExtensions.specVersion(MachineLevelISA, "1.10")),
        nRegions = coreParams.nPMPs,
        granularity = coreParams.pmpGranularity
      ))
    }
    else {
      None
    }
  }
}