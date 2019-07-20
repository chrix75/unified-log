package csperandio.unifiedlog.storage

import csperandio.unifiedlog.events.Event

/**
 * Saves event in a list.
 *
 * @constructor Builds an empty storage
 */
class InMemoryEventStorage : EventStorage {
    private val events = mutableListOf<Event>()

    override fun save(e: Event) {
        synchronized(this) {
            events.add(e)
        }
    }

    override operator fun get(i: Int): Event {
        if (i <= events.size) {
            return events[i]
        }

        throw IndexOutOfBoundsException("No events in offset $i")
    }

}
