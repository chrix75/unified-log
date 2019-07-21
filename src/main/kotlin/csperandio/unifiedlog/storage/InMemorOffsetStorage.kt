package csperandio.unifiedlog.storage

/**
 * Stores the offset for a Walker in memory
 */
class InMemorOffsetStorage(start: Int = 0) : OffsetStorage {
    private var current = start

    override val value: Int
        get() = current

    override operator fun inc(): InMemorOffsetStorage {
        ++current
        return this
    }

}
