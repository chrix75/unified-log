package csperandio.unifiedlog.events

/**
 * Create a event type from a string.
 *
 * @param _name The string value of the EventType
 */
class SimpleEventType(private val _name: String) : EventType {
    override val name: String
        get() = _name
}