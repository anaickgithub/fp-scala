package funsets

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/**
 * 2. Purely Functional Sets.
 */
object FunSets {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type FunSet = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: FunSet, elem: Int): Boolean =
    s(elem)

  /**
   * Returns the set of the one given element.
   */
  def singleElementSet(elem: Int): FunSet =
    //TODO : singleton set
    //def fonction(x:Int):Boolean={x==elem}fonction
    x => x == elem;

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: FunSet, t: FunSet): FunSet = /*{
    //TODO : union
    def fonction(x: Int): Boolean = {
      contains(s, x) || contains(t, x)
    }
    fonction
  }*/
    x => contains(s, x) || contains(t, x)

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` or `t`.
   */
  def intersect(s: FunSet, t: FunSet): FunSet =
    // TODO : interesection between 2 sets
    x => contains(s, x) && contains(t, x)

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: FunSet, t: FunSet): FunSet =
    // TODO : difference between 2 sets
    x => contains(s, x) && !contains(t, x)

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: FunSet, p: Int => Boolean): FunSet =
    //TODO : return a new set in which only elements verifying the predicate are kept
    x => if (contains(s, x)) contains(p, x) else false
  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: FunSet, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (contains(s, a) && !contains(p, a)) false
      else iter(a + 1)
    }
    iter(-bound)
  }
  //TODO: forall : check if all integers verify the predicate

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: FunSet, p: Int => Boolean): Boolean =
    //TODO: check if at least an integer verifies the predicate
    if (forall(s, x => !contains(p, x))) false else true

  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  def map(s: FunSet, f: Int => Int): FunSet =
    //TODO : transform into a new set
    a => exists(s, x => a == f(x))

  def toSet(ints: List[Int]): FunSet =
    ??? //TODO : (optional) convert a list to Set

  def toList(set: FunSet): List[Int] = {
    //TODO : (optional) convert a Set to a List
    def iter(a: Int): ListBuffer[Int] = {
      if (a > bound) ListBuffer()
      else if (set(a)) iter(a + 1) :+ a
      else iter(a + 1)
    }
    iter(-bound).toList
  }

  /**
   * Displays the contents of a set
   */
  def toString(s: FunSet): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: FunSet) {
    println(toString(s))
  }
}
