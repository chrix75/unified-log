package csperandio.unifiedlog.events

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class EventTest {
    @Test
    fun create_derived_event() {
        val e = EventBuilder().fromString(SimpleEventType("SIMPLE_EVENT"), "A simple Event")
        val d = EventBuilder().fromString(SimpleEventType("DERIVED_EVENT"), "A derived event", e)

        assertEquals(e.id, d.origin.id)
    }

    @Test
    fun create_event_from_any_object() {
        val e = EventBuilder(FakeConverter()).fromAny(SimpleEventType("SIMPLE_EVENT"), "A simple Event")
        assertEquals("This object comes from a converter", String(e.data))
    }

    private class FakeConverter: Converter {
        override fun convert(o: Any): ByteArray = "This object comes from a converter".toByteArray()
    }

    @Test
    fun convert_event_into_string() {
        val e = EventBuilder().fromString(SimpleEventType("SIMPLE_EVENT"), "A simple Event")
        val d = EventBuilder().fromString(SimpleEventType("DERIVED_EVENT"), "A derived event", e)
        println(e)
        println(d)
    }
}

