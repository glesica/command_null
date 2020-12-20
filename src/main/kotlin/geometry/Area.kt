package geometry

/**
 * Used as the basis for a collection of areas of various shapes, such as
 * circles, rectangles, and arbitrary polygons. Each of these needs its own
 * implementation.
 */
interface Area {
    fun includes(l: Location): Boolean
}
