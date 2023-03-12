import java.util.TreeMap

@Suppress("NAME_SHADOWING")
class MyCalendarTwo {
    private val map: TreeMap<Int, Int> = TreeMap()
    private val overlap: TreeMap<Int, Int> = TreeMap()

    fun book(start: Int, end: Int): Boolean {
        var start = start
        var end = end
        val ol = overlap.lowerKey(end)
        if (ol == null || overlap[ol]!! <= start) {
            while (true) {
                val lower = map.lowerKey(end)
                if (lower == null || map[lower]!! <= start) {
                    break
                }
                overlap[start.coerceAtLeast(lower)] = end.coerceAtMost(map[lower]!!)
                start = start.coerceAtMost(lower)
                end = end.coerceAtLeast(map[lower]!!)
                map.remove(lower)
            }
            map[start] = end
            return true
        }
        return false
    }
}


/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * var obj = MyCalendarTwo()
 * var param_1 = obj.book(start,end)
 */