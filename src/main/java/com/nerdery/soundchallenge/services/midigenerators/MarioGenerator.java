package com.nerdery.soundchallenge.services.midigenerators;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import java.io.FileOutputStream;

/**
 * @author Josh Klun (jklun@nerdery.com)
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MarioGenerator extends AbstractMidiGenerator {

    protected static final int LEAD1_VOICE = 0x50;
    protected static final int JAZZ_GTAR_VOICE = 0x1A;

    private static final long SIXTEENTH_TICKS = 8;
    private static final long QUARTER_TICKS = SIXTEENTH_TICKS * 2;
    private static final long HALF_TICKS = QUARTER_TICKS * 2;
    private static final long WHOLE_TICKS = HALF_TICKS * 2;
    private static final long THREE_QUARTERS_TICKS = WHOLE_TICKS - QUARTER_TICKS;
    private static final long FIVE_QUARTERS_TICKS = WHOLE_TICKS + QUARTER_TICKS;
    private static final long WHOLE_SHORT_TICKS = WHOLE_TICKS - SIXTEENTH_TICKS;

    @Override
    protected void addNotes(Sequence sequence) throws InvalidMidiDataException {
        Track melody = buildTrack(sequence, "Melody", 0);
        setVoice(melody, LEAD1_VOICE);
        buildMelody(melody);
        endTrack(melody, WHOLE_TICKS);

        Track harmony = buildTrack(sequence, "Harmony", 1);
        setVoice(harmony, LEAD1_VOICE);
        buildHarmony(harmony);
        endTrack(harmony, WHOLE_TICKS);

        Track backup = buildTrack(sequence, "Backup", 2);
        setVoice(backup, JAZZ_GTAR_VOICE);
        buildBackup(backup);
        endTrack(backup, WHOLE_TICKS);
    }

    private void buildMelody(Track track) throws InvalidMidiDataException {
        addNote(track, MIDDLE_C + 16, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, HALF_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 12, WHOLE_TICKS * 3 - QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 10, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 21, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 12, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 10, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 21, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 19, WHOLE_SHORT_TICKS + THREE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 18, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 19, SIXTEENTH_TICKS + THREE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 18, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 24, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 24, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 24, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 19, SIXTEENTH_TICKS + WHOLE_TICKS + THREE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 18, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 15, WHOLE_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, WHOLE_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, WHOLE_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 19, WHOLE_TICKS * 3 + SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 18, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 19, SIXTEENTH_TICKS + THREE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 18, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 24, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 24, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 24, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 19, SIXTEENTH_TICKS + WHOLE_TICKS + THREE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 18, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 15, WHOLE_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, WHOLE_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, WHOLE_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 12, WHOLE_TICKS * 2 + SIXTEENTH_TICKS + QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 12, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS + WHOLE_TICKS * 3, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 16, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, HALF_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 12, WHOLE_TICKS * 2 + THREE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 10, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 21, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 12, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 10, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 21, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 16, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 11, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 21, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 21, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 21, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 16, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 11, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 16, WHOLE_TICKS * 2 + THREE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 11, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 21, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 21, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 21, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 16, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 11, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 12, WHOLE_TICKS * 2 + THREE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 12, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS + WHOLE_TICKS * 3, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 16, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, HALF_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 16, WHOLE_TICKS * 2 + THREE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 11, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 21, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 21, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 21, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 16, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 11, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
    }

    private void buildHarmony(Track track) throws InvalidMidiDataException {
        addNote(track, MIDDLE_C + 6, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 6, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 6, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 6, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 6, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 4, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 5, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 2, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 1, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 2, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 5, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 2, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 1, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 2, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 16, WHOLE_SHORT_TICKS + THREE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 16, SIXTEENTH_TICKS + THREE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 16, SIXTEENTH_TICKS + WHOLE_TICKS + THREE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 8, WHOLE_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, WHOLE_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, WHOLE_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 16, WHOLE_TICKS * 3 + SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 16, SIXTEENTH_TICKS + THREE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 16, SIXTEENTH_TICKS + WHOLE_TICKS + THREE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 8, WHOLE_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, WHOLE_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, WHOLE_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 8, WHOLE_TICKS * 2 + SIXTEENTH_TICKS + QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 10, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 8, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 10, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 8, SIXTEENTH_TICKS + WHOLE_TICKS * 3, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 10, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 6, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 6, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 6, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 6, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 6, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 4, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 5, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 2, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 1, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 2, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 5, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 2, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 1, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 2, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 12, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 12, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 12, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 12, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 8, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 10, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 8, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 10, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 8, SIXTEENTH_TICKS + WHOLE_TICKS * 3, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 10, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 6, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 6, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 6, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 6, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 6, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 12, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 12, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 11, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);
    }

    private void buildBackup(Track track) throws InvalidMidiDataException {
        addNote(track, MIDDLE_C - 10, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 10, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 10, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 10, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 10, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 5, FIVE_QUARTERS_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C - 5, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 8, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 12, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 7, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 5, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 6, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 7, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C - 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 2, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 1, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 3, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 5, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C - 5, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 8, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 12, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 7, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 5, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 6, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 7, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C - 8, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 5, QUARTER_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 2, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 1, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 3, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 5, SIXTEENTH_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C - 12, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 5, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 7, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 7, HALF_TICKS, QUARTER_TICKS);

        addNote(track, MIDDLE_C - 12, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 8, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 5, WHOLE_SHORT_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, HALF_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C + 19, SIXTEENTH_TICKS, QUARTER_TICKS);
        addNote(track, MIDDLE_C - 5, HALF_TICKS, QUARTER_TICKS);

//        addNote(track, MIDDLE_C + 16, SIXTEENTH_TICKS + THREE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 16, SIXTEENTH_TICKS + WHOLE_TICKS + THREE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 8, WHOLE_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, WHOLE_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, WHOLE_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 16, WHOLE_TICKS * 3 + SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 16, SIXTEENTH_TICKS + THREE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 17, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 17, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 16, SIXTEENTH_TICKS + WHOLE_TICKS + THREE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 15, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 8, WHOLE_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, WHOLE_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, WHOLE_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 8, WHOLE_TICKS * 2 + SIXTEENTH_TICKS + QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 10, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 8, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 10, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 8, SIXTEENTH_TICKS + WHOLE_TICKS * 3, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 10, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 6, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 6, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 6, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 6, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 6, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 11, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 4, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C, WHOLE_SHORT_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C - 5, WHOLE_SHORT_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C, WHOLE_SHORT_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 2, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 1, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 7, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 11, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 2, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C, WHOLE_SHORT_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C - 5, WHOLE_SHORT_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C, WHOLE_SHORT_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 2, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 1, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 7, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 11, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 11, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 9, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 2, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 12, WHOLE_SHORT_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 12, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 11, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 7, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 12, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 12, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 11, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 7, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 8, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 10, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 8, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 10, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 7, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 8, SIXTEENTH_TICKS + WHOLE_TICKS * 3, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 8, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 10, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 7, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 6, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 6, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 6, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 6, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 6, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 11, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 12, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 17, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 16, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 12, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 9, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, WHOLE_SHORT_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 5, SIXTEENTH_TICKS, QUARTER_TICKS);
//
//        addNote(track, MIDDLE_C + 7, FIVE_QUARTERS_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 14, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 12, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 11, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 7, QUARTER_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, SIXTEENTH_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C + 4, HALF_TICKS, QUARTER_TICKS);
//        addNote(track, MIDDLE_C, SIXTEENTH_TICKS, QUARTER_TICKS);
    }

    @Override
    public String getName() {
        return "mario";
    }

    //

    public static void main(String[] args) throws Exception {
//        new MarioGenerator().generateSong(new FileOutputStream("Z:\\Projects\\jvm-challenge\\NerdSoundChallenge\\mario.mid"));
        new MarioGenerator().generateSong(new FileOutputStream("mario.mid"));
    }
}
