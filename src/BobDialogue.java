public class BobDialogue extends Dialogue {
    /**
     *
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendOption(getPlayer(),"Give me a quest!", "Have you anything to sell?", "Can you repair my items for me?");
                break;
            case 1:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.ANGRY_3, "Get yer own!");
                setNext(4);
                break;
            case 2:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Yes! I buy and sell axes! Take your pick (or axe)!");
                setNext(3);
                break;
            case 3:
                end();
                getPlayer().skillX = getPlayer().absX;
                getPlayer().skillY = getPlayer().absY;
                getPlayer().PutNPCCoords = true;
                getPlayer().WanneShop = 23; // Lumbridge Axe Shop
                break;
            case 4:
                end();
                getPlayer().RemoveAllWindows();
                break;
            case 5:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Of course I'll repair it, though the materials may cost", " you. Just hand me the item and I'll have a look.");
                setNext(4);
                break;
        }

    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_3_1:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Give me a quest!");
                setNext(1);
                break;
            case DialogueConstants.OPTIONS_3_2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Have you anything to sell?");
                setNext(2);
                break;
                case DialogueConstants.OPTIONS_3_3:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Can you repair my items for me?");
                setNext(5);
                break;
        }
        return false;
    }
}
