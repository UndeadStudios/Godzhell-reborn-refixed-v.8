public class CassieDialogue extends Dialogue {
    /**
     *
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "I buy and sell shields, do you want to trade?");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(),"Yes please.", "No thank you.");
                break;
            case 4:
                end();
                getPlayer().RemoveAllWindows();
                break;
        }

    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_2_1:
                end();
                getPlayer().skillX = getPlayer().absX;
                getPlayer().skillY = getPlayer().absY;
                getPlayer().PutNPCCoords = true;
                getPlayer().WanneShop = 101; // cassie shield Shop
                break;
            case DialogueConstants.OPTIONS_2_2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "No thank you.");
                setNext(4);
                break;
        }
        return false;
    }
}
