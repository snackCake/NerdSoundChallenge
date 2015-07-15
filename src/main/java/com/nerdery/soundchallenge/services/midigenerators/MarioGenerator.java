package com.nerdery.soundchallenge.services.midigenerators;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import java.io.FileOutputStream;

/**
 * @author Josh Klun (jklun@nerdery.com)
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MarioGenerator extends AbstractMidiGenerator {

    protected static final int LEAD1_VOICE = 0x50;

    private static final int SIXTEENTH_TICKS = 8;
    private static final int QUARTER_TICKS = SIXTEENTH_TICKS * 2;
    private static final int HALF_TICKS = QUARTER_TICKS * 2;
    private static final int WHOLE_TICKS = HALF_TICKS * 2;

    @Override
    protected void addNotes(Sequence sequence) throws InvalidMidiDataException {
        Track melodyTrack = buildTrack(sequence, "Melody Track");
        setVoice(melodyTrack, LEAD1_VOICE);

        addNote(melodyTrack, MIDDLE_C + 16, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 16, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 16, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 19, HALF_TICKS, QUARTER_TICKS);

        addNote(melodyTrack, MIDDLE_C + 12, QUARTER_TICKS + HALF_TICKS + WHOLE_TICKS + WHOLE_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 7, WHOLE_TICKS - SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 4, WHOLE_TICKS - SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 9, WHOLE_TICKS - SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 11, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 10, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(melodyTrack, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 19, QUARTER_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 21, QUARTER_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 19, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(melodyTrack, MIDDLE_C + 12, WHOLE_TICKS - SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 7, WHOLE_TICKS - SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 4, WHOLE_TICKS - SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 9, WHOLE_TICKS - SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 11, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 10, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(melodyTrack, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 19, QUARTER_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 21, QUARTER_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 19, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(melodyTrack, MIDDLE_C + 19, (WHOLE_TICKS - SIXTEENTH_TICKS)
                + WHOLE_TICKS - QUARTER_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 18, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(melodyTrack, MIDDLE_C + 19, (SIXTEENTH_TICKS) + WHOLE_TICKS - QUARTER_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 18, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 24, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 24, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 24, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(melodyTrack, MIDDLE_C + 19, (SIXTEENTH_TICKS + WHOLE_TICKS)
                + WHOLE_TICKS - QUARTER_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 18, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(melodyTrack, MIDDLE_C + 15, (SIXTEENTH_TICKS) + WHOLE_TICKS - SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 14, WHOLE_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, WHOLE_TICKS, QUARTER_TICKS);

        addNote(melodyTrack, MIDDLE_C + 19, (SIXTEENTH_TICKS + QUARTER_TICKS + WHOLE_TICKS + WHOLE_TICKS)
                + WHOLE_TICKS - QUARTER_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 18, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(melodyTrack, MIDDLE_C + 19, (SIXTEENTH_TICKS) + WHOLE_TICKS - SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 18, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 24, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 24, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 24, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(melodyTrack, MIDDLE_C + 19, (SIXTEENTH_TICKS + WHOLE_TICKS)
                + WHOLE_TICKS - QUARTER_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 18, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(melodyTrack, MIDDLE_C + 15, (SIXTEENTH_TICKS) + WHOLE_TICKS - SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 14, WHOLE_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, WHOLE_TICKS, QUARTER_TICKS);

        addNote(melodyTrack, MIDDLE_C + 12, (SIXTEENTH_TICKS + QUARTER_TICKS + WHOLE_TICKS + WHOLE_TICKS),
                QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(melodyTrack, MIDDLE_C + 12, QUARTER_TICKS + WHOLE_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 16, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(melodyTrack, MIDDLE_C + 12, (SIXTEENTH_TICKS + WHOLE_TICKS + WHOLE_TICKS + WHOLE_TICKS),
                QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(melodyTrack, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);

        endTrack(melodyTrack);
    }

    @Override
    public String getName() {
        return "mario";
    }

    //

    @Override
    protected void addNote(Track track, int note, long duration) throws InvalidMidiDataException {
        addNote(track, note, 0l, duration);
    }

    protected void addNote(Track track, int note, long pause, long duration) throws InvalidMidiDataException {
        //****  note on ****
        ShortMessage shortMessage = new ShortMessage();
        shortMessage.setMessage(ShortMessage.NOTE_ON, note, 0x60);
        MidiEvent midiEvent = new MidiEvent(shortMessage, addTrackTicks(track.toString(), pause));
        track.add(midiEvent);

        //****  note off  ****
        shortMessage = new ShortMessage();
        shortMessage.setMessage(ShortMessage.NOTE_OFF, note, 0x40);
        midiEvent = new MidiEvent(shortMessage, addTrackTicks(track.toString(), duration));
        track.add(midiEvent);
    }

    public static void main(String[] args) throws Exception {
        new MarioGenerator().generateSong(new FileOutputStream("Z:\\Projects\\jvm-challenge\\NerdSoundChallenge\\mario.mid"));
    }
}
