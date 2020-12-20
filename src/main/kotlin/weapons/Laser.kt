package weapons

import enemies.Enemy

/**
 * A basic weapon with infinite range that damages all enemies along the path of
 * its beam (its aimed heading).
 */
class Laser(val power: Double = 0.1) : Weapon() {
    override fun fire() {
        val here = world.locateEntity(tower)
        val targets = world.entitiesAlong(here, aimedHeading)
        val delta = power * -1.0

        for (target in targets) {
            if (target is Enemy) {
                world.updateEntityIntegrity(target, delta)
            }
        }
    }
}
