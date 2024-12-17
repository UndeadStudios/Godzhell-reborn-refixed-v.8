import java.util.List;
import com.google.common.collect.Lists;

/**
 * Representing a specific location.
 *
 * @author Emiel
 */
public class Location {
	private int x;
	private int y;
	private int z;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
		z = 0;
	}

	public Location(int x, int y, int h) {
		this.x = x;
		this.y = y;
		this.z = h;
	}

	/**
	 * Absolute distance between this Coordiante and another.
	 *
	 * @param other The other Coordiante.
	 * @return The distance between the 2 Coordinates.
	 */
	public int getDistance(Location other) {
		return (int) Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2) + Math.pow(z - other.z, 2));
	}

	/**
	 * Absolute distance between 2 Coordiantes.
	 *
	 * @param c1 The first Coordiante.
	 * @param c2 The the second Coordiante.
	 * @return The distance between the 2 Coordinates.
	 */
	public static int getDistance(Location c1, Location c2) {
		return (int) Math.sqrt(Math.pow(c1.x - c2.x, 2) + Math.pow(c1.y - c2.y, 2) + Math.pow(c1.z - c2.z, 2));
	}

	/**
	 * Checks if this position is within distance of another position.
	 *
	 * @param position
	 *            the position to check the distance for.
	 * @param distance
	 *            the distance to check.
	 * @return true if this position is within the distance of another position.
	 */
	public boolean withinDistance(Location position, int distance) {
		if (this.z != position.z) return false;
		return Math.abs(position.getX() - this.getX()) <= distance && Math.abs(position.getY() - this.getY()) <= distance;
	}

	public static Location of(int x, int y, int z) {
		return new Location(x, y, z);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + z;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Location other = (Location) obj;
		if (z != other.z) return false;
		if (x != other.x) return false;
		return y == other.y;
	}

	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + ", h=" + z + "]";
	}

	public Location copy() {
		return new Location(x, y, z);
	}

	public List<Location> getSurrounding(int size) {
		List<Location> surround = Lists.newArrayList();
		for (int x = -size; x < size; x++) {
			for (int y = -size; y < size; y++) {
				surround.add(new Location(this.x + x, this.y + y, z));
			}
		}
		return surround;
	}

	public Location translate(int x, int y, int z) {
		return new Location(this.x + x, this.y + y, this.z + z);
	}

	public Location center(int size) {
		return translate((int) Math.ceil(size / 2.0), (int) Math.ceil(size / 2.0), 0);
	}

	public boolean equalsIgnoreHeight(Location other) {
		return x == other.x && y == other.y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getZ() {
		return this.z;
	}

	public void setX(final int x) {
		this.x = x;
	}

	public void setY(final int y) {
		this.y = y;
	}

	public void setZ(final int z) {
		this.z = z;
	}

	/**
	 * Gets the region x coordinate.
	 *
	 * @return The region x coordinate.
	 */
	public int getRegionX() {
		return (this.x >> 3) - 6;
	}

	/**
	 * Gets the region y coordinate.
	 *
	 * @return The region y coordinate.
	 */
	public int getRegionY() {
		return (this.y >> 3) - 6;
	}

	public Location transform(int diffX, int diffY, int diffZ)
	{
		return new Location(x + diffX, y + diffY, z + diffZ);
	}

	public int regionX() {
		return (x >> 6);
	}

	public int regionY() {
		return (y >> 6);
	}

	public int getRegionId()
	{
		return ((regionX() << 8) + regionY());
	}


	public boolean isWithinDistance(Location location, int distance) {
		int objectX = location.getX();
		int objectY = location.getY();
		for (int i = 0; i <= distance; i++) {
			for (int j = 0; j <= distance; j++) {
				if ((objectX + i) == x && ((objectY + j) == y || (objectY - j) == y || objectY == y)) {
					return true;
				} else if ((objectX - i) == x && ((objectY + j) == y || (objectY - j) == y || objectY == y)) {
					return true;
				} else if (objectX == x && ((objectY + j) == y || (objectY - j) == y || objectY == y)) {
					return true;
				}
			}
		}
		return false;
	}



}

