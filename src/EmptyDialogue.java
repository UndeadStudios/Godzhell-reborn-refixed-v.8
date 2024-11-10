public class EmptyDialogue extends Dialogue{

    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendStatement(getPlayer(), "<col=ff0000>This command will empty your player's inventory</col>", "<col=ff0000>including untradables. Do you want to do that?</col>", "<col=ff0000>WARNING: This can't be undone.</col>");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(), "Yes", "No");
                break;
        }
        // TODO Auto-generated method stub

    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_2_1:
                getPlayer().removeAllItems();
                getPlayer().RemoveAllWindows();
                break;
            case DialogueConstants.OPTIONS_2_2:
                getPlayer().RemoveAllWindows();
                break;
        }

        return false;
    }

}