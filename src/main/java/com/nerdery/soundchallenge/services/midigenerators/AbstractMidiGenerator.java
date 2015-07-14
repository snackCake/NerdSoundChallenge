package com.nerdery.soundchallenge.services.midigenerators;

import javax.sound.midi.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * AbstractMidiGenerator provides utility methods for generating a MIDI file that can be extended by subclasses.
 * This class is based on code found here: http://www.automatic-pilot.com/midifile.java
 *
 * @author Josh Klun (jklun@nerdery.com)
 */
public abstract class AbstractMidiGenerator implements MidiGenerator {

    protected static final int MIDDLE_C = 0x3C;
    protected static final int FLUTE_VOICE = 0x49;
    protected static final int PIANO_VOICE = 0x0;
    protected static final int QUARTER_TICKS = 60;

    private Map<String, Long> currentTicks = new HashMap<>();

    @Override
    public void generateSong(OutputStream outputStream) throws IOException, InvalidMidiDataException {
        Sequence sequence = buildSequence();
        addNotes(sequence);
        saveSequence(outputStream, sequence);
    }

    protected long getTrackTicks(String trackId) {
        Long ticks = currentTicks.get(trackId);
        if (ticks == null) {
            final long initialTicks = 1L;
            currentTicks.put(trackId, initialTicks);
            ticks = initialTicks;
        }
        return ticks;
    }

    protected long addTrackTicks(String trackId, long addedTicks) {
        long newTicks = getTrackTicks(trackId) + addedTicks;
        currentTicks.replace(trackId, newTicks);
        return newTicks;
    }

    protected Track buildTrack(Sequence sequence, String trackName) throws InvalidMidiDataException {
        Track track = sequence.createTrack();
        enableGeneralMidi(track);
        configureTempo(track);
        nameTrack(track, trackName);
        configureTrack(track);
        return track;
    }

    protected abstract void addNotes(Sequence sequence) throws InvalidMidiDataException;

    protected void addNote(Track track, int note, long duration) throws InvalidMidiDataException {
        //****  note on ****
        ShortMessage shortMessage = new ShortMessage();
        shortMessage.setMessage(0x90, note, 0x60);
        MidiEvent midiEvent = new MidiEvent(shortMessage, getTrackTicks(track.toString()));
        track.add(midiEvent);

        //****  note off  ****
        shortMessage = new ShortMessage();
        shortMessage.setMessage(0x80, note, 0x40);
        midiEvent = new MidiEvent(shortMessage, addTrackTicks(track.toString(), duration));
        track.add(midiEvent);
    }

    protected void nameTrack(Track track, String trackName) throws InvalidMidiDataException {
        MetaMessage metaMessage = new MetaMessage();
        metaMessage.setMessage(0x03, trackName.getBytes(), trackName.length());
        track.add(new MidiEvent(metaMessage, (long) 0));
    }

    protected void configureTrack(Track track) throws InvalidMidiDataException {
        MidiEvent midiEvent;//****  set omni on  ****
        ShortMessage shortMessage = new ShortMessage();
        shortMessage.setMessage(0xB0, 0x7D, 0x00);
        midiEvent = new MidiEvent(shortMessage, (long) 0);
        track.add(midiEvent);

        //****  set poly on  ****
        shortMessage = new ShortMessage();
        shortMessage.setMessage(0xB0, 0x7F, 0x00);
        midiEvent = new MidiEvent(shortMessage, (long) 0);
        track.add(midiEvent);
    }

    protected void setVoice(Track track, int voiceNumber) throws InvalidMidiDataException {
        ShortMessage shortMessage = new ShortMessage();
        shortMessage.setMessage(0xC0, voiceNumber, 0x0);
        track.add(new MidiEvent(shortMessage, (long) 0));
    }

    protected void endTrack(Track track) throws InvalidMidiDataException {
        MetaMessage metaMessage = new MetaMessage();
        byte[] bet = {}; // empty array
        metaMessage.setMessage(0x2F, bet, 0);
        track.add(new MidiEvent(metaMessage, (long) 140));
    }

    private void configureTempo(Track track) throws InvalidMidiDataException {
        MidiEvent midiEvent;//****  set tempo (meta event)  ****
        MetaMessage metaMessage = new MetaMessage();
        byte[] tempoBytes = {0x02, (byte) 0x00, 0x00};
        metaMessage.setMessage(0x51, tempoBytes, 3);
        midiEvent = new MidiEvent(metaMessage, (long) 0);
        track.add(midiEvent);
    }

    private void enableGeneralMidi(Track track) throws InvalidMidiDataException {
        //****  General MIDI sysex -- turn on General MIDI sound set  ****
        byte[] generalMidiBytes = {(byte) 0xF0, 0x7E, 0x7F, 0x09, 0x01, (byte) 0xF7};
        SysexMessage sysexMessage = new SysexMessage();
        sysexMessage.setMessage(generalMidiBytes, generalMidiBytes.length);
        MidiEvent midiEvent = new MidiEvent(sysexMessage, (long) 0);
        track.add(midiEvent);
    }

    private int saveSequence(OutputStream theOutputStream, Sequence sequence) throws IOException {
        return MidiSystem.write(sequence, 1, theOutputStream);
    }

    private Sequence buildSequence() throws InvalidMidiDataException {
        return new Sequence(Sequence.PPQ, 24);
    }

}
