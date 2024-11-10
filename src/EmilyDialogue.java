public class EmilyDialogue extends Dialogue {
    /**
     *
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Heya! What can I get you?");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "What ales are you serving?");
                setNext(2);
                break;
            case 2:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Well, we've got Asgarnian Ale, Wizard's Mind Bomb", "and Dwarven Stout, all for only 3 coins.");
                setNext(3);
                break;
            case 3:
                DialogueManager.sendOption(getPlayer(), "One Asgarnian Ale, please.", "I'll try the Mind Bomb.", "Can I have a Dwarven Stout?", "I don't feel like any of those.");
                break;
            case 4:
                if(getPlayer().playerHasItem(995, 3)){
                    getPlayer().deleteItem2(995, 3);
                    getPlayer().addItem(ItemIDs.ASGARNIAN_ALE, 1);
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Thanks, Emily.");
                    setNext(7);
                } else {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.ANGRY_1, "I said 3 coins! You haven't got 3 coins!");
                    setNext(6);
                }
                break;
            case 6:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.SAD, "Sorry, I'll come back another day.");
                setNext(7);
                break;
            case 7:
                end();
                getPlayer().RemoveAllWindows();
                break;
            case 8:
                if(getPlayer().playerHasItem(995, 3)){
                    getPlayer().deleteItem2(995, 3);
                    getPlayer().addItem(ItemIDs.WIZARDS_MIND_BOMB, 1);
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Thanks, Emily.");
                    setNext(7);
                } else {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.ANGRY_1, "I said 3 coins! You haven't got 3 coins!");
                    setNext(6);
                }
                break;
            case 9:
                if(getPlayer().playerHasItem(995, 3)){
                    getPlayer().deleteItem2(995, 3);
                    getPlayer().addItem(ItemIDs.DWARVEN_STOUT, 1);
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Thanks, Emily.");
                    setNext(7);
                } else {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.ANGRY_1, "I said 3 coins! You haven't got 3 coins!");
                    setNext(6);
                }
                break;
        }
    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_4_1:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "One Asgarnian Ale, please.");
                setNext(4);
                break;
            case DialogueConstants.OPTIONS_4_2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "I'll try the Mind Bomb.");
                setNext(8);
                break;
            case DialogueConstants.OPTIONS_4_3:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Can I have a Dwarven Stout?");
                setNext(9);
                break;
            case DialogueConstants.OPTIONS_4_4:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "I don't feel like any of those.");
                setNext(7);
                break;
        }
        return false;
    }
}
