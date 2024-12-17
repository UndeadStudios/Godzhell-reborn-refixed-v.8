import java.util.*

enum class Skill(@JvmField val id: Int) {
    ATTACK(0),
    DEFENCE(1),
    STRENGTH(2),
    HITPOINTS(3),
    RANGED(4),
    PRAYER(5),
    MAGIC(6),
    COOKING(7),
    WOODCUTTING(8),
    FLETCHING(9),
    FISHING(10),
    FIREMAKING(11),
    CRAFTING(12),
    SMITHING(13),
    MINING(14),
    HERBLORE(15),
    AGILITY(16),
    THIEVING(17),
    SLAYER(18),
    FARMING(19),
    RUNECRAFTING(20),
    CONSTRUCTION(21),
    HUNTER(22);

    override fun toString(): String {
        val name = name.lowercase(Locale.getDefault())
        return misc.capitalize(name)
    }

    companion object {
        @OptIn(ExperimentalStdlibApi::class)
        fun forId(id: Int): Skill? {
            return Arrays.asList(*entries.toTypedArray()).stream().filter { s: Skill? -> s!!.id == id }.findFirst()
                .orElse(null)
        }
    }
}