package com.nerdery.soundchallenge.services.midigenerators.dsl

/**
 * A run is a container which can be expanded to a set of note events
 */
trait Run {
  def expand(start: Long): Seq[NoteEvent]
  def length: Long

  def repeat(times: Int) = new SequentialRun(List.fill(times)(this):_*)
  def repeatFill(other: Run) = repeat(other.length.toInt / length.toInt)
}

/**
 * A sequential run contains one or more sub-runs which will play one after another
 */
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

/**
 * A parallel run contains one or more sub-runs which will play simultaneously
 */
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



