class Solution {
    fun isOneBitCharacter(arr: IntArray): Boolean {
        var i = 0
        while (i < arr.size - 1) {
            i = if (arr[i] == 1) i + 2 else i + 1
        }
        return i == arr.size - 1
    }
}
