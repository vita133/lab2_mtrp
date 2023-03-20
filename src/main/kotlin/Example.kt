package main.kotlin

fun main() {
    val list = DoublyLinkedList<Char>()

    list.append('a')
    list.append('b')
    list.append('c')
    println("List after appending elements:[${list.get(0)}, ${list.get(1)}, ${list.get(2)} ]")

    list.insert('d', 2)
    println("List after inserting element at index 2: [${list.get(0)}, ${list.get(1)}, ${list.get(2)}, ${list.get(3)}]")

    val deletedElement = list.delete(1)
    println("List after deleting element at index 1: [${list.get(0)}, ${list.get(1)}, ${list.get(2)}]")
    println("Deleted element: $deletedElement")

    val length = list.length()
    println("Length of the list: $length")

    val element = list.get(1)
    println("Element at index 1: $element")

    val clonedList = list.clone()
    println("Cloned list: [${clonedList.get(0)}, ${clonedList.get(1)}, ${clonedList.get(2)}]")

    val firstOccurrence = list.findFirst('b')
    println("First occurrence of 'b'(no occurrence): $firstOccurrence")

    val lastOccurrence = list.findLast('c')
    println("Last occurrence of 'c': $lastOccurrence")

    val otherList = DoublyLinkedList<Char>()
    otherList.append('e')
    otherList.append('f')
    list.extend(otherList)
    println("List after extending with another list: [${list.get(0)}, ${list.get(1)}]")

    val reversedList = list.reverse()
    println("Reversed list: [${list.get(0)}, ${list.get(1)}]")

    list.deleteAll('e')
    println("List after deleting all occurrences of 'e': [${list.get(0)}, ${list.get(1)}]")

    list.clear()
    val length2 = list.length()
    println("Length list after clearing: $length2 ")

}
