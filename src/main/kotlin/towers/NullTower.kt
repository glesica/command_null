package towers

/**
 * A simple, no-op tower for use in tests and anywhere else we need a fake tower
 * (such as in place of `null`).
 */
class NullTower internal constructor(): Tower() {
    companion object {
        val instance = NullTower()
    }
}
