public class DeadExplorerDialogue extends Dialogue {
    /**
     *
     */
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                DialogueManager.sendStatement(getPlayer(), "You rummage around in the dead explorer's bag.....");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendStatement(getPlayer(), "You find a book of hand written notes.");
                setNext(2);
                break;
            case 2:
                end();
                getPlayer().RemoveAllWindows();
                break;
        }

    }
}
