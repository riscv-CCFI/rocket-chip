// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.diplomacy

case object Unreachable {
  def apply(): Nothing = throw new AssertionError("unreachable code")
}
