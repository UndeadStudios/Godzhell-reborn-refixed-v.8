import java.util.ArrayList;

public class ObjectManager {

	public ArrayList<Objects2> objects2s = new ArrayList<Objects2>();
	private ArrayList<Objects2> toRemove = new ArrayList<Objects2>();

	public void process() {
		for (Objects2 o : objects2s) {
			if (o.tick > 0)
				o.tick--;
			else {
				updateObject(o);
				toRemove.add(o);
			}
		}
		toRemove.clear();
	}
	public static void singleGateTicks(final client player, final int objectId, final int newObjectX, final int newObjectY, final int oldObjectX, final int oldObjectY, final int objectH, final int face, int ticks) {
		EventManager.getSingleton().addEvent(player, new Event() {
			@Override
			public void execute(EventContainer container) {
				if (DoubleGates.gateAmount == 0) {
					container.stop();
					return;
				}
				server.getGlobalObjects().add(new GlobalObject(-1, oldObjectX, oldObjectY, objectH, face, 0, 0));
				server.getGlobalObjects().add(new GlobalObject(objectId, newObjectX, newObjectY, objectH, face, 0, 0));
				container.stop();
			}

			@Override
			public void stop() {
				if (DoubleGates.gateAmount == 1) {
					DoubleGates.gateAmount = 0;
				}
			}
		}, ticks* 600);
	}

	public static void doubleGateTicks(final client player, final int objectId, final int newObjectX, final int newObjectY, final int oldObjectX, final int oldObjectY, final int oldObjectX2, final int oldObjectY2, final int objectH, final int face, int ticks) {
		EventManager.getSingleton().addEvent(player, new Event() {
			@Override
			public void execute(EventContainer container) {
				if (DoubleGates.gateAmount == 0) {
					container.stop();
					return;
				}
				server.getGlobalObjects().add(new GlobalObject(-1, oldObjectX, oldObjectY, objectH, face, 0, 0));
				Region.getRegion(oldObjectX, oldObjectY).setClipToZero(oldObjectX, oldObjectY, objectH);
				server.getGlobalObjects().add(new GlobalObject(-1, oldObjectX2, oldObjectY2, objectH, face, 0, 0));
				Region.getRegion(oldObjectX2, oldObjectY2).setClipToZero(oldObjectX2, oldObjectY2, objectH);
				server.getGlobalObjects().add(new GlobalObject(objectId, newObjectX, newObjectY, objectH, face, 0, 0));
				Region.getRegion(newObjectX, newObjectY).setClipToZero(newObjectX, newObjectY, objectH);
				container.stop();
			}

			@Override
			public void stop() {
				if (DoubleGates.gateAmount == 2) {
					DoubleGates.gateAmount = 1;
				} else if (DoubleGates.gateAmount == 1) {
					DoubleGates.gateAmount = 0;
				}
			}
		}, ticks * 600);
	}

	public void removeObject(int x, int y) {
		for (int j = 0; j < PlayerHandler.players.length; j++) {
			if (PlayerHandler.players[j] != null) {
				client c = (client) PlayerHandler.players[j];
				c.makeGlobalObject(x, y, -1, 0, 10);
			}
		}
	}

	public void updateObject(Objects2 o) {
		for (int j = 0; j < PlayerHandler.players.length; j++) {
			if (PlayerHandler.players[j] != null) {
				client c = (client) PlayerHandler.players[j];
				c.makeGlobalObject(o.objectX, o.objectY, o.newId, o.face, o.type);
			}
		}
	}

	public void placeObject(Objects2 o) {
		for (int j = 0; j < PlayerHandler.players.length; j++) {
			if (PlayerHandler.players[j] != null) {
				client c = (client) PlayerHandler.players[j];
				if (c.distanceToPoint(o.objectX, o.objectY) <= 60)
					c.makeGlobalObject(o.objectX, o.objectY, o.objectId, o.face,
							o.type);
			}
		}
	}

	public Objects2 getObject(int x, int y, int height) {
		for (Objects2 o : objects2s) {
			if (o.objectX == x && o.objectY == y && o.height == height)
				return o;
		}
		return null;
	}

	public void loadObjects(client c) {
		if (c == null)
			return;
		for (Objects2 o : objects2s) {
			if (loadForPlayer(o, c))
				c.makeGlobalObject(o.objectX, o.objectY, o.objectId, o.face,
						o.type);
		}
	}

	public final int IN_USE_ID = 14825;


	public boolean loadForPlayer(Objects2 o, client c) {
		if (o == null || c == null)
			return false;
		return c.distanceToPoint(o.objectX, o.objectY) <= 60
				&& c.heightLevel == o.height;
	}

	public void addObject(Objects2 o) {
		if (getObject(o.objectX, o.objectY, o.height) == null) {
			objects2s.add(o);
			placeObject(o);
		}
	}

}