public class PartyPeteDialogue extends Dialogue {
    /**
     *
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Hi! I'm Party Pete. Welcome to the Party Room!");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(), "So what's this room for?", "What's the big lever over there for?", "What's the gold chest for?", "Have you always been here in Falador?", "I wanna party!");
                break;
            case 2:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "This room is for partying the night away!");
                setNext(3);
                break;
            case 3:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "How do you have a party in GodzHell?");
                setNext(4);
                break;
            case 4:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Get a few mates round, get the beers in and have fun!");
                setNext(5);
                break;
            case 5:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Some players organise parties so keep an eye open!");
                setNext(6);
                break;
            case 6:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Woop! Thanks Pete!");
                setNext(7);
                break;
            case 7:
                end();
                getPlayer().RemoveAllWindows();
                break;
            case 8:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Simple. With the lever you can do some fun stuff.");
                setNext(9);
                break;
            case 9:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "What kind of stuff?");
                setNext(10);
                break;
            case 10:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "A balloon drop costs 1000 gold. For this you get 200", "balloons dropped across the whole of the party room.", "You can then have fun popping the balloons! If there", "are items in the Party Drop Chest they will be inside");
                setNext(11);
                break;
            case 11:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "the balloons! For 500 gold you can summon the Party", "Room Knights who will dance for your delight.");
                setNext(12);
                break;
            case 12:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Their singing isn't a delight though!");
                setNext(13);
                break;
            case 13:
                end();
                getPlayer().RemoveAllWindows();
                break;
            case 14:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Any items that are in the chest will be dropped inside", "the balloons when you pull the lever!");
                setNext(15);
                break;
            case 15:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Cool! Sounds like a fun way to do a drop party!");
                setNext(16);
                break;
            case 16:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Exactly!");
                setNext(17);
                break;
            case 17:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "A word of warning though. Any items that you put into", "the chest can't be taken out again and it costs 1000", "gold pieces for each balloon drop.");
                setNext(18);
                break;
            case 18:
                end();
                getPlayer().RemoveAllWindows();
                break;
            case 19:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "We used to be in Seers' Village, far to the west, but we", "had to move - the seers were complaining about the", "noise level, and the knights of Camelot got it into their", "heads that the Party Room knights were making fun of");
                setNext(20);
                break;
            case 20:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "them.");
                setNext(21);
                break;
            case 21:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "We're doing well here, though. The people of Falador", "are happy we're here, and we've hardly ever had the", "White Knights telling us to keep the noise down.");
                setNext(22);
                break;
            case 22:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "We're going to turn Falador into the party capital of", "Gielinor!");
                setNext(23);
                break;
            case 23:
                end();
                getPlayer().RemoveAllWindows();
                break;
            case 24:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "I've won the Dance Trophy at the Kandarin Ball three", "years in a trot!");
                setNext(25);
                break;
            case 25:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Show me your moves Pete!");
                setNext(26);
                break;
            case 26:
                end();
                getPlayer().RemoveAllWindows();
                break;
        }
    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_5_1:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "So what's this room for?");
                setNext(2);
                break;
            case DialogueConstants.OPTIONS_5_2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "What's the big lever over there for?");
                setNext(8);
                break;
            case DialogueConstants.OPTIONS_5_3:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "What's the gold chest for?");
                setNext(14);
                break;
            case DialogueConstants.OPTIONS_5_4:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Have you always been here in Falador?");
                setNext(19);
                break;
            case DialogueConstants.OPTIONS_5_5:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "I wanna party!");
                setNext(24);
                break;
        }
        return false;
    }
}
