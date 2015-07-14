package com.nerdery.soundchallenge.services.midigenerators;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import java.util.Random;

/**
 * @author Josh Klun (jklun@nerdery.com)
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DemoGenerator extends AbstractMidiGenerator {

    @Override
    protected void addNotes(Sequence sequence) throws InvalidMidiDataException {
        Track trebleTrack = buildTrack(sequence, "Treble Track");
        setVoice(trebleTrack, FLUTE_VOICE);
        Track bassTrack = buildTrack(sequence, "Treble Track");
        setVoice(bassTrack, FLUTE_VOICE);

        addNote(bassTrack, MIDDLE_C - 12, QUARTER_TICKS * 4);

        addNote(trebleTrack, MIDDLE_C + 4, QUARTER_TICKS);
        addNote(trebleTrack, MIDDLE_C + 4, QUARTER_TICKS);
        addNote(trebleTrack, MIDDLE_C + 5, QUARTER_TICKS);
        addNote(trebleTrack, MIDDLE_C + 7, QUARTER_TICKS);

        addNote(bassTrack, MIDDLE_C - 3, QUARTER_TICKS * 4);

        addNote(trebleTrack, MIDDLE_C + 7, QUARTER_TICKS);
        addNote(trebleTrack, MIDDLE_C + 5, QUARTER_TICKS);
        addNote(trebleTrack, MIDDLE_C + 4, QUARTER_TICKS);
        addNote(trebleTrack, MIDDLE_C + 2, QUARTER_TICKS);

        addNote(bassTrack, MIDDLE_C - 12, QUARTER_TICKS * 4);

        addNote(trebleTrack, MIDDLE_C, QUARTER_TICKS);
        addNote(trebleTrack, MIDDLE_C, QUARTER_TICKS);
        addNote(trebleTrack, MIDDLE_C + 2, QUARTER_TICKS);
        addNote(trebleTrack, MIDDLE_C + 4, QUARTER_TICKS);

        addNote(bassTrack, MIDDLE_C - 3, QUARTER_TICKS * 4);

        addNote(trebleTrack, MIDDLE_C + 4, (long) (QUARTER_TICKS * 1.5));
        addNote(trebleTrack, MIDDLE_C + 2, (long) (QUARTER_TICKS * 0.5));
        addNote(trebleTrack, MIDDLE_C + 2, (long) (QUARTER_TICKS * 2));

        endTrack(trebleTrack);
        endTrack(bassTrack);

        Track fluteTrack = buildTrack(sequence, "Epic Solo Not Flute Drop");
        setVoice(fluteTrack, FLUTE_VOICE);

        addTrackTicks(fluteTrack.toString(), getTrackTicks(trebleTrack.toString()));
        new Random().ints(-12, 12).limit(40).forEach(note -> {
            try {
                addNote(fluteTrack, MIDDLE_C + note, QUARTER_TICKS);
            } catch (InvalidMidiDataException e) {
                throw new RuntimeException("Synthesizer could not the flute.", e);
            }
        });

        endTrack(fluteTrack);
    }

    @Override
    public String getName() {
        return "demo";
    }

}
