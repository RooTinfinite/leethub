class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val o = image[sr][sc]
        helper(image, sr, sc, newColor, o)
        return image
    }

    private fun helper(img: Array<IntArray>, r: Int, c: Int, n: Int, o: Int) {
        if (r >= img.size || c >= img[0].size || r < 0 || c < 0 || img[r][c] == n || img[r][c] != o) {
            return
        }
        img[r][c] = n
        helper(img, r + 1, c, n, o)
        helper(img, r - 1, c, n, o)
        helper(img, r, c + 1, n, o)
        helper(img, r, c - 1, n, o)
    }
}
