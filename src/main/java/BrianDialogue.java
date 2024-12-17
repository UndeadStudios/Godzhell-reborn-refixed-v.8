public class BrianDialogue extends Dialogue {
    /**
     *
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendOption(getPlayer(), "So, are you selling something?", "Ello.");
                break;
            case 2:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc,  Emotion.HAPPY, "Yep, take a look at these great axes!");
                setNext(3);
                break;
            case 3:
                end();
                getPlayer().skillX = getPlayer().absX;
                getPlayer().skillY = getPlayer().absY;
                getPlayer().PutNPCCoords = true;
                getPlayer().WanneShop = 19; // General Store
                break;
            case 4:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc,  Emotion.HAPPY, "Ello!");
                setNext(5);
                break;
            case 5:
                end();
                getPlayer().RemoveAllWindows();
                break;
        }
    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_2_1:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "So, are you selling something?");
                setNext(2);
                break;
            case DialogueConstants.OPTIONS_2_2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Ello.");
                setNext(4);
                break;
        }
        return false;
    }
}
