package weapons

class NullWeapon internal constructor(
) : Weapon() {
    companion object {
        val instance = NullWeapon()
    }

    override fun fire() {}
}
