package csperandio.unifiedlog.storage

import csperandio.unifiedlog.events.EventBuilder
import csperandio.unifiedlog.events.SimpleEventType
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class InMemoryEventStorageTest {

    private lateinit var storage: EventStorage

    @Before
    fun setUp() {
        storage = InMemoryEventStorage()
        storage.save(EventBuilder().fromString(SimpleEventType("SIMPLE_EVENT"), "Event 1"))
        storage.save(EventBuilder().fromString(SimpleEventType("ANOTHER_SIMPLE_EVENT"), "Event 2"))
    }

    @Test
    fun fetch_first_event() {
        val e = storage[0]
        assertEquals("SIMPLE_EVENT", e.type.name)
    }

    @Test
    fun fetch_last_event() {
        val e = storage[1]
        assertEquals("ANOTHER_SIMPLE_EVENT", e.type.name)
    }

    @Test(expected = IndexOutOfBoundsException::class)
    fun out_of_bound_event() {
        storage[2]
    }
}