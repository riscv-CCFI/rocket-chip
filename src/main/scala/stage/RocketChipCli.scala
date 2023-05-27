// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.stage

import firrtl.options.Shell

trait RocketChipCli { this: Shell =>

  parser.note("Rocket Chip Compiler Options")
  Seq(
    TopModuleAnnotation,
    ConfigsAnnotation,
    OutputBaseNameAnnotation
  )
    .foreach(_.addOptions(parser))

}
