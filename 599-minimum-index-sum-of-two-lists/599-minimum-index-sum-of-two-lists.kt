class Solution {
    fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
        var min = 1000000
        val hm: MutableMap<String, Int> = HashMap()
        val result: MutableList<String> = ArrayList()
        fillMap(list1, hm)
        // find min value
        for (i in list2.indices) {
            if (hm.containsKey(list2[i])) {
                val value = hm[list2[i]]!! + i
                // a new min value was found
                if (value < min) {
                    min = value
                    // Clean the arraylist
                    result.clear()
                    // add new min value
                    result.add(list2[i])
                } else if (value == min) {
                    result.add(list2[i])
                }
            }
        }
        return result.toTypedArray()
    }

    fun fillMap(a: Array<String>, hm: MutableMap<String, Int>) {
        for (i in a.indices) {
            hm[a[i]] = i
        }
    }
}
