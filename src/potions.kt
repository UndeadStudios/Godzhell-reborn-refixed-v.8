class potions {
    fun buryItem(item: Int, slot: Int, ID: Int) {
        var used = true
        val c = PlayerHandler.players[ID] as client
        if (item != c.playerItems[slot] - 1) {
            return
        }
        if (c.playerHasItem(item)) {
            when (item) {
                199, 201, 203, 205, 207, 209, 211, 213, 215, 217, 219, 2485, 3049, 3051 -> c.herblore.identify(item)
                else -> used = false
            }
        }
    }
} //closes potion hand
