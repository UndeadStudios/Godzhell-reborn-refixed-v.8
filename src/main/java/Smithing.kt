@file:OptIn(ExperimentalStdlibApi::class)

import org.python.compiler.ClassFile.fixName
import kotlin.math.abs


class Smithing(private val c: client) {


    internal enum class BarData(
        var index: Int,
        var level: Int,
        var xp: Int,
        var itemRequired1: Int,
        var itemRequired2: Int,
        var secondItemAmount: Int,
        var product: Int
    ) {
        BRONZE_BAR(1, 1, 6, 436, 438, -1, 2349),
        IRON_BAR(2, 15, 12, 440, -1, -1, 2351),
        STEEL_BAR(3, 20, 17, 440, 453, 2, 2353),
        MITHRIL_BAR(4, 50, 30, 447, 453, 4, 2359),
        ADAMANANT_BAR(5, 70, 37, 449, 453, 6, 2361),
        RUNE_BAR(6, 85, 50, 451, 453, 8, 2363),
        SILVER_BAR(7, 20, 13, 442, -1, -1, 2355),
        GOLD_BAR(8, 40, 22, 444, -1, -1, 2357);

        companion object {
            fun forId(id: Int): BarData {
                for (bar in entries) if (bar.index == id) return bar
                return BRONZE_BAR
            }
        }
    }

    private val SMELT_BARS = intArrayOf(
        2349, 2351, 2355, 2353, 2357, 2359,
        2361, 2363
    )
    private val SMELT_FRAME = intArrayOf(
        2405, 2406, 2407, 2409, 2410, 2411,
        2412, 2413
    )
    private val BAR_REQS = intArrayOf(1, 15, 20, 30, 40, 50, 70, 85)
    private val ORE_1 = intArrayOf(438, 440, -1, 440, 444, 447, 449, 451)
    private val ORE_2 = intArrayOf(436, -1, -1, -1, -1, -1, -1, -1)
    private val SMELT_EXP = intArrayOf(6, 13, -1, 18, 23, 30, 38, 50)
    private var oreId2 = 0
    private var barId = 0
    fun canSmelt(barType: Int): Boolean {
        for (j in SMELT_BARS.indices) {
            if (barType == SMELT_BARS[j]) {
                // c.sendMessage("" + c.playerLevel + " bar: " + BAR_REQS[j]);
                return c.playerLevel[c.playerSmithing] >= BAR_REQS[j]
            }
        }
        return false
    }

    fun getExp(barType: Int): Int {
        for (j in SMELT_BARS.indices) {
            if (barType == SMELT_BARS[j]) {
                return SMELT_EXP[j]
            }
        }
        return 0
    }

    fun getOre(barType: Int): Int {
        for (j in SMELT_BARS.indices) {
            if (barType == SMELT_BARS[j]) {
                // c.sendMessage("" + ORE_1[j]);
                return ORE_1[j]
            }
        }
        return 0
    }

    fun getOre2(barType: Int): Int {
        for (j in SMELT_BARS.indices) {
            if (barType == SMELT_BARS[j]) {
                // c.sendMessage("" + ORE_2[j]);
                return ORE_2[j]
            }
        }
        return 0
    }

    fun hasOres(barType: Int): Boolean {
        return if (getOre2(barType) > 0) {
            (c.playerHasItem(getOre(barType))
                    && c.playerHasItem(getOre2(barType)))
        } else {
            c.playerHasItem(getOre(barType))
        }
    }

    fun sendSmelting() {
        for (j in SMELT_FRAME.indices) {
            c.sendFrame246(SMELT_FRAME[j], 150, SMELT_BARS[j])
        }
        c.sendFrame164(2400)
        c.smeltInterface = true
    }
    fun doAmount(c: client, amount: Int, bartype: Int) {
        c.doAmount = amount
        smeltBar(c, bartype)
    }
    private fun hasItems(c: client, bar: BarData): Boolean {
        if (bar.itemRequired1 > 0 && bar.itemRequired2 > 0) {
            if (!c.playerHasItem(bar.itemRequired1) || !c.playerHasItem(bar.itemRequired2)) {
                val name: String = c.getItemName(bar.itemRequired1).toLowerCase()
                val item2name: String = c.getItemName(bar.itemRequired2).toLowerCase()
                if (bar.secondItemAmount == -1) c.sendMessage("You need " + name + " and " + fixName(item2name) + " to make this bar.") else c.sendMessage(
                    "You need " + name + " and " + abs(bar.secondItemAmount.toDouble()) + " " + item2name + " to make this bar."
                )
                c.RemoveAllWindows()
                return false
            }
        }
        return true
    }

