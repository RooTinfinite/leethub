class Solution {
    fun climbStairs(n: Int): Int {
        if (n < 2) {
            return n
        }
        val cache = IntArray(n)
        // creating a cache or DP to store the result
        // so that we dont have to iterate multiple times
        // for the same values;

        // for 0 and 1 the result array i.e cache values would be 1 and 2
        // in loop we are just getting ith values i.e 5th step values from
        // i-1 and i-2 which are 4th step and 3rd step values.
        cache[0] = 1
        cache[1] = 2
        for (i in 2 until n) {
            cache[i] = cache[i - 1] + cache[i - 2]
        }
        return cache[n - 1]
    }
}
