public class BettyDialogue extends Dialogue {
    /**
     *
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Hello there. Welcome to my magic emporium.");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(),"Can i see your wares?", "Sorry, I'm not into magic.");
                break;
            case 2:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Of course.");
                setNext(3);
                break;
            case 3:
                end();
                getPlayer().skillX = getPlayer().absX;
                getPlayer().skillY = getPlayer().absY;
                getPlayer().PutNPCCoords = true;
                getPlayer().WanneShop = 21; // General Store
                break;
        }

    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_2_1:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Can i see your wares?");
                setNext(2);
                break;
            case DialogueConstants.OPTIONS_2_2:
                end();
                getPlayer().RemoveAllWindows();
                break;
        }
        return false;
    }
}
