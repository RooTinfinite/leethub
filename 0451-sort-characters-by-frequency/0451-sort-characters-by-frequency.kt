class Solution {
    fun frequencySort(s: String) = s.groupingBy { it }.eachCount().entries.sortedByDescending { it.value }
        .joinToString("") {
            StringBuilder().apply { for (i in 1..it.value) append(it.key) }.toString()
        }
}
