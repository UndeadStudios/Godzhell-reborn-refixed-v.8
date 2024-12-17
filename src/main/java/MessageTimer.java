public class MessageTimer extends Thread
        implements Runnable {
    boolean firstMsg = false;

    public void run() {
        long l = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() - l >= 120000L) {
                if (this.firstMsg) {
                    PlayerHandler.messageToAll = "*** Remember To Vote Everyday ***";
                } else {
                    PlayerHandler.messageToAll = "*** Don't Ask For Staff Or Items From Any Staff ***";
                }

                this.firstMsg = (!this.firstMsg);
                l = System.currentTimeMillis();
            }
            try {
                Thread.sleep(50L);
            } catch (InterruptedException localInterruptedException) {
            }
        }
    }
}