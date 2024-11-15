public class MenuHandler {

    public void attackMenu(int a) {
        client p = (client) PlayerHandler.players[a];

        p.sendQuest("@whi@Attack", 8716);
        p.sendQuest("@whi@Level", 8718);
        p.sendQuest("@whi@Advancement", 8719);
        p.sendQuest("@cya@1", 8720);
        p.sendQuest("@cya@1", 8721);
        p.sendQuest("@cya@5", 8722);
        p.sendQuest("@cya@10", 8723);
        p.sendQuest("@cya@20", 8724);
        p.sendQuest("@cya@30", 8725);
        p.sendQuest("@cya@40", 8726);
        p.sendQuest("@cya@60", 8727);
        p.sendQuest("@cya@70", 8728);
        p.sendQuest("@cya@70", 8729);
        p.sendQuest(" ", 8730);
        p.sendQuest("@cya@Bronze", 8760);
        p.sendQuest("@cya@Iron", 8761);
        p.sendQuest("@cya@Steel", 8762);
        p.sendQuest("@cya@Black", 8763);
        p.sendQuest("@cya@Mithril", 8764);
        p.sendQuest("@cya@Adamentite", 8765);
        p.sendQuest("@cya@Rune", 8766);
        p.sendQuest("@cya@Dragon", 8767);
        p.sendQuest("@cya@Barrows", 8768);
        p.sendQuest("@cya@Abyssal", 8769);
        p.sendQuest(" ", 8770);
        p.sendQuest("Attack", 8846);
        p.sendQuest(" ", 8849);
        p.sendQuest("Defense", 8823);
        p.sendQuest("Ranged", 8824);
        p.sendQuest("Magic", 8827);
        p.sendQuest(" ", 8837);
        p.sendQuest(" ", 8840);
        p.sendQuest(" ", 8843);
        p.sendQuest(" ", 8859);
        p.sendQuest(" ", 8862);
        p.sendQuest(" ", 8865);
        p.sendQuest(" ", 15303);
        p.sendQuest(" ", 15306);
        p.sendQuest(" ", 15309);
        p.clearQuestInterface();
        p.sendFrame246(8715, 700, 4587);
        p.showInterface(8714);
        p.flushOutStream();
    }

    public void defenseMenu(int a) {
        client p = (client) PlayerHandler.players[a];

        p.sendQuest("@whi@Defense", 8716);
        p.sendQuest("@whi@Level", 8718);
        p.sendQuest("@whi@Advancement", 8719);
        p.sendQuest("@cya@1", 8720);
        p.sendQuest("@cya@1", 8721);
        p.sendQuest("@cya@5", 8722);
        p.sendQuest("@cya@10", 8723);
        p.sendQuest("@cya@20", 8724);
        p.sendQuest("@cya@30", 8725);
        p.sendQuest("@cya@40", 8726);
        p.sendQuest("@cya@50", 8727);
        p.sendQuest("@cya@60", 8728);
        p.sendQuest("@cya@70", 8729);
        p.sendQuest(" ", 8730);
        p.sendQuest("@cya@Bronze", 8760);
        p.sendQuest("@cya@Iron", 8761);
        p.sendQuest("@cya@Steel", 8762);
        p.sendQuest("@cya@Black", 8763);
        p.sendQuest("@cya@Mithril", 8764);
        p.sendQuest("@cya@Adamentite", 8765);
        p.sendQuest("@cya@Rune", 8766);
        p.sendQuest("@cya@Granite", 8767);
        p.sendQuest("@cya@Dragon", 8768);
        p.sendQuest("@cya@Barrows", 8769);
        p.sendQuest(" ", 8770);
        p.sendQuest("Attack", 8846);
        p.sendQuest(" ", 8849);
        p.sendQuest("Defense", 8823);
        p.sendQuest("Ranged", 8824);
        p.sendQuest("Magic", 8827);
        p.sendQuest(" ", 8837);
        p.sendQuest(" ", 8840);
        p.sendQuest(" ", 8843);
        p.sendQuest(" ", 8859);
        p.sendQuest(" ", 8862);
        p.sendQuest(" ", 8865);
        p.sendQuest(" ", 15303);
        p.sendQuest(" ", 15306);
        p.sendQuest(" ", 15309);
        p.clearQuestInterface();
        p.sendFrame246(8715, 600, 1187);
        p.showInterface(8714);
        p.flushOutStream();
    }

    public void rangeMenu(int a) {
        client p = (client) PlayerHandler.players[a];

        p.sendQuest("@whi@Ranged", 8716);
        p.sendQuest("@whi@Level", 8718);
        p.sendQuest("@whi@Advancement", 8719);
        p.sendQuest("@cya@1", 8720);
        p.sendQuest("@cya@1", 8721);
        p.sendQuest("@cya@5", 8722);
        p.sendQuest("@cya@20", 8723);
        p.sendQuest("@cya@30", 8724);
        p.sendQuest("@cya@40", 8725);
        p.sendQuest("@cya@50", 8726);
        p.sendQuest("@cya@70", 8727);
        p.sendQuest(" ", 8728);
        p.sendQuest(" ", 8729);
        p.sendQuest(" ", 8730);
        p.sendQuest("@cya@Short Bow", 8760);
        p.sendQuest("@cya@Long Bow", 8761);
        p.sendQuest("@cya@Oak Bows", 8762);
        p.sendQuest("@cya@Willow Bows", 8763);
        p.sendQuest("@cya@Maple Bows", 8764);
        p.sendQuest("@cya@Yew Bows", 8765);
        p.sendQuest("@cya@Magic Bows", 8766);
        p.sendQuest("@cya@Crystal Bow", 8767);
        p.sendQuest(" ", 8768);
        p.sendQuest(" ", 8769);
        p.sendQuest(" ", 8770);
        p.sendQuest("Attack", 8846);
        p.sendQuest(" ", 8849);
        p.sendQuest("Defense", 8823);
        p.sendQuest("Ranged", 8824);
        p.sendQuest("Magic", 8827);
        p.sendQuest(" ", 8837);
        p.sendQuest(" ", 8840);
        p.sendQuest(" ", 8843);
        p.sendQuest(" ", 8859);
        p.sendQuest(" ", 8862);
        p.sendQuest(" ", 8865);
        p.sendQuest(" ", 15303);
        p.sendQuest(" ", 15306);
        p.sendQuest(" ", 15309);
        p.clearQuestInterface();
        p.sendFrame246(8715, 600, 4212);
        p.showInterface(8714);
        p.flushOutStream();
    }

    public void mageMenu(int a) {
        client p = (client) PlayerHandler.players[a];

        p.sendQuest("@whi@Magic", 8716);
        p.sendQuest("@whi@Level", 8718);
        p.sendQuest("@whi@Advancement", 8719);
        p.sendQuest("@cya@NA", 8720);
        p.sendQuest("@cya@20", 8721);
        p.sendQuest(" ", 8722);
        p.sendQuest(" ", 8723);
        p.sendQuest(" ", 8724);
        p.sendQuest(" ", 8725);
        p.sendQuest(" ", 8726);
        p.sendQuest(" ", 8727);
        p.sendQuest(" ", 8728);
        p.sendQuest(" ", 8729);
        p.sendQuest(" ", 8730);
        p.sendQuest("@cya@See Spell Book", 8760);
        p.sendQuest("@cya@Mystic Armour", 8761);
        p.sendQuest(" ", 8762);
        p.sendQuest(" ", 8763);
        p.sendQuest(" ", 8764);
        p.sendQuest(" ", 8765);
        p.sendQuest(" ", 8766);
        p.sendQuest(" ", 8767);
        p.sendQuest(" ", 8768);
        p.sendQuest(" ", 8769);
        p.sendQuest(" ", 8770);
        p.sendQuest("Attack", 8846);
        p.sendQuest(" ", 8849);
        p.sendQuest("Defense", 8823);
        p.sendQuest("Ranged", 8824);
        p.sendQuest("Magic", 8827);
        p.sendQuest(" ", 8837);
        p.sendQuest(" ", 8840);
        p.sendQuest(" ", 8843);
        p.sendQuest(" ", 8859);
        p.sendQuest(" ", 8862);
        p.sendQuest(" ", 8865);
        p.sendQuest(" ", 15303);
        p.sendQuest(" ", 15306);
        p.sendQuest(" ", 15309);
        p.clearQuestInterface();
        p.sendFrame246(8715, 600, 560);
        p.showInterface(8714);
        p.flushOutStream();
    }

    public void prayMenu(int a) {
        client p = (client) PlayerHandler.players[a];

        p.sendQuest("@whi@Prayer", 8716);
        p.sendQuest("@whi@Level", 8718);
        p.sendQuest("@whi@Advancement", 8719);
        p.sendQuest("@cya@NA", 8720);
        p.sendQuest(" ", 8721);
        p.sendQuest(" ", 8722);
        p.sendQuest(" ", 8723);
        p.sendQuest(" ", 8724);
        p.sendQuest(" ", 8725);
        p.sendQuest(" ", 8726);
        p.sendQuest(" ", 8727);
        p.sendQuest(" ", 8728);
        p.sendQuest(" ", 8729);
        p.sendQuest(" ", 8730);
        p.sendQuest("@cya@See Prayer Book", 8760);
        p.sendQuest(" ", 8761);
        p.sendQuest(" ", 8762);
        p.sendQuest(" ", 8763);
        p.sendQuest(" ", 8764);
        p.sendQuest(" ", 8765);
        p.sendQuest(" ", 8766);
        p.sendQuest(" ", 8767);
        p.sendQuest(" ", 8768);
        p.sendQuest(" ", 8769);
        p.sendQuest(" ", 8770);
        p.sendQuest("Attack", 8846);
        p.sendQuest(" ", 8849);
        p.sendQuest("Defense", 8823);
        p.sendQuest("Ranged", 8824);
        p.sendQuest("Magic", 8827);
        p.sendQuest(" ", 8837);
        p.sendQuest(" ", 8840);
        p.sendQuest(" ", 8843);
        p.sendQuest(" ", 8859);
        p.sendQuest(" ", 8862);
        p.sendQuest(" ", 8865);
        p.sendQuest(" ", 15303);
        p.sendQuest(" ", 15306);
        p.sendQuest(" ", 15309);
        p.clearQuestInterface();
        p.sendFrame246(8715, 600, 3840);
        p.showInterface(8714);
        p.flushOutStream();
    }

    public void runecraftMenu(int a) {
        client p = (client) PlayerHandler.players[a];

        p.sendQuest("@whi@Runecrafting", 8716);
        p.sendQuest("@whi@Level", 8718);
        p.sendQuest("@whi@Advancement", 8719);
        p.sendQuest("@cya@1", 8720);
        p.sendQuest("@cya@2", 8721);
        p.sendQuest("@cya@5 ", 8722);
        p.sendQuest("@cya@9", 8723);
        p.sendQuest("@cya@14", 8724);
        p.sendQuest("@cya@20", 8725);
        p.sendQuest("@cya@27", 8726);
        p.sendQuest("@cya@35", 8727);
        p.sendQuest("@cya@44", 8728);
        p.sendQuest("@cya@54", 8729);
        p.sendQuest("@cya@65", 8730);
        p.sendQuest("@cya@Air Runes", 8760);
        p.sendQuest("@cya@Mind Runes", 8761);
        p.sendQuest("@cya@Water Runes", 8762);
        p.sendQuest("@cya@Earth Runes", 8763);
        p.sendQuest("@cya@Fire Runes", 8764);
        p.sendQuest("@cya@Body Runes", 8765);
        p.sendQuest("@cya@Cosmic Runes", 8766);
        p.sendQuest("@cya@Chaos Runes", 8767);
        p.sendQuest("@cya@Nature Runes", 8768);
        p.sendQuest("@cya@Law Runes", 8769);
        p.sendQuest("@cya@Death Runes", 8770);
        p.sendQuest("Attack", 8846);
        p.sendQuest(" ", 8849);
        p.sendQuest("Defense", 8823);
        p.sendQuest("Ranged", 8824);
        p.sendQuest("Magic", 8827);
        p.sendQuest(" ", 8837);
        p.sendQuest(" ", 8840);
        p.sendQuest(" ", 8843);
        p.sendQuest(" ", 8859);
        p.sendQuest(" ", 8862);
        p.sendQuest(" ", 8865);
        p.sendQuest(" ", 15303);
        p.sendQuest(" ", 15306);
        p.sendQuest(" ", 15309);
        p.clearQuestInterface();
        p.sendFrame246(8715, 600, 1458);
        p.showInterface(8714);
        p.flushOutStream();
    }

    public void agilityMenu(int a) {
        client p = (client) PlayerHandler.players[a];

        p.sendQuest("@whi@Agility", 8716);
        p.sendQuest("@whi@Level", 8718);
        p.sendQuest("@whi@Advancement", 8719);
        p.sendQuest("@cya@1", 8720);
        p.sendQuest("@cya@30", 8721);
        p.sendQuest(" ", 8722);
        p.sendQuest(" ", 8723);
        p.sendQuest(" ", 8724);
        p.sendQuest(" ", 8725);
        p.sendQuest(" ", 8726);
        p.sendQuest(" ", 8727);
        p.sendQuest(" ", 8728);
        p.sendQuest(" ", 8729);
        p.sendQuest(" ", 8730);
        p.sendQuest("@cya@Gnome Course", 8760);
        p.sendQuest("@cya@Werewolf Course ", 8761);
        p.sendQuest(" ", 8762);
        p.sendQuest(" ", 8763);
        p.sendQuest(" ", 8764);
        p.sendQuest(" ", 8765);
        p.sendQuest(" ", 8766);
        p.sendQuest(" ", 8767);
        p.sendQuest(" ", 8768);
        p.sendQuest(" ", 8769);
        p.sendQuest(" ", 8770);
        p.sendQuest("Attack", 8846);
        p.sendQuest(" ", 8849);
        p.sendQuest("Defense", 8823);
        p.sendQuest("Ranged", 8824);
        p.sendQuest("Magic", 8827);
        p.sendQuest(" ", 8837);
        p.sendQuest(" ", 8840);
        p.sendQuest(" ", 8843);
        p.sendQuest(" ", 8859);
        p.sendQuest(" ", 8862);
        p.sendQuest(" ", 8865);
        p.sendQuest(" ", 15303);
        p.sendQuest(" ", 15306);
        p.sendQuest(" ", 15309);
        p.clearQuestInterface();
        p.sendFrame246(8715, 600, 3107);
        p.showInterface(8714);
        p.flushOutStream();
    }
}
