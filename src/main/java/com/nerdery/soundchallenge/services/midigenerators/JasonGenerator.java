package com.nerdery.soundchallenge.services.midigenerators;

import midiReference.ScaleReference;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

/**
 * Created by floater on 7/16/15.
 */

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class JasonGenerator extends AbstractMidiGenerator {

    private static final int[] scaleUp = ScaleReference.PENTATONIC.getDegrees();
    private static final int[] scaleDown = ScaleReference.PENTATONIC.getDegrees().clone();
    private static final int tempo = 20;

    @PostConstruct
    public void init() {
        // scaleDown needs to be reversed
        ArrayUtils.reverse(scaleDown);
    }

    @Override
    protected void addNotes(Sequence sequence) throws InvalidMidiDataException {


        Track myTrack = buildTrack(sequence, "Pentatonic Track");
        setVoice(myTrack, 30);

        for (int reps = 0; reps < 15; reps++) {


            for(int c : scaleUp) {
                addNote(myTrack, MIDDLE_C + c, tempo);
            }


            for(int c : scaleDown) {
                addNote(myTrack, MIDDLE_C + c, tempo);
            }

        }


        endTrack(myTrack);

    }

    @Override
    public String getName() {
        return "steve vai pentatonic licks";
    }

}
