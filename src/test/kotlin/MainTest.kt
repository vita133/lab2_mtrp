import main.kotlin.DoublyLinkedList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DoublyLinkedListTest {
    @Test
    fun `length should return the correct number of elements`() {
        val list = DoublyLinkedList<Char>()

        // Test for an empty list
        assertEquals(0, list.length())

        // Test for a list with elements
        list.append('A')
        list.append('B')
        assertEquals(2, list.length())

        // Test for deleting an element
        list.delete(0)
        assertEquals(1, list.length())
    }


    @Test
    fun `append should add the element to the end of the list`() {
        val list = DoublyLinkedList<Char>()

        // Test append first element to the list
        list.append('A')
        assertEquals(1, list.length())
        assertEquals('A', list.get(0))

        // Test append second element to the list
        list.append('B')
        assertEquals(2, list.length())
        assertEquals('A', list.get(0))
        assertEquals('B', list.get(1))
    }

    @Test
    fun `insert should add an element at the specified index`() {
        val list = DoublyLinkedList<Char>()

        // Test insert element at index 0
        list.insert('A', 0)
        assertEquals(1, list.length())
        assertEquals('A', list.get(0))

        // Test insert element at index 1
        list.insert('B', 1)
        assertEquals(2, list.length())
        assertEquals('A', list.get(0))
        assertEquals('B', list.get(1))

        // Test insert element at index 1 again
        list.insert('C', 1)
        assertEquals(3, list.length())
        assertEquals('A', list.get(0))
        assertEquals('C', list.get(1))
        assertEquals('B', list.get(2))

        // Test insert element at end
        list.insert('D', 3)
        assertEquals(4, list.length())
        assertEquals('A', list.get(0))
        assertEquals('C', list.get(1))
        assertEquals('B', list.get(2))
        assertEquals('D', list.get(3))

        // Test with invalid index
        assertThrows<IndexOutOfBoundsException> { list.insert('E', 5) }
    }

    @Test
    fun `delete should remove element from the list at the given index`() {
        val list = DoublyLinkedList<Char>()
        list.append('A')
        list.append('B')
        list.append('C')

        // Test delete element with index 1
        val removedElement1 = list.delete(1)
        assertEquals('B', removedElement1)
        assertEquals(2, list.length())
        assertEquals('A', list.get(0))
        assertEquals('C', list.get(1))

        // Test delete element with index 0
        val removedElement2 = list.delete(0)
        assertEquals('A', removedElement2)
        assertEquals(1, list.length())
        assertEquals('C', list.get(0))

        // Test with invalid index
        assertThrows<IndexOutOfBoundsException> { list.delete(2) }
    }

    @Test
    fun `deleteAll should remove all elements with the given value`() {
        val list = DoublyLinkedList<Char>()
        list.append('A')
        list.append('B')
        list.append('A')
        list.append('C')

        // Test remove all elements with value 'A'
        list.deleteAll('A')
        assertEquals(2, list.length())
        assertEquals('B', list.get(0))
        assertEquals('C', list.get(1))

        // Test make no changes, if element is not present
        list.deleteAll('D')
        assertEquals(2, list.length())
        assertEquals('B', list.get(0))
        assertEquals('C', list.get(1))

        // Test remove all elements with value 'B'
        list.deleteAll('B')
        assertEquals(1, list.length())
        assertEquals('C', list.get(0))
    }

    @Test
    fun `get should return the value of the element at the given index`() {
        val linkedList = DoublyLinkedList<Char>()
        linkedList.append('A')
        linkedList.append('B')
        linkedList.append('C')

        // Test return the value of element at index 0, 1, 2
        assertEquals('A', linkedList.get(0))
        assertEquals('B', linkedList.get(1))
        assertEquals('C', linkedList.get(2))

        // Test with invalid index
        assertThrows<IndexOutOfBoundsException> {
            linkedList.get(-1)
        }
        assertThrows<IndexOutOfBoundsException> {
            linkedList.get(3)
        }
    }

    @Test
    fun `clone should return a new list with the same elements`() {
        val list = DoublyLinkedList<Char>()
        list.append('A')
        list.append('B')
        list.append('C')

        // Test should return a copy list
        val clonedList = list.clone()
        assertEquals(3, clonedList.length())
        assertEquals('A', clonedList.get(0))
        assertEquals('B', clonedList.get(1))
        assertEquals('C', clonedList.get(2))

        // Test original list is not modified
        clonedList.delete(0)
        assertEquals(2, clonedList.length())
        assertEquals(3, list.length())
    }

    @Test
    fun `reverse should return a new reversed list`() {
        val list = DoublyLinkedList<Char>()
        list.append('A')
        list.append('B')
        list.append('C')

        // Test should return a reversed list
        val reversedList = list.reverse()
        assertEquals(3, reversedList.length())
        assertEquals('C', reversedList.get(0))
        assertEquals('B', reversedList.get(1))
        assertEquals('A', reversedList.get(2))

        // Test original list is not modified
        reversedList.delete(0)
        assertEquals(2, reversedList.length())
        assertEquals(3, list.length())
    }

    @Test
    fun `findFirst should return the index of the first occurrence of value from head`() {
        val list = DoublyLinkedList<Char>()
        list.append('A')
        list.append('B')
        list.append('A')
        list.append('C')

        // Test return the index of the first occurrence of value
        assertEquals(0, list.findFirst('A'))
        assertEquals(1, list.findFirst('B'))

        // Test return -1, if the data item is not found
        assertEquals(-1, list.findFirst('D'))
    }

    @Test
    fun `findLast should return the index of the first occurrence of value from tail`() {
        val list = DoublyLinkedList<Char>()
        list.append('A')
        list.append('B')
        list.append('A')
        list.append('C')

        // Test return the index of the first occurrence of value
        assertEquals(2, list.findLast('A'))
        assertEquals(1, list.findLast('B'))

        // Test return -1, if the data item is not found
        assertEquals(-1, list.findLast('D'))
    }

    @Test
    fun `clear should remove all elements from the list`() {
        val list = DoublyLinkedList<Char>()
        list.append('A')
        list.append('B')
        list.append('C')
        assertEquals(3, list.length())

        // Test remove all elements from the list
        list.clear()
        assertEquals(0, list.length())
    }

    @Test
    fun `extend should add all elements from the given list to the end of the list`() {
        val list1 = DoublyLinkedList<Char>()
        list1.append('A')
        list1.append('B')
        list1.append('C')

        val list2 = DoublyLinkedList<Char>()
        list2.append('D')
        list2.append('E')
        list2.append('F')

        // Test add all element from the given list to the list
        list1.extend(list2)
        assertEquals(6, list1.length())
        assertEquals('A', list1.get(0))
        assertEquals('D', list1.get(3))
        assertEquals('F', list1.get(5))

        // Test original list is not modified
        list2.delete(0)
        assertEquals(6, list1.length())
    }
}