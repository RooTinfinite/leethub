class Solution {
    fun countBattleships(board: Array<CharArray>?): Int {
        if (board == null || board.size == 0) {
            return 0
        }
        var count = 0
        val m = board.size
        val n = board[0].size
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (board[i][j] != '.' && (j <= 0 || board[i][j - 1] != 'X') &&
                    (i <= 0 || board[i - 1][j] != 'X')
                ) {
                    count++
                }
            }
        }
        return count
    }
}
