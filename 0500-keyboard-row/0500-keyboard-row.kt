import java.util.Random

/*
 * The rand7() API is already defined in the parent class SolBase.
 * fun rand7(): Int {}
 * @return a random integer in the range 1 to 7
 */
@Suppress("kotlin:S2245")
class Solution {
    private val random: Random = Random()
    fun rand10(): Int {
        var r1: Int
        do {
            var r2: Int
            do { r2 = rand7() } while (r2 == 7)
            if (r2 in 1..3) { r1 = rand7() } else { r1 = 7 + rand7() }
        } while (r1 > 10)
        return r1
    }

    private fun rand7(): Int {
        return random.nextInt(7) + 1
    }
}
