class Solution {
    fun findPairs(nums: IntArray, k: Int): Int {
        var res = 0
        val set: HashSet<Int> = HashSet()
        val twice: HashSet<Int> = HashSet()
        for (n in nums) {
            if (set.contains(n)) {
                if (k == 0 && !twice.contains(n)) {
                    res++
                    twice.add(n)
                } else {
                    continue
                }
            } else {
                if (set.contains(n - k)) {
                    res++
                }
                if (set.contains(n + k)) {
                    res++
                }
            }
            set.add(n)
        }
        return res
    }
}
