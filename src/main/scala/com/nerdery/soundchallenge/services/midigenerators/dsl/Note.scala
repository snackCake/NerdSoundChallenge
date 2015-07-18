package com.nerdery.soundchallenge.services.midigenerators.dsl

/**
 * Represents a key played with a certain duration
 */
case class Note(key: Key, duration: Duration) extends Run {
  override def expand(start: Long) = Seq(NoteEvent(start, this))
  override def length = duration.ticks

  def *(n: Int) = Note(key, Duration(duration.ticks*n))
}