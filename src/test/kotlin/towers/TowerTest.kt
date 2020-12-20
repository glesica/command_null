package towers

import kotlin.test.assertFailsWith

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import weapons.NullWeapon
import weapons.Weapon
import java.lang.IllegalArgumentException

internal class TowerTest {
    lateinit var tower: Tower
    lateinit var weapon0: Weapon
    lateinit var weapon1: Weapon

    @BeforeEach
    fun setUp() {
        tower = NullTower()
        weapon0 = NullWeapon()
        weapon1 = NullWeapon()
    }

    @Test
    fun `attachWeapon should succeed initially`() {
        tower.attachWeapon(weapon0)
    }

    @Test
    fun `attachWeapon should fail on a second call`() {
        tower.attachWeapon(weapon0)
        assertFailsWith<IllegalStateException> {
            tower.attachWeapon(weapon1)
        }
    }

    @Test
    fun `detachWeapon should succeed on the attached weapon`() {
        tower.attachWeapon(weapon0)
        tower.detachWeapon(weapon0)
    }

    @Test
    fun `detachWeapon should fail on a different weapon`() {
        tower.attachWeapon(weapon0)
        assertFailsWith<IllegalArgumentException> {
            tower.detachWeapon(weapon1)
        }
    }
}
