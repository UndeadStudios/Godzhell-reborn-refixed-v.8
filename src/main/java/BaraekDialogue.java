public class BaraekDialogue extends Dialogue {
    /**
     * 
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                if(!getPlayer().playerHasItem(948)) {
                    DialogueManager.sendOption(getPlayer(), "Can you sell me some furs?", "Hello. I am in search of a quest.");
                } else {
                    DialogueManager.sendOption(getPlayer(), "Can you sell me some furs?", "Hello. I am in search of a quest.", "Would you like to buy my fur?");
                }
                break;
            case 1:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Yeah, sure. They're 20 gold coins each.");
                setNext(2);
                break;
            case 2:
                DialogueManager.sendOption(getPlayer(), "Yeah, okay, here you go.", "20 gold coins? That's an outrage!");
                break;
            case 4:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Well, my best price is 18 coins.");
                setNext(5);
                break;
            case 5:
                DialogueManager.sendOption(getPlayer(), "OK, here you go.", "No thanks, I'll leave it.");
                break;
            case 8:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Well, I can't go any cheaper than that mate. I've got a ", "family to feed.");
                setNext(9);
                break;
            case 9:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Oh well, never mind.");
                setNext(10);
                break;
            case 10:
                end();
                getPlayer().RemoveAllWindows();
                break;
            case 11:
                if(getPlayer().playerHasItem(995, 18)) {
                    DialogueManager.sendItem1(getPlayer(), "Baraek sells you a fur.", 948);
                    getPlayer().deleteItem2(995, 18);
                    getPlayer().addItem(948, 1);
                    setNext(10);
                }
                break;
            case 12:
                if(getPlayer().playerHasItem(995, 20)) {
                    DialogueManager.sendItem1(getPlayer(), "Baraek sells you a fur.", 948);
                    getPlayer().deleteItem2(995, 20);
                    getPlayer().addItem(948, 1);
                    setNext(10);
                }
                break;
            case 13:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Sorry kiddo, I'm a fur trader not a damsel in distress.");
                setNext(10);
                break;
            case 14:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Well, I can't go any cheaper than that mate. I have a", "family to feed.");
                setNext(10);
                break;
            case 15:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "It's your loss mate.");
                setNext(10);
                break;
            case 16:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Let's have a look at it.");
                setNext(17);
                break;
            case 17:
                DialogueManager.sendItem1(getPlayer(), "You hand Baraek your fur to look at.", 948);
                setNext(18);
                break;
            case 18:
                if(getPlayer().getItemAmount(948) >= 2){
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, " It's not in the best condition. I guess I could give you", "12 coins for each one.");
                    setNext(19);
                } else {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, " It's not in the best condition. I guess I could give you", "12 coins for it.");
                    setNext(19);
                }
                break;
            case 19:
                DialogueManager.sendOption(getPlayer(), "Yeah, that'll do.", "I think I'll keep hold of it actually.");
                break;
            case 20:
                if(getPlayer().getItemAmount(948) >= 2){
                    int amount = getPlayer().getItemAmount(948);
                    getPlayer().deleteItem2(948, amount);
                    getPlayer().addItem(995, 12 * amount);
                    end();
                    getPlayer().RemoveAllWindows();
                } else {
                    getPlayer().deleteItem2(948, 1);
                    getPlayer().addItem(995, 12);
                    end();
                    getPlayer().RemoveAllWindows();
                }
               break;
            case 21:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Oh ok. Didn't want it anyway!");
                setNext(10);
                break;
    }
    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_2_1:
                if(getNext() == 0) {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Can you sell me some furs?");
                    setNext(1);
                } else if(getNext() == 2){
                    if(getPlayer().playerHasItem(995, 20)){
                        DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Yeah, okay, here you go.");
                        setNext(12);
                    } else {
                        DialogueManager.sendPlayerChat(getPlayer(), Emotion.SAD, "Oh dear, I don't have enough money!");
                        setNext(4);
                    }
                } else if(getNext() == 5){
                    if(getPlayer().playerHasItem(995, 18)){
                        DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "OK, here you go.");
                        setNext(11);
                    } else {
                        DialogueManager.sendPlayerChat(getPlayer(), Emotion.SAD, "Oh dear, I don't have that either.");
                        setNext(8);
                    }
                }else if(getNext() == 19){
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Yeah, that'll do.");
                    setNext(20);
                }
                break;
            case DialogueConstants.OPTIONS_3_1:
                if(getNext() == 0) {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Can you sell me some furs?");
                    setNext(1);
                }
                break;
            case DialogueConstants.OPTIONS_2_2:
                if(getNext() == 0) {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Hello! I am in search of a quest.");
                    setNext(13);
                } else if(getNext() == 2) {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "20 gold coins? That's an outrage!");
                    setNext(14);
                } else if(getNext() == 5){
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "No thanks, I'll leave it.");
                    setNext(15);
                } else if(getNext() == 19){
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "I think I'll keep hold of it actually.");
                    setNext(21);
                }
                break;
            case DialogueConstants.OPTIONS_3_2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Hello! I am in search of a quest.");
                setNext(13);
                break;

                case DialogueConstants.OPTIONS_3_3:
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Would you like to buy my fur?");
                    setNext(16);
                    break;

        }
        return false;
    }
}
