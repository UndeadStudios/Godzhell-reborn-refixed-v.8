public class FatherAereckDialogue extends Dialogue {
    /**
     *
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Welcome to the church of holy Saradomin.");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(), "Who's Saradomin?", "Nice place you've got here.", "I'm looking for a quest!");
                break;
            case 2:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Surely you have heard of the god, Saradomin?");
                setNext(3);
                break;
            case 3:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "He who creates the forces of goodness and purity in", "this world? I cannot believe your ignorance!");
                setNext(4);
                break;
            case 4:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "This is the god with more followers than any other! ...At", "least in this part of the world");
                setNext(5);
                break;
            case 5:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "He who created this world along with his brothers", "Guthix and Zamorak?");
                setNext(6);
                break;
            case 6:
                DialogueManager.sendOption(getPlayer(), "Oh, THAT Saradomin...", "Oh, sorry. I'm not from this world.");
                break;
            case 7:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "There... is only one Saradomin...");
                setNext(8);
                break;
            case 8:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Yeah... I, uh, thought you said something else.");
                setNext(9);
                break;
            case 9:
                end();
                getPlayer().RemoveAllWindows();
                break;
            case 10:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "...");
                setNext(11);
                break;
            case 11:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "That's... strange.");
                setNext(12);
                break;
            case 12:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "I thought things not from this world were all... You", " now. Slime and tentacles.");
                setNext(13);
                break;
            case 13:
                DialogueManager.sendOption(getPlayer(), "You don't understand. This is an online game!", "I am - do you like my disguise?");
                break;
            case 14:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "I... beg your pardon?");
                setNext(15);
                break;
            case 15:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Never mind.");
                setNext(16);
                break;
            case 16:
                end();
                getPlayer().RemoveAllWindows();
                break;
            case 17:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Aargh! Avaunt foul creature from another dimension!", " Avaunt! Begone in the name of Saradomin!");
                setNext(18);
                break;
            case 18:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Ok, ok, I was only joking...");
                setNext(19);
                break;
            case 19:
                end();
                getPlayer().RemoveAllWindows();
                break;
            case 20:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "It is, isn't it? It was built over 230 years ago.");
                setNext(21);
                break;
            case 21:
                end();
                getPlayer().RemoveAllWindows();
                break;
            case 22:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "That's lucky, I need someone to do a quest for me.");
                setNext(23);
                break;
            case 23:
                if(getPlayer().combat <= 9){
                    DialogueManager.sendStatement(getPlayer(), "Before starting this quest, be aware that your combat level is lower", " than the recommended level of 10.");
                    setNext(24);
                } else {
                    DialogueManager.sendOption(getPlayer(), "Yes", "No");
                }
                break;
            case 24:
                DialogueManager.sendOption(getPlayer(), "Yes", "No");
                break;
            case 25:
                getPlayer().sendMessage("Not added yet.");
                end();
                getPlayer().RemoveAllWindows();

                break;
        }

    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_2_1:
                if(getNext() == 6) {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Oh, THAT Saradomin...");
                    setNext(7);
                } else if(getNext() == 13) {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "You don't understand. This is an online game!");
                    setNext(14);
                }else if(getNext() == 23) {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Yes");
                    setNext(25);
                }else if(getNext() == 24) {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Yes");
                    setNext(25);
                }

                break;
            case DialogueConstants.OPTIONS_2_2:
                if(getNext() == 6) {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Oh, sorry. I'm not from this world.");
                    setNext(10);
                } else if(getNext() == 13) {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Oh, sorry. I'm not from this world.");
                    setNext(17);
                }else if(getNext() == 23) {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "No");
                    setNext(25);
                }else if(getNext() == 24) {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "No");
                    setNext(25);
                }
                break;
            case DialogueConstants.OPTIONS_3_1:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Who's Saradomin?");
                setNext(2);
                break;
            case DialogueConstants.OPTIONS_3_2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Nice place you've got here.");
                setNext(20);
                break;
                case DialogueConstants.OPTIONS_3_3:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "I'm looking for a quest!");
                setNext(22);
                break;
        }
        return false;
    }
}
