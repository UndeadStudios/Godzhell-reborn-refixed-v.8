public class DwarfMultiCannon {

	/**
	 * To-Do: Exception when trying to set up a cannon within 3 coords of another one
	 *            NPC distance checking
	 *	       Projectiles(Not sure if it works)
	 *
	 * @author relex lawl / relex
	 */

	private client player;
	public DwarfMultiCannon(client client) {
		this.player = client;
	}
	private static final int CANNON_BASE = 7, CANNON_STAND = 8, CANNON_BARRELS = 9, CANNON = 6;
	private static final int CANNONBALL = 2, CANNON_BASE_ID = 6, CANNON_STAND_ID = 8, CANNON_BARRELS_ID = 10, CANNON_FURNACE_ID = 12;
	
	public void setUpCannon() {
		if (canSetUpCannon() || inGoodArea())
			return;
		EventManager.getSingleton().addEvent(player,new Event() {
			int time = 4;
			public void execute(EventContainer setup) {
				if (canSetUpCannon())
					setup.stop();		
				switch (time) {
					case 4:
						if (!player.playerHasItem(CANNON_BASE_ID))
							setup.stop();
						player.startAnimation(827);
						player.hasCannon = true;
						player.settingUpCannon = true;
						player.setUpBase = true;
						Objects3 base = new Objects3(CANNON_BASE, player.absX, player.absY, 0, 0, 10, 0);
						server.objectHandler.addObject(base);
						server.objectHandler.placeObject(base);
						player.oldCannon = base;
						player.deleteItem(CANNON_BASE_ID, 1);
						base.belongsTo = player.playerName;
					break;
					
					case 3:
						if (!player.playerHasItem(CANNON_STAND_ID)) {
							player.settingUpCannon = false;
							setup.stop();
						}
						player.startAnimation(827);
						player.setUpStand = true;
						Objects3 stand = new Objects3(CANNON_STAND, player.absX, player.absY, 0, 0, 10, 0);
						server.objectHandler.removeObject(player.oldCannon);
						server.objectHandler.addObject(stand);
						server.objectHandler.placeObject(stand);
						player.oldCannon = stand;
						player.deleteItem(CANNON_STAND_ID, 1);
						stand.belongsTo = player.playerName;
					break;
					
					case 2:
						if (!player.playerHasItem(CANNON_BARRELS_ID)) {
							player.settingUpCannon = false;
							setup.stop();
						}
						player.startAnimation(827);
						player.setUpBarrels = true;
						Objects3 barrel = new Objects3(CANNON_BARRELS, player.absX, player.absY, 0, 0, 10, 0);
						server.objectHandler.removeObject(player.oldCannon);
						server.objectHandler.addObject(barrel);
						server.objectHandler.placeObject(barrel);
						player.oldCannon = barrel;
						player.deleteItem(CANNON_BARRELS_ID, 1);
						barrel.belongsTo = player.playerName;
					break;
					
					case 1:
						if (!player.playerHasItem(CANNON_FURNACE_ID)) {
							player.settingUpCannon = false;
							setup.stop();
						}
						player.startAnimation(827);
						player.setUpFurnace = true;
						Objects3 cannon = new Objects3(CANNON, player.absX, player.absY, 0, 0, 10, 0);
						player.cannonBaseX = player.absX;
						player.cannonBaseY = player.absY;
						player.cannonBaseH = player.heightLevel;
						//player.removeObject(player.oldCannon);
						server.objectHandler.addObject(cannon);
						server.objectHandler.placeObject(cannon);
						player.oldCannon = cannon;
						player.deleteItem(CANNON_FURNACE_ID, 1);
						cannon.belongsTo = player.playerName;
					break;
					
					case 0:
						player.settingUpCannon = false;
						setup.stop();
					break;
				}
				if (time > 0)
					time--;
			}
			@Override
			public void stop() {
				// TODO Auto-generated method stub
				
			}
		}, 2000);
	}
	
	public void shootCannon() {
		Objects3 cannon = null;
		for(Objects3 o: server.objectHandler.globalObjects) {
			if (o.objectX == player.cannonBaseX && o.objectY == player.cannonBaseY && o.objectHeight == player.cannonBaseH) {
				cannon = o;
			}
		}
		if (cannon == null) {
			player.sendMessage("This is not your cannon!");
			return;
		}
		if (player.cannonIsShooting) {
			if (player.playerHasItem(CANNONBALL)) {
				int amountOfCannonBalls = player.itemAmount(CANNONBALL) > 30 ? 30 : player.itemAmount(CANNONBALL);
				player.cannonBalls += amountOfCannonBalls;
			} else {
				player.sendMessage("Your cannon is already firing!");
				return;
			}
		}
		if (player.cannonBalls < 1) {
			int amountOfCannonBalls = player.itemAmount(CANNONBALL) > 30 ? 30 : player.itemAmount(CANNONBALL);
			if (amountOfCannonBalls < 1) {
				player.sendMessage("You need ammo to shoot this cannon!");
				return;
			}
			player.cannonBalls = amountOfCannonBalls;
			player.deleteItem(CANNONBALL, player.getItemSlot(CANNONBALL), amountOfCannonBalls);
		} else
			startFiringCannon(cannon);
	}
	
	private void startFiringCannon(final Objects3 cannon) {
		player.cannonIsShooting = true;
		EventManager.getSingleton().addEvent(player,new Event() {
			public void execute(EventContainer fire) {
				if (player.cannonBalls < 1) {
					player.sendMessage("Your cannon has run out of ammo!");
					player.cannonIsShooting = false;
					fire.stop();
				} else {
					player.rotation++;
					rotateCannon(cannon);
				}
			}

			@Override
			public void stop() {
				// TODO Auto-generated method stub
				
			}
		}, (player.inMulti() ? 800 : 2500));
	}
	
	private void rotateCannon(Objects3 cannon) {
		switch (player.rotation) {
			case 1: //north
				player.objectAnim(cannon.objectX, cannon.objectY, 516, 10, -1);
			break;
			case 2: //north-east
				player.objectAnim(cannon.objectX, cannon.objectY, 517, 10, -1);
			break;
			case 3: //east
				player.objectAnim(cannon.objectX, cannon.objectY, 518, 10, -1);
			break;
			case 4: //south-east
				player.objectAnim(cannon.objectX, cannon.objectY, 519, 10, -1);
			break;
			case 5: //south
				player.objectAnim(cannon.objectX, cannon.objectY, 520, 10, -1);
			break;
			case 6: //south-west
				player.objectAnim(cannon.objectX, cannon.objectY, 521, 10, -1);
			break;
			case 7: //west
				player.objectAnim(cannon.objectX, cannon.objectY, 514, 10, -1);
			break;
			case 8: //north-west
				player.objectAnim(cannon.objectX, cannon.objectY, 515, 10, -1);
				player.rotation = 0;
			break;
		}
	}
	
	public void pickUpCannon() {
		Objects3 cannon = null;
		for(Objects3 o: server.objectHandler.globalObjects) {
			if (o.objectX == player.cannonBaseX && o.objectY == player.cannonBaseY && o.objectHeight == player.cannonBaseH) {
				cannon = o;
			}
		}
		if (cannon == null) {
			player.sendMessage("This is not your cannon!");
			return;
		}
		player.startAnimation(827);
		Objects3 empty = new Objects3(100, cannon.objectX, cannon.objectY, 0, 0, 10, 0);
		server.objectHandler.addObject(empty);
		server.objectHandler.placeObject(empty);
		server.objectHandler.removeObject(empty);
		if (player.setUpBase) {
			if (player.freeSlots() > 0)
				player.addItem(CANNON_BASE_ID, 1);
			else {
				player.addItemToBank(CANNON_BASE_ID, 1);
				player.sendMessage("You did not have enough inventory space, so this cannon part was banked.");
			}
			player.setUpBase = false;
		}
		if (player.setUpStand) {
			if (player.freeSlots() > 0)
				player.addItem(CANNON_STAND_ID, 1);
			else {
				player.addItemToBank(CANNON_STAND_ID, 1);
				player.sendMessage("You did not have enough inventory space, so this cannon part was banked.");
			}
			player.setUpStand = false;
		}
		if (player.setUpBarrels) {
			if (player.freeSlots() > 0)
				player.addItem(CANNON_BARRELS_ID, 1);
			else {
				player.addItemToBank(CANNON_BARRELS_ID, 1);
				player.sendMessage("You did not have enough inventory space, so this cannon part was banked.");
			}
			player.setUpBarrels = false;
		}
		if (player.setUpFurnace) {
			if (player.freeSlots() > 0)
				player.addItem(CANNON_FURNACE_ID, 1);
			else {
				player.addItemToBank(CANNON_FURNACE_ID, 1);
				player.sendMessage("You did not have enough inventory space, so this cannon part was banked.");
			}
			player.setUpFurnace = false;
		}
		if (player.cannonBalls > 0) {
			if (player.freeSlots() > 0)
				player.addItem(CANNONBALL, player.cannonBalls);
			else {
				player.addItemToBank(CANNONBALL, player.cannonBalls);
				player.sendMessage("You did not have enough inventory space, so your cannonballs have been banked.");
			}
			player.cannonBalls = 0;
		}
	}
	
	public static void checkNPCDistance() {
		for (Player p : PlayerHandler.players) {
			if (p == null)
				return;
			client players = (client) p;
			NPC n = getNPCWithinDistance(players, players.cannonBaseX, players.cannonBaseY, players.cannonBaseH);
			int damage = misc.random(30);
			if (n.inMulti()) {
				startCannonballProjectile(players, players.oldCannon, n);
				n.hitDiff = damage;
				n.HP -= damage;
				n.hitUpdateRequired = true;
				n.killerId = players.playerId;
				n.facePlayer(players.playerId);
				n.forceChat("im hit, multi");
			} else {
				if (n.underAttackBy > 0 && n.underAttackBy != players.playerId)
					return;
				startCannonballProjectile(players, players.oldCannon, n);
				n.hitDiff = damage;
				n.HP -= damage;
				n.hitUpdateRequired = true;
				n.killerId = players.playerId;
				n.facePlayer(players.playerId);
				n.forceChat("im hit, single");
			}
			players.cannonBalls--;
		}
	}
	
	private static NPC getNPCWithinDistance(client players, int x, int y, int height) {
		NPC npc = null;
		for (int i = 0; i < NPCHandler.npcs.length; i++) {
			if (server.npcHandler.npcs[i] != null)
			npc = (NPC) server.npcHandler.npcs[i];
		}
		int myX = players.cannonBaseX;
		int myY = players.cannonBaseY;
		int theirX = npc.absX;
		int theirY = npc.absY;
		if (!npc.IsDead && npc.heightLevel == height && !npc.IsDead && npc.HP != 0 && npc.npcType != 1266 && npc.npcType != 1268) {
			switch (players.rotation) {
				case 1: //north
					if(theirY > myY && theirX >= myX - 1 && theirX <= myX + 1)
						return npc;
				break;
				case 2: //north-east
					if(theirX >= myX + 1 && theirY >= myY + 1)
						return npc;
				break;
				case 3: //east
					if(theirX > myX && theirY >= myY - 1 && theirY <= myY + 1)
						return npc;
				break;
				case 4: //south-east
					if(theirY <= myY - 1 && theirX >= myX + 1)
						return npc;
				break;
				case 5: //south
					if(theirY < myY && theirX >= myX - 1 && theirX <= myX + 1)
						return npc;
				break;
				case 6: //south-west
					if(theirX <= myX - 1 && theirY <= myY - 1)
						return npc;
				break;
				case 7: //west
					if(theirX < myX && theirY >= myY - 1 && theirY <= myY + 1)
						return npc;
				break;
				case 8: //north-west
					if(theirX <= myX - 1 && theirY >= myY + 1)
						return npc;
				break;
			}
		}
		return null;
	}
	
	private static void startCannonballProjectile(client player, Objects3 cannon, NPC n) {
		int oX = cannon.objectX;
		int oY = cannon.objectY;
		int offX = ((oX - n.getX()) * -1);
		int offY = ((oY - n.getY()) * -1);
		player.createPlayersProjectile(oX, oY, offY, offX, 50, 60, 53, 20, 20, - player.oldNpcIndex + 1, 30);
	}
	
	public static int distanceToSquare(int x, int y, int tx, int ty){
		return (int) Math.sqrt((Math.abs(x - tx) + Math.abs(y - ty)));
	}
	
	private final boolean canSetUpCannon() {
		return !inGoodArea() && player.playerLevel[3] <= 0 && player.hasCannon && player.settingUpCannon;
	}
	
	private final boolean inGoodArea() {
		/*if (ClanWars.inWaitingArea(player)) {
			player.sendMessage("You are not allowed to set up a cannon in clan wars!");
			return false;
		}
		if (player.inBH()) {
			player.sendMessage("You are not allowed to set up a cannon in bounty hunter!");
			return false;
		}//add your own exceptions*/
		return true;	
	}
}