    private fun hasItem(c: client, bar: BarData): Boolean {
        if (bar.itemRequired2 < 0) {
            val name: String = c.getItemName(bar.itemRequired1).toLowerCase()
            if (!c.playerHasItem(bar.itemRequired1)) {
                c.sendMessage("You need $name to make this bar.")
                c.RemoveAllWindows()
                return false
            }
        }
        return true
    }

    private fun hasCoalAmount(c: client, bar: BarData): Boolean {
        if (bar.secondItemAmount > 0) {
            if (!c.playerHasItem(bar.itemRequired2, bar.secondItemAmount)) {
                val name: String = c.getItemName(bar.itemRequired1).toLowerCase()
                c.sendMessage("You need " + name + " and " + bar.secondItemAmount + " coal ores to make this bar.")
                c.RemoveAllWindows()
                return false
            }
        }
        return true
    }

    /**
     * Gets the index from DATA for which bar to smelt
     */
    fun getBar(c: client, i: Int) {
        when (i) {
            15147 -> {
                doAmount(c, 1, 8)
                doAmount(c, 5, 8)
                doAmount(c, 10, 8)
                doAmount(c, 28, 1)
            }

            15146 -> {
                doAmount(c, 5, 8)
                doAmount(c, 10, 8)
                doAmount(c, 28, 1)
            }

            10247 -> {
                doAmount(c, 10, 8)
                doAmount(c, 28, 1)
            }

            9110 -> doAmount(c, 28, 1)
            15151 -> {
                doAmount(c, 1, 8)
                doAmount(c, 5, 8)
                doAmount(c, 10, 8)
                doAmount(c, 28, 2)
            }

            15150 -> {
                doAmount(c, 5, 8)
                doAmount(c, 10, 8)
                doAmount(c, 28, 2)
            }

            15149 -> {
                doAmount(c, 10, 8)
                doAmount(c, 28, 2)
            }

            15148 -> doAmount(c, 28, 2)
            15159 -> {
                doAmount(c, 1, 8)
                doAmount(c, 5, 8)
                doAmount(c, 10, 8)
                doAmount(c, 28, 3)
            }

            15158 -> {
                doAmount(c, 5, 8)
                doAmount(c, 10, 8)
                doAmount(c, 28, 3)
            }

            15157 -> {
                doAmount(c, 10, 8)
                doAmount(c, 28, 3)
            }

            15156 -> doAmount(c, 28, 3)
            29017 -> {
                doAmount(c, 1, 8)
                doAmount(c, 5, 8)
                doAmount(c, 10, 8)
                doAmount(c, 28, 4)
            }

            29016 -> {
                doAmount(c, 5, 8)
                doAmount(c, 10, 8)
                doAmount(c, 28, 4)
            }

            24253 -> {
                doAmount(c, 10, 8)
                doAmount(c, 28, 4)
            }

            16062 -> doAmount(c, 28, 4)
            29022 -> {
                doAmount(c, 1, 8)
                doAmount(c, 5, 8)
                doAmount(c, 10, 8)
                doAmount(c, 28, 5)
            }

            29020 -> {
                doAmount(c, 5, 8)
                doAmount(c, 10, 8)
                doAmount(c, 28, 5)
            }

            29019 -> {
                doAmount(c, 10, 8)
                doAmount(c, 28, 5)
            }

            29018 -> doAmount(c, 28, 5)
            29026 -> {
                doAmount(c, 1, 8)
                doAmount(c, 5, 8)
                doAmount(c, 10, 8)
                doAmount(c, 28, 6)
            }

            29025 -> {
                doAmount(c, 5, 8)
                doAmount(c, 10, 8)
                doAmount(c, 28, 6)
            }

            29024 -> {
                doAmount(c, 10, 8)
                doAmount(c, 28, 6)
            }

            29023 -> doAmount(c, 28, 6)
            15155 -> {
                doAmount(c, 1, 8)
                doAmount(c, 5, 8)
                doAmount(c, 10, 8)
                doAmount(c, 28, 7)
            }

            15154 -> {
                doAmount(c, 5, 8)
                doAmount(c, 10, 8)
                doAmount(c, 28, 7)
            }

            15153 -> {
                doAmount(c, 10, 8)
                doAmount(c, 28, 7)
            }

            15152 -> doAmount(c, 28, 7)
            15163 -> {
                doAmount(c, 1, 8)
                doAmount(c, 5, 8)
                doAmount(c, 10, 8)
                doAmount(c, 28, 8)
            }

            15162 -> {
                doAmount(c, 5, 8)
                doAmount(c, 10, 8)
                doAmount(c, 28, 8)
            }

            15161 -> {
                doAmount(c, 10, 8)
                doAmount(c, 28, 8)
            }

            15160 -> doAmount(c, 28, 8)
        }
    }
    private fun smeltBar(c: client, bartype: Int) {
        val bar = BarData.forId(bartype)
        if (bar != null) {
            if (c.playerLevel[13] < bar.level) {
                c
                    .sM(("You need a smithing level of at least " + bar.level).toString() + " in order smelt this bar.")
                return
            }
            if (c.isSmething || !hasItems(c, bar) || !hasCoalAmount(c, bar) || !hasItem(c, bar)) {
                return
            }
            c.isSmething = true
            c.RemoveAllWindows()
            EventManager.getSingleton().addEvent(c,object : Event {
                override fun execute(container: EventContainer) {
                    if (c.doAmount <= 0 || !c.isSmething) {
                        container.stop()
                    }
                    if (c.playerHasItem(bar.itemRequired1) && bar.secondItemAmount === -1) {
                        c.deleteItem(bar.itemRequired1, 1)
                        c.deleteItem(bar.itemRequired2, 1)
                    } else if (c.playerHasItem(bar.itemRequired2, bar.secondItemAmount)) {
                        c.deleteItem(bar.itemRequired1, 1)
                        c.deleteItem2(bar.itemRequired2, bar.secondItemAmount)
                    } else {
                        container.stop()
                    }
                    c.setAnimation(899)
                    c.sendMessage("You smelt " + fixName(c.getItemName(bar.product).toLowerCase()) + ".")
                    c.sendSound(soundList.SMELTING_ORE, 100, 0)
                    c.addSkillXP((bar.xp * Config.SMITHING_EXPERIENCE).toDouble(), 13)
                    c.addItem(bar.product, 1)
                    if (!c.playerHasItem(bar.itemRequired1) || !c
                            .playerHasItem(bar.itemRequired2, bar.secondItemAmount)
                    ) {
                        c.sendMessage("You don't have enough ores to continue!")
                        container.stop()
                    }
                    c.doAmount--
                }

                override fun stop() {
                    c.isSmething = false
                }
            }, AnimationLength.getFrameLength(899)+2+600)
        }
    }

