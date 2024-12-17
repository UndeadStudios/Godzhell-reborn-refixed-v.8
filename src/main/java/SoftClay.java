public class SoftClay {

    public static final int SOFT_CLAY = 1761, CLAY = 434;

    public static void makeClay(final client player) {
        if (!player.playerHasItem(CLAY)) {
            player.sendMessage("You need clay to do this.");
            return;
        }
        player.isSpinning = true;
        player.doAmount = player.getItemAmount(CLAY);
        EventManager.getSingleton().addEvent(player, new Event() {
            @Override
            public void execute(EventContainer container) {
                if (player.playerHasItem(CLAY) && player.isSpinning == true) {
                    player.startAnimation(896);
                    player.deleteItem(CLAY, 1);
                    player.addItem(SOFT_CLAY, 1);
                    player.doAmount--;
                  //  RandomEventHandler.addRandom(player);
                    player.sendMessage("You turn the clay into soft clay.");
                    if (player.disconnected || player.isSpinning == false || player.doAmount == 0) {
                        container.stop();
                        return;
                    }
                }
            }
            @Override
            public void stop() {
                player.isSpinning = false;
                player.startAnimation(65535);
                return;
            }
        }, 3+600);
    }

}