// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.diplomaticobjectmodel

import freechips.rocketchipRT.diplomaticobjectmodel.logicaltree._
import freechips.rocketchipRT.diplomaticobjectmodel.model.OMComponent
import freechips.rocketchipRT.util.ElaborationArtefacts

case object ConstructOM {
  def constructOM(): Unit = {
    val om: Seq[OMComponent] = LogicalModuleTree.bind()
    ElaborationArtefacts.add("objectModel.json", DiplomaticObjectModelUtils.toJson(om))
  }
}
