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
}

trait Run {
  def expand(start: Long): Seq[NoteEvent]
  def length: Long
}

class SequenceRun(runs: Run*) extends Run {
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

  def repeat(times: Int) = new SequenceRun(List.fill(times)(this):_*)
}

class ParallelRun(runs: Run*) extends Run {
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
}

object Rest {
  def *(duration: Duration) = Rest(duration)
}

case class Rest(duration: Duration) extends Run {
  override def expand(start: Long) = Seq()
  override def length = duration.ticks
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
}

object C extends Key(0, 4)
object D extends Key(2, 4)
object E extends Key(4, 4)
object F extends Key(5, 4)
object G extends Key(7, 4)
object A extends Key(9, 4)
object B extends Key(11, 4)
