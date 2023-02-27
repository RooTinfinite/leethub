class Solution {
    fun trap(height: IntArray): Int {
        val size = height.size
        var maxLeft = 0
        var maxRight = 0
        var totalWater = 0
        var leftPtr = 0
        var rightPtr = size - 1
        while (leftPtr < rightPtr) {
            if (height[leftPtr] <= height[rightPtr]) {
                if (maxLeft > height[leftPtr]) {
                    totalWater = totalWater + maxLeft - height[leftPtr]
                } else {
                    maxLeft = height[leftPtr]
                }
                ++leftPtr
            } else {
                if (maxRight > height[rightPtr]) {
                    totalWater = totalWater + maxRight - height[rightPtr]
                } else {
                    maxRight = height[rightPtr]
                }
                --rightPtr
            }
        }
        return totalWater
    }
}
