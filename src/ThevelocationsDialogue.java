public class ThevelocationsDialogue extends Dialogue {

    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendOption(getPlayer(), "Falador", "East Ardougne");
                break;

        }
    }
    @Override
    public boolean clickButton(int id) {

        switch(id) {
            case DialogueConstants.OPTIONS_2_1://fishing guild
                    getPlayer().movePlayer(2964, 3378, 0);
                    getPlayer().RemoveAllWindows();
                end();
                break;
            case DialogueConstants.OPTIONS_2_2://mining guild
                getPlayer().movePlayer(2661,3307,0);
                getPlayer().RemoveAllWindows();
                end();
                break;
        }
        return false;
    }
}
