import org.apache.commons.lang3.RandomUtils;

import java.util.Optional;
import java.util.Random;

public class MiningEvent implements Event {
    /**
     * The amount of cycles that must pass before the animation is updated
     */
    private final int ANIMATION_CYCLE_DELAY = 3;

    /**
     * The value in cycles of the last animation
     */
    private int lastAnimation;

    /**
     * The player attempting to mine
     */
    private final client player;

    /**
     * The pickaxe being used to mine
     */
    private final Pickaxe pickaxe;

    /**
     * The mineral being mined
     */
    private final Mineral mineral;

    /**
     * The object that we are mning
     */
    private int objectId;

    /**
     * The location of the object we're mining
     */
    private Location3D location;

    /**
     * The npc the player is mining, if any
     */
    private NPC npc;

    public static int gems[] = {ItemIDs.UNCUT_DIAMOND, ItemIDs.UNCUT_EMERALD, ItemIDs.UNCUT_RUBY, ItemIDs.UNCUT_SAPPHIRE};

    public static int randomGems() {
        return gems[(int) (Math.random() * gems.length)];
    }
    /**
     * Constructs a new {@link MiningEvent} for a single player
     * @param player	the player this is created for
     * @param objectId	the id value of the object being mined from
     * @param location	the location of the object being mined from
     * @param mineral	the mineral being mined
     * @param pickaxe	the pickaxe being used to mine
     */
    public MiningEvent(client player, int objectId, Location3D location, Mineral mineral, Pickaxe pickaxe) {
        this.player = player;
        this.objectId = objectId;
        this.location = location;
        this.mineral = mineral;
        this.pickaxe = pickaxe;
    }

    /**
     * Constructs a new {@link MiningEvent} for a single player
     * @param player	the player this is created for
     * @param npc		the npc being from from
     * @param location	the location of the npc
     * @param mineral	the mineral being mined
     * @param pickaxe	the pickaxe being used to mine
     */
    public MiningEvent(client player, NPC npc, Location3D location, Mineral mineral, Pickaxe pickaxe) {
        this.player = player;
        this.npc = npc;
        this.location = location;
        this.mineral = mineral;
        this.pickaxe = pickaxe;
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
        if (!player.playerHasItem(pickaxe.getItemId())
                && !player.isWearingItem(pickaxe.getItemId())) {
            player.sendMessage("That is strange! The pickaxe could not be found.");
            container.stop();
            return;
        }
        if (player.freeSlots() == 0) {
            player.sendMessage("You have no more free slots.");
            container.stop();
            return;
        }
		/*if (Misc.random(100) == 0 && player.getInterfaceEvent().isExecutable()) {
			player.getInterfaceEvent().execute();
			container.stop();
			return;
		}*/
        if (objectId > 0) {
            if (server.getGlobalObjects().exists(mineral.getDepleteObject(), location.getX(), location.getY(), location.getZ())) {
                player.sendMessage("This vein contains no more minerals.");
                player.resetAnimation();
                container.stop();
                return;
            }
        } else {
            if (npc == null || npc.IsDead) {
                player.sendMessage("This vein contains no more minerals.");
                player.resetAnimation();
                container.stop();
                return;
            }
        }
        if (container.getTick() - lastAnimation > ANIMATION_CYCLE_DELAY) {
            player.startAnimation(pickaxe.getAnimation());
            player.sendSound(432, 100, 0);
            lastAnimation = container.getTick();
        }

        if(player == null || player.disconnected  || player.IsDead) {
            container.stop();
            return;
        }
        if(misc.random(35) == 0){
            if(mineral.getBobleObject() != -1) {
                server.getGlobalObjects().add(new GlobalObject(mineral.getBobleObject(), location.getX(), location.getY(),
                        location.getZ(), 0, 10, mineral.getRespawnRate(), objectId));
                container.stop();
            }
        }
        if (mineral.isDepletable()) {
            int face = 0;
            Optional<WorldObject2> worldObject = Region.getWorldObject(objectId, location.getX(), location.getY(), 0);
            if (worldObject.isPresent()) {
                face = worldObject.get().getFace();
            }
                if (objectId > 0) {
                    server.getGlobalObjects().add(new GlobalObject(mineral.getDepleteObject(), location.getX(), location.getY(),
                            location.getZ(), face, 10, mineral.getRespawnRate(), objectId));
                } else {
                    npc.IsDead = true;
                    npc.actionTimer = 0;
                    npc.NeedRespawn = false;
                }
        }
        int chance20 = misc.random(3);
       // player.face(location.getX(), location.getY());
        if(mineral.equals(Mineral.ESSENCE)) {
            if(player.playerLevel[player.playerMining] >= 30) {
                player.addItem(7936, 1);
            }else {
                player.addItem(1436, 1);
            }
        }
        if(misc.random(50) == 0){
            int randomgem = randomGems();
            player.addItem(randomgem, 1);
            player.sM("You find a "+Item.getItemName(randomgem)+".");
        }
        player.addItem(mineral.getMineralReturn().generate(), 1);
        int chance = misc.random(300);
        //player.sendMessage("Your chance to get 100 platinum tokens from skilling was " + chance + " you needed 0.");
		/*if (Misc.random(30) == 0) {
			player.getPA().rewardPoints(3, "Congrats, You randomly got 3 PK Points from mining!");
		}*/
        //Achievements.increase(player, AchievementType.MINING, 1);
        if (player.playerEquipment[player.playerHat] == 12013 && player.playerEquipment[player.playerChest] == 12014 && player.playerEquipment[player.playerLegs] == 12015 && player.playerEquipment[player.playerFeet] == 12016) {
            player.addSkillXP(Config.MINING_EXPERIENCE * mineral.getExperience() * 1.2, Skill.MINING.id);
        } else {
            player.addSkillXP(Config.MINING_EXPERIENCE * mineral.getExperience(), Skill.MINING.id);
        }
    }

    @Override
    public void stop () {
        player.resetAnimation();
    }
}
