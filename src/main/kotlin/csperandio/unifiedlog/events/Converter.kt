package csperandio.unifiedlog.events

/**
 * Define how any object can be converted into byte array.
 */
interface Converter {
    /**
     * Convert an object into a byte array.
     *
     * @param o Object to convert
     * @return The byte array
     */
    fun convert(o: Any): ByteArray
}