class Solution {
    fun fizzBuzz(n: Int): Array<String> = Array<String>(n) { index ->
        val value = index + 1
        when {
            (value % 3 == 0 && value % 5 == 0) -> "FizzBuzz"
            (value % 3 == 0) -> "Fizz"
            (value % 5 == 0) -> "Buzz"
            else -> "$value"
        }
    }
}
