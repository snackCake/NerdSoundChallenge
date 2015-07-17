package com.nerdery.soundchallenge.services.midigenerators.dsl

case class Duration(ticks: Long) {
  def dotted = Duration(ticks * 3 / 2)
  def triplet = Duration(ticks * 2 / 3)
}

object Duration {
  val Quarter = Duration(60)
  val Half = Duration(Quarter.ticks * 2)
  val Whole = Duration(Half.ticks * 2)
  val Eighth = Duration(Quarter.ticks / 2)
  val Sixteenth = Duration(Eighth.ticks / 2)
}