package com.nerdery.soundchallenge.services.midigenerators.dsl

/**
 * Represents a musical interval between two keys
 */
case class Interval(halfSteps: Int)

object Interval {
  val MinSecond = Interval(1)
  val MajSecond = Interval(2)
  val MinThird = Interval(3)
  val MajThird = Interval(4)
  val Fourth = Interval(5)
  val Fifth = Interval(7)
  val MinSixth = Interval(8)
  val MajSixth = Interval(9)
  val MinSeventh = Interval(10)
  val MajSeventh = Interval(11)
  val Octave = Interval(12)
}