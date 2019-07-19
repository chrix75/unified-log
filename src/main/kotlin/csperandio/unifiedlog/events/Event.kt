package csperandio.unifiedlog.events

import java.util.*

open class Event(val type: EventType, val data: ByteArray, val id: UUID = UUID.randomUUID(), val timestamp: Date = Date()) {
    override fun equals(other: Any?): Boolean = other is Event && other.id == id
    override fun hashCode(): Int = id.hashCode()

    override fun toString(): String {
        return "Event(type:${type.name}, data:${String(data)}, id:$id, timestamp:$timestamp)"
    }
}