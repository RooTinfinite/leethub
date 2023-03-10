class Solution {
    fun predictPartyVictory(senate: String): String {
        val blocks = IntArray(2)
        val status = BooleanArray(senate.length)
        var changes = true
        while (changes) {
            changes = false
            for (i in senate.indices) {
                if (status[i]) {
                    continue
                }
                val curr = senate[i]
                val block: Int = if (curr == 'R') {
                    0
                } else {
                    1
                }
                if (blocks[1 - block] > 0) {
                    status[i] = true
                    blocks[1 - block]--
                    changes = true
                } else {
                    blocks[block]++
                }
            }
        }
        for (i in senate.indices) {
            if (!status[i]) {
                return if (senate[i] == 'R') {
                    "Radiant"
                } else {
                    "Dire"
                }
            }
        }
        return ""
    }
}
