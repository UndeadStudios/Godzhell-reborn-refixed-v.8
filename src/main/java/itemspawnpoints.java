// Item Spawn Points by xerozcheez

public class itemspawnpoints {
    public int spawntimer = 0;
    public int spawntimer2 = 0;

    public void LoadItems() {
        for (int i = 0; i <= 15000; i++) {
            if (spawntimer <= 1) {
                ItemHandler.addItem(2414, 3118, 9848, 1, ItemHandler.globalItemController[i], false); // Zammy Cape
                ItemHandler.addItem(2412, 3119, 9848, 1, ItemHandler.globalItemController[i], false); // Sara Cape
                ItemHandler.addItem(2413, 3120, 9848, 1, ItemHandler.globalItemController[i], false); // Guthix Cape
//ItemHandler.addItem(995, 2507, 3379, 1000000, ItemHandler.globalItemController[i], false); //Nets's Moderator Island 50m Drop
                spawntimer = 100;
            }
            if (spawntimer2 <= 1) {
                ItemHandler.addItem(995, 3268, 3352, 500000, ItemHandler.globalItemController[i], false); // Zammy Cape
                ItemHandler.addItem(995, 3266, 3352, 500000, ItemHandler.globalItemController[i], false); // Sara Cape
                //ItemHandler.addItem(2413, 3120, 9848, 1, ItemHandler.globalItemController[i], false); // Guthix Cape
//ItemHandler.addItem(995, 2507, 3379, 1000000, ItemHandler.globalItemController[i], false); //Nets's Moderator Island 50m Drop
                spawntimer2 = 300;
            }
        }
    }

    public void process() {
        LoadItems();
        spawntimer -= 1;
        spawntimer2 -= 1;
    }
}