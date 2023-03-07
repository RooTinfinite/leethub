class Solution {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        return people.sortedWith(compareBy({ -it[0] }, { it[1] }))
            .fold(mutableListOf<IntArray>()) { output, p -> output.add(p[1], p); output }
            .toTypedArray()
    }
}
