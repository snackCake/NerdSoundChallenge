package com.nerdery.soundchallenge.services.midigenerators.dsl

object Rest {
  def *(duration: Duration) = Rest(duration)
}

case class Rest(duration: Duration) extends Run {
  override def expand(start: Long) = Seq()
  override def length = duration.ticks

  def *(n: Int) = Rest(Duration(duration.ticks*n))
}