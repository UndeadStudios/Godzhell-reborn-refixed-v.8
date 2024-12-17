package clip;

public class StateObject {

	private int objectType;
	private int objectX;
	private int objectY;
	private int objectHeight;
	private int objectFace;
	private int objectStateChange;
	private int objectVType;

	public StateObject(int objectType, int objectX, int objectY, int objectFace, int objectHeight, int objectStateChange, int objectVType)
	{
		this.objectType = objectType;
		this.objectX = objectX;
		this.objectY = objectY;
		this.objectFace = objectFace;
		this.objectHeight = objectHeight;
		this.objectStateChange = objectStateChange;
		this.objectVType = objectVType;
	}
	
	public int getType()
	{
		return objectType;
	}
	
	public int getX()
	{
		return objectX;
	}
	
	public int getY()
	{
		return objectY;
	}
	
	public int getHeight()
	{
		return objectHeight;
	}
	
	public int getFace()
	{
		return objectFace;
	}
	
	public int getStatedObject()
	{
		return objectStateChange;
	}
	
	public int getVType()
	{
		return objectVType;
	}
	
}