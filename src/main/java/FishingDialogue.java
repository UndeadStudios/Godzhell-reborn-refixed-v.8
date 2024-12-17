public class FishingDialogue extends Dialogue{
    /**
     *
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendOption(getPlayer(), "Catherby", "Barbarian village", "Karamja docks", "Lumbridge(net)", "More Options");
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(), "Lumbridge(rod)", "Fishing guild", "Coming Soon!", "Coming Soon!", "More Options");
                break;
        }
    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_5_1:
                if(getNext() == 0) {
                    getPlayer().movePlayer(2849, 3436, 0);
                    end();
                    getPlayer().RemoveAllWindows();
                }
                break;
            case DialogueConstants.OPTIONS_5_2:
                if(getNext() == 0) {
                    getPlayer().movePlayer(3105, 3433, 0);
                    end();
                    getPlayer().RemoveAllWindows();
                }
                break;
            case DialogueConstants.OPTIONS_5_3:
                if(getNext() == 0) {
                    getPlayer().movePlayer(2923, 3173, 0);
                    end();
                    getPlayer().RemoveAllWindows();
                }
                break;
            case DialogueConstants.OPTIONS_5_4:
                if(getNext() == 0) {
                    getPlayer().movePlayer(3243, 3161, 0);
                    end();
                    getPlayer().RemoveAllWindows();
                }
                break;
            case DialogueConstants.OPTIONS_5_5:
                if(getNext() == 0) {
                    DialogueManager.sendOption(getPlayer(), "Lumbridge(rod)", "Fishing guild", "Coming Soon!", "Coming Soon!", "More Options");
                    setNext(1);
                } else if(getNext() == 1) {
                    setNext(0);
                }
                break;
        }
        return false;
    }
}
