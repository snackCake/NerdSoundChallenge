package com.nerdery.soundchallenge.services.midigenerators.dsl

import com.nerdery.soundchallenge.services.midigenerators.dsl.FreeformMidiGenerator

/**
 * Represents an amount of musical time
 */
case class Duration(ticks: Long) {
  def dotted = Duration(ticks * 3 / 2)
  def triplet = Duration(ticks * 2 / 3)
}

object Duration {
  val Quarter = Duration(FreeformMidiGenerator.Resolution)
  val Half = Duration(Quarter.ticks * 2)
  val Whole = Duration(Half.ticks * 2)
  val Eighth = Duration(Quarter.ticks / 2)
  val Sixteenth = Duration(Eighth.ticks / 2)
}