package geometry

/**
 * A heading relative to the global coordinate system.
 */
class Heading private constructor(val theta: Double) {
    companion object {
        val NORTH = Heading(Math.PI / 2.0)
        val SOUTH = Heading(Math.PI * 3.0 / 2.0)
        val EAST = Heading(0.0)
        val WEST = Heading(Math.PI)
    }

    // TODO: Implement all the math and comparison nonsense
}