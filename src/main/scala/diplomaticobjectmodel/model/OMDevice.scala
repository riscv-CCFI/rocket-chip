// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.diplomaticobjectmodel.model

trait OMDevice extends OMComponent {
  def memoryRegions: Seq[OMMemoryRegion]
  def interrupts: Seq[OMInterrupt]
}

