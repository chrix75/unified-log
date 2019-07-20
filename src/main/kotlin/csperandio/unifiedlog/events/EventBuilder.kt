package csperandio.unifiedlog.events

import java.lang.IllegalStateException
import java.nio.charset.Charset
import java.util.*

/**
 * Build an Event from value.
 *
 * @param converter A Converter transforms a object into a byte array,
 * @constructor Build a builder. A converter can be passed for object building.
 */
class EventBuilder(private val converter: Converter? = null) {

    /**
     * Builds an Event from a string value.
     *
     * @param type Event type
     * @param s The event data as a string value
     * @param id Event ID
     * @param timestamp Event creation date
     * @return A new Event
     */
    fun fromString(type: EventType, s: String, id: UUID = UUID.randomUUID(), timestamp: Date = Date()): Event = 
        Event(type, s.toByteArray(Charset.forName("UTF-8")), id, timestamp)


    /**
     * Builds an DerivedEvent from a string value.
     *
     * @param type Event type
     * @param s The event data as a string value
     * @param origin The source Event
     * @param id Event ID
     * @param timestamp Event creation date
     * @return A new DerivedEvent
     */
    fun fromString(type: EventType, s: String, origin: Event, id: UUID = UUID.randomUUID(), timestamp: Date = Date()): DerivedEvent =
        DerivedEvent(type, s.toByteArray(Charset.forName("UTF-8")), origin, id, timestamp)


    /**
     * Builds an Event from a byte array.
     *
     * @param type Event type
     * @param b The event data as a byte array
     * @param id Event ID
     * @param timestamp Event creation date
     * @return A new Event
     */
    fun fromBytes(type: EventType, b: ByteArray, id: UUID = UUID.randomUUID(), timestamp: Date = Date()): Event =
        Event(type, b, id, timestamp)


    /**
     * Builds an DerivedEvent from a byte array.
     *
     * @param type Event type
     * @param b The event data as a byte array
     * @param origin The source Event
     * @param id Event ID
     * @param timestamp Event creation date
     * @return A new DerivedEvent
     */
    fun fromBytes(type: EventType, b: ByteArray, origin: Event, id: UUID = UUID.randomUUID(), timestamp: Date = Date()): DerivedEvent =
        DerivedEvent(type, b, origin, id, timestamp)

    /**
     * Builds an Event from any object.
     *
     * The method uses a Converter object.
     *
     * @param type Event type
     * @param o The event data
     * @param id Event ID
     * @param timestamp Event creation date
     * @return A new Event
     */
    fun fromAny(type: EventType, o: Any, id: UUID = UUID.randomUUID(), timestamp: Date = Date()): Event {
        if (converter == null) {
            throw IllegalStateException("No Converter provided.")
        }

        return Event(type, converter.convert(o), id, timestamp)
    }


    /**
     * Builds an DerivedEvent from any object.
     *
     * The method uses a Converter object.
     *
     * @param type Event type
     * @param o The event data
     * @param id Event ID
     * @param timestamp Event creation date
     * @return A new DerivedEvent
     */
    fun fromAny(type: EventType, o: Any, origin: Event, id: UUID = UUID.randomUUID(), timestamp: Date = Date()): DerivedEvent {
        if (converter == null) {
            throw IllegalStateException("No Converter provided.")
        }

        return DerivedEvent(type, converter.convert(o), origin, id, timestamp)
    }

}