package csperandio.unifiedlog

import csperandio.unifiedlog.events.Event
import csperandio.unifiedlog.storage.EventStorage
import java.lang.IndexOutOfBoundsException

class Walker(private val storage: EventStorage) {
    private var offset = 0

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