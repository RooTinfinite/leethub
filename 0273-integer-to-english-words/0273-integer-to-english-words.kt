import java.util.StringJoiner

class Solution {
    private val ones = arrayOf(
        "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "
    )
    private val teens = arrayOf(
        "Ten ",
        "Eleven ",
        "Twelve ",
        "Thirteen ",
        "Fourteen ",
        "Fifteen ",
        "Sixteen ",
        "Seventeen ",
        "Eighteen ",
        "Nineteen "
    )
    private val twenties = arrayOf(
        "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "
    )

    fun numberToWords(num: Int): String {
        if (num == 0) {
            return "Zero"
        }
        val joiner = StringJoiner("")
        processThreeDigits(joiner, num / 1000000000, "Billion ")
        processThreeDigits(joiner, num / 1000000, "Million ")
        processThreeDigits(joiner, num / 1000, "Thousand ")
        processThreeDigits(joiner, num, null)
        return joiner.toString().trim { it <= ' ' }
    }

    private fun processThreeDigits(joiner: StringJoiner, input: Int, name: String?) {
        val threeDigit = input % 1000
        if (threeDigit > 0) {
            if (threeDigit / 100 > 0) {
                joiner.add(ones[threeDigit / 100 - 1])
                val hundred = "Hundred "
                joiner.add(hundred)
            }
            if (threeDigit % 100 >= 20) {
                joiner.add(twenties[threeDigit % 100 / 10 - 2])
                if (threeDigit % 10 > 0) {
                    joiner.add(ones[threeDigit % 10 - 1])
                }
            } else if (threeDigit % 100 >= 10 && threeDigit % 100 < 20) {
                joiner.add(teens[threeDigit % 10])
            } else if (threeDigit % 100 > 0 && threeDigit % 100 < 10) {
                joiner.add(ones[threeDigit % 10 - 1])
            }
            if (name != null) {
                joiner.add(name)
            }
        }
    }
}
