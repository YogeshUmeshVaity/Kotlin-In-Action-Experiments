package companionobject.constants

data class User(val id: String, val name: String) {
    companion object {
        const val DEFAULT_NAME = "Guest"
        const val MIN_AGE = 16
    }
}