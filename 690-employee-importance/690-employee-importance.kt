/*
 *	// Definition for Employee.
 *	class Employee {
 *		var id:Int = 0
 *		var importance:Int = 0
 *		var subordinates:List<Int> = listOf()
 *	}
 */
class Solution {
    fun getImportance(employees: List<Employee?>, id: Int): Int {
        val map: MutableMap<Int, Employee> = HashMap()
        for (emp in employees) {
            map[emp!!.id] = emp
        }
        return calculateImportance(id, map)
    }

    private fun calculateImportance(id: Int, map: Map<Int, Employee>): Int {
        val employee = map[id]
        var sum = employee!!.importance
        for (sub in employee.subordinates) {
            sum += calculateImportance(sub, map)
        }
        return sum
    }
}
