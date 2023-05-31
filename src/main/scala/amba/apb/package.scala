// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.amba

import freechips.rocketchipRT.diplomacy._

package object apb
{
  type APBOutwardNode = OutwardNodeHandle[APBMasterPortParameters, APBSlavePortParameters, APBEdgeParameters, APBBundle]
  type APBInwardNode = InwardNodeHandle[APBMasterPortParameters, APBSlavePortParameters, APBEdgeParameters, APBBundle]
  type APBNode = SimpleNodeHandle[APBMasterPortParameters, APBSlavePortParameters, APBEdgeParameters, APBBundle]
}
