import java.util.Arrays;
import java.util.Optional;

public class TuraelDialogue extends Dialogue {
    @Override
    public void execute() {
        switch (getNext()) {
            case 0:
                if (player.getSlayer().getTask().isPresent()) {
                    if (player.getSlayer().getTask().get().getLevel() > player.playerLevel[18]) {
                        DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.ANNOYED, "You have been assigned a task you cannot complete.",
                                "What an inconvenience, i'll get to the bottom of this.",
                                "In the meanwhile, i've reset your task.",
                                "Talk to me or one of the others to get a new task.");
                        player.getSlayer().setTask(Optional.empty());
                        player.getSlayer().setTaskAmount(0);
                        end();
                        return;
                    }
                }
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.HAPPY, "What do you want?");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(),  "I'd like to see the slayer interface.", "I am in need of a slayer assignment.",
                        "Could you tell me where I can find my current task?", "Nothing, sorry!");
                break;
            case 2:
                end();
                getPlayer().RemoveAllWindows();
                break;
            case 3:
                break;
            case 4:
                getPlayer().getSlayer().handleInterface("buy");
                break;
            case 5:
                Optional<SlayerTask> task = getPlayer().getSlayer().getTask();
                Optional<SlayerMaster> master = SlayerMaster.get(getPlayer().talkingNpc);
                Optional<SlayerMaster> myMaster = SlayerMaster.get(getPlayer().getSlayer().getMaster());

                if (task.isPresent() && master.isPresent() && myMaster.isPresent()) {
                    if (getPlayer().getSlayer().getMaster() != master.get().getId()) {
                        if (myMaster.get().getLevel() < master.get().getLevel()) {
                            DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.CALM, "You have an easier task from a different master.",
                                    "If you cannot complete their task, you cannot start",
                                    "one of mine. You must finish theirs first.");
                            getPlayer().sendMessage("@blu@test");
                            setNext(2);
                            return;
                        }
                        DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.CALM, "I can give you an easier task but this will reset your",
                                "consecutive tasks completed if you have an active task.",
                                "Are you sure this is what you want to do?");
                        getPlayer().sendMessage("@blu@test2");
                        setNext(6);
                    } else {
                        DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.CALM, "You currently have " + player.getSlayer().getTaskAmount() + " "
                                        + player.getSlayer().getTask().get().getPrimaryName() + " to kill.",
                                "You cannot get an easier task. You must finish this.");
                        getPlayer().sendMessage("@blu@test3");
                        setNext(7);
                    }
                } else {
                    player.getSlayer().createNewTask(getPlayer().talkingNpc);
                }
                break;
            case 7:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Okay will do.");
                setNext(2);
                break;
            case 6:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.CALM, "You can find your slayer task near theses locations ", ""+Arrays.toString(getPlayer().getSlayer().getTask().get().getLocations()));
                setNext(9);
                break;
            case 8:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.CALM, "You currently have " + player.getSlayer().getTaskAmount() + " "
                        + player.getSlayer().getTask().get().getPrimaryName() + " to kill.");
                break;
            case 9:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.CALM, "would you like to teleport there?");
                setNext(10);
                break;
            case 10:
                DialogueManager.sendOption(getPlayer(), "Yes please.", "No, Thanks.");
                break;
            case 11:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.CALM, "Okay!");
                setNext(12);
                break;
            case 12:
                getPlayer().movePlayer(player.getSlayer().getTask().get().getTeleportLocation()[0], player.getSlayer().getTask().get().getTeleportLocation()[1], 0);
                end();
                getPlayer().RemoveAllWindows();
                break;
            case 13:
                DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.CALM, "Okay, maybe next time.");
                setNext(14);
                break;
            case 14:
                end();
                getPlayer().RemoveAllWindows();
                break;
        }
    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_4_1:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "I'd like to see the slayer interface.");
                setNext(4);
                break;
            case DialogueConstants.OPTIONS_4_2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "I need an assignment.");
                setNext(5);
                break;
            case DialogueConstants.OPTIONS_4_3:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Could you tell me where I can find my current task?");
                setNext(6);
                break;
            case DialogueConstants.OPTIONS_4_4:
                break;
            case DialogueConstants.OPTIONS_2_1:
                if(getNext() != 10) {
                    Optional<SlayerMaster> master_npc = SlayerMaster.get(getPlayer().talkingNpc);
                    if (getPlayer().getSlayer().getMaster() != master_npc.get().getId() && master_npc.get().getId() != 405) {
                        DialogueManager.sendNpcChat(getPlayer(), getPlayer().talkingNpc, Emotion.CALM, "You already seem to have an active task with someone else.");
                        setNext(2);
                        return false;
                    }
                    getPlayer().getSlayer().createNewTask(getPlayer().talkingNpc);
                } else {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Yes please.");
                    setNext(11);
                }
                break;
            case DialogueConstants.OPTIONS_2_2:
                if(getNext() != 10) {
                    getPlayer().RemoveAllWindows();
                } else {
                    DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "No, Thanks.");
                    setNext(13);
                }
                break;
        }
        return false;

    }
}
