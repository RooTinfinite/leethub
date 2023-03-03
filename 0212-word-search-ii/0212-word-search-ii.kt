class Solution {
    private var root: Tree? = null
    fun findWords(board: Array<CharArray>, words: Array<String?>): List<String> {
        if (board.size < 1 || board[0].size < 1) {
            return emptyList()
        }
        root = Tree()
        for (word in words) {
            Tree.addWord(root, word!!)
        }
        val collected: MutableList<String> = ArrayList()
        for (i in board.indices) {
            for (j in board[0].indices) {
                dfs(board, i, j, root, collected)
            }
        }
        return collected
    }

    private fun dfs(board: Array<CharArray>, i: Int, j: Int, cur: Tree?, collected: MutableList<String>) {
        var cur: Tree? = cur
        val c = board[i][j]
        if (c == '-') {
            return
        }
        cur = cur!!.getChild(c)
        if (cur == null) {
            return
        }
        if (cur.end != null) {
            val s: String = cur.end!!
            collected.add(s)
            cur.end = null
            if (cur.len() == 0) {
                Tree.deleteWord(root, s)
            }
        }
        board[i][j] = '-'
        if (i > 0) {
            dfs(board, i - 1, j, cur, collected)
        }
        if (i + 1 < board.size) {
            dfs(board, i + 1, j, cur, collected)
        }
        if (j > 0) {
            dfs(board, i, j - 1, cur, collected)
        }
        if (j + 1 < board[0].size) {
            dfs(board, i, j + 1, cur, collected)
        }
        board[i][j] = c
    }
}

class Tree {
    private var children: Array<Tree?>? = null
    var end: String? = null
    private var length = 0
    private fun addChild(c: Char): Tree? {
        val i = c.toInt() - 'a'.toInt()
        if (children == null) {
            children = arrayOfNulls(26)
        }
        if (children!![i] == null) {
            children!![i] = Tree()
            ++length
        }
        return children!![i]
    }

    fun getChild(c: Char): Tree? {
        return if (children == null) null else children!![c.toInt() - 'a'.toInt()]
    }

    fun len(): Int {
        return length
    }

    companion object {
        fun addWord(root: Tree?, word: String) {
            var t = root
            for (c in word.toCharArray()) {
                t = t!!.addChild(c)
            }
            t!!.end = word
        }

        fun deleteWord(root: Tree?, word: String) {
            var root = root
            var toDelOn = root
            var toDel = word[0]
            for (c in word.toCharArray()) {
                if (root!!.length > 1) {
                    toDelOn = root
                    toDel = c
                }
                root = root.getChild(c)
                requireNotNull(root)
            }
            toDelOn!!.children!![toDel.toInt() - 'a'.toInt()] = null
            --toDelOn.length
            require(root!!.length == 0)
        }
    }
}

