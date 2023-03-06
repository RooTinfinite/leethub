class Solution {
    fun maxProduct(words: Array<String>): Int {
        val n = words.size
        var res = 0
        val masks = IntArray(n)
        for (i in 0 until n) {
            masks[i] = getMask(words[i])
        }
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                if (masks[i] and masks[j] == 0) {
                    res = Math.max(res, words[i].length * words[j].length)
                }
            }
        }
        return res
    }

    private fun getMask(s: String): Int {
        var mask = 0
        for (i in 0 until s.length) {
            val c = s[i]
            mask = mask or (1 shl c.toInt() - 'a'.toInt())
        }
        return mask
    }
}
