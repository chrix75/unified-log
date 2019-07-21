package csperandio.unifiedlog.storage

/**
 * Stores offset for a Walker
 */
interface OffsetStorage {
    /**
     * Current offset value
     */
    val value: Int

    /**
     * Increments the current offset
     */
    operator fun inc(): OffsetStorage
}
