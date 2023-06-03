// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.diplomacy

import freechips.rocketchipRT.macros.ValNameImpl

case class ValName(name: String)

object ValName
{
  implicit def materialize(implicit x: ValNameImpl): ValName = ValName(x.name)
}
