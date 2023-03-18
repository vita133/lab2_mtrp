class DoublyLinkedList<Char> {

    private class Node<Char>(var data: Char, var prev: Node<Char>? = null, var next: Node<Char>? = null)

    private var head: Node<Char>? = null
    private var tail: Node<Char>? = null
    private var size = 0

    fun length(): Int {
        return size
    }

    fun append(element: Char) {
        val newNode = Node(element)
        if (tail == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.prev = tail
            tail?.next = newNode
            tail = newNode
        }
        size++
    }

    fun insert(element: Char, index: Int) {
        if (index < 0 || index > size) {
            throw IndexOutOfBoundsException("Invalid index: $index")
        }
        if (index == size) {
            append(element)
            return
        }
        if (index == 0) {
            val h = head
            val newNode = Node<Char>(element, null, h)
            head = newNode
            h?.prev = newNode
            size++
            return
        }
        var currElement = 0
        var currNode = head
        while (currElement < index) {
            currNode = currNode?.next
            currElement++
        }
        val newNode = Node(element, currNode?.prev, currNode)
        currNode?.prev?.next = newNode
        currNode?.prev = newNode
        size++
    }

    fun delete(index: Int) {
        if (size == 0 || index < 0 || index >= size) return
        var node = tail
        var currElement = size - 1
        while (currElement >= index) {
            if (currElement == index) {
                node?.prev?.next = node?.next
                node?.next?.prev = node?.prev
                if (node == head) {
                    head = node?.next
                }
                if (node == tail) {
                    tail = node?.prev
                }
                size--
                return
            }
            node = node?.prev
            currElement--
        }
    }

    fun deleteAll(element: Char) {
        var currNode = head
        while (currNode != null) {
            if (currNode.data == element) {
                currNode.prev?.next = currNode.next
                currNode.next?.prev = currNode.prev
                if (currNode == head) {
                    head = currNode.next
                }
                if (currNode == tail) {
                    tail = currNode.prev
                }
                size--
            }
            currNode = currNode.next
        }
    }

    fun get(index: Int) : Char? {
        if (size == 0 || index < 0 || index >= size){
            throw IndexOutOfBoundsException("Invalid index: $index")
        }
        var node = tail
        var currElement = size - 1
        while (currElement >= index) {
            if (currElement == index) {
                if (node != null) {
                    return node.data
                }
            }
            node = node?.prev
            currElement--
        }
        throw IndexOutOfBoundsException("Element not found at index: $index")
    }

    fun clone(): DoublyLinkedList<Char> {
        val newList = DoublyLinkedList<Char>()
        var node = head
        while (node != null) {
            newList.append(node.data)
            node = node.next
        }
        return newList
    }

    fun findFirst(element: Char): Int {
        var currNode = head
        var index = 0
        while (currNode != null) {
            if (currNode.data == element) {
                return index
            }
            currNode = currNode.next
            index++
        }
        return -1
    }

    fun findLast(element: Char): Int {
        var currNode = tail
        var index = size - 1
        while (currNode != null) {
            if (currNode.data == element) {
                return index
            }
            currNode = currNode.prev
            index--
        }
        return -1
    }

    fun clear() {
        head = null
        tail = null
        size = 0
    }

    fun extend(other: DoublyLinkedList<Char>) {
        var currNode = other.head
        var index = 0
        while (currNode != null) {
            append(currNode.data)
            currNode = currNode.next
            index++
        }
    }

    fun reverse() {
        var temp: Node<Char>? = null
        var currNode = head
        while (currNode != null) {
            temp = currNode.prev
            currNode.prev = currNode.next
            currNode.next = temp
            currNode = currNode.prev
        }
        if (temp != null) {
            head = temp.prev
        }
    }

}