package com.nerdery.soundchallenge.services.midigenerators.dsl

/**
 * Represents a musical rest; a duration with no notes played
 */
case class Rest(duration: Duration) extends Run {
  override def expand(start: Long) = Seq()
  override def length = duration.ticks

  def *(n: Int) = Rest(Duration(duration.ticks*n))
}

object Rest {
  def *(duration: Duration) = Rest(duration)
}