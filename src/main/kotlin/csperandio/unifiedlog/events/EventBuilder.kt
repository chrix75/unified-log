package csperandio.unifiedlog.events

import java.lang.IllegalStateException
import java.nio.charset.Charset
import java.util.*

class EventBuilder(private val converter: Converter? = null) {

    fun fromString(type: EventType, s: String, id: UUID = UUID.randomUUID(), timestamp: Date = Date()): Event = 
        Event(type, s.toByteArray(Charset.forName("UTF-8")), id, timestamp)
    

    fun fromString(type: EventType, s: String, origin: Event, id: UUID = UUID.randomUUID(), timestamp: Date = Date()): DerivedEvent = 
        DerivedEvent(type, s.toByteArray(Charset.forName("UTF-8")), origin, id, timestamp)
    

    fun fromBytes(type: EventType, b: ByteArray, id: UUID = UUID.randomUUID(), timestamp: Date = Date()): Event =
        Event(type, b, id, timestamp)
    

    fun fromBytes(type: EventType, b: ByteArray, origin: Event, id: UUID = UUID.randomUUID(), timestamp: Date = Date()): DerivedEvent =
        DerivedEvent(type, b, origin, id, timestamp)

    fun fromAny(type: EventType, o: Any, id: UUID = UUID.randomUUID(), timestamp: Date = Date()): Event {
        if (converter == null) {
            throw IllegalStateException("No Converter provided.")
        }

        return Event(type, converter.convert(o), id, timestamp)
    }

    fun fromAny(type: EventType, o: Any, origin: Event, id: UUID = UUID.randomUUID(), timestamp: Date = Date()): DerivedEvent {
        if (converter == null) {
            throw IllegalStateException("No Converter provided.")
        }

        return DerivedEvent(type, converter.convert(o), origin, id, timestamp)
    }

}