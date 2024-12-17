public class SkillzShopkeeperDialogue extends Dialogue {
    /**
     *
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Can i help you at all?");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(),"Yes please, What are you selling?", "No thanks.");
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
                getPlayer().WanneShop = 55; // General Store
                break;
            case DialogueConstants.OPTIONS_2_2:
                end();
                getPlayer().RemoveAllWindows();
                break;
        }
        return false;
    }
}
