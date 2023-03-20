package main.kotlin

class DoublyLinkedList<Char> {

    private val list = mutableListOf<Char>()

    fun length(): Int {
        return list.size
    }

    fun append(element: Char) {
        list.add(element)
    }

    fun insert(element: Char, index: Int) {
        if (index < 0 || index > list.size) {
            throw IndexOutOfBoundsException("Invalid index: $index")
        }
        list.add(index, element)
    }

    fun delete(index: Int): Char? {
        if (list.isEmpty() || index < 0 || index >= list.size) {
            throw IndexOutOfBoundsException("Invalid index: $index")
        }
        return list.removeAt(index)
    }

    fun deleteAll(element: Char) {
        list.removeAll { it == element }
    }

    fun get(index: Int): Char? {
        if (list.isEmpty() || index < 0 || index >= list.size) {
            throw IndexOutOfBoundsException("Invalid index: $index")
        }
        return list[index]
    }

    fun clone(): DoublyLinkedList<Char> {
        val newList = DoublyLinkedList<Char>()
        newList.list.addAll(list)
        return newList
    }

    fun findFirst(element: Char): Int {
        return list.indexOf(element)
    }

    fun findLast(element: Char): Int {
        return list.lastIndexOf(element)
    }

    fun clear() {
        list.clear()
    }

    fun extend(other: DoublyLinkedList<Char>) {
        list.addAll(other.list)
    }

    fun reverse(): DoublyLinkedList<Char> {
        val reversedList = DoublyLinkedList<Char>()
        reversedList.list.addAll(list.reversed())
        return reversedList
    }
}
