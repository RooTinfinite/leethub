// Kotlin Iterator reference:
// https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/

class PeekingIterator(private val iterator: Iterator<Int>) : Iterator<Int> {
    var peekedValue: Int? = null

    fun peek(): Int =
        if (peekedValue == null) {
            peekedValue = iterator.next()
            peekedValue!!
        } else {
            peekedValue!!
        }

    override fun next(): Int =
        if (peekedValue == null) {
            iterator.next()
        } else {
            val ret = peekedValue!!
            peekedValue = null
            ret
        }

    override fun hasNext(): Boolean = peekedValue != null || iterator.hasNext()
}


/**
 * Your PeekingIterator object will be instantiated and called as such:
 * var obj = PeekingIterator(arr)
 * var param_1 = obj.next()
 * var param_2 = obj.peek()
 * var param_3 = obj.hasNext()
 */