    companion object {
        var item = 0
        var xp = 0
        var remove = 0
        var removeamount = 0
        var maketimes = 0
        private var exp = 0
        private var oreId = 0
        private fun CheckAddy(
            c: client, level: Int,
            amounttomake: Int, type: String
        ) {
            remove = 2361
            if (type.equals("1357", ignoreCase = true) && level >= 71) { // Axe
                xp = 63
                item = 1357
                removeamount = 1
                maketimes = amounttomake
            } else if (type.equals("1211", ignoreCase = true) && level >= 70) { // Dagger
                xp = 63
                item = 1211
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1430" && level >= 72) { // Mace
                xp = 63
                item = 1430
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1145" && level >= 73) { // Med helm
                xp = 63
                item = 1145
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "9380" && level >= 74) { // Dart tips
                xp = 63
                item = 9380
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1287" && level >= 74) { // Sword (s)
                xp = 63
                item = 1287
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "4823" && level >= 74) { // Nails
                xp = 63
                item = 4823
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "43" && level >= 75) { // Arrow tips
                xp = 63
                item = 43
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1331" && level >= 75) { // Scim
                xp = 125
                item = 1331
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1301" && level >= 76) { // Longsword
                xp = 125
                item = 1301
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "867" && level >= 77) { // Knives
                xp = 63
                item = 867
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1161" && level >= 77) { // Full Helm
                xp = 125
                item = 1161
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1183" && level >= 78) { // Square shield
                xp = 125
                item = 1183
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1345" && level >= 79) { // Warhammer
                xp = 188
                item = 1345
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "9143" && level >= 73) //Dart tips
            {
                xp = 63
                item = 9143
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1371" && level >= 80) { // Battle axe
                xp = 188
                item = 1371
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1111" && level >= 81) { // Chain
                xp = 188
                item = 1111
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1199" && level >= 82) { // Kite
                xp = 188
                item = 1199
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1317" && level >= 84) { // 2h Sword
                xp = 188
                item = 1317
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1073" && level >= 86) { // Platelegs
                xp = 188
                item = 1073
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1091" && level >= 86) { // PlateSkirt
                xp = 188
                item = 1091
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1123" && level >= 88) { // Platebody
                xp = 313
                item = 1123
                removeamount = 5
                maketimes = amounttomake
            } else {
                c.sendMessage("You don't have a high enough level to make this Item!")
                return
            }
            doAction(c, item, remove, removeamount, maketimes, -1, -1, xp)
        }

        private fun CheckBronze(
            c: client, level: Int,
            amounttomake: Int, type: String
        ) {
            if (type.equals("1351", ignoreCase = true) && level >= 1) {
                xp = 13
                item = 1351
                remove = 2349
                removeamount = 1
                maketimes = amounttomake
            } else if (type.equals("1205", ignoreCase = true) && level >= 1) {
                xp = 13
                item = 1205
                remove = 2349
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1422" && level >= 2) {
                xp = 13
                item = 1422
                remove = 2349
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1139" && level >= 3) {
                xp = 13
                item = 1139
                remove = 2349
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "9375" && level >= 4) {
                xp = 13
                item = 9375
                remove = 2349
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1277" && level >= 4) {
                xp = 13
                item = 1277
                remove = 2349
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "4819" && level >= 4) {
                xp = 13
                item = 4819
                remove = 2349
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "39" && level >= 5) {
                xp = 13
                item = 39
                remove = 2349
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1321" && level >= 5) {
                xp = 25
                item = 1321
                remove = 2349
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1291" && level >= 6) {
                xp = 25
                item = 1291
                remove = 2349
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "864" && level >= 7) {
                xp = 25
                item = 864
                remove = 2349
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1155" && level >= 7) {
                xp = 25
                item = 1155
                remove = 2349
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1173" && level >= 8) {
                xp = 25
                item = 1173
                remove = 2349
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1337" && level >= 9) {
                xp = 38
                item = 1337
                remove = 2349
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1375" && level >= 10) {
                xp = 38
                item = 1375
                remove = 2349
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1103" && level >= 11) {
                xp = 38
                item = 1103
                remove = 2349
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1189" && level >= 12) {
                xp = 38
                item = 1189
                remove = 2349
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1307" && level >= 14) {
                xp = 38
                item = 1307
                remove = 2349
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1075" && level >= 16) {
                xp = 38
                item = 1075
                remove = 2349
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1087" && level >= 16) {
                xp = 38
                item = 1087
                remove = 2349
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1117" && level >= 18) {
                xp = 63
                item = 1117
                remove = 2349
                removeamount = 5
                maketimes = amounttomake
            } else {
                c.sendMessage("You don't have a high enough level to make this Item!")
                return
            }
            doAction(c, item, remove, removeamount, maketimes, -1, -1, xp)
        }

        private fun CheckIron(
            c: client, level: Int,
            amounttomake: Int, type: String
        ) {
            remove = 2351
            if (type.equals("1349", ignoreCase = true) && level >= 16) // Axe
            {
                xp = 25
                item = 1349
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "9140" && level >= 19) //Dart tips
            {
                xp = 25
                item = 9140
                removeamount = 1
                maketimes = amounttomake
            } else if (type.equals("1203", ignoreCase = true) && level >= 15) // Dagger
            {
                xp = 25
                item = 1203
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1420" && level >= 17) // Mace
            {
                xp = 25
                item = 1420
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1137" && level >= 18) // Med helm
            {
                xp = 25
                item = 1137
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "9377" && level >= 19) // Bolt tips
            {
                xp = 25
                item = 9377
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1279" && level >= 19) // Sword (s)
            {
                xp = 25
                item = 1277
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "4820" && level >= 19) // Nails
            {
                xp = 25
                item = 4820
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "40" && level >= 20) // Arrow tips
            {
                xp = 25
                item = 40
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1323" && level >= 20) // Scim
            {
                xp = 50
                item = 1323
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1293" && level >= 21) // Longsword
            {
                xp = 50
                item = 1293
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "863" && level >= 22) // Knives
            {
                xp = 25
                item = 863
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1153" && level >= 22) // Full Helm
            {
                xp = 50
                item = 1153
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1175" && level >= 23) // Square shield
            {
                xp = 50
                item = 1175
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1335" && level >= 24) // Warhammer
            {
                xp = 38
                item = 1335
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1363" && level >= 25) // Battle axe
            {
                xp = 75
                item = 1363
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1101" && level >= 26) // Chain
            {
                xp = 75
                item = 1101
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1191" && level >= 27) // Kite
            {
                xp = 75
                item = 1191
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1309" && level >= 29) // 2h Sword
            {
                xp = 75
                item = 1309
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1067" && level >= 31) // Platelegs
            {
                xp = 75
                item = 1067
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1081" && level >= 31) // PlateSkirt
            {
                xp = 75
                item = 1081
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1115" && level >= 33) // Platebody
            {
                xp = 100
                item = 1115
                removeamount = 5
                maketimes = amounttomake
            } else {
                c.sendMessage("You don't have a high enough level to make this Item!")
                return
            }
            doAction(c, item, remove, removeamount, maketimes, -1, -1, xp)
        }

        private fun CheckMith(
            c: client, level: Int,
            amounttomake: Int, type: String
        ) {
            remove = 2359
            if (type.equals("1355", ignoreCase = true) && level >= 51) // Axe
            {
                xp = 50
                item = 1355
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "9142" && level >= 54) //Dart tips
            {
                xp = 50
                item = 9142
                removeamount = 1
                maketimes = amounttomake
            } else if (type.equals("1209", ignoreCase = true) && level >= 50) // Dagger
            {
                xp = 50
                item = 1209
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1428" && level >= 52) // Mace
            {
                xp = 50
                item = 1428
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1143" && level >= 53) // Med helm
            {
                xp = 50
                item = 1143
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "9379" && level >= 54) // Dart tips
            {
                xp = 50
                item = 9379
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1285" && level >= 54) // Sword (s)
            {
                xp = 50
                item = 1285
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "4822" && level >= 54) // Nails
            {
                xp = 50
                item = 4822
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "42" && level >= 55) // Arrow tips
            {
                xp = 50
                item = 42
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1329" && level >= 55) // Scim
            {
                xp = 100
                item = 1329
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1299" && level >= 56) // Longsword
            {
                xp = 100
                item = 1299
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "866" && level >= 57) // Knives
            {
                xp = 50
                item = 866
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1159" && level >= 57) // Full Helm
            {
                xp = 100
                item = 1159
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1181" && level >= 58) // Square shield
            {
                xp = 100
                item = 1181
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1343" && level >= 59) // Warhammer
            {
                xp = 150
                item = 1343
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1369" && level >= 60) // Battle axe
            {
                xp = 150
                item = 1369
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1109" && level >= 61) // Chain
            {
                xp = 150
                item = 1109
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1197" && level >= 62) // Kite
            {
                xp = 150
                item = 1197
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1315" && level >= 64) // 2h Sword
            {
                xp = 150
                item = 1315
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1071" && level >= 66) // Platelegs
            {
                xp = 150
                item = 1071
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1085" && level >= 66) // PlateSkirt
            {
                xp = 150
                item = 1085
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1121" && level >= 68) // Platebody
            {
                xp = 250
                item = 1121
                removeamount = 5
                maketimes = amounttomake
            } else {
                c.sendMessage("You don't have a high enough level to make this Item!")
                return
            }
            doAction(c, item, remove, removeamount, maketimes, -1, -1, xp)
        }

        private fun CheckRune(
            c: client, level: Int,
            amounttomake: Int, type: String
        ) {
            remove = 2363
            if (type.equals("1359", ignoreCase = true) && level >= 86) // Axe
            {
                xp = 75
                item = 1359
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "9144" && level >= 89) //Dart tips
            {
                xp = 75
                item = 9144
                removeamount = 1
                maketimes = amounttomake
            } else if (type.equals("1213", ignoreCase = true) && level >= 85) // Dagger
            {
                xp = 75
                item = 1213
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1432" && level >= 87) // Mace
            {
                xp = 75
                item = 1432
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1147" && level >= 88) // Med helm
            {
                xp = 75
                item = 1147
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "9381" && level >= 89) // Dart tips
            {
                xp = 75
                item = 9381
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1289" && level >= 89) // Sword (s)
            {
                xp = 75
                item = 1289
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "4824" && level >= 89) // Nails
            {
                xp = 75
                item = 4824
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "44" && level >= 90) // Arrow tips
            {
                xp = 75
                item = 44
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1333" && level >= 90) // Scim
            {
                xp = 150
                item = 1333
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1303" && level >= 91) // Longsword
            {
                xp = 150
                item = 1303
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "868" && level >= 92) // Knives
            {
                xp = 75
                item = 868
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1163" && level >= 92) // Full Helm
            {
                xp = 150
                item = 1163
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1185" && level >= 93) // Square shield
            {
                xp = 150
                item = 1185
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1347" && level >= 94) // Warhammer
            {
                xp = 225
                item = 1347
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1373" && level >= 95) // Battle axe
            {
                xp = 225
                item = 1373
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1113" && level >= 96) // Chain
            {
                xp = 225
                item = 1113
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1201" && level >= 97) // Kite
            {
                xp = 225
                item = 1201
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1319" && level >= 99) // 2h Sword
            {
                xp = 225
                item = 1319
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1079" && level >= 99) // Platelegs
            {
                xp = 225
                item = 1079
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1093" && level >= 99) // PlateSkirt
            {
                xp = 225
                item = 1093
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1127" && level >= 99) // Platebody
            {
                xp = 313
                item = 1127
                removeamount = 5
                maketimes = amounttomake
            } else {
                c.sendMessage("You don't have a high enough level to make this Item!")
                return
            }
            doAction(c, item, remove, removeamount, maketimes, -1, -1, xp)
        }

        private fun CheckSteel(
            c: client, level: Int,
            amounttomake: Int, type: String
        ) {
            remove = 2353
            if (type.equals("1353", ignoreCase = true) && level >= 31) // Axe
            {
                xp = 38
                item = 1353
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "9141" && level >= 34) //Dart tips
            {
                xp = 50
                item = 9141
                removeamount = 1
                maketimes = amounttomake
            } else if (type.equals("1207", ignoreCase = true) && level >= 30) // Dagger
            {
                xp = 50
                item = 1207
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1424" && level >= 32) // Mace
            {
                xp = 50
                item = 1424
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1141" && level >= 33) // Med helm
            {
                xp = 50
                item = 1141
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "9378" && level >= 34) // Dart tips
            {
                xp = 50
                item = 9378
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1281" && level >= 34) // Sword (s)
            {
                xp = 50
                item = 1281
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1539" && level >= 34) // Nails
            {
                xp = 50
                item = 1539
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "41" && level >= 35) // Arrow tips
            {
                xp = 50
                item = 41
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1325" && level >= 35) // Scim
            {
                xp = 75
                item = 1325
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1295" && level >= 36) // Longsword
            {
                xp = 75
                item = 1295
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "865" && level >= 37) // Knives
            {
                xp = 50
                item = 865
                removeamount = 1
                maketimes = amounttomake
            } else if (type == "1157" && level >= 37) // Full Helm
            {
                xp = 75
                item = 1157
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1177" && level >= 38) // Square shield
            {
                xp = 75
                item = 1177
                removeamount = 2
                maketimes = amounttomake
            } else if (type == "1339" && level >= 39) // Warhammer
            {
                xp = 113
                item = 1339
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1365" && level >= 40) // Battle axe
            {
                xp = 113
                item = 1365
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1105" && level >= 41) // Chain
            {
                xp = 113
                item = 1105
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1193" && level >= 42) // Kite
            {
                xp = 113
                item = 1193
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1311" && level >= 44) // 2h Sword
            {
                xp = 113
                item = 1311
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1069" && level >= 46) // Platelegs
            {
                xp = 113
                item = 1069
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1083" && level >= 46) // PlateSkirt
            {
                xp = 113
                item = 1083
                removeamount = 3
                maketimes = amounttomake
            } else if (type == "1119" && level >= 48) // Platebody
            {
                xp = 188
                item = 1119
                removeamount = 5
                maketimes = amounttomake
            } else {
                c.sendMessage("You don't have a high enough level to make this Item!")
                return
            }
            doAction(c, item, remove, removeamount, maketimes, -1, -1, xp)
        }

        fun doAction(
            c: client?, toadd: Int, toremove: Int,
            toremove2: Int, timestomake: Int, NOTUSED: Int,
            NOTUSED2: Int, xp: Int
        ) {
            c!!.event = 3
            c.makeTimes = timestomake
            c.RemoveAllWindows()
            if (!c.playerHasItem(toremove, toremove2)) {
                c.sendMessage("You don't have enough bars to make this item!")
                return
            }
            if (!c.playerHasItem(2347, 1) && !c.playerHasItem(2949)) {
                c.sendMessage("You don't have a hammer with you!")
                return
            }
            c.startAnimation(898)
            c.isSmething = true
            EventManager.getSingleton().addEvent(c,object : Event {
                override fun execute(container: EventContainer) {
                    if (c == null || c.disconnected || c.IsDead) {
                        container.stop()
                        return
                    }
                    if(!c.isSmething){
                        container.stop()
                        return
                    }
                    if (!c.playerHasItem(toremove, toremove2)) {
                        c.sendMessage("You have run out of supplies")
                        container.stop()
                        return
                    }
                    if (!c.playerHasItem(2347, 1) && !c.playerHasItem(2949)) {
                        c.sendMessage("You don't have a hammer with you!")
                        container.stop()
                        return
                    }
                    if (c.makeTimes == 0) {
                        container.stop()
                        return
                    }
                    c.deleteItem2(toremove, toremove2)
                    if (c.getItemName(toadd).contains("bolt")) {
                        c.addItem(toadd, 10)
                    } else {
                        if (c.getItemName(toadd).contains("nail")) {
                            c.addItem(toadd, 15)
                        } else {
                            if (c.getItemName(toadd).contains("arrow")) {
                                c.addItem(toadd, 15)
                            } else {
                                if (c.getItemName(toadd).contains("knife")) {
                                    c.addItem(toadd, 5)
                                } else {
                                    if (c.getItemName(toadd).contains("cannon")) {
                                        c.addItem(toadd, 4)
                                    } else {
                                        c.addItem(toadd, 1)
                                    }
                                }
                            }
                        }
                    }
                    var bonus = 1.0
                    if (c.playerHasItem(2949)) bonus *= 1.2
                    c.addSkillXP(xp * Config.SMITHING_EXPERIENCE * bonus, 13)
                    c.refreshSkill(13)
                    c.sendSound(soundList.SMITHING_ANVIL, 100, 0)
                    c.sendMessage("You make a " + c.getItemName(toadd) + ".")
                    val chance = misc.random(50)
                    //c.sendMessage("Your chance to get 100 platinum tokens from skilling was " + chance + " you needed 0.");
                    //	if (chance == 0) {
                    //		c.pkp += 3;
                    //	c.sendMessage("Congrats, You randomly got 3 PK Points from smithing!");
                    //	}
                    if (c.makeTimes != 1) {
                        c.startAnimation(898)
                    }
                    c.makeTimes--
                }

                override fun stop() {
                    c.makeTimes = 0
                }
            }, AnimationLength.getFrameLength(898) + 600)
        }

        @JvmStatic
        fun readInput(
            level: Int, type: String, c: client,
            amounttomake: Int
        ) {
            if (c.getItemName(type.toInt()).contains("Bronze")) {
                CheckBronze(c, level, amounttomake, type)
            } else {
                if (c.getItemName(type.toInt())
                        .contains("Iron")
                ) {
                    CheckIron(c, level, amounttomake, type)
                } else {
                    if (c.getItemName(type.toInt())
                            .contains("Steel")
                    ) {
                        CheckSteel(c, level, amounttomake, type)
                    } else {
                        if (c.getItemName(type.toInt())
                                .contains("Mith")
                        ) {
                            CheckMith(c, level, amounttomake, type)
                        } else {
                            if (c.getItemName(type.toInt())
                                    .contains("Adam")
                                || c.getItemName(type.toInt())
                                    .contains("Addy")
                            ) {
                                CheckAddy(c, level, amounttomake, type)
                            } else {
                                if (c.getItemName(type.toInt())
                                        .contains("Rune")
                                    || c.getItemName(type.toInt())
                                        .contains("Runite")
                                ) {
                                    CheckRune(c, level, amounttomake, type)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}