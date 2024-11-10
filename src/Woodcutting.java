public class Woodcutting {



    private static final Woodcutting INSTANCE = new Woodcutting();

    public void chop(client c, int objectId, int x, int y) {
        Tree tree = Tree.forObject(objectId);
        c.face(x, y);
        if (c.playerLevel[c.playerWoodcutting] < tree.getLevelRequired()) {
            c.sendMessage("You do not have the woodcutting level required to cut this tree down.");
            return;
        }
        Hatchet hatchet = Hatchet.getBest(c);
        if (hatchet == null) {
            c.sendMessage("You must have an axe and the level required to cut this tree down.");
            return;
        }
        if (c.freeSlots() == 0) {
            c.sendMessage("You must have at least one free inventory space to do this.");
            return;
        }
        if (server.getGlobalObjects().exists(tree.getStumpId(), x, y)) {
            c.sendMessage("This tree has been cut down to a stump, you must wait for it to grow.");
            return;
        }
        c.getSkilling().stop();
        c.sendMessage("You swing your axe at the tree.");
        c.setAnimation(hatchet.getAnimation());
        c.sendSound(soundList.TREE_CUT_BEGIN, 100, 0);
        c.getSkilling().setSkill(Skill.WOODCUTTING);
        Event woodcuttingEvent = new WoodcuttingEvent(c, tree, hatchet, objectId, x , y);
        c.getSkilling().add(woodcuttingEvent, 1*600);
    }

    public static Woodcutting getInstance() {
        return INSTANCE;
    }
}

