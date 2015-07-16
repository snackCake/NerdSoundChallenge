package com.nerdery.soundchallenge.services.midigenerators

import java.io.OutputStream
import javax.sound.midi._
import com.nerdery.soundchallenge.midi.MidiCommands._

abstract class FreeformMidiGenerator extends MidiGenerator {

  def generateSong(outputStream: OutputStream) {
    val sequence = buildSequence()
    build(sequence)
    saveSequence(outputStream, sequence)
  }

  def buildTrack(sequence: Sequence, trackName: String, tempo: Int) = {
    val track = sequence.createTrack
    enableGeneralMidi(track)
    configureTempo(track, tempo)
    nameTrack(track, trackName)
    configureTrack(track)
    track
  }

  def build(sequence: Sequence)

  def addNote(track: Track, tick: Long, note: Int, channel: Int, velocity: Int, duration: Long) {
    addChannelEvent(track, NoteOn, channel, note, velocity, tick)
    addChannelEvent(track, NoteOn, channel, note, 0, tick+duration)
  }

  def configureTrack(track: Track) {
    addSimpleEvent(track, ControlChange, ControlCommands.OmniOn, 0)
    addSimpleEvent(track, ControlChange, ControlCommands.PolyOn, 0)
  }

  def setVoice(track: Track, voiceNumber: Int) {
    addSimpleEvent(track, ProgramChange, voiceNumber, 0)
  }

  def nameTrack(track: Track, trackName: String) {
    val metaMessage = new MetaMessage
    metaMessage.setMessage(0x03, trackName.getBytes, trackName.length)
    track.add(new MidiEvent(metaMessage, 0))
  }

  def endTrack(track: Track) {
    val metaMessage = new MetaMessage
    val bet = Array[Byte]()
    metaMessage.setMessage(0x2F, bet, 0)
    track.add(new MidiEvent(metaMessage, 140))
  }

  def configureTempo(track: Track, bpm: Int) {
    val metaMessage = new MetaMessage
    val tempoBytes = BigInt(60000000/bpm).toByteArray
    metaMessage.setMessage(0x51, tempoBytes, tempoBytes.length)
    track.add(new MidiEvent(metaMessage, 0))
  }

  def enableGeneralMidi(track: Track) {
    val generalMidiBytes = Array(0xF0, 0x7E, 0x7F, 0x09, 0x01, 0xF7).map(_.toByte)
    val sysexMessage = new SysexMessage
    sysexMessage.setMessage(generalMidiBytes, generalMidiBytes.length)
    track.add(new MidiEvent(sysexMessage, 0.asInstanceOf[Long]))
  }

  def addSimpleEvent(track: Track, status: Int, data1: Int, data2: Int, tick: Long=0) {
    val message = new ShortMessage
    message.setMessage(status, data1, data2)

    val event = new MidiEvent(message, tick)
    track.add(event)
  }

  def addChannelEvent(track: Track, command: Int, channel: Int, data1: Int, data2: Int, tick: Long=0) {
    val message = new ShortMessage
    message.setMessage(command, channel, data1, data2)

    val event = new MidiEvent(message, tick)
    track.add(event)
  }

  def saveSequence(theOutputStream: OutputStream, sequence: Sequence): Int = {
    MidiSystem.write(sequence, 1, theOutputStream)
  }

  def buildSequence() = new Sequence(Sequence.PPQ, 60)
}
