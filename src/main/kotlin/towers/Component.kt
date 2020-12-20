package towers

import game.Entity

/**
 * A component is something that can be attached to a tower to provide some kind
 * of functionality, such as a gun or a sensor.
 */
abstract class Component: Entity() {
    protected var tower: Tower = NullTower.instance

    fun attachToTower(t: Tower) {
        tower = t
    }

    fun detachFromTower(t: Tower) {
        if (tower == t) {
            tower = NullTower.instance
        } else {
            throw IllegalArgumentException()
        }
    }
}
