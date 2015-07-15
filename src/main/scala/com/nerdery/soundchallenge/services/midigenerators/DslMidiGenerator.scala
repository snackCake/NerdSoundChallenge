package com.nerdery.soundchallenge.services.midigenerators

import javax.sound.midi.{Sequence, Track}

/**
 *
 * @author Justin Mullin
 *
 * Exposes a little Scala DSL for MIDI composition.
 *
 */
trait DslMidiGenerator extends AbstractMidiGenerator {
  override def getName: String
  override protected def addNotes(sequence: Sequence): Unit = {
    implicit val seq = sequence
    generate()(seq)
  }

  def generate()(implicit sequence: Sequence): Unit

  def track(name: String, voice: Int)(build: Track => Unit)(implicit sequence: Sequence): Unit = {
    val newTrack = buildTrack(sequence, name)
    setVoice(newTrack, voice)
    
    build(newTrack)

    endTrack(newTrack)
  }

  def play(note: Note, duration: Duration)(implicit track: Track): Unit = {
    addNote(track, note.value, duration.ticks)
  }
}

case class Duration(ticks: Long) {
  def /(n: Int) = Duration(ticks / n)
  def *(n: Int) = Duration(ticks * n)
  def dotted = Duration(ticks * 3 / 2)
}

object Duration {
  val quarter = Duration(60)
  val half = quarter * 2
  val whole = half * 2
  val eighth = quarter / 2
  val sixteenth = eighth / 2
}

case class Note(pitch: Int, octave: Int) {
  def value = AbstractMidiGenerator.MIDDLE_C + pitch + (octave-4) * 12
}

object Note {
  val (c0,  c1,  c2,  c3,  c4,  c5,  c6,  c7,  c8,  c9)  = octaves(0)
  val (cs0, cs1, cs2, cs3, cs4, cs5, cs6, cs7, cs8, cs9) = octaves(1)
  val (db0, db1, db2, db3, db4, db5, db6, db7, db8, db9) = octaves(1)
  val (d0,  d1,  d2,  d3,  d4,  d5,  d6,  d7,  d8,  d9)  = octaves(2)
  val (ds0, ds1, ds2, ds3, ds4, ds5, ds6, ds7, ds8, ds9) = octaves(3)
  val (e0,  e1,  e2,  e3,  e4,  e5,  e6,  e7,  e8,  e9)  = octaves(4)
  val (f0,  f1,  f2,  f3,  f4,  f5,  f6,  f7,  f8,  f9)  = octaves(5)
  val (fs0, fs1, fs2, fs3, fs4, fs5, fs6, fs7, fs8, fs9) = octaves(6)
  val (g0,  g1,  g2,  g3,  g4,  g5,  g6,  g7,  g8,  g9)  = octaves(7)
  val (gs0, gs1, gs2, gs3, gs4, gs5, gs6, gs7, gs8, gs9) = octaves(8)
  val (a0,  a1,  a2,  a3,  a4,  a5,  a6,  a7,  a8,  a9)  = octaves(9)
  val (as0, as1, as2, as3, as4, as5, as6, as7, as8, as9) = octaves(10)
  val (b0,  b1,  b2,  b3,  b4,  b5,  b6,  b7,  b8,  b9)  = octaves(11)

  def octaves(pitch: Int) = (
    Note(pitch, 0),
    Note(pitch, 1),
    Note(pitch, 2),
    Note(pitch, 3),
    Note(pitch, 4),
    Note(pitch, 5),
    Note(pitch, 6),
    Note(pitch, 7),
    Note(pitch, 8),
    Note(pitch, 9)
  )
}