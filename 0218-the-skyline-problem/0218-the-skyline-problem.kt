import java.util.TreeMap

class Solution {
    fun getSkyline(blds: Array<IntArray>): List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        if (blds.isEmpty()) {
            return ans
        }
        val totalBuildings = blds.size
        val buildings = Array<Building?>(totalBuildings * 2) { null }
        var idx = 0
        for (building in blds) {
            buildings[idx] = Building(building[0], building[2], true)
            buildings[idx + 1] = Building(building[1], building[2], false)
            idx += 2
        }
        buildings.sort()
        val skyline = TreeMap<Int, Int>()
        skyline[0] = 1
        var prevMaxHeight = 0
        for (building in buildings) {
            if (building == null) {
                continue
            }
            val height = building.height
            if (building.isStart) {
                skyline[height] = 1 + (skyline[height] ?: 0)
            } else {
                skyline[height] = (skyline[height] ?: 1) - 1
                if (skyline[height] == 0) skyline.remove(height)
            }
            val xCoor = building.xCoor
            val curMaxHeight = skyline.lastKey()
            if (prevMaxHeight != curMaxHeight) {
                ans.add(arrayListOf(xCoor, curMaxHeight))
                prevMaxHeight = curMaxHeight
            }
        }
        return ans
    }

    private class Building(val xCoor: Int, val height: Int, val isStart: Boolean) : Comparable<Building> {
        override fun compareTo(other: Building): Int {
            return COMPARATOR.compare(this, other)
        }

        private companion object {
            private val COMPARATOR = Comparator<Building> { a, b ->
                when {
                    a.xCoor != b.xCoor -> a.xCoor.compareTo(b.xCoor)
                    a.isStart && b.isStart -> b.height.compareTo(a.height)
                    !(a.isStart || b.isStart) -> a.height.compareTo(b.height)
                    else -> if (a.isStart) -1 else 1
                }
            }
        }
    }
}
