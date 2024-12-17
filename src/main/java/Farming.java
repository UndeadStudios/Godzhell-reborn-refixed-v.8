public class Farming {

	private client c;

	private enum Farming_Data {

		GUAM(5291, 199, 11, 13, 1),
		MARRENTIL(5292, 201, 14, 15, 14),
		TARROMIN(5293, 203, 16, 18, 19),
		HARRALANDER(5294, 205, 22, 24, 26),
		RANARR(5295, 207, 27, 31, 32),
		TOADFLAX(5296, 3049, 34, 39, 38),
		IRIT(5297, 209, 43, 49, 44),
		AVANTOE(5298, 211, 55, 62, 50),
		KWUARM(5299, 213, 69, 78, 56),
		SNAPDRAGON(5300, 3051, 88, 99, 62),
		CADANTINE(5301, 215, 107, 120, 67),
		LANTADYME(5302, 2485, 135, 152, 73),
		DWARF_WEED(5303, 217, 171, 192, 79),
		TORSTOL(5304, 219, 200, 225, 85);

		private int seedId, produce, plantXP, herbXP, req;
		private Farming_Data(int seedId, int produce, int plantXP, int herbXP, int req) {
			this.seedId = seedId;
			this.produce = produce;
			this.plantXP = plantXP;
			this.herbXP = herbXP;
			this.req = req;
		}

		public int getSeed() {
			return seedId;
		}

		public int getReq() {
			return req;
		}

		public int getProduce() {
			return produce;
		}

		public int getPlantXP() {
			return plantXP;
		}

		public int getHerbXP() {
			return herbXP;
		}
	}

	private Patch[] p = new Patch[5];

	public Farming(client c) {
		this.c = c;
	}


	public int getNearestFreePatch() {
		for (int i = 0; i < p.length; i++) {
			if (p[i] == null) {
				return i;
			}
		}
		return -1;
	}

	public void setPatchInfo(int produce, int xp) {
		int nearest = getNearestFreePatch();
		if (getNearestFreePatch() > -1) {
			if (c.itemUsedInRegion(2809, 2812, 3335, 3338)) { //Entrana patch
				p[nearest] = new Patch(2809, 2812, 3335, 3338, new int[] {2812, 3338}, produce, misc.random(12), xp);
			}
		}
	}

	public static Farming_Data forSeed(int seed) {
		for (Farming_Data fd : Farming_Data.values()) {
			if (fd.getSeed() == seed) {
				return fd;
			}
		}
		return null;
	}

	public void checkItemOnObject(int itemId) {
		Farming_Data fd = forSeed(itemId);
		if (fd != null) {
			handleFarming(fd);
		}
		return;
	}

	private void handleFarming(Farming_Data f) {
		if (c.playerLevel[c.playerFarming] >= f.getReq()) {
			if (c.playerHasItemAmount(f.getSeed(), 1)) {
				c.deleteItem(f.getSeed(), c.getItemSlot(f.getSeed()), 1);
				c.addSkillXP(f.getPlantXP(), c.playerFarming);
				c.refreshSkills();
				setPatchInfo(f.getProduce(), f.getHerbXP());
				updatePatch();
				c.sendMessage("You plant the seed.");
			}
		} else {
			c.sendMessage("You need a farming level of "+f.getReq()+" to plant this seed.");
		}
	}

	public int getPatch() {
		for (int i = 0; i < p.length; i++) {
			if (c.itemUsedInRegion(p[i].minX, p[i].maxX, p[i].minY, p[i].maxY)) {
				return i;
			}
		}
		return -1;
	}

	public void updatePatch() {
		if (p != null) {
			if (getPatch() > -1) {
				if (p[getPatch()].getProduceAmount() > 0) {
					c.handleObjectRegion(-1, p[getPatch()].minX, p[getPatch()].minY, p[getPatch()].maxX, p[getPatch()].maxY);
					c.makeGlobalObject(8143, p[getPatch()].produceSpot[0], p[getPatch()].produceSpot[1], -1, 10);
				} else {
					c.handleObjectRegion(8174, p[getPatch()].getMinX(), p[getPatch()].getMinY(), p[getPatch()].getMaxX(), p[getPatch()].getMaxY());
					resetVariables(p[getPatch()]);
				}
			}
		}
	}

	public void pickHerb() {
		if (p[getPatch()].getProduceAmount() > 0) {
			if (c.freeSlots() > 0) {
				c.startAnimation(2273);
				c.addItem(p[getPatch()].getProduce(), 1);
				c.addSkillXP(p[getPatch()].getPickXP(), c.playerFarming);
				p[getPatch()].produceAmount--;
				c.sendMessage("You pick a herb.");
				updatePatch();
				c.resetAnimation();
			} else {
				c.sendMessage("You do not have enough inventory space to pick this herb.");
			}
		}
	}

	public void resetVariables(Patch p) {
		p.minX = -1;
		p.maxX = -1;
		p.minY = -1;
		p.maxY = -1;
		p.produce = -1;
		p.produceAmount = -1;
		p.produceSpot = new int[]{-1, -1};
		p.pickXP = -1;
		p = null;
	}
	public static boolean prepareCrop(client player, int item, int x, int y) {
		// plant pot
		// allotments
		if (player.getAllotment().curePlant(x, y, item)) {
			return true;
		}
		if (player.getAllotment().putCompost(x, y, item)) {
			return true;
		}
		if (player.getAllotment().clearPatch(x, y, item)) {
			return true;
		}
		if (item >= 3422 && item <= 3428) {
			player.deleteItem(item, 1);
			player.addItem(item + 8, 1);
			player.startAnimation(832);
			player.sendMessage("You put the olive oil on the fire, and turn it into sacred oil.");
			return true;
		}
		if (item <= 5340 && item > 5332) {
			if (player.getAllotment().waterPatch(x, y, item)) {
				return true;
			}
		}
		if (player.getAllotment().plantSeed(x, y, item)) {
			return true;
		}
		return false;
	}

	public static boolean inspectObject(client player, int x, int y) {
		// allotments
		if (player.getAllotment().inspect(x, y)) {
			return true;
		} // flowers
		/*if (player.getFlowers().inspect(x, y)) {
			return true;
		}
		// herbs
		if (player.getHerbs().inspect(x, y)) {
			return true;
		}
		// hops
		if (player.getHops().inspect(x, y)) {
			return true;
		}
		// bushes
		if (player.getBushes().inspect(x, y)) {
			return true;
		}
		// trees
		if (player.getTrees().inspect(x, y)) {
			return true;
		}
		// fruit trees
		if (player.getFruitTrees().inspect(x, y)) {
			return true;
		}
		// special plant one
		if (player.getSpecialPlantOne().inspect(x, y)) {
			return true;
		}
		// special plant two
		if (player.getSpecialPlantTwo().inspect(x, y)) {
			return true;
		}*/
		return false;
	}

	public static boolean guide(client player, int x, int y) {
		// allotments
		if (player.getAllotment().guide(x, y)) {
			return true;
		} // flowers
		/*if (player.getFlowers().guide(x, y)) {
			return true;
		}
		// herbs
		if (player.getHerbs().guide(x, y)) {
			return true;
		}
		// hops
		if (player.getHops().guide(x, y)) {
			return true;
		}
		// bushes
		if (player.getBushes().guide(x, y)) {
			return true;
		}
		// trees
		if (player.getTrees().guide(x, y)) {
			return true;
		}
		// fruit trees
		if (player.getFruitTrees().guide(x, y)) {
			return true;
		}
		// special plant one
		if (player.getSpecialPlantOne().guide(x, y)) {
			return true;
		}
		// special plant two
		if (player.getSpecialPlantTwo().guide(x, y)) {
			return true;
		}*/
		return false;
	}

	public static boolean harvest(client player, int x, int y) {
		// allotments

		if (player.getAllotment().harvest(x, y)) {
			return true;
		}
	/*	// flowers
		if (player.getFlowers().harvest(x, y)) {
			return true;
		}
		// herbs
		if (player.getHerbs().harvest(x, y)) {
			return true;
		}
		// hops
		if (player.getHops().harvest(x, y)) {
			return true;
		}
		// bushes
		if (player.getBushes().harvestOrCheckHealth(x, y)) {
			return true;
		}
		// trees
		if (player.getTrees().checkHealth(x, y)) {
			return true;
		}
		if (player.getTrees().cut(x, y)) {
			return true;
		}
		// fruit trees
		if (player.getFruitTrees().harvestOrCheckHealth(x, y)) {
			return true;
		}
		// special plant one
		if (player.getSpecialPlantOne().harvestOrCheckHealth(x, y)) {
			return true;
		}
		// special plant two
		if (player.getSpecialPlantTwo().harvestOrCheckHealth(x, y)) {
			return true;
		}*/
		return false;
	}
}