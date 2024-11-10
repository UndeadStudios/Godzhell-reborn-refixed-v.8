public class Fillables  {
    public enum fillData {
        VIAL(229, 227),
        BUCKET(1925, 1929),
        JUG(1935, 1937),
        BOWL(1923, 1921),
        CUP(1980, 4458),
        WATERING_CAN(5331, 5340),
        WATERING_CAN2(5333, 5340),
        WATERING_CAN3(5334, 5340),
        WATERING_CAN4(5335, 5340),
        WATERING_CAN5(5336, 5340),
        WATERING_CAN6(5337, 5340),
        WATERING_CAN7(5338, 5340),
        WATERING_CAN8(5339, 5340),
        WATERSKIN(1831, 1823),
        WATERSKIN2(1825, 1823),
        WATERSKIN3(1827, 1823),
        WATERSKIN4(1829, 1823),
        FISHBOWL(6667, 6668);

        private int emptyid, filledid;

        private fillData(int emptyid, int filledid){
            this.emptyid = emptyid;
            this.filledid = filledid;

        }
        public int getEmptyId(){
            return emptyid;
        }
        public int getFilledId(){
            return filledid;
        }


    }

    public static void fillTheItem(final client c, int itemId, int objectID) {
        for(final fillData g : fillData.values()) {
            if(c.playerHasItem(g.getEmptyId(), 1)) {

                if(itemId == g.getEmptyId()) {
                    c.fillingWater = true;
                    EventManager.getSingleton().addEvent(c, new Event() {

                        @Override
                        public void execute(EventContainer container) {
                            if(c == null || c.disconnected) {
                                stop();
                                return;
                            }
                            if (c.fillingWater) {
                                if (!c.playerHasItem(g.getEmptyId(), 1)) {
                                    //c.sendMessage("You have run out of molten glass.");
                                    container.stop();
                                    return;
                                }
                                c.startAnimation(832);
                                c.deleteItem2(g.getEmptyId(), 1);
                                c.addItem(g.getFilledId(), 1);
                                c.sendMessage("You fill "+c.getItemName(g.getEmptyId())+" with water.");
                            }else {
                                container.stop();
                            }


                        }
                        @Override
                        public void stop() {
                            c.startAnimation(65535);
                            c.fillingWater = false;
                        }
                    }, 3+600);
                }
            }
        }
    }
}
