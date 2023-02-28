class Solution {
    fun wordBreak(s: String, wordDict: List<String>?): List<String> {
        val result: MutableList<String> = LinkedList()
        val wordSet: Set<String> = HashSet(wordDict)
        dfs(s, wordSet, 0, StringBuilder(), result)
        return result
    }

    private fun dfs(
        s: String,
        wordSet: Set<String>,
        index: Int,
        sb: StringBuilder,
        result: MutableList<String>
    ) {
        if (index == s.length) {
            if (sb[sb.length - 1] == ' ') {
                sb.setLength(sb.length - 1)
            }
            result.add(sb.toString())
            return
        }
        val len = sb.length
        for (i in index + 1..s.length) {
            val subs = s.substring(index, i)
            if (wordSet.contains(subs)) {
                sb.append(subs).append(" ")
                dfs(s, wordSet, i, sb, result)
            }
            sb.setLength(len)
        }
    }
}
