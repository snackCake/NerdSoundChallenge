package com.nerdery.soundchallenge.services.midigenerators.dsl

/**
 * Represents a note played at a certain time
 */
case class NoteEvent(tick: Long, note: Note)
