import java.util.Optional;

public class PickableObjects {

public static void pickupFlax(final client c, final int object, final int obX, final int obY) {


                        EventManager.getSingleton().addEvent(c,new Event() {
                                public void execute(EventContainer container) {
										c.setAnimation(827);
									int face = 0;
									Optional<WorldObject2> worldObject = Region.getWorldObject(object, obX, obY, c.heightLevel);
									if (worldObject.isPresent()) {
										face = worldObject.get().getFace();
									}
									server.getGlobalObjects().add(new GlobalObject(-1, obX, obY, c.heightLevel, face, 10, 60, object));
									c.addItem(1779, 1);
										container.stop();
                                }
                                public void stop() {

                                }
                        }, AnimationLength.getFrameLength(827)*600);
                }

public static void pickupCabbage(final client c, final int object, final int obX, final int obY) {

	c.startAnimation(827);

	EventManager.getSingleton().addEvent(c,new Event() {
		public void execute(EventContainer container) {
			int face = 0;
			Optional<WorldObject2> worldObject = Region.getWorldObject(object, obX, obY, c.heightLevel);
			if (worldObject.isPresent()) {
				face = worldObject.get().getFace();
			}
			server.getGlobalObjects().add(new GlobalObject(-1, obX, obY, c.heightLevel, face, 10, 60, object));
			c.addItem(1965, 1);
			container.stop();
		}
		public void stop() {

		}
	}, AnimationLength.getFrameLength(827)*600);
}

public static void pickupWheat(final client c, final int object, final int obX, final int obY) {

	c.startAnimation(827);

	EventManager.getSingleton().addEvent(c,new Event() {
		public void execute(EventContainer container) {
			int face = 0;
			Optional<WorldObject2> worldObject = Region.getWorldObject(object, obX, obY, c.heightLevel);
			if (worldObject.isPresent()) {
				face = worldObject.get().getFace();
			}
			server.getGlobalObjects().add(new GlobalObject(-1, obX, obY, c.heightLevel, face, 10, 60, object));
			c.sendMessage("You pick a grain.");
			c.addItem(1947, 1);
			container.stop();
		}
		public void stop() {

		}
	}, AnimationLength.getFrameLength(827)*600);
}

public static void pickupPotato(final client c, final int object, final int obX, final int obY) {

	c.startAnimation(827);

	EventManager.getSingleton().addEvent(c,new Event() {
		public void execute(EventContainer container) {
			int face = 0;
			Optional<WorldObject2> worldObject = Region.getWorldObject(object, obX, obY, c.heightLevel);
			if (worldObject.isPresent()) {
				face = worldObject.get().getFace();
			}
			server.getGlobalObjects().remove(new GlobalObject(-1, obX, obY, c.heightLevel, face, 10, 60, object));
			c.sendMessage("You pick a potato.");
			c.addItem(1942, 1);
			container.stop();
		}
		public void stop() {

		}
	}, AnimationLength.getFrameLength(827)*600);
}

public static void pickupOnion(final client c, final int object, final int obX, final int obY) {

	c.startAnimation(827);

	EventManager.getSingleton().addEvent(c,new Event() {
		public void execute(EventContainer container) {
			int face = 0;
			Optional<WorldObject2> worldObject = Region.getWorldObject(object, obX, obY, c.heightLevel);
			if (worldObject.isPresent()) {
				face = worldObject.get().getFace();
			}
			server.getGlobalObjects().add(new GlobalObject(-1, obX, obY, c.heightLevel, face, 10, 60, object));
			c.sendMessage("You pick a onion.");
			c.addItem(1957, 1);
			container.stop();
		}
		public void stop() {

		}
	}, AnimationLength.getFrameLength(827)*600);
}
	public static void pickupPineapple(final client c, final int object, final int obX, final int obY) {

		c.startAnimation(827);

		EventManager.getSingleton().addEvent(c,new Event() {
			public void execute(EventContainer container) {
				int face = 0;
				if(misc.random(3) == 1) {
					Optional<WorldObject2> worldObject = Region.getWorldObject(object, obX, obY, c.heightLevel);
					if (worldObject.isPresent()) {
						face = worldObject.get().getFace();
					}
					server.getGlobalObjects().add(new GlobalObject(1413, obX, obY, c.heightLevel, face, 10, 60, object));
				Region.addWorldObject(1413, obX, obY, c.heightLevel, face);
				}
				c.sendMessage("You pick a pineapple.");
				c.addItem(ItemIDs.PINEAPPLE, 1);
				container.stop();
			}
			public void stop() {

			}
		}, AnimationLength.getFrameLength(827)*600);
	}
}
