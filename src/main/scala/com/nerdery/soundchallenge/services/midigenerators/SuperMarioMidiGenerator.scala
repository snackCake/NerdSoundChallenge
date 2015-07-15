package com.nerdery.soundchallenge.services.midigenerators

import javax.sound.midi.Sequence

import com.nerdery.soundchallenge.midi.GeneralMidiVoices._
import com.nerdery.soundchallenge.services.midigenerators.Note._
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
    // TODO: make this not be "Mary Had a Little Lamb"

    track("melody", Glockenspiel) { implicit t =>
      play(e4, quarter.dotted)
      play(d4, eighth)
      play(c4, quarter)
      play(d4, quarter)
      play(e4, quarter)
      play(e4, quarter)
      play(e4, half)
    }
  }
}
