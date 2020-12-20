package weapons

import geometry.Heading
import geometry.Location
import geometry.headingFromLocation
import geometry.locationFromHeading
import towers.Component

/**
 * A weapon is simple. It can fire, which allows it to inflict damage upon on or
 * more enemies.
 *
 * TODO: Force the two aims to remain consistent
 */
abstract class Weapon : Component() {
    private var _aimedHeading: Heading = Heading.NORTH
    val aimedHeading: Heading
        get() = _aimedHeading

    private var _aimedLocation: Location = Location.ORIGIN
    val aimedLocation: Location
        get() = _aimedLocation

    fun aimHeading(h: Heading) {
        _aimedHeading = h
        _aimedLocation = locationFromHeading(h, location, _aimedLocation)
    }

    fun aimLocation(l: Location) {
        _aimedLocation = l
        _aimedHeading = headingFromLocation(l, location)
    }

    abstract fun fire()
}
