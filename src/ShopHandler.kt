import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException

class ShopHandler internal constructor() {
    init {
        for (i in 0 until MaxShops) {
            for (j in 0 until MaxShopItems) {
                ResetItem(i, j)
                ShopItemsSN[i][j] = 0 //Special resetting, only at begin !
            }
            ShopItemsStandard[i] = 0 //Special resetting, only at begin !
            ShopSModifier[i] = 0
            ShopBModifier[i] = 0
            ShopName[i] = ""
        }
        TotalShops = 0
        loadShops("./Data/cfg/shops.cfg")
    }

    fun restockTimeItem(itemId: Int): Int {
        return when (itemId) {
            else -> 1000
        }
    }
    fun process() {
        var DidUpdate = false
        for (i in 1..TotalShops) {
            for (j in 0 until MaxShopItems) {
                if (ShopItems[i][j] > 0) {
                    if (ShopItemsDelay[i][j] >= MaxShowDelay) {
                        if (j <= ShopItemsStandard[i] && ShopItemsN[i][j] <= ShopItemsSN[i][j]) {
                            if (ShopItemsN[i][j] < ShopItemsSN[i][j] && System.currentTimeMillis() - shopItemsRestock[i][j] > restockTimeItem(
                                    ShopItems[i][j]
                                )
                            ) {
                                ShopItemsN[i][j] += 1 //if amount lower then standard, increase it !
                                ShopItemsDelay[i][j] = 1
                                ShopItemsDelay[i][j] = 0
                                DidUpdate = true
                                shopItemsRestock[i][j] = System.currentTimeMillis()
                            }
                        } else if (ShopItemsDelay[i][j] >= MaxShowDelay) {
                            DiscountItem(i, j)
                            ShopItemsDelay[i][j] = 0
                            DidUpdate = true
                        }
                        refreshShop(i)
                    }
                    ShopItemsDelay[i][j]++
                }
            }
            if (DidUpdate) {
                for (k in 1 until PlayerHandler.maxPlayers) {
                    if (PlayerHandler.players[k] != null) {
                        if (PlayerHandler.players[k].IsShopping && PlayerHandler.players[k].MyShopID == i) {
                            PlayerHandler.players[k].UpdateShop = true
                        }
                    }
                }
                DidUpdate = false
            }
        }
    }
    fun refreshShop(shopId: Int) {
        // We don't want to remove items that should be kept in stock
        for (j in ShopItemsStandard[shopId] until MaxShopItems) {
            if (ShopItemsN[shopId][j] <= 0) {
                ResetItem(shopId, j)
                val next = j + 1
                if (next < MaxShopItems && ShopItemsN[shopId][next] > 0) {
                    ShopItems[shopId][j] = ShopItems[shopId][next]
                    ShopItemsN[shopId][j] = ShopItemsN[shopId][next]
                    ShopItemsDelay[shopId][j] = ShopItemsDelay[shopId][next]
                    ResetItem(shopId, next)
                }
            }
        }
    }
    fun DiscountItem(ShopID: Int, ArrayID: Int) {
        ShopItemsN[ShopID][ArrayID] -= 1
        if (ShopItemsN[ShopID][ArrayID] <= 0) {
            ShopItemsN[ShopID][ArrayID] = 0
            ResetItem(ShopID, ArrayID)
        }
    }

    fun ResetItem(ShopID: Int, ArrayID: Int) {
        ShopItems[ShopID][ArrayID] = 0
        ShopItemsN[ShopID][ArrayID] = 0
        ShopItemsDelay[ShopID][ArrayID] = 0
    }

    fun loadShops(FileName: String): Boolean {
        var line = ""
        var token = ""
        var token2 = ""
        var token2_2 = ""
        var token3 = arrayOfNulls<String>(MaxShopItems * 2)
        var EndOfFile = false
        val ReadMode = 0
        var characterfile: BufferedReader? = null
        characterfile = try {
            BufferedReader(FileReader("./$FileName"))
        } catch (fileex: FileNotFoundException) {
            misc.println("$FileName: file not found.")
            return false
        }
        line = try {
            characterfile!!.readLine()
        } catch (ioexception: IOException) {
            misc.println("$FileName: error loading file.")
            return false
        }
        while (!EndOfFile) {
            line = line.trim { it <= ' ' }
            val spot = line.indexOf("=")
            if (spot > -1) {
                token = line.substring(0, spot)
                token = token.trim { it <= ' ' }
                token2 = line.substring(spot + 1)
                token2 = token2.trim { it <= ' ' }
                token2_2 = token2.replace("\t\t".toRegex(), "\t")
                token2_2 = token2_2.replace("\t\t".toRegex(), "\t")
                token2_2 = token2_2.replace("\t\t".toRegex(), "\t")
                token2_2 = token2_2.replace("\t\t".toRegex(), "\t")
                token2_2 = token2_2.replace("\t\t".toRegex(), "\t")
                token3 = token2_2.split("\t".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                if (token == "shop") {
                    val ShopID = token3[0]!!.toInt()
                    ShopName[ShopID] = token3[1]!!.replace("_".toRegex(), " ")
                    ShopSModifier[ShopID] = token3[2]!!.toInt()
                    ShopBModifier[ShopID] = token3[3]!!.toInt()
                    for (i in 0 until (token3.size - 4) / 2) {
                        if (token3[4 + i * 2] != null) {
                            ShopItems[ShopID][i] = token3[4 + i * 2]!!.toInt() + 1
                            ShopItemsN[ShopID][i] = token3[5 + i * 2]!!.toInt()
                            ShopItemsSN[ShopID][i] = token3[5 + i * 2]!!.toInt()
                            ShopItemsStandard[ShopID]++
                        } else {
                            break
                        }
                    }
                    TotalShops++
                }
            } else {
                if (line == "[ENDOFSHOPLIST]") {
                    try {
                        characterfile!!.close()
                    } catch (ioexception: IOException) {
                    }
                    return true
                }
            }
            try {
                line = characterfile!!.readLine()
            } catch (ioexception1: IOException) {
                EndOfFile = true
            }
        }
        try {
            characterfile.close()
        } catch (ioexception: IOException) {
        }
        return false
    }
    fun getItemAmount(shopId: Int): Int {
        var itemCount = 0
        for (i in ShopItems[shopId]) {
            val id = ShopItems[shopId][i]
            if (id > 0) {
                itemCount += ShopItems.size
            }
        }
        return itemCount
    }
    companion object {

        var MaxShops = 500 //1 more because we don't use [0] !
        @JvmField
        public var MaxShopItems = 1500 //1 more because we don't use [0] !
        var MaxInShopItems = 60
        var MaxShowDelay = 10
        var TotalShops = 0
        @JvmField
        public var ShopItems = Array(MaxShops) { IntArray(MaxShopItems) }
        @JvmField
        var ShopItemsN = Array(MaxShops) { IntArray(MaxShopItems) }

        @JvmField
        var ShopItemsDelay = Array(MaxShops) { IntArray(MaxShopItems) }
        var ShopItemsSN = Array(MaxShops) { IntArray(MaxShopItems) }
        @JvmField
        var ShopItemsStandard = IntArray(MaxShops)
        @JvmField
        var ShopName = arrayOfNulls<String>(MaxShops)
        @JvmField
        var ShopSModifier = IntArray(MaxShops)
        @JvmField
        var ShopBModifier = IntArray(MaxShops)
        var shopItemsRestock = Array<LongArray>(MaxShops) {
            LongArray(
                MaxShopItems
            )
        }
    }
}

private operator fun Int.plusAssign(get: IntArray) {

}
