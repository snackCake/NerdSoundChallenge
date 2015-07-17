package com.nerdery.soundchallenge.services.midigenerators.dsl

import javax.sound.midi.{Sequence, Track}

import com.nerdery.soundchallenge.services.midigenerators.FreeformMidiGenerator

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