public class sandtoBucket {
    public enum sandData {
        BUCKET(1925, 1783);


        private int emptyid, filledid;

        private sandData(int emptyid, int filledid){
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
        for(final sandData g : sandData.values()) {
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
                                c.startAnimation(895);
                                c.deleteItem(g.getEmptyId(), 1);
                                c.addItem(g.getFilledId(), 1);
                                c.sendMessage("You fill the bucket with sand.");
                            }else {
                                container.stop();
                            }


                        }
                        @Override
                        public void stop() {
                            c.startAnimation(65535);
                            c.fillingWater = false;
                        }
                    }, 3 * 600);
                }
            }
        }
    }
}