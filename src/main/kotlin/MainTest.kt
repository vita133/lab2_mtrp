import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DoublyLinkedListTest {

    @Test
    fun `length should be zero when list is empty`() {
        val list = DoublyLinkedList<String>()
        assertEquals(0, list.length())
    }

    @Test
    fun `length should be updated when an element is added`() {
        val list = DoublyLinkedList<String>()
        list.add("A")
        assertEquals(1, list.length())
    }

    @Test
    fun `length should be updated when an element is removed`() {
        val list = DoublyLinkedList<String>()
        list.add("A")
        list.add("B")
        list.remove("A")
        assertEquals(1, list.length())
    }

    @Test
    fun `length should be updated when all elements are removed`() {
        val list = DoublyLinkedList<String>()
        list.add("A")
        list.add("B")
        list.removeAll()
        assertEquals(0, list.length())
    }
}
