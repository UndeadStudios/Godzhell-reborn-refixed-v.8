public class Patch {

	public int minX = -1, maxX = -1, minY = -1, maxY = -1, produce = -1, produceAmount = -1, pickXP = -1;
	public int[] produceSpot = new int[2];
	
	public Patch(int minX, int maxX, int minY, int maxY, int[] produceSpot, int produce, int produceAmount, int pickXP) {
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
		this.produceSpot = produceSpot;
		this.produce = produce;
		this.produceAmount = produceAmount;
		this.pickXP = pickXP;
	}
	
	public int getMinX() {
		return minX;
	}
	
	public int getMaxX() {
		return maxX;
	}
	
	public int getMinY() {
		return minY;
	}
	
	public int getMaxY() {
		return maxY;
	}
	
	public int getProduceSpot(int i) {
		return produceSpot[i];
	}
	
	public int getProduce() {
		return produce;
	}
	
	public int getProduceAmount() {
		return produceAmount;
	}
	
	public int getPickXP() {
		return pickXP;
	}
}