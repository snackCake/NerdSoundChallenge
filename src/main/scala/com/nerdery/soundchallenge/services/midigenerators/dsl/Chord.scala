package com.nerdery.soundchallenge.services.midigenerators.dsl

/**
 * Convenience container for building a set of notes played simultaneously
 */
case class Chord(keys: Key*) {
  def *(duration: Duration) = new ParallelRun(keys.map(_ * duration):_*)
  def +(key: Key) = Chord(keys :+ key:_*)
  def +(interval: Interval) = Chord(keys :+ Key(keys.last.pitch+interval.halfSteps, keys.last.octave):_*)
  def -(interval: Interval) = Chord(keys :+ Key(keys.last.pitch-interval.halfSteps, keys.last.octave):_*)
}
