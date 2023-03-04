/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var l = 1
        var r = n
        var mid: Int
        while (l < r) {
            mid = l + (r - l) / 2
            if (!isBadVersion(mid)) {
                l = mid + 1
            } else {
                r = mid
            }
        }
        return l
    }

}