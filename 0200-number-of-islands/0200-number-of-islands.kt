class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var islands = 0
        if (grid.isNotEmpty() && grid[0].isNotEmpty()) {
            for (i in grid.indices) {
                for (j in grid[0].indices) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j)
                        islands++
                    }
                }
            }
        }
        return islands
    }

    private fun dfs(grid: Array<CharArray>, x: Int, y: Int) {
        if (x < 0 || grid.size <= x || y < 0 || grid[0].size <= y || grid[x][y] != '1') {
            return
        }
        grid[x][y] = 'x'
        dfs(grid, x + 1, y)
        dfs(grid, x - 1, y)
        dfs(grid, x, y + 1)
        dfs(grid, x, y - 1)
    }
}
