
public class PickableObjects {

public static void pickupFlax(final client c, final int object, final int obX, final int obY) {


                        EventManager.getSingleton().addEvent(c,new Event() {
                                public void execute(EventContainer container) {
										c.setAnimation(827);
                                        c.addItem(1779, 1);
									c.makeGlobalObject(obX, obY, -1, 0, 10);
									container.stop();
                                }
                                public void stop() {

                                }
                        }, AnimationLength.getFrameLength(827)*600);
                        EventManager.getSingleton().addEvent(c,new Event() {
                                public void execute(EventContainer container) {
                                        c.makeGlobalObject(obX, obY, object, 0, 10);
                                        container.stop();
                                }
                                public void stop() {

                                }
                        }, 13000);
                }

public static void pickupCabbage(final client c, final int object, final int obX, final int obY) {

	c.startAnimation(827);

	EventManager.getSingleton().addEvent(c,new Event() {
		public void execute(EventContainer container) {
			 c.makeGlobalObject(obX, obY, -1, 0, 10);
			c.addItem(1965, 1);
			container.stop();
		}
		public void stop() {

		}
	}, AnimationLength.getFrameLength(827)*600);
	EventManager.getSingleton().addEvent(c,new Event() {
		public void execute(EventContainer container) {
			 c.makeGlobalObject(obX, obY, object, 0, 10);
			container.stop();
		}
		public void stop() {

		}
	}, 13000);
}

public static void pickupWheat(final client c, final int object, final int obX, final int obY) {

	c.startAnimation(827);

	EventManager.getSingleton().addEvent(c,new Event() {
		public void execute(EventContainer container) {
			 c.makeGlobalObject(obX, obY, -1, 0, 10);
			c.addItem(1947, 1);
			container.stop();
		}
		public void stop() {

		}
	}, AnimationLength.getFrameLength(827)*600);
	EventManager.getSingleton().addEvent(c,new Event() {
		public void execute(EventContainer container) {
			 c.makeGlobalObject(obX, obY, object, 0, 10);
			container.stop();
		}
		public void stop() {

		}
	}, 13000);
}

public static void pickupPotato(final client c, final int object, final int obX, final int obY) {

	c.startAnimation(827);

	EventManager.getSingleton().addEvent(c,new Event() {
		public void execute(EventContainer container) {
			 c.makeGlobalObject(obX, obY, -1, 0, 10);
			c.addItem(1942, 1);
			container.stop();
		}
		public void stop() {

		}
	}, AnimationLength.getFrameLength(827)*600);
	EventManager.getSingleton().addEvent(c,new Event() {
		public void execute(EventContainer container) {
			 c.makeGlobalObject(obX, obY, object, 0, 10);
			container.stop();
		}
		public void stop() {

		}
	}, 13000);
}

public static void pickupOnion(final client c, final int object, final int obX, final int obY) {

	c.startAnimation(827);

	EventManager.getSingleton().addEvent(c,new Event() {
		public void execute(EventContainer container) {
			 c.makeGlobalObject(obX, obY, -1, 0, 10);
			c.addItem(1957, 1);
			container.stop();
		}
		public void stop() {

		}
	}, AnimationLength.getFrameLength(827)*600);
	EventManager.getSingleton().addEvent(c,new Event() {
		public void execute(EventContainer container) {
			 c.makeGlobalObject(obX, obY, object, 0, 10);
			container.stop();
		}
		public void stop() {

		}
	}, 13000);
}
}
