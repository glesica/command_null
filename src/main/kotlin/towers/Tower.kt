package towers

import game.Entity
import weapons.NullWeapon
import weapons.Weapon
import java.lang.IllegalStateException

/**
 * A tower is the primary defensive structure. It serves as a point of
 * attachment for weapons, sensors, and so on.
 */
abstract class Tower: Entity() {
    protected var weapon: Weapon = NullWeapon.instance

    /**
     * Attach a single weapon to the tower. Towers may only have one weapon. The
     * old weapon must be detached before a new one can be attached.
     */
    fun attachWeapon(w: Weapon) {
        if (weapon != NullWeapon.instance) {
            throw IllegalStateException()
        }

        weapon = w
    }

    /**
     * Detach the current weapon from the tower. The current weapon must match
     * the one being detached.
     */
    fun detachWeapon(w: Weapon) {
        if (weapon != w) {
            throw IllegalArgumentException()
        }

        weapon = NullWeapon.instance
    }
}
