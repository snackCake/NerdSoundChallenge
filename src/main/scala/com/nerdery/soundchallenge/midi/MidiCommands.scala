package com.nerdery.soundchallenge.midi

object MidiCommands {
  val NoteOn = 0x90
  val NoteOff = 0x80
  val ControlChange = 0xB0
  val ProgramChange = 0xC0

  object ControlCommands {
    val OmniOn = 0x7D
    val PolyOn = 0x7F
  }
}
