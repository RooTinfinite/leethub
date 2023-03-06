class Solution {
    private fun gcd(n1: Int, n2: Int): Int {
        return if (n2 == 0) {
            n1
        } else gcd(n2, n1 % n2)
    }

    fun canMeasureWater(jug1Capacity: Int, jug2Capacity: Int, targetCapacity: Int): Boolean {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false
        }
        val gcd = gcd(jug1Capacity, jug2Capacity)
        return targetCapacity % gcd == 0
    }
}
