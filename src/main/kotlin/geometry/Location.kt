package geometry

/**
 * A location within the physical world of the game.
 */
data class Location(val x: Long, val y: Long) {
    companion object {
        val ORIGIN = Location(0, 0)
    }
}
