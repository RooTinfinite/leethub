class MapSum {
    internal class Node {
        var `val`: Int = 0
        var child: Array<Node?> = arrayOfNulls(26)
    }

    private val root: Node = Node()

    fun insert(key: String, `val`: Int) {
        var curr: Node? = root
        for (c in key.toCharArray()) {
            if (curr!!.child[c.toInt() - 'a'.toInt()] == null) {
                curr.child[c.toInt() - 'a'.toInt()] = Node()
            }
            curr = curr.child[c.toInt() - 'a'.toInt()]
        }
        curr!!.`val` = `val`
    }

    private fun sumHelper(root: Node?): Int {
        var o = 0
        for (i in 0..25) {
            if (root!!.child[i] != null) {
                o += root.child[i]!!.`val` + sumHelper(root.child[i])
            }
        }
        return o
    }

    fun sum(prefix: String): Int {
        var curr: Node? = root
        for (c in prefix.toCharArray()) {
            if (curr!!.child[c.toInt() - 'a'.toInt()] == null) {
                return 0
            }
            curr = curr.child[c.toInt() - 'a'.toInt()]
        }
        val sum = curr!!.`val`
        return sum + sumHelper(curr)
    }
}
