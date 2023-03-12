class Solution {
    private val root = Node()
    private var longestWord: String? = ""

    private class Node {
        var children: Array<Node?> = arrayOfNulls(26)
        var str: String? = null

        fun insert(curr: Node?, word: String) {
            var curr = curr
            for (element in word) {
                if (curr!!.children[element.toInt() - 'a'.toInt()] == null) {
                    curr.children[element.toInt() - 'a'.toInt()] = Node()
                }
                curr = curr.children[element.toInt() - 'a'.toInt()]
            }
            curr!!.str = word
        }
    }

    fun longestWord(words: Array<String>): String? {
        for (word in words) {
            root.insert(root, word)
        }
        dfs(root)
        return longestWord
    }

    private fun dfs(curr: Node?) {
        for (i in 0..25) {
            if (curr!!.children[i] != null && curr.children[i]!!.str != null) {
                if (curr.children[i]!!.str!!.length > longestWord!!.length) {
                    longestWord = curr.children[i]!!.str
                }
                dfs(curr.children[i])
            }
        }
    }
}
