class Solution {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var start = 0
        var end = letters.size - 1
        // If target is greater than last element return first element of the array.
        if (letters[letters.size - 1] <= target) {
            return letters[start]
        }
        while (start < end) {
            val mid = start + (end - start) / 2
            if (letters[mid] <= target) {
                start = mid + 1
            } else {
                end = mid
            }
        }
        return letters[start]
    }
}
