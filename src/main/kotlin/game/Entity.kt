package game

import geometry.Location
import world.NullWorld
import world.World

/**
 * A game entity, including towers, enemies, and so on. Every actor in the game
 * is an entity of some sort.
 */
abstract class Entity() {
    val id: Long = nextId++

    val location: Location
        get() {
            return world.locateEntity(this)
        }

    protected var world: World = NullWorld.instance

    companion object {
        private var nextId: Long = 0
    }

    fun attachWorld(w : World) {
        world = w
    }

    fun detachWorld(w: World) {
        if (world == w) {
            world = NullWorld.instance
        } else {
            throw IllegalArgumentException()
        }
    }
}
