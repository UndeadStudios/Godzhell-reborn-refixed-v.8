public class JiminuaDialogue extends Dialogue {
    /**
     * 
     */
    @Override
    public void execute() {
        switch(getNext()){
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Welcome to the Jungle Store. Can I help you at all?");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(), "Yes please. What are you selling", "No thanks.");
                break;

            case 2:
                end();
                getPlayer().skillX = getPlayer().absX;
                getPlayer().skillY = getPlayer().absY;
                getPlayer().PutNPCCoords = true;
                getPlayer().WanneShop = 201; // Jiminua's Jungle Store
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
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Yes please. What are you selling?");
                setNext(2);
                break;
            case DialogueConstants.OPTIONS_2_2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "No thank you.");
                setNext(4);
                break;
        }
        return false;
    }
}
