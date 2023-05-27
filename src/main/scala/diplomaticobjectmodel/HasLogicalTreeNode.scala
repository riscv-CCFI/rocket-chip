// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.diplomaticobjectmodel


import freechips.rocketchipRT.diplomaticobjectmodel.logicaltree._

trait HasLogicalTreeNode {
  def logicalTreeNode: LogicalTreeNode
  def addLogicalTreeNode(childLogicalTreeNode: LogicalTreeNode): Unit = LogicalModuleTree.add(logicalTreeNode, childLogicalTreeNode)
}

