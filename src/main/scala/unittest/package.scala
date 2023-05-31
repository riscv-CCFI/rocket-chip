// See LICENSE.SiFive for license details.

package freechips.rocketchipRT

import Chisel._

package object unittest
{
  implicit class LazyUnitTestSeq(val seq: Seq[LazyUnitTest]) {
    def finished = seq.map(_.module.finished).foldLeft(Bool(true))(_ && _)
  }
}
