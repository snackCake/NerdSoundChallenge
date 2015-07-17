package com.nerdery.soundchallenge.services.midigenerators

import javax.sound.midi.{Sequence, Track}

/**
 *
 * @author Justin Mullin
 *
 * Exposes a little Scala DSL for MIDI composition.
 *
 */
trait DslMidiGenerator extends FreeformMidiGenerator {
  implicit def intToKey(i: Int) = Key(i, 0)

  override def getName: String
  override def build(sequence: Sequence): Unit = {
    implicit val seq = sequence
    generate()(seq)
  }

  def generate()(implicit sequence: Sequence): Unit

  def track(name: String, voice: Int, tempo: Int, channel: Int=0)(build: Track => Run)(implicit sequence: Sequence): Unit = {
    implicit val newTrack = buildTrack(sequence, name, tempo)
    setVoice(newTrack, voice)
    
    val run = build(newTrack)
    for(NoteEvent(tick, note) <- run.expand(0)) {
      add(tick, note, channel)
    }

    endTrack(newTrack)
  }

  def percussionTrack(name: String, tempo: Int)(build: Track => Run)(implicit sequence: Sequence): Unit = {
    track(name, 0, tempo, 9)(build)
  }

  def add(tick: Long, note: Note, channel: Int)(implicit track: Track): Unit = {
    println(f"Adding note ${note.key.value} at $tick for ${note.duration.ticks}")
    addNote(track, tick, note.key.value, channel, 0x70, note.duration.ticks)
  }
}

case class Chord(keys: Key*) {
  def *(duration: Duration) = new ParallelRun(keys.map(_ * duration):_*)
  def +(key: Key) = Chord(keys :+ key:_*)
  def +(interval: Interval) = Chord(keys :+ Key(keys.last.pitch+interval.halfSteps, keys.last.octave):_*)
  def -(interval: Interval) = Chord(keys :+ Key(keys.last.pitch-interval.halfSteps, keys.last.octave):_*)
}

trait Run {
  def expand(start: Long): Seq[NoteEvent]
  def length: Long

  def repeat(times: Int) = new SequenceRun(List.fill(times)(this):_*)
}

case class SequenceRun(runs: Run*) extends Run {
  override def expand(start: Long) = {
    var expanded = Seq[NoteEvent]()
    var tick = start

    for(run <- runs) {
      expanded ++= run.expand(tick)
      tick += run.length
    }

    expanded
  }
  override def length = runs.map(_.length).sum
}

case class ParallelRun(runs: Run*) extends Run {
  override def expand(start: Long) = {
    var expanded = Seq[NoteEvent]()

    for(run <- runs) {
      expanded ++= run.expand(start)
    }

    expanded
  }
  override def length = runs.map(_.length).max
}

case class NoteEvent(tick: Long, note: Note)

case class Note(key: Key, duration: Duration) extends Run {
  override def expand(start: Long) = Seq(NoteEvent(start, this))
  override def length = duration.ticks

  def *(n: Int) = Note(key, Duration(duration.ticks*n))
}

case class Interval(halfSteps: Int)

object Interval {
  val MinSecond = Interval(1)
  val MajSecond = Interval(2)
  val MinThird = Interval(3)
  val MajThird = Interval(4)
  val Fourth = Interval(5)
  val Fifth = Interval(7)
  val MinSixth = Interval(8)
  val MajSixth = Interval(9)
  val MinSeventh = Interval(10)
  val MajSeventh = Interval(11)
  val Octave = Interval(12)
}

object Rest {
  def *(duration: Duration) = Rest(duration)
}

case class Rest(duration: Duration) extends Run {
  override def expand(start: Long) = Seq()
  override def length = duration.ticks

  def *(n: Int) = Rest(Duration(duration.ticks*n))
}

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

object C extends Key(0, 4)
object D extends Key(2, 4)
object E extends Key(4, 4)
object F extends Key(5, 4)
object G extends Key(7, 4)
object A extends Key(9, 4)
object B extends Key(11, 4)
