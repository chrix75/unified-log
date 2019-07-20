package csperandio.unifiedlog.storage

import csperandio.unifiedlog.events.Event

/**
 * Defines storage for events.
 */
interface EventStorage {
    /**
     * Adds an Event in the storage
     *
     * @param e Event to add
     */
    fun save(e: Event)

    /**
     * Returns the ith events in the storage
     *
     * @param i The index of the event in the storage (0 indexed)
     * @throws IndexOutOfBoundsException raised if not Event at index i
     */
    operator fun get(i: Int): Event
}