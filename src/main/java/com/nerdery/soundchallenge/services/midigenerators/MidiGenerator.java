package com.nerdery.soundchallenge.services.midigenerators;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.io.OutputStream;

/**
 * The interface that must be implemented by all MIDI generators.
 *
 * @author Josh Klun (jklun@nerdery.com)
 */
public interface MidiGenerator {

    String getName();

    void generateSong(OutputStream theOutputStream) throws IOException, InvalidMidiDataException;
}
