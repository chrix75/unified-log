package csperandio.unifiedlog.storage

import csperandio.unifiedlog.events.Event

interface EventStorage {
    fun save(e: Event)
    operator fun get(i: Int): Event
}