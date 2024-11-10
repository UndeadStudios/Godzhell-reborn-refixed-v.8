public class RommikDialogue extends Dialogue {
    /**
     *
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, " Would you like to buy some crafting equipment?");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(),"Let's see what you've got, then.", "No thanks, I've got all the Crafting equipment I need.");
                break;
            case 2:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Okay. Fare well on your travels.");
                setNext(3);
                break;
            case 3:
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
                getPlayer().WanneShop = 14; // General Store
                break;
            case DialogueConstants.OPTIONS_2_2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "No thanks; I've got all the Crafting equipment I need.");
                setNext(2);
                break;
        }
        return false;
    }
}
