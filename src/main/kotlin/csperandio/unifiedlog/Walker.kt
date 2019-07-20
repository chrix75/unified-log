package csperandio.unifiedlog

import csperandio.unifiedlog.events.Event
import csperandio.unifiedlog.storage.EventStorage
import java.lang.IndexOutOfBoundsException

/**
 * Walks along an event storage.
 *
 * @param storage Place where events will be stored.
 * @constructor Build a walker is linked to a EventStorage
 */
class Walker(private val storage: EventStorage) {
    private var offset = 0

    /**
     * Returns the next event in the storage.
     *
     * @return The next Event or null if no event exists.
     */
    fun next(): Event? {
        return try {
            val e = storage[offset]
            ++offset
            e
        } catch (e: IndexOutOfBoundsException) {
            null
        }
    }
}