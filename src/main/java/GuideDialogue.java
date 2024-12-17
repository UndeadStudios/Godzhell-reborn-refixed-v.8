public class GuideDialogue extends Dialogue {
    /**
     *
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Welcome to Godzhell Reborn. We are the first remake", "of godzhell started in 2011 I am here to help", "you Learn about the server, Would you need help?");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Brought back in 2024 and here to stay!", "all old staff will regain there rank,", "we will never go down again.");
                setNext(2);
                break;
            case 2:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "with the mystyc dragon by our side", "built strong with love and hours", "of our devs work, we back brothers and sisters!");
                setNext(3);
                break;
            case 3:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "What can i do in the game?");
                setNext(4);
                break;
            case 4:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "What you can do in the game?", "We do have the classic locations from godzhell,", "there also new locations for training", "theres some hidden dungeons long lost found again.");
                setNext(5);
                break;
            case 5:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY,  "Would you like to to know the diffences from GodzHell", "and GodzHell Reborn and Remastered?");
                setNext(6);
                break;
            case 6:
                DialogueManager.sendOption(getPlayer(), "Yes please!", "No thank you.");
                break;

            case 8:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "We have torrmented demons and corp and Gwd,", "we also have working trading and pvp,", "and dont worry about bank resets thoses will never happen,", "Fell safe while playing GodzHell Reborn and Remastered!");
                setNext(9);
                break;
            case 9:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "Hope you enjoy your stay at Godzhell Reborn", "and Remastered, Remember to vote if you like the server,", "Voting Brings Players!");
                setNext(10);
                break;
            case 10:
                getPlayer().RemoveAllWindows();
                end();
                break;
        }
    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_2_1:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.HAPPY, "Yes please!");
                setNext(8);
                break;
            case DialogueConstants.OPTIONS_2_2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.DEFAULT, "No thank you.");
                setNext(10);
                break;
        }
        return false;
    }
}
