public class BartenderDialogue extends Dialogue {
    /**
     *
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendOption(getPlayer(), "Could i buy a beer please?", "Have you heard any rumours here?");
                break;
            case 1:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Sure, that will be 2 gold coins please.");
                setNext(2);
                break;
            case 2:
                if(getPlayer().playerHasItem(995, 2)){
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "ok, here you go.");
                    setNext(4);
                } else {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.SAD, "I don't have enough coins.");
                    setNext(3);
                }
                break;
            case 3:
                end();
                getPlayer().RemoveAllWindows();
                break;
            case 4:
                if(getPlayer().playerHasItem(995, 2)) {
                    getPlayer().deleteItem2(995, 2);
                    getPlayer().addItem(ItemIDs.BEER, 1);
                    DialogueManager.sendStatement(getPlayer(), "You buy a pint of beer!");
                    setNext(3);
                } else {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.ANGRY_1, "Sir, you dropped your coins on the ground.", "Pick them up and talk to me again.");
                    setNext(5);
                }
                break;
            case 5:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.SAD, "Okay. will do");
                setNext(3);
                break;
            case 6:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Well, there was a guy in here earlier saying the goblins", "up by the mountain are arguing again, about the colour", "of their armour of all things.");
                setNext(7);
                break;
            case 7:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Knowing the goblins it could easily turn into a full", "blown war, which wouldn't be good. Goblin wars make", "such a mess of the countryside.");
                setNext(8);
                break;
            case 8:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Well if I have time I'll go and see if i can knock some", "sense into them.");
                setNext(3);
                break;
        }
    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_2_1:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Could I buy a beer please?");
                setNext(1);
                break;
            case DialogueConstants.OPTIONS_2_2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Have you heard any rumours here?");
                setNext(6);
                break;
        }
        return false;
    }
}
