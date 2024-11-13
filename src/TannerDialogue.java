public class TannerDialogue extends Dialogue {
    /**
     *
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Greetings friend. I am a manufacturer of leather.");
                setNext(1);
                break;
            case 1:
                if(!getPlayer().playerHasItem(1739)) {
                    DialogueManager.sendOption(getPlayer(), "Can I buy some leather then?", "Leather is rather weak stuff.");
                } else {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, " I see you have brought me some hides.", "Would you like me to tan them for you?");
                    setNext(9);
                }
                break;
            case 2:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Normal leather may be quite weak, but it's very cheap -", " I make it from cowhides for only 1 gp per hide - and", "it's so easy to craft that anyone can work with it.");
                setNext(3);
                break;
            case 3:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Alternatively you could try hard leather. It's not so", "easy to craft, but I only charge 3 gp per cowhide to", "prepare it, and it makes much sturdier armour.");
                setNext(4);
                break;
            case 4:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "I can also tan snake hides and dragonhides, suitable for", "crafting into the highest quality armour for rangers.");
                setNext(5);
                break;
            case 5:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Thanks, I'll bear it in mind.");
                setNext(6);
                break;
            case 6:
                end();
                getPlayer().RemoveAllWindows();
                break;
            case 7:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "I make leather from animal hides. Bring me some", "cowhides and one gold coin per hide, and I'll tan them", "into soft leather for you.");
                setNext(8);
                break;
            case 8:
                end();
                getPlayer().RemoveAllWindows();
                break;
            case 9:
                DialogueManager.sendOption(getPlayer(), "Yes please.","No thanks");
                break;
            case 10:
                end();
                Tanning.sendTanningInterface(getPlayer());
                break;
            case 11:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, " Very well, sir, as you wish.");
                setNext(12);
                break;
            case 12:
                end();
                getPlayer().RemoveAllWindows();
                break;
        }

    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_2_1:
                if(getNext() == 1) {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Can I buy some leather then?");
                    setNext(7);
                } else if(getNext() == 9) {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Yes please.");
                    setNext(10);
                }
                break;
            case DialogueConstants.OPTIONS_2_2:
                if(getNext() == 1) {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Leather is rather weak stuff.");
                    setNext(2);
                } else if(getNext() == 9) {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "No thanks.");
                    setNext(11);
                }
                break;
        }
            return false;
        }
}
