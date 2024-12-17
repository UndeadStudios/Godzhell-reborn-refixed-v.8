package clip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectManager {

	private static List<StateObject> stateChanges = new ArrayList<StateObject>();
	private static Map<Integer, CachedObject> cachedObjects = new HashMap<Integer, CachedObject>();
	private static Map<Integer, int[]> objectSizes = new HashMap<Integer, int[]>();
	private static List<VariableObject> varObjects = new ArrayList<VariableObject>();

	public static void appendStateChange(int objectType, int objectX, int objectY, int objectHeight, int objectFace, int objectChangeState, int objectVType)
	{
		stateChanges.add(new StateObject(objectType, objectX, objectY, objectFace, objectHeight, objectChangeState, objectVType));
	}

	public static void appendVarObject(int objectType, int objectX, int objectY, int objectHeight, int objectFace)
	{
		varObjects.add(new VariableObject(objectType, objectX, objectY, objectFace, objectHeight));
	}

	public static void removeStateChange(int objectType, int objectX, int objectY, int objectHeight)
	{
		for (int index = 0; index < stateChanges.size(); index++)
		{
			StateObject so = stateChanges.get(index);
			if(so == null)
				continue;
			if((so.getX() == objectX && so.getY() == objectY && so.getHeight() == objectHeight) && so.getType() == objectType || so.getStatedObject() == objectType)
			{
				stateChanges.remove(index);
				break;
			}
		}
	}

	public static void removeVarObject(int objectType, int objectX, int objectY, int objectHeight)
	{
		for (int index = 0; index < varObjects.size(); index++)
		{
			VariableObject vo = varObjects.get(index);
			if(vo == null)
				continue;
			if(vo.getType() == objectType && vo.getX() == objectX && vo.getY() == objectY && vo.getHeight() == objectHeight)
			{
				varObjects.remove(index);
				break;
			}
		}
	}

	public static boolean varObjectExists(int objectX, int objectY, int objectHeight)
	{
		for (VariableObject vo : varObjects)
		{
			if(vo.getHeight() != objectHeight)
				continue;
			if(vo.getX() == objectX && vo.getY() == objectY)
				return true;
		}
		return false;
	}
	
	public static boolean stateHasChanged(int objectType, int objectX, int objectY, int objectHeight)
	{
		for (StateObject so : stateChanges)
		{
			if(so.getHeight() != objectHeight)
				continue;
			if(so.getX() == objectX && so.getY() == objectY && so.getType() == objectType)
				return true;
		}
		return false;
	}
	
	private static void loadCachedObjects()
	{
		try {
			java.io.File f = new java.io.File("./Data/object_data");
			java.io.DataInputStream dis = new java.io.DataInputStream(new java.io.FileInputStream(f));
			int length = ((int) f.length() / 8);
			for (int index = 0; index < length; index++)
				cachedObjects.put(dis.readInt(), new CachedObject(dis.readUnsignedShort(), dis.readByte(), dis.readByte()));
			dis.close();
			int key = (0 << 30) + (2658 << 15) + (2639);
			cachedObjects.put(key, new CachedObject(14315, 10, 0));
			key = (0 << 30) + (3091 << 15) + (3504);
			cachedObjects.put(key, new CachedObject(4388, 10, 0));
			key = (0 << 30) + (3094 << 15) + (3504);
			cachedObjects.put(key, new CachedObject(4408, 10, 0));
			key = (0 << 30) + (3097 << 15) + (3504);
			cachedObjects.put(key, new CachedObject(2387, 10, 0));
			key = (0 << 30) + (3092 << 15) + (3487);
			cachedObjects.put(key, new CachedObject(6552, 10, 0));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int getOrientation(int objectX, int objectY, int objectHeight)
	{
		if(cachedObjects.size() == 0)
			loadCachedObjects();
		int key = (objectHeight << 30) + (objectX << 15) + (objectY);
		return (cachedObjects.get(key) != null ? cachedObjects.get(key).getOrientation() : 0);
	}
	
	public static void changeOrientation(int objectX, int objectY, int objectHeight, int newO)
	{
		if(cachedObjects.size() == 0)
			loadCachedObjects();
		int key = (objectHeight << 30) + (objectX << 15) + (objectY);
		if(cachedObjects.get(key) != null)
			cachedObjects.get(key).changeOrientation(newO);
	}
	
	public static boolean isCachedObject(int objectX, int objectY, int objectHeight, int objectId)
	{
		for (StateObject so : stateChanges)
		{
			if(so == null)
				continue;
			if(so.getHeight() != objectHeight)
				continue;
			if(so.getStatedObject() == objectId && so.getX() == objectX && so.getY() == objectY)
				return true;
		}
		return false;
	}
	
	public static StateObject getStateObject(int objectX, int objectY, int objectHeight, int objectId)
	{
		for (StateObject so : stateChanges)
		{
			if(so == null)
				continue;
			if(so.getHeight() != objectHeight)
				continue;
			if(so.getStatedObject() == objectId && so.getX() == objectX && so.getY() == objectY)
				return so;
		}
		return null;
	}
	
	public static boolean objectExists(int objectX, int objectY, int objectHeight, int objectId)
	{
		if(cachedObjects.size() == 0)
			loadCachedObjects();
		int key = (objectHeight << 30) + (objectX << 15) + (objectY);
		return (cachedObjects.get(key) != null ? cachedObjects.get(key).getId() == objectId : false);
	}
	
	public static boolean objectExists(int objectX, int objectY, int objectHeight)
	{
		if(cachedObjects.size() == 0)
			loadCachedObjects();
		int key = (objectHeight << 30) + (objectX << 15) + (objectY);
		return (cachedObjects.get(key) != null);
	}
	
	public static int getType(int objectX, int objectY, int objectHeight)
	{
		if(cachedObjects.size() == 0)
			loadCachedObjects();
		int key = (objectHeight << 30) + (objectX << 15) + (objectY);
		return (cachedObjects.get(key) != null ? cachedObjects.get(key).getType() : 10);
	}
	
	public static void loadObjectSizes()
	{
		try {
			java.io.DataInputStream dis = new java.io.DataInputStream(new java.io.FileInputStream("./Data/object_size_config"));
			int size = (int) (new java.io.File("./Data/object_size_config").length() / 2);
			for (int index = 0; index < size; index++)
			{
				int bitPart = dis.readShort();
				objectSizes.put(index, new int[] { ((bitPart >> 8) & 0xff), ((bitPart) & 0xff) });
			}
			dis.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean withinRange(int objectType, int objectX, int objectY, int playerX, int playerY, int atHeight)
	{
		if(objectSizes.size() == 0)
			loadObjectSizes();
		int sizeX = 1;
		int sizeY = 1;
		if(objectSizes.get(objectType) != null)
		{
			sizeX = objectSizes.get(objectType)[0];
			sizeY = objectSizes.get(objectType)[1];
		}
		int face = getOrientation(objectX, objectY, atHeight);
		if(face == 1 || face == 3)
		{
			int tempX = sizeX;
			sizeX = sizeY;
			sizeY = tempX;
		}
		java.awt.Rectangle objectField = new java.awt.Rectangle(objectX, objectY, sizeX, sizeY);
		java.awt.Rectangle playerField = new java.awt.Rectangle(objectX - 1, (objectY - 1), (sizeX + 2), (sizeY + 2));
		return playerField.contains(playerX, playerY) && !objectField.contains(playerX, playerY);
	}
	
	public static boolean withinDoorRange(int objectType, int objectX, int objectY, int playerX, int playerY, int atHeight)
	{
		if(objectSizes.size() == 0)
			loadObjectSizes();
		boolean isOpen = isCachedObject(objectX, objectY, atHeight, objectType);
		if(isOpen)
		{
			StateObject so = getStateObject(objectX, objectY, atHeight, objectType);
			int face = so.getFace();
			if(face == 1 || face == 3)
				return playerX >= objectX - 1 && playerX <= objectX + 1 && playerY == objectY;
			else
				return playerY >= objectY - 1 && playerY <= objectY + 1 && playerX == objectX;
		} else
		{
			int face = getOrientation(objectX, objectY, atHeight);
			if(face == 1 || face == 3)
				return playerX >= objectX - 1 && playerX <= objectX + 1 && playerY == objectY;
			else
				return playerY >= objectY - 1 && playerY <= objectY + 1 && playerX == objectX;
		}
	}
}