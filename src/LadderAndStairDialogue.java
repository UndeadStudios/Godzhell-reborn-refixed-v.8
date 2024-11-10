public class LadderAndStairDialogue extends Dialogue {

    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendOption(getPlayer(), "Climb up", "Climb down", "Nothing");
                break;

        }
    }
    @Override
    public boolean clickButton(int id) {

        switch(id) {
            case DialogueConstants.OPTIONS_3_1://fishing guild
                if(getPlayer().heightLevel == 0) {
                    getPlayer().movePlayer(getPlayer().getX(), getPlayer().getY(), 1);
                    getPlayer().RemoveAllWindows();
                    end();
                } else if(getPlayer().heightLevel == 1) {
                    getPlayer().movePlayer(getPlayer().getX(), getPlayer().getY(), 2);
                    getPlayer().RemoveAllWindows();
                    end();
                } else if(getPlayer().heightLevel == 2) {
                    getPlayer().movePlayer(getPlayer().getX(), getPlayer().getY(), 3);
                    getPlayer().RemoveAllWindows();
                    end();
                }
                break;
            case DialogueConstants.OPTIONS_3_2://mining guild
                if(getPlayer().heightLevel == 1) {
                    getPlayer().movePlayer(getPlayer().getX(), getPlayer().getY(), 0);
                    getPlayer().RemoveAllWindows();
                    end();
                } else if(getPlayer().heightLevel == 2) {
                    getPlayer().movePlayer(getPlayer().getX(), getPlayer().getY(), 1);
                    getPlayer().RemoveAllWindows();
                    end();
                } else if(getPlayer().heightLevel == 3) {
                    getPlayer().movePlayer(getPlayer().getX(), getPlayer().getY(), 2);
                    getPlayer().RemoveAllWindows();
                    end();
                }
                break;
            case DialogueConstants.OPTIONS_3_3://crafting guild
                getPlayer().RemoveAllWindows();
                end();
                break;
        }
        return false;
    }
}
