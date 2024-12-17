public class ManandWomanDialogue extends Dialogue {


    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Hello, how's it going?");
                setNext(1);
                break;
            case 1:
                int random = misc.random(12);
                if (random == 0) {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.DEFAULT, "How can I help you");
                    setNext(3);
                } else if (random == 1) {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.DEFAULT, "I'm fine, how are you?");
                    setNext(4);
                } else if (random == 2) {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.DEFAULT, "I'm busy right now.");
                    setNext(2);
                } else if (random == 3) {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.ANGRY_1, "No, I don't want to buy anything!");
                    setNext(2);
                } else if (random == 4) {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.ANNOYED, "No I don't have any spare change.");
                    setNext(2);
                } else if (random == 5) {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "I'm very well thank you.");
                    setNext(2);
                } else if (random == 6) {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Hello there! Nice weather we've been having.");
                    setNext(2);
                } else if (random == 7) {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.DEFAULT, "That is classified information.");
                    setNext(2);
                } else if (random == 8) {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.ANGRY_1, "Get out of my way, I'm in a hurry!");
                    setNext(2);
                } else if (random == 9) {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Hello.");
                    setNext(2);
                } else if (random == 10) {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Do I know you? I'm in a hurry");
                    setNext(2);
                } else if (random == 11) {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.ANNOYED, "I'm sorry I can't help you there.");
                    setNext(2);
                } else if (random == 12) {
                    DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.DEFAULT, "Not too bad thanks.");
                    setNext(2);
                }
                break;
            case 2:
                end();
                getPlayer().RemoveAllWindows();
                break;
        }
    }

}