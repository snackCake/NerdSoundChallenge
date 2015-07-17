package com.nerdery.soundchallenge.services.midigenerators.dsl

case class Chord(keys: Key*) {
  def *(duration: Duration) = new ParallelRun(keys.map(_ * duration):_*)
  def +(key: Key) = Chord(keys :+ key:_*)
  def +(interval: Interval) = Chord(keys :+ Key(keys.last.pitch+interval.halfSteps, keys.last.octave):_*)
  def -(interval: Interval) = Chord(keys :+ Key(keys.last.pitch-interval.halfSteps, keys.last.octave):_*)
}

trait Run {
  def expand(start: Long): Seq[NoteEvent]
  def length: Long

  def repeat(times: Int) = new SequentialRun(List.fill(times)(this):_*)
  def repeatFill(other: Run) = repeat(other.length.toInt / length.toInt)
}

case class SequentialRun(runs: Run*) extends Run {
  override def expand(start: Long) = {
    var expanded = Seq[NoteEvent]()
    var tick = start

    for(run <- runs) {
      expanded ++= run.expand(tick)
      tick += run.length
    }

    expanded
  }
  override def length = runs.map(_.length).sum
}

case class ParallelRun(runs: Run*) extends Run {
  override def expand(start: Long) = {
    var expanded = Seq[NoteEvent]()

    for(run <- runs) {
      expanded ++= run.expand(start)
    }

    expanded
  }
  override def length = runs.map(_.length).max
}

case class NoteEvent(tick: Long, note: Note)