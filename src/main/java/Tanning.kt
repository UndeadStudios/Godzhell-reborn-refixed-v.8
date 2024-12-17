object Tanning : CraftingData() {
    @OptIn(ExperimentalStdlibApi::class)
    @JvmStatic
    fun sendTanningInterface(c: client) {
        c.showInterface(14670)
        for (t in tanningData.entries) {
            c.sendFrame246(
                t.itemFrame, 250,
                t.leatherId
            )
            c.sendFrame126(t.getName(), t.nameFrame)
            if (c.playerHasItem(995, t.price)) {
                c.sendFrame126(
                    "@gre@Price: " + t.price, t.costFrame
                )
            } else {
                c.sendFrame126(
                    "@red@Price: " + t.price, t.costFrame
                )
            }
        }
    }

    @OptIn(ExperimentalStdlibApi::class)
    @JvmStatic
    fun tanHide(player: client, buttonId: Int) {
        for (t in tanningData.entries) {
            if (buttonId == t.getButtonId(buttonId)) {
                var amount = player.getItemAmount(t.hideId)
                if (amount > t.getAmount(buttonId)) {
                    amount = t.getAmount(buttonId)
                }
                var price = amount * t.price
                val coins = player.getItemAmount(995)
                if (price > coins) {
                    price = coins - coins % t.price
                }
                if (amount > 0 && price == 0) {
                    player.sendMessage("You do not have enough coins to tan this hide.")
                    return
                }
                amount = price / t.price
                val hide = t.hideId
                val leather = t.leatherId
                if (player.playerHasItem(995, price)) {
                    if (player.playerHasItem(hide)) {
                        player.deleteItem2(hide, amount)
                        player.deleteItem2(995, price)
                        player.addItem(leather, amount)
                        player.sendMessage("The tanner tans the hides for you.")
                    } else {
                        player.sendMessage("You do not have any hides to tan.")
                        return
                    }
                } else {
                    player.sendMessage(
                        "You do not have enough coins to tan this hide."
                    )
                    return
                }
            }
        }
    }
}