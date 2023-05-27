// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.amba

import freechips.rocketchipRT.diplomacy._

package object axis
{
  type AXISInwardNode = InwardNodeHandle[AXISMasterPortParameters, AXISSlavePortParameters, AXISEdgeParameters, AXISBundle]
  type AXISOutwardNode = OutwardNodeHandle[AXISMasterPortParameters, AXISSlavePortParameters, AXISEdgeParameters, AXISBundle]
  type AXISNode = NodeHandle[AXISMasterPortParameters, AXISSlavePortParameters, AXISEdgeParameters, AXISBundle, AXISMasterPortParameters, AXISSlavePortParameters, AXISEdgeParameters, AXISBundle]
}
