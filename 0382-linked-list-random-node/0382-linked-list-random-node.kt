/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
import kotlin.random.Random

/*
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
@Suppress("NAME_SHADOWING", "kotlin:S2245")
class Solution(head: ListNode?) {
    private val al: MutableList<Int>

    init {
        var head = head
        al = ArrayList()
        while (head != null) {
            al.add(head.`val`)
            head = head.next
        }
    }

    fun getRandom(): Int {
        /*
        Math.random() will generate a random number b/w 0 & 1.
        then multiply it with the array size.
        take only the integer part which is a random index.
        return the element at that random index.
         */
        val ind = Random.nextInt(al.size)
        return al[ind]
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(head)
 * var param_1 = obj.getRandom()
 */