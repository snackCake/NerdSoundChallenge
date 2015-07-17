package com.nerdery.soundchallenge.services.midigenerators.dsl

case class Key(_pitch: Int, _octave: Int) {
  val octave = _octave + _pitch/12
  val pitch = _pitch % 12

  def value = 0x3C + pitch + (octave-4) * 12

  def ~(octave: Int) = Key(pitch, octave)

  def sharp = Key(pitch+1, octave)
  def flat = Key(pitch-1, octave)

  def *(duration: Duration) = Note(this, duration)
  def +(key: Key) = Chord(this, key)
  def +(interval: Interval) = {
    println(f"From $pitch to ${pitch+interval.halfSteps}")
    Chord(this, Key(pitch+interval.halfSteps, octave))
  }
  def -(interval: Interval) = {
    Chord(this, Key(pitch-interval.halfSteps, octave))
  }
}

object Key {
  object C extends Key(0, 4)
  object D extends Key(2, 4)
  object E extends Key(4, 4)
  object F extends Key(5, 4)
  object G extends Key(7, 4)
  object A extends Key(9, 4)
  object B extends Key(11, 4)
}