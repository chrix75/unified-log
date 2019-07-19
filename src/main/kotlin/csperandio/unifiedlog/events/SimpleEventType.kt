package csperandio.unifiedlog.events

class SimpleEventType(private val _name: String) : EventType {
    override val name: String
        get() = _name
}