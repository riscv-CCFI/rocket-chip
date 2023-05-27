// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.diplomaticobjectmodel.model


case class OMTestHarness(
  components: Seq[OMComponent],
  _types: Seq[String] = Seq("OMTestHarness")
) extends OMComponent
