package com.nerdery.soundchallenge.services.midigenerators

import javax.sound.midi.Sequence

import com.nerdery.soundchallenge.midi.GeneralMidiVoices._
import com.nerdery.soundchallenge.midi.GeneralMidiVoices.Percussion._
import com.nerdery.soundchallenge.services.midigenerators.Duration._
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * @author Justin Mullin
 *
 * The one, the only, the classic.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class SuperMarioMidiGenerator extends DslMidiGenerator {
  override def getName: String = "superMario"

  override def generate()(implicit sequence: Sequence): Unit = {
    track("melody", LeadSquare, 200) { implicit t =>
      new SequenceRun(
        Chord(D~3, F.sharp~4, E~5) * Eighth,
        Chord(D~3, F.sharp~4, E~5) * Eighth,
        Rest * Eighth,
        Chord(D~3, F.sharp~4, E~5) * Eighth,
        Rest * Eighth,
        Chord(D~3, F.sharp~4, C~5) * Eighth,
        Chord(D~3, F.sharp~4, E~5) * Eighth,
        Rest * Eighth,
        Chord(G~4, B~4, G~5) * Eighth,
        Rest * Quarter.dotted,
        Chord(G~3, G~4) * Quarter,
        Rest * Quarter,

        Chord(G~3, E~4, C~5) * Eighth,
        Rest * Quarter,
        Chord(E~3, C~4, G~5) * Eighth,
        Rest * Quarter,
        Chord(C~3, G~4, E~5) * Eighth,
        Rest * Quarter,
        Chord(F~3, C~4, A~4) * Eighth,
        Rest * Eighth,
        Chord(G~3, D~4, B~4) * Eighth,
        Rest * Eighth,
        Chord(G.flat~3, D.flat~4, B.flat~4) * Eighth,
        Chord(F~3, C~4, A~4) * Quarter,

        Chord(E~3, C~4, G~4) * Quarter.triplet,
        Chord(C~4, G~4, E~5) * Quarter.triplet,
        Chord(E~4, B~4, G~5) * Quarter.triplet,
        Chord(F~4, C~5, A~5) * Eighth,
        Rest * Eighth,
        Chord(D~4, A~4, F~5) * Eighth,
        Chord(E~4, B~4, G~5) * Eighth,
        Rest * Eighth,
        Chord(C~4, A~4, E~5) * Eighth,
        Rest * Eighth,
        Chord(A~3, E~4, C~5) * Eighth,
        Chord(B~3, F~4, D~5) * Eighth,
        Chord(G~3, D~4, B~4) * Eighth,
        Rest * Quarter,

        Chord(G~3, E~4, C~5) * Eighth,
        Rest * Quarter,
        Chord(E~3, C~4, G~5) * Eighth,
        Rest * Quarter,
        Chord(C~3, G~4, E~5) * Eighth,
        Rest * Quarter,
        Chord(F~3, C~4, A~4) * Eighth,
        Rest * Eighth,
        Chord(G~3, D~4, B~4) * Eighth,
        Rest * Eighth,
        Chord(G.flat~3, D.flat~4, B.flat~4) * Eighth,
        Chord(F~3, C~4, A~4) * Quarter,

        Chord(E~3, C~4, G~4) * Quarter.triplet,
        Chord(C~4, G~4, E~5) * Quarter.triplet,
        Chord(E~4, B~4, G~5) * Quarter.triplet,
        Chord(F~4, C~5, A~5) * Eighth,
        Rest * Eighth,
        Chord(D~4, A~4, F~5) * Eighth,
        Chord(E~4, B~4, G~5) * Eighth,
        Rest * Eighth,
        Chord(C~4, A~4, E~5) * Eighth,
        Rest * Eighth,
        Chord(A~3, E~4, C~5) * Eighth,
        Chord(B~3, F~4, D~5) * Eighth,
        Chord(G~3, D~4, B~4) * Eighth,
        Rest * Quarter
      )
    }

    percussionTrack("hiHat", 200) { implicit t =>
      new SequenceRun(
        ClosedHiHat * Quarter,
        ClosedHiHat * Eighth.triplet,
        Rest * Eighth.triplet,
        ClosedHiHat * Eighth.triplet
      ).repeat(20)
    }

    percussionTrack("snare", 200) { implicit t =>
      new SequenceRun(
        Rest * Half,
        SnareDrum1 * Half,
        Rest * Half,
        SnareDrum1 * Half
      ).repeat(5)
    }

    percussionTrack("bass", 200) { implicit t =>
      new SequenceRun(
        BassDrum1 * Whole,
        BassDrum1 * Whole
      ).repeat(5)
    }
  }
}
