// See LICENSE.SiFive for license details.

package freechips.rocketchipRT.unittest

import firrtl.options.StageMain
import freechips.rocketchipRT.system.RocketChipStage

object Generator extends StageMain(new RocketChipStage)
