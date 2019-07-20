package csperandio.unifiedlog.events

import java.util.*

/**
 * An event will be stored inside an EventStorage
 *
 * @property type Type of the event
 * @property data Information stored inside the event
 * @property id Event id
 * @property timestamp Timestamp of the event creation
 */
open class Event(val type: EventType, val data: ByteArray, val id: UUID = UUID.randomUUID(), val timestamp: Date = Date()) {
    override fun equals(other: Any?): Boolean = other is Event && other.id == id
    override fun hashCode(): Int = id.hashCode()

    override fun toString(): String {
        return "Event(type:${type.name}, data:${String(data)}, id:$id, timestamp:$timestamp)"
    }
}