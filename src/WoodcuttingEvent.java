import java.util.Optional;
import java.util.Random;

public class WoodcuttingEvent implements Event {
    public static final Random random25 = new Random();
    private client player;
    private Tree tree;
    private Hatchet hatchet;
    private int objectId, x, y, chops;

    public WoodcuttingEvent(client player, Tree tree, Hatchet hatchet, int objectId, int x, int y) {
        this.player = player;
        this.tree = tree;
        this.hatchet = hatchet;
        this.objectId = objectId;
        this.x = x;
        this.y = y;
    }

    /**
     * Called when the event is executed.
     *
     * @param container The event container, so the event can dynamically change the
     *                  tick time etc.
     */
    @Override
    public void execute (EventContainer container) {
        if(player == null || player.disconnected || player.IsDead) {
            container.stop();
            return;
        }
        if (!player.playerHasItem(hatchet.getItemId()) && !player.isWearingItem(hatchet.getItemId())) {
            player.sendMessage("Your axe has dissapeared.");
            container.stop();
            return;
        }
        if (player.playerLevel[player.playerWoodcutting] < hatchet.getLevelRequired()) {
            player.sendMessage("You no longer have the level required to operate this hatchet.");
            container.stop();
            return;
        }
        if (player.freeSlots() == 0) {
            player.sendMessage("You have run out of free inventory space.");
            container.stop();
            return;
        }
        chops++;
        player.setAnimation(hatchet.getAnimation());
        player.sendSound(soundList.TREE_CUTTING, 100, 0);
        int chopChance = 1 + (int) (tree.getChopsRequired() * hatchet.getChopSpeed());
        if (misc.random(tree.getChopdownChance()) == 0 || tree.equals(Tree.NORMAL) && misc.random(chopChance) == 0) {
            int face = 0;
            Optional<WorldObject2> worldObject = Region.getWorldObject(objectId, x, y, 0);
            if (worldObject.isPresent()) {
                face = worldObject.get().getFace();
            }

            server.getGlobalObjects().add(new GlobalObject(tree.getStumpId(), x, y, player.heightLevel, face, 10, tree.getRespawnTime(), objectId));
            player.addItem(tree.getWood(), 1);
            player.sendMessage("You get some "+Item.getItemName(tree.getWood()).replace("_", " ")+".");
            if (player.playerEquipment[player.playerHat] == 10941 && player.playerEquipment[player.playerChest] == 10939 && player.playerEquipment[player.playerLegs] == 10940 && player.playerEquipment[player.playerFeet] == 10933) {
                player.addSkillXP(tree.getExperience() * Config.WOODCUTTING_EXPERIENCE * 1.2, player.playerWoodcutting);
            } else {
                player.addSkillXP(tree.getExperience() * Config.WOODCUTTING_EXPERIENCE, player.playerWoodcutting);
            }
            player.sendSound(soundList.TREE_EMPTY, 100, 0);
            //Achievements.increase(player, AchievementType.WOODCUTTING, 1);
            container.stop();
            return;
        }

        if (misc.random(chopChance) == 0 || chops >= tree.getChopsRequired()) {
            int chance20 = misc.random(3);
            chops = 0;
            player.addItem(tree.getWood(), 1);
            player.sendMessage("You get some "+Item.getItemName(tree.getWood()).replace("_", " ")+".");
            if (player.playerEquipment[player.playerHat] == 10941 && player.playerEquipment[player.playerChest] == 10939 && player.playerEquipment[player.playerLegs] == 10940 && player.playerEquipment[player.playerFeet] == 10933) {
                player.addSkillXP(tree.getExperience() * Config.WOODCUTTING_EXPERIENCE * 1.2, player.playerWoodcutting);
            } else {
                player.addSkillXP(tree.getExperience() * Config.WOODCUTTING_EXPERIENCE, player.playerWoodcutting);
            }
        }
    }

    @Override
    public void stop () {
        if (player != null) {
            player.startAnimation(65535);
        }
    }
}
