import java.util.Random
import java.util.TreeMap

@Suppress("kotlin:S2245")
class Solution(val w: IntArray) {

    var x: IntArray = IntArray(w.size) { 0 }
    val rand = Random()
    val tree = TreeMap<Int, Int>()
    var sum = 0

    init {
        for (i in w.indices) {
            tree.put(sum, i)
            sum += w[i]
        }
    }

    fun pickIndex(): Int {
        val r = rand.nextInt(sum)
        return tree.floorEntry(r).value!!
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(w)
 * var param_1 = obj.pickIndex()
 */