package world

import game.Entity
import geometry.Area
import geometry.Heading
import geometry.Location
import towers.Tower

/**
 * This is the entire state of a game at any given moment.
 *
 * Everything is stored here and an instance is passed to towers and components
 * so that they can observe it and request updates.
 *
 * TODO: We might handle ticks with a "addToNextTick" method
 * It would take a closure that would run during the next tick. But then we
 * need to enforce that a given component (or whatever) can only add so many
 * jobs to each tick. Maybe the world maintains a queue for each entity?
 *
 * TODO: Add more geometry methods (entitiesAtLocation, entitiesAlongPath,
 * entitiesInArea) These could be handled by a provider so that it's easy to
 * swap out the initial, naive implementation with an R-tree or something. Plus
 * testing will be simpler.
 */
interface World {
    val currentTick: Long

    val entities: Iterable<Entity>

    val towers: Iterable<Tower>

    /**
     * Modify the given entity by applying the given function for the given
     * number of simulation ticks.
     *
     * TODO: What about entity resistance?
     * TODO: How do we avoid mutable entities though?
     */
    fun entitiesAlong(origin: Location, h: Heading): Iterable<Entity>

    fun entitiesWithin(a: Area): Iterable<Entity>

    fun entityIntegrity(e: Entity): Double

    fun updateEntityIntegrity(e: Entity, delta: Double)

    fun locateEntity(e: Entity): Location
}
