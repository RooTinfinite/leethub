class Trie {
    private val root: TrieNode
    private var startWith = false

    class TrieNode {
        // Initialize your data structure here.
        var children: Array<TrieNode?>
        var isWord = false

        init {
            children = arrayOfNulls(26)
        }
    }

    // Inserts a word into the trie.
    fun insert(word: String) {
        insert(word, root, 0)
    }

    private fun insert(word: String, root: TrieNode?, idx: Int) {
        if (idx == word.length) {
            root!!.isWord = true
            return
        }
        val index = word[idx] - 'a'
        if (root!!.children[index] == null) {
            root.children[index] = TrieNode()
        }
        insert(word, root.children[index], idx + 1)
    }

    // Returns if the word is in the trie.
    @JvmOverloads
    fun search(word: String, root: TrieNode? = this.root, idx: Int = 0): Boolean {
        if (idx == word.length) {
            startWith = true
            return root!!.isWord
        }
        val index = word[idx] - 'a'
        if (root!!.children[index] == null) {
            startWith = false
            return false
        }
        return search(word, root.children[index], idx + 1)
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    fun startsWith(prefix: String): Boolean {
        search(prefix)
        return startWith
    }

    init {
        root = TrieNode()
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */