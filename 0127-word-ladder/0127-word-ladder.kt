class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordDict: List<String>): Int {
        var beginSet: MutableSet<String> = HashSet()
        var endSet: MutableSet<String> = HashSet()
        val wordSet: Set<String> = HashSet(wordDict)
        val visited: MutableSet<String> = HashSet()
        if (!wordDict.contains(endWord)) {
            return 0
        }
        var len = 1
        val strLen = beginWord.length
        beginSet.add(beginWord)
        endSet.add(endWord)
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size > endSet.size) {
                val temp = beginSet
                beginSet = endSet
                endSet = temp
            }
            val tempSet: MutableSet<String> = HashSet()
            for (s in beginSet) {
                val chars = s.toCharArray()
                for (i in 0 until strLen) {
                    val old = chars[i]
                    var j = 'a'
                    while (j <= 'z') {
                        chars[i] = j
                        val temp = String(chars)
                        if (endSet.contains(temp)) {
                            return len + 1
                        }
                        if (!visited.contains(temp) && wordSet.contains(temp)) {
                            tempSet.add(temp)
                            visited.add(temp)
                        }
                        j++
                    }
                    chars[i] = old
                }
            }
            beginSet = tempSet
            len++
        }
        return 0
    }
}
