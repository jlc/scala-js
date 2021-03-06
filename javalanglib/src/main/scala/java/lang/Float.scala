package java.lang

import scala.scalajs.js

// This class is not emitted, but we need to define its members correctly
final class Float(value: scala.Float) extends Number with Comparable[Float] {

  def this(s: String) = this(Float.parseFloat(s))

  override def byteValue(): scala.Byte = sys.error("stub")
  override def shortValue(): scala.Short = sys.error("stub")
  def intValue(): scala.Int = sys.error("stub")
  def longValue(): scala.Long = sys.error("stub")
  def floatValue(): scala.Float = sys.error("stub")
  def doubleValue(): scala.Double = sys.error("stub")

  override def equals(that: Any): scala.Boolean = sys.error("stub")

  override def compareTo(that: Float): Int = sys.error("stub")

  override def toString(): String = sys.error("stub")

  def isNaN(): scala.Boolean = sys.error("stub")
  def isInfinite(): scala.Boolean = sys.error("stub")

}

object Float {
  final val TYPE = classOf[scala.Float]
  final val POSITIVE_INFINITY = 1.0f / 0.0f
  final val NEGATIVE_INFINITY = 1.0f / -0.0f
  final val NaN = 0.0f / 0.0f
  final val MAX_VALUE = scala.Float.MaxValue
  final val MIN_VALUE = scala.Float.MinPositiveValue
  final val MAX_EXPONENT = 127
  final val MIN_EXPONENT = -126
  final val SIZE = 32

  private[this] lazy val floatStrPat = new js.RegExp("^" +
      "[\\x00-\\x20]*"   + // optional whitespace
      "[+-]?"            + // optional sign
      "(NaN|Infinity|"   + // special cases
       "(\\d+\\.?\\d*|"  + // literal w/  leading digit
        "\\.\\d+)"       + // literal w/o leading digit
       "([eE][+-]?\\d+)?"+ // optional exponent
      ")[fFdD]?"         + // optional float / double specifier (ignored)
      "[\\x00-\\x20]*"   + // optional whitespace
      "$")

  @inline def valueOf(floatValue: scala.Float): Float = new Float(floatValue)

  @inline def valueOf(s: String): Float = valueOf(parseFloat(s))

  def parseFloat(s: String): scala.Float = {
    if (floatStrPat.test(s))
      js.parseFloat(s).toFloat
    else
      throw new NumberFormatException(s"""For input string: "$s"""")
  }

  @inline def toString(f: scala.Float): String = f.toString

  @inline def compare(a: scala.Float, b: scala.Float): scala.Int = {
    if (a == b) 0
    else if (a < b) -1
    else 1
  }

  @inline def isNaN(v: scala.Float): scala.Boolean =
    valueOf(v).isNaN()

  @inline def isInfinite(v: scala.Float): scala.Boolean =
    valueOf(v).isInfinite()

  def intBitsToFloat(bits: scala.Int): scala.Float = sys.error("unimplemented")
  def floatToIntBits(value: scala.Float): scala.Int = sys.error("unimplemented")
}
