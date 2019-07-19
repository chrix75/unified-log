package csperandio.unifiedlog

import csperandio.unifiedlog.events.EventBuilder
import csperandio.unifiedlog.events.SimpleEventType
import csperandio.unifiedlog.storage.EventStorage
import csperandio.unifiedlog.storage.InMemoryEventStorage
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WalkerTest {
    private lateinit var storage: EventStorage

    @Before
    fun setUp() {
        storage = InMemoryEventStorage()
        storage.save(EventBuilder().fromString(SimpleEventType("SIMPLE_EVENT"), "Event 1"))
        storage.save(EventBuilder().fromString(SimpleEventType("ANOTHER_SIMPLE_EVENT"), "Event 2"))

    }

    @Test
    fun walk_events_until_last() {
        val walker  = Walker(storage)
        walker.next()
        val e = walker.next()
        assertNotNull(e)
        assertEquals("ANOTHER_SIMPLE_EVENT", e!!.type.name)
    }

    @Test
    fun walk_all_events() {
        val walker  = Walker(storage)
        walker.next()
        walker.next()
        val e = walker.next()
        assertNull(e)
    }

    @Test
    fun wal_all_events_and_after_add_new_event() {
        val walker  = Walker(storage)
        walker.next()
        walker.next()
        assertNull(walker.next())

        storage.save(EventBuilder().fromString(SimpleEventType("NEW_ADDED_EVENT"), "Event 3"))
        val e = walker.next()
        assertNotNull(e)
        assertEquals("NEW_ADDED_EVENT", e!!.type.name)
        assertEquals("Event 3", String(e.data))
    }
}