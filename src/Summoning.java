/**
 * 
 * @author Jesse's
 *
 */
public class Summoning {
	
	private client c;
	
	public Summoning(client client){
		this.c = client;
	}

	public void pickUp(client c, int Type) {
		for (int i = 0; i < NPCHandler.maxNPCs; i++){
			if(NPCHandler.npcs[i] == null)
				continue;
		}
		for(int i = 0; i < NPCHandler.maxNPCs; i++){
			if(NPCHandler.npcs[i] != null){
				if(NPCHandler.npcs[i].npcType == Type){
					if(NPCHandler.npcs[i].spawnedBy == c.playerId && NPCHandler.npcs[i].spawnedBy > 0){
						NPCHandler.npcs[i].absX = 0;
						NPCHandler.npcs[i].absY = 0;
						NPCHandler.npcs[i] = null;
					}
				}
			}
			
		}
	}
	int[][] petArray = {{3505, 7583}, {3506, 7584}, {766, 1560}, {3507, 7585},  {765, 1559}, {764, 1558}, {763, 1557}, {762, 1556}, {761, 1555}, {768, 1561}, {769, 1562}, {770, 1563}, {771, 1564}, {772, 1565}, {773, 1566}};
	
	public void pickUpClean(client c, int id){
		for(int i = 0; i < petArray.length; i++)
			if(petArray[i][0] == id)
				c.addItem(petArray[i][1], 1);
		for(int i = 0; i < NPCHandler.maxNPCs; i++){
			if(NPCHandler.npcs[i] == null)
				continue;
			if(NPCHandler.npcs[i].npcType == id){
				NPCHandler.npcs[i].absX = 0;
				NPCHandler.npcs[i].absY = 0;
			}
		c.HasNpc = false;
		}
	}
}
