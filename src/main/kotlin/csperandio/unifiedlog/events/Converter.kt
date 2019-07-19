package csperandio.unifiedlog.events

interface Converter {
    fun convert(o: Any): ByteArray
}