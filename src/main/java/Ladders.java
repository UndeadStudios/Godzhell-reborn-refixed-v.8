public class Ladders {
    public static void climbLadder(final client player, int x, int y, int h) {
        player.startAnimation(828/*method == "up" ? 828 : 827*/);
        player.RemoveAllWindows();
        EventManager.getSingleton().addEvent(player,new Event() {
            @Override
            public void execute(EventContainer container) {
                player.movePlayer(x, y, h);
                player.startAnimation(65535);
                container.stop();
            }
            public void stop() {
                //player.setStopPacket(false);
            }
        }, AnimationLength.getFrameLength(828));
    }

}
