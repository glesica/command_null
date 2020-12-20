package sensors

import game.Entity
import geometry.Heading
import geometry.Location
import geometry.headingFromLocation
import geometry.locationFromHeading
import towers.Component

/**
 * A sensor can detect entities within a particular range.
 *
 * TODO: Force the two "aims" to remain consistent
 */
abstract class Sensor: Component() {
    private val _range: Double = 1.0
    val range: Double
        get() = _range

    private var _directedHeading: Heading = Heading.NORTH
    val directedHeading: Heading
        get() = _directedHeading

    private var _directedLocation: Location = Location.ORIGIN
    val directedLocation: Location
        get() = _directedLocation

    fun directHeading(h: Heading) {
        _directedHeading = h
        _directedLocation = locationFromHeading(h, location, _directedLocation)
    }

    fun directLocation(l: Location) {
        _directedLocation = l
        _directedHeading = headingFromLocation(l, location)
    }

    abstract fun sense(): Iterable<Entity>
}