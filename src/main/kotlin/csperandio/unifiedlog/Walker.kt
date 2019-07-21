package csperandio.unifiedlog

import csperandio.unifiedlog.events.Event
import csperandio.unifiedlog.storage.EventStorage
import csperandio.unifiedlog.storage.InMemorOffsetStorage
import csperandio.unifiedlog.storage.OffsetStorage
import java.lang.IndexOutOfBoundsException

/**
 * Walks along an event storage.
 *
 * @property storage Place where events will be stored.
 * @property offset Storage saves the Walker's position
 * @constructor Build a walker is linked to a EventStorage
 */
class Walker(private val storage: EventStorage, private var offset: OffsetStorage = InMemorOffsetStorage()) {

    /**
     * Returns the next event in the storage.
     *
     * @return The next Event or null if no event exists.
     */
    fun next(): Event? {
        return try {
            val e = storage[offset.value]
            ++offset
            e
        } catch (e: IndexOutOfBoundsException) {
            null
        }
    }
}