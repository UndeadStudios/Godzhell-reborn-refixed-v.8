/**
 * Class BowStringing contains the data for stringing the bow and the bow
 * string together.
 */

public class BowStringing extends StringingData {

    private static int BOW_STRING = 1777;

    /**
     * This void contains the cycle event to string the
     * unstrung bow and the bow string together
     * playingSkilling[9] = fletching,
     */

    public static void stringBow(final client c, final int itemUsed, final int usedWith) {
        if (c.playerIsfFetching) {
            return;
        }
        final int itemId = (itemUsed == BOW_STRING ? usedWith : itemUsed);
        for (final stringingData g : stringingData.values()) {
            if (itemId == g.unStrung()) {
                if (c.playerLevel[9] < g.getLevel()) {
                    c.sendMessage("You need a fletching level of "+ g.getLevel() +" to string this bow.");
                    return;
                }
                if (!c.playerHasItem(itemId)) {
                    return;
                }
                c.playerIsfFetching = true;
                c.startAnimation(g.getAnimation());
                EventManager.getSingleton().addEvent(c,new Event() {
                    @Override
                    public void execute(EventContainer container) {
                        if(c == null || c.disconnected  || c.IsDead) {
                            container.stop();
                            return;
                        }
                        if(!c.playerHasItem(1777)) {
                            c.sendMessage("You need a <col=0000FF>Bow String <col=000000>to string the "+ c.getItemName(itemId).toLowerCase() +".");
                            container.stop();
                            return;
                        }
                        if (c.playerIsfFetching = true) {
                            if (c.playerHasItem(itemId) && c.playerHasItem(BOW_STRING)) {
                                c.startAnimation(g.getAnimation());
                            } else {
                                container.stop();
                            }
                        } else {
                            container.stop();
                        }
                    }
                    @Override
                    public void stop() {
                        c.playerIsfFetching = false;
                    }
                }, AnimationLength.getFrameLength(g.getAnimation())+600);
                EventManager.getSingleton().addEvent(c, new Event() {
                    @Override
                    public void execute(EventContainer container) {
                        if(c == null || c.disconnected  || c.IsDead) {
                            container.stop();
                            return;
                        }
                        if (c.playerIsfFetching == true) {
                            if (c.playerHasItem(itemId) && c.playerHasItem(BOW_STRING)) {
                                c.deleteItem(itemId, 1);
                                c.deleteItem(BOW_STRING, 1);
                                c.addItem(g.Strung(), 1);
                                c.addSkillXP((int) g.getXP(), 9);
                                c.sendMessage("You attach the bow string to the "+ c.getItemName(itemId).toLowerCase() +".");
                                c.startAnimation(g.getAnimation());
                            } else {
                                container.stop();
                            }
                        } else {
                            container.stop();
                        }
                    }
                    @Override
                    public void stop() {
                        c.playerIsfFetching = false;
                    }
                }, AnimationLength.getFrameLength(g.getAnimation())+600);
            }
        }
    }
}