public class GardenerDialogue extends Dialogue {
    /**
     *
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Hello.");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.ANGRY_1, "Oi'm busy. If tha' wants owt, tha' can go find Wyson. ", "He's ta boss 'round here. And KEEP YER", "TRAMPIN' FEET ORFF MA' FLOWERS!");
                setNext(2);
                break;
            case 2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Right...");
                setNext(3);
                break;
            case 3:
                end();
                getPlayer().RemoveAllWindows();
                break;
        }
    }
}
