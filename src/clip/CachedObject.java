package clip;

public class CachedObject {

	private int objectId;
	private int objectType;
	private int objectOrientation;

	public CachedObject(int objectId, int objectType, int objectOrientation)
	{
		this.objectId = objectId;
		this.objectType = objectType;
		this.objectOrientation = objectOrientation;
	}
	
	public int getId()
	{
		return objectId;
	}
	
	public int getType()
	{
		return objectType;
	}
	
	public int getOrientation()
	{
		return objectOrientation;
	}
	
	public void changeOrientation(int o)
	{
		objectOrientation = o;
	}
	
}