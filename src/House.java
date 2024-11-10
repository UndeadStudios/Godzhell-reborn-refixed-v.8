import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class House implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final String houseLocation = "./Data/houses/";
	
	  public static boolean hasHouse(client player) {
		    return new File(houseLocation + player.playerName + ".house").exists();
		  }
	
	public static void showHouse(client host, client visiter) {
		host.sM("entering house");
		visiter.getOutStream().createFrameVarSizeWord(241);
		visiter.getOutStream().writeWordA(visiter.mapRegionY + 6);
		visiter.getOutStream().initBitAccess();
		for(int z = 0; z < 4; z++) {
			for(int x = 0; x < 13; x++) {
				for(int y = 0; y < 13; y++) {
					Room room = host.getHouse().rooms[x][y][z];
					visiter.getOutStream().writeBits(1, room != null ? 1 : 0);
					if(room != null) {
						visiter.getOutStream().writeBits(26, room.locationHash);
					}
				}
			}
		}
		visiter.getOutStream().finishBitAccess();
		visiter.getOutStream().writeWord(visiter.mapRegionX + 6);
		visiter.getOutStream().endFrameVarSizeWord();
		visiter.flushOutStream();
		visiter.inHouse = true;
		loadObjects(host);
		System.out.println("house loaded for "+host);
	}
	
	public static void loadObjects(client c) {
		for(RoomObject object : c.getHouse().objects) {
			/*visiter.getOutStream().createFrame(85);
			visiter.getOutStream().writeByteC((object.y - visiter.getMapRegionY() * 8);
			visiter.getOutStream().writeByteC((object.x - visiter.getMapRegionX() * 8);
			visiter.getOutStream().createFrame(101);
			visiter.getOutStream().writeByteC((object.rot);
			visiter.getOutStream().writeByte(0);
			visiter.getOutStream().createFrame(151);
			visiter.getOutStream().writeByteS(0);
			visiter.getOutStream().writeWordBigEndian(object.id);
			visiter.getOutStream().writeByteS(object.rot);
			visiter.flushOutStream();*/
			new Objects2(object.id, object.y, object.x, c.playerId*4, c.objRot, getObjType(object.id), object.id, 0);
			System.out.println(c.objRot);
		}
	}
	
	public House getHouse(client player) {
		House d = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(houseLocation + player.playerName + ".house"));
			d = (House) in.readObject();
			in.close();
			System.out.println("umm:" +d.objects.size());
		} catch (Exception e) {
		//	e.printStackTrace();
			return new House(player, false);
		}
		return d;
		
	}
	
	public House(client player, boolean hasHouse) {
		House h = getHouse(player);
		for(int x = 0; x < 11; x++) {
			for(int y = 0; y < 11; y++) {
				rooms[x][y][0] = h.rooms[x][y][0];
				if(x == 0 || y == 0 || x == 1 || y == 1 || x == 11 || y == 11 || x == 10 || y == 10) {
					rooms[x][y][0] = null;
				}
			}
		}
		rooms[6][6][0] = GARDEN;
	}
	
	public static boolean save(client player) {
		player.sendMessage("Saving house.");
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(houseLocation + player.playerName + ".house"));
			out.writeObject(player.getHouse());
			out.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
    private Room[][][] rooms = new Room[13][13][4];
       
    public static class Room implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private int locationHash;
		private Room(int x, int y, int z, int rot) {
			this.locationHash = x / 8 << 14 | y / 8 << 3 | z % 4 << 24 | rot % 4 << 1;
		}
	}
	
	private LinkedList<RoomObject> objects = new LinkedList<RoomObject>();
	private static class RoomObject implements Serializable {

		private static final long serialVersionUID = 1L;
		private int x;
		private int y;
		private int z;
		private int id;
		private int rot;
		private RoomObject(int id, int x, int y, int z, int type, int face) {
			this.rot = type << 2 | face & 3;
			this.x = x;
			this.y = y;
			this.z = z;
			this.id = id;
		}
	}
	
	//public static final Room DEFAULT = new Room(1864, 5056, 0, 0);
	public static final Room DEFAULT = new Room(3248, 3286, 0, 0);
	public static final Room GARDEN = new Room(1859, 5066, 0, 0);
    public static final Room THRONE = new Room(1904, 5096, 0, 0);
    public static final Room GAME = new Room(1864, 5104, 0, 0);
    public static final Room FLOOR2 = new Room(1903, 5095, 0, 0);
	public static final Room PARLOUR = new Room(1856, 5112, 0, 0);
	public static final Room KITCHEN = new Room(1872, 5112, 0, 0);
	public static final Room DINING = new Room(1890, 5112, 0, 0);
	public static final Room WORKSHOP = new Room(1856, 5096, 0, 0);
	public static final Room BEDROOM = new Room(1904, 5112, 0, 0);
	public static final Room SKILLHALL = new Room(1880, 5104, 0, 0);
	public static final Room COMBAT = new Room(1880, 5088, 0, 0);
	public static final Room QUEST_HALL = new Room(1912, 5104, 0, 0);
	public static final Room STUDY = new Room(1888, 5096, 0, 0);
	public static final Room COSTUME_ROOM = new Room(1904, 5064, 0, 0);
	public static final Room CHAPEL = new Room(1872, 5096, 0, 0);
	public static final Room PORTAL_CHAMBER = new Room(1864, 5088, 0, 0);
	public static final Room FORMAL_GARDEN = new Room(1872, 5064, 0, 0);
	public static final Room THRONE_ROOM = new Room(1904, 5080, 0, 0);
	public static final Room OUBILIETTE = new Room(1904, 5080, 0, 0);
	public static final Room CORRIDOR_DUNGEON = new Room(1888, 5080, 0, 0);
	public static final Room JUNCTION_DUNGEON = new Room(1856, 5080, 0, 0);
	public static final Room STAIRS_DUNGEON = new Room(1872, 5080, 0, 0);
	public static final Room TREASURE_ROOM = new Room(1912, 5088, 0, 0);
    
	public static int[][] objectData = { 
		//Build obj id, Real obj id, obj type
		{15361, 13405, 10}
	};
	
	public static int getObjType(int id) {
		for(int i = 0; i < objectData.length; i++) {
			if(objectData[i][0] == id) {
				return objectData[i][2];
			}
		}
		return 10;
	}
	
	public static int getObjId(int id) {
		for(int i = 0; i < objectData.length; i++) {
			if(objectData[i][0] == id) {
				return objectData[i][1];
			}
		}
		return -1;
	}
	
	public static void handleConstructionClick(client player, int id, int x, int y) {
		int locX = player.absX % 8;
		int locY = player.absY % 8;
		switch(id) {
		case 15364:
		case 15361:
			createObject(player, getObjId(id), x, y, getObjType(id), player.objRot);
			break;
		case 15314:
		case 15313:
			if(locX == 3 && locY == 0 || locX == 4 && locY == 0) {
				addRoom(player, id, x, y, getRoomToBuild(player), player.absX / 8, (player.absY - 1) / 8);
			}	
			if(locX == 0 && locY == 3 || locX == 0 && locY == 4) {
				addRoom(player, id, x, y, getRoomToBuild(player), (player.absX - 1) / 8, player.absY / 8);
			}	
			if(locX == 3 && locY == 7 || locX == 4 && locY == 7) {
				addRoom(player, id, x, y, getRoomToBuild(player), player.absX / 8, (player.absY + 1) / 8);
			}
			if(locX == 7 && locY == 3 || locX == 7 && locY == 4) {
				addRoom(player, id, x, y, getRoomToBuild(player), (player.absX + 1) / 8, player.absY / 8);
			}	
			break;
		}
		//player.sendDialogues(62, 0);
	}
	
	public static boolean handleButtons(client c, int actionButtonId) {
		switch(actionButtonId) {
		case 9168:
			if(c.objRot > 3) {
				c.objRot++;
			}
			createObject(c, getObjId(c.objectId), c.ObjectX, c.ObjectY, getObjType(c.objectId), c.objRot);
			loadObjects(c);
			break;
		}
		return false;
	}
	
	public static void createObject(client player, int id, int x, int y, int type, int face) {
		if(player != null) {
			RoomObject object = new RoomObject(id, x, y, player.heightLevel, type, face);
			player.objectId = id;
			player.objRot = face;
			new Objects2(object.id, object.y, object.x, player.playerId*4, player.objRot, getObjType(object.id), object.id, 0);
			object.id = id;
			object.x = player.objectX;
			object.y = player.objectY;
			player.getOutStream().createFrame(85);
			player.getOutStream().writeByteC((object.y - player.getMapRegionY() * 8));
			player.getOutStream().writeByteC((object.x - player.getMapRegionX() * 8));
			player.getOutStream().createFrame(101);
			player.getOutStream().writeByteC((object.rot));
			player.getOutStream().writeByte(0);
			player.getOutStream().createFrame(151);
			player.getOutStream().writeByteS(0);
			player.getOutStream().writeWordBigEndian(object.id);
			player.getOutStream().writeByteS(object.rot);
			player.flushOutStream();
			player.getHouse().objects.add(object);
			loadObjects(player);
		}	
	}
	
	public static Room getRoomToBuild(client c) {
		return GAME;
	}
	
	public static void addRoom(client player, int id, int x, int y, Room room, int slotX, int slotY) {
		player.getHouse().rooms[slotX][slotY][0] = room;
		showHouse(player, player);
	}
}