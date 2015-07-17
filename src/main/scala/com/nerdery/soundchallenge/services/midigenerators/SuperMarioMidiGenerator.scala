package com.nerdery.soundchallenge.services.midigenerators

import javax.sound.midi.Sequence

import com.nerdery.soundchallenge.midi.GeneralMidiVoices._
import com.nerdery.soundchallenge.midi.GeneralMidiVoices.Percussion._
import com.nerdery.soundchallenge.services.midigenerators.Duration._
import com.nerdery.soundchallenge.services.midigenerators.Interval._
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
  val tempo = 200

  override def getName: String = "superMario"

  override def generate()(implicit sequence: Sequence): Unit = {
    track("melody", SynthBass1, tempo) { implicit t =>
      SequenceRun(
        intro,
        aSection repeat 2,
        bSection repeat 2
      )
    }

    percussionTrack("percussion", tempo) { implicit t =>
      percussionASection repeat 37
    }
  }

  def intro = SequenceRun(
    (D~3 + F.sharp~4 + E~5) * Eighth,
    (D~3 + F.sharp~4 + E~5) * Eighth,
    Rest * Eighth,
    (D~3 + F.sharp~4 + E~5) * Eighth,
    Rest * Eighth,
    (D~3 + F.sharp~4 + C~5) * Eighth,
    (D~3 + F.sharp~4 + E~5) * Eighth,
    Rest * Eighth,
    (G~4 + B~4 + G~5) * Eighth,
    Rest * Quarter.dotted,
    (G~3 + G~4) * Quarter,
    Rest * Quarter
  )

  def aSection = SequenceRun(
    (G~3 + E~4 + C~5) * Eighth,
    Rest * Quarter,
    (E~3 + C~4 + G~4) * Eighth,
    Rest * Quarter,
    (C~3 + G~4 + E~4) * Eighth,
    Rest * Quarter,
    (F~3 + C~4 + A~4) * Eighth,
    Rest * Eighth,
    (G~3 + D~4 + B~4) * Eighth,
    Rest * Eighth,
    (G.flat~3 + D.flat~4 + B.flat~4) * Eighth,
    (F~3 + C~4 + A~4) * Quarter,

    (E~3 + C~4 + G~4) * Quarter.triplet,
    (C~4 + G~4 + E~5) * Quarter.triplet,
    (E~4 + B~4 + G~5) * Quarter.triplet,
    (F~4 + C~5 + A~5) * Eighth,
    Rest * Eighth,
    (D~4 + A~4 + F~5) * Eighth,
    (E~4 + B~4 + G~5) * Eighth,
    Rest * Eighth,
    (C~4 + A~4 + E~5) * Eighth,
    Rest * Eighth,
    (A~3 + E~4 + C~5) * Eighth,
    (B~3 + F~4 + D~5) * Eighth,
    (G~3 + D~4 + B~4) * Eighth,
    Rest * Quarter
  )

  def bSection = ParallelRun(
    SequenceRun(
      C~3 * Eighth,
      Rest * Quarter,
      G~3 * Eighth,
      Rest * Quarter,
      C~4 * Eighth,
      Rest * Eighth,
      F~3 * Eighth,
      Rest * Quarter,
      C~4 * Eighth,
      C~4 * Eighth,
      Rest * Eighth,
      F~3 * Eighth,
      Rest * Eighth,
      C~3 * Eighth,
      Rest * Quarter,
      E~3 * Eighth,
      Rest * Quarter,
      G~3 * Eighth,
      C~4 * Eighth,
      Rest * Half.dotted,
      G~3 * Eighth,
      Rest * Eighth,

      C~3 * Eighth,
      Rest * Quarter,
      G~3 * Eighth,
      Rest * Quarter,
      C~4 * Eighth,
      Rest * Eighth,
      F~3 * Eighth,
      Rest * Quarter,
      C~4 * Eighth,
      C~4 * Eighth,
      Rest * Eighth,
      F~3 * Eighth,
      Rest * Eighth,
      C~3 * Eighth,
      Rest * Eighth,
      A.flat~3 * Eighth,
      Rest * Quarter,
      B.flat~3 * Eighth,
      Rest * Quarter,
      C~4 * Eighth,
      Rest * Quarter,
      G~3 * Eighth,
      G~3 * Eighth,
      Rest * Eighth,
      C~3 * Eighth,
      Rest * Eighth
    ),
    SequenceRun(
      Rest * Quarter,
      (E~5 + MinThird) * Eighth,
      (D.sharp~5 + MinThird) * Eighth,
      (D~5 + MinThird) * Eighth,
      (B~4 + MajThird) * Eighth,
      Rest * Eighth,
      (C~5 + MajThird) * Eighth,
      Rest * Eighth,

      (E~4 + MajThird) * Eighth,
      (F~4 + MajThird) * Eighth,
      (G~4 + Fourth) * Eighth,
      Rest * Eighth,
      (C~4 + MajSixth) * Eighth,
      (E~4 + MinSixth) * Eighth,
      (F~4 + MajSixth) * Eighth,

      Rest * Quarter,
      (E~5 + MinThird) * Eighth,
      (D.sharp~5 + MinThird) * Eighth,
      (D~5 + MinThird) * Eighth,
      (B~4 + MajThird) * Eighth,
      Rest * Eighth,
      (C~5 + MajThird) * Eighth,
      Rest * Eighth,

      (F~5 + MajSecond + Fourth) * Eighth,
      Rest * Eighth,
      (F~5 + MajSecond + Fourth) * Eighth,
      (F~5 + MajSecond + Fourth) * Eighth,
      Rest * Quarter.dotted,

      Rest * Quarter,
      (E~5 + MinThird) * Eighth,
      (D.sharp~5 + MinThird) * Eighth,
      (D~5 + MinThird) * Eighth,
      (B~4 + MajThird) * Eighth,
      Rest * Eighth,
      (C~5 + MajThird) * Eighth,
      Rest * Eighth,

      (E~4 + MajThird) * Eighth,
      (F~4 + MajThird) * Eighth,
      (G~4 + Fourth) * Eighth,
      Rest * Eighth,
      (C~4 + MajSixth) * Eighth,
      (E~4 + MinSixth) * Eighth,
      (F~4 + MajSixth) * Eighth,

      Rest * Quarter,
      (A.flat~4 + Fifth) * Eighth,
      Rest * Quarter,
      (F~4 + MajSixth) * Eighth,
      Rest * Quarter,
      (E~4 + MinSixth) * Eighth,
      Rest * Quarter.dotted,
      Rest * Half
    )
  )

  def percussionASection = ParallelRun(
    SequenceRun(
      ClosedHiHat * Quarter,
      ClosedHiHat * Eighth.triplet,
      Rest * Eighth.triplet,
      ClosedHiHat * Eighth.triplet
    ) repeat 4,
    SequenceRun(
      Rest * Half,
      SnareDrum1 * Half,
      Rest * Half,
      SnareDrum1 * Half
    ),
    SequenceRun(
      BassDrum2 * Whole,
      BassDrum2 * Whole
    )
  )
}
