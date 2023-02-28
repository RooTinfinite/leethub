class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        if (triangle.isEmpty()) {
            return 0
        }
        val dp = Array(triangle.size) { IntArray(triangle[triangle.size - 1].size) }
        for (temp in dp) {
            Arrays.fill(temp, -10001)
        }
        return dfs(triangle, dp, 0, 0)
    }

    private fun dfs(triangle: List<List<Int>>, dp: Array<IntArray>, row: Int, col: Int): Int {
        if (row >= triangle.size) {
            return 0
        }
        if (dp[row][col] != -10001) {
            return dp[row][col]
        }
        val sum = (
            triangle[row][col] +
                Math.min(
                    dfs(triangle, dp, row + 1, col),
                    dfs(triangle, dp, row + 1, col + 1)
                )
            )
        dp[row][col] = sum
        return sum
    }
}
