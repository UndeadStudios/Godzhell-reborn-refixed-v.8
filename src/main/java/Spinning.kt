object Spinning : CraftingData() {
    var BEFORE_AFTER = arrayOf(intArrayOf(1737, 1759, 3, 1), intArrayOf(1779, 1777, 15, 10))
    @JvmStatic
    fun showSpinning(player: client) {
        player.sendFrame164(8880)
        player.sendFrame126("What would you like to make?", 8879)
        player.sendFrame246(8883, 180, 1737) // left
        player.sendFrame246(8884, 180, 1779) // middle
        player.sendFrame246(8885, 180, 6051) // right
        player.sendFrame126("Wool", 8889)
        player.sendFrame126("Flax", 8893)
        player.sendFrame126("Magic tree", 8897)
        player.clickedSpinning = true
    }

    @JvmStatic
    fun getAmount(c: client, amount: Int) {
        c.doAmount = amount
        spinItem(c)
        c.isSpinning = true
    }

    fun spinItem(player: client) {
        player.RemoveAllWindows()
        for (element in BEFORE_AFTER) {
            val before = element[0]
            val after = element[1]
            val exp = element[2]
            val level = element[3]
            EventManager.getSingleton().addEvent(player, object : Event {
                override fun execute(container: EventContainer) {
                    if (player.isSpinning == true) {
                        if (player.playerHasItem(before)) {
                            if (player.playerLevel[player.playerCrafting] < level) {
                                player.sM("You need a crafting level of $level to do this.")
                                return
                            }
                            player.startAnimation(896)
                            player.deleteItem2(before, 1)
                            player.addItem(after, 1)
                            player.addSkillXP(exp.toDouble(), player.playerCrafting)
                            player.sendMessage(
                                "You spin the " + Item.getItemName(before) + " into a " + Item.getItemName(
                                    after
                                ) + "."
                            )
                            player.doAmount--
                        }
                        if (player.doAmount <= 0 || player.isSpinning == false) {
                            container.stop()
                            return
                        }
                    }
                }

                override fun stop() {
                    player.isSpinning = false
                    player.startAnimation(65535)
                    return
                }
            }, AnimationLength.getFrameLength(896) * 600)
        }
    }
}