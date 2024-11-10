package clip;

public class VariableObject {

	private int type;
	private int x;
	private int y;
	private int z;
	private int face;

	public VariableObject(int type, int x, int y, int z, int face)
	{
		this.type = type;
		this.x = x;
		this.y = y;
		this.z = z;
		this.face = face;
	}

	public int getType()
	{
		return type;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getHeight()
	{
		return z;
	}

	public int getFace()
	{
		return face;
	}

}