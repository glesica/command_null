package world

import game.Entity
import geometry.Area
import geometry.Heading
import geometry.Location
import towers.Tower

class NullWorld private constructor(): World {
    companion object {
        val instance = NullWorld()
    }

    override val currentTick: Long = 0

    override val entities: Iterable<Entity> = listOf()

    override val towers: Iterable<Tower> = listOf()

    override fun entitiesAlong(origin: Location, h: Heading): Iterable<Entity> {
        return listOf()
    }

    override fun entitiesWithin(a: Area): Iterable<Entity> {
        return listOf()
    }

    override fun entityIntegrity(e: Entity): Double {
        return 0.0
    }

    override fun updateEntityIntegrity(e: Entity, delta: Double) {}

    override fun locateEntity(e: Entity): Location {
        return Location.ORIGIN
    }
}
