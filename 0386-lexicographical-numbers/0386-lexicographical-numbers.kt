class Solution {
    fun lexicalOrder(n: Int): List<Int> {
        val list = ArrayList<Int>()
        fun recursion(x: Int) {
            if (x > n) return
            list.add(x)
            for (i in 0..9) {
                recursion(x * 10 + i)
            }
        }
        for (i in 1..9) {
            recursion(i)
        }
        return list
    }
}
