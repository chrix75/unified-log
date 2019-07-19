package csperandio.unifiedlog.events

import java.util.*

class DerivedEvent(
    type: EventType,
    data: ByteArray,
    val origin: Event,
    id: UUID = UUID.randomUUID(),
    timestamp: Date = Date()
) : Event(type, data, id, timestamp) {

    override fun equals(other: Any?): Boolean = other is DerivedEvent && other.id == id
    override fun hashCode(): Int = id.hashCode()


    override fun toString(): String {
        return "DerivedEvent(type:${type.name}, data:${String(data)}, id:$id, timestamp:$timestamp, origin:$origin)"
    }

}
