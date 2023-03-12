import java.util.Objects

/*
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
@Suppress("NAME_SHADOWING")
class Solution {
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        var head = head
        val len = getLength(head)
        val aveSize = len / k
        var extra = len % k
        val result = arrayOfNulls<ListNode>(k)
        for (i in 0 until k) {
            result[i] = head
            var aveSizeTmp = aveSize
            aveSizeTmp += if (extra-- > 0) 1 else 0
            var aveSizeTmp2 = aveSizeTmp
            while (aveSizeTmp-- > 0) {
                head = Objects.requireNonNull(head)?.next
            }
            if (result[i] != null) {
                var tmp = result[i]
                while (tmp!!.next != null && aveSizeTmp2-- > 1) {
                    tmp = tmp.next
                }
                tmp.next = null
            }
        }
        return result
    }

    private fun getLength(root: ListNode?): Int {
        var len = 0
        var tmp = root
        while (tmp != null) {
            len++
            tmp = tmp.next
        }
        return len
    }
}
