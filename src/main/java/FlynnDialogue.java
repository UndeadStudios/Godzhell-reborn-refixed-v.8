public class FlynnDialogue extends Dialogue {
    /**
     *
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Hello. Do you want to buy or sell any maces?");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(),"No thanks.", "Well, I'll have a look, at least.");
                break;
            case 2:
                end();
                getPlayer().RemoveAllWindows();
                break;
        }

    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_2_1:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "No thanks.");
                setNext(2);
                break;
            case DialogueConstants.OPTIONS_2_2:
                end();
                getPlayer().skillX = getPlayer().absX;
                getPlayer().skillY = getPlayer().absY;
                getPlayer().PutNPCCoords = true;
                getPlayer().WanneShop = 5; // General Store
                break;
        }
        return false;
    }
}
