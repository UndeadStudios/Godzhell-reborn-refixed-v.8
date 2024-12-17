public class BankerDialogue extends Dialogue {


    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Good day, how may I help you?");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(), "I'd like to access my bank account, please.", "I'd like to check my PIN settings.", "I'd like to collect items.", "What is this place?");
                break;
            case 2:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "This is a branch of the Bank of GodzHell Reborn and", "Remastered, We have branches in many towns.");
                setNext(3);
                break;
            case 3:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "And what do you do?");
                setNext(4);
                break;
            case 4:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.DEFAULT, "We will look after your items and money for you. ", "Leave your valuables with us if you want to keep them safe.");
                setNext(5);
                break;
            case 5:
                getPlayer().RemoveAllWindows();
                end();
                break;
        }

    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_2_1:
                getPlayer().openUpBank();
                end();
                break;
            case DialogueConstants.OPTIONS_2_2:
                getPlayer().openUpBank2();
                end();
                break;
            case DialogueConstants.OPTIONS_4_1:
                if(!getPlayer().rights.isStaff()) {
                    end();
                    getPlayer().openUpBank();
                } else {
                    DialogueManager.sendOption(getPlayer(), "Main bank", "Staff bank");
                }
                break;
            case DialogueConstants.OPTIONS_4_2:
                getPlayer().openUpPinSettings();
                break;
            case DialogueConstants.OPTIONS_4_3:
                DialogueManager.sendStatement(getPlayer(), "The G.E is not added yet.");
                setNext(5);
                break;
            case DialogueConstants.OPTIONS_4_4:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "What is this place?");
                setNext(2);
                break;
        }
        return false;
    }
}
