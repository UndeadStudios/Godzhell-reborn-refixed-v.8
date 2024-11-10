/**
 * Not finished yet.
 *
 * @author Micheal/01053
 */

public class Arrow {

    public static void initialize(client c, int itemUsed, int useWith) {
        //ArrowData data = null;
        if(System.currentTimeMillis() - c.newactionTimer < 600)
            return;

        if(((itemUsed == 314 || itemUsed == 2950) &&  useWith == 52) || ((useWith == 314 || useWith == 2950) && itemUsed == 52)) {
            int amount = Math.min((itemUsed != 2950 && useWith != 2950) ? c.getItemAmount(314) : 15, c.getItemAmount(52));
            if(c.freeSlots() == 0 && amount > 15) {
                c.sendMessage("You do not have enough inventory space!");
                return;
            }
            if(amount > 15)
                amount = 15;
            if(itemUsed != 2950 && useWith != 2950)
                c.deleteItem(314, amount);
            c.deleteItem(52, amount);
            c.addItem(53, amount);
            c.addSkillXP(1 * amount, c.playerFletching);
            c.sendMessage("You create a <col=0000FF>" + c.getItemName(53)
                    + "<col=000000> x<col=0000FF>" + amount + ".");
            c.newactionTimer = System.currentTimeMillis();
        } else if(itemUsed == 53 || useWith == 53 || itemUsed == 314 || useWith == 314 || useWith == 2950 || itemUsed == 2950) {
            ArrowData data = null;
            for (ArrowData data2 : ArrowData.values()) {
                if((((itemUsed == data2.getArrowData() && useWith == 53) || (useWith == data2.getArrowData() && itemUsed == 53)) && !data2.requiresFeather()) ||
                        (((itemUsed == data2.getArrowData() && useWith == 314) || (useWith == data2.getArrowData() && itemUsed == 314)) && data2.requiresFeather())) {
                    if(c.playerLevel[c.playerFletching] < data2.getLevelReq()) {
                        c.sendMessage("You require a fletching level of " + data2.getLevelReq() + " in order to fletch these arrows.");
                    } else {
                        data = data2;
                    }
                }
            }

            if(data == null)
                return;
            int amount = Math.min(c.getItemAmount(data.getArrowData()),(itemUsed != 2950 && useWith != 2950) ?
                    c.getItemAmount(data.requiresFeather() ? 314 : 53) : 15);
            if(c.freeSlots() == 0 && amount > 15) {
                c.sendMessage("You do not have enough inventory space!");
                return;
            }
            if(amount > 15)
                amount = 15;
            c.deleteItem(data.getArrowData(), amount);
            if(itemUsed != 2950 && useWith != 2950)
                c.deleteItem(data.requiresFeather() ? 314 : 53, amount);
            c.addItem(data.getArrowType(), amount);
            c.addSkillXP(data.getExperience() * amount, c.playerFletching);
            c.sendMessage("You create <col=0000FF>" + c.getItemName(data.getArrowType())
                    + "<col=000000> x<col=0000FF>" + amount + ".");
            c.newactionTimer = System.currentTimeMillis();


        }
    }
}