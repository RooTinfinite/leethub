class Solution {
    fun diffWaysToCompute(expression: String): List<Int> {
        return diffWayToCompute(expression, hashMapOf())
    }

    private fun diffWayToCompute(expression: String, hashMap: HashMap<String, List<Int>>): List<Int> {
        if (hashMap.containsKey(expression)) {
            return hashMap[expression]!!
        }
        val newList = arrayListOf<Int>()
        if (!hasOperatorInBetween(expression)) {
            newList.add(Integer.parseInt(expression))
        } else {
            for ((index, _) in expression.withIndex()) {
                val operator = expression[index]
                if (!Character.isDigit(operator)) {
                    val leftExpression = diffWayToCompute(expression.substring(0, index), hashMap)
                    val rightExpression = diffWayToCompute(expression.substring(index + 1), hashMap)
                    for (l in leftExpression) {
                        for (r in rightExpression) {
                            when (operator) {
                                '+' -> newList.add(l + r)
                                '-' -> newList.add(l - r)
                                '*' -> newList.add(l * r)
                            }
                        }
                    }
                }
            }
        }
        hashMap[expression] = newList
        return newList
    }

    private fun hasOperatorInBetween(expression: String): Boolean {
        for ((index, _) in expression.withIndex()) {
            when (expression[index]) {
                '+' -> return true
                '-' -> return true
                '*' -> return true
            }
        }
        return false
    }
}
