/**
 * @author Karma_K (http://www.rune-server.org/members/karma_k/)
 */
object Prestige {
    fun wearingItems(c: client): Boolean {
        for (j in c.playerEquipment.indices) {
            if (c.playerEquipment[j] > 0) {
                c.sendMessage("Remove all equipment before prestiging.")
                return true
            }
        }
        return false
    }

    fun checkArea(c: client): Boolean {
        if (!c.nonWild()) {
            c.sendMessage("You can't do this in the area you're standing in.")
            return true
        }
        return false
    }

    fun prestigeSkill(c: client, skillId: Int) {
        if (checkArea(c)) {
            return
        }
        if (wearingItems(c)) {
            return
        }
        if (c.playerLevel[skillId] == 99) {
            c.playerXP[skillId] = c.getXPForLevel(1) + 5
            c.playerLevel[skillId] = c.getLevelForXP(c.playerXP[skillId])
            c.refreshSkill(skillId)
            c.addItem(995, 1000000)
            c.sendMessage("You received 1m!")
            c.sendMessage("You've successfully prestiged !")
            c.RemoveAllWindows()
        } else {
            c.sendMessage("You need to be 99  to prestige.")
        }
    }
}