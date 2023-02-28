class LRUCache(capacity: Int) {
    private val nodeMap = HashMap<Int, Node>()
    private val head = Node()
    private val tail = Node()
    private var cacheCapacity = 0

    init {
        head.next = tail
        tail.prev = head
        cacheCapacity = capacity
    }

    fun get(key: Int): Int {
        return if (!nodeMap.containsKey(key)) {
            -1
        } else {
            val requiredNode = nodeMap.getValue(key)
            update(requiredNode)
            requiredNode.value
        }
    }

    fun put(key: Int, value: Int) {
        if (nodeMap.containsKey(key)) {
            val requiredNode = nodeMap.getValue(key)
            requiredNode.value = value
            update(requiredNode)
        } else {
            val newNode = Node(key = key, value = value)
            if (nodeMap.size >= cacheCapacity) {
                val nodeToDelete = tail.prev!!
                remove(nodeToDelete)
                nodeMap.remove(nodeToDelete.key)
            }
            add(newNode)
            nodeMap.put(key, newNode)
        }
    }

    fun add(node: Node) {
        val after = head.next
        head.next = node
        node.prev = head
        node.next = after
        after?.prev = node
    }

    private fun remove(node: Node) {
        val before = node.prev
        val after = node.next

        before?.next = after
        after?.prev = before
    }

    private fun update(node: Node) {
        remove(node)
        add(node)
    }

    data class Node(var key: Int = -1, var value: Int = -1, var next: Node? = null, var prev: Node? = null)
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */