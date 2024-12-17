/**
 * WeaponConfig class
 *		all data related to weapons
 * @author Rebelle
 * @date 2/24/11
 */
public class WeaponConfig {
	/**
	 * Attack animations
	 * @param player
	 *		player whom calls for the method
	 */
	void attackAnimation(int player) {
		client client = (client) PlayerHandler.players[player];
		int weapon = client.playerEquipment[client.playerWeapon];
		switch(weapon) {
			case 18353:
			client.attackIndex = 13055; 
			break;
			
						case 4151:
			client.attackIndex = 11969; 
			break;
			
						case 1215:
						case 1231:
						case 5680:
						case 5689:
			client.attackIndex = 376; 
			break;


			case 11694:
case 11696:
case 11698:
case 11700:
case 11730:
			client.attackIndex = 7041;
			//client.sendCustomSound("godsword");
			break;

			default:
				client.attackIndex = 422;
				break;
		}
	}
	/**
	 * Stand animations
	 * @param player
	 *		player whom calls for the method
	 */
	void standAnimation(int player) {
		client client = (client) PlayerHandler.players[player];
		int weapon = client.playerEquipment[client.playerWeapon];
		switch(weapon) {

			case 18353:
			client.standIndex = 13217; 
			break;
						case 4151:
			client.standIndex = 11973; 
			break;

			

			case 11694:
case 11696:
case 11698:
case 11700:
case 11730:
			client.standIndex = 7047; 
			break;

			default:
				client.standIndex = 808;
				break;
		}
	}
	/**
	 * Walk animations
	 * @param player
	 *		player whom calls for the method
	 */
	void walkAnimation(int player) {
		client client = (client) PlayerHandler.players[player];
		int weapon = client.playerEquipment[client.playerWeapon];
		switch(weapon) {

			case 18353:
			client.walkIndex = 13218; 
			break;

			case 4151:
			client.walkIndex = 11975; 
			break;
			
			case 11694:
case 11696:
case 11698:
case 11700:
case 11730:
			client.walkIndex = 7046; 
			break;

			default:
				client.walkIndex = 819;
				break;
		}
	}
	/**
	 * Run animations
	 * @param player
	 *		player whom calls for the method
	 */
	void runAnimation(int player) {
		client client = (client) PlayerHandler.players[player];
		int weapon = client.playerEquipment[client.playerWeapon];
		switch(weapon) {

			case 18353:
			client.runIndex = 13220; 
			break;
			
			
			case 4151:
			client.runIndex = 11976; 
			break;


			case 11694:
case 11696:
case 11698:
case 11700:
case 11730:
			client.runIndex = 7039; 
			break;

			default:
				client.runIndex = 824;
				break;
		}
	}
	/**
	 * Turn animations
	 * @param player
	 *		player whom calls for the method
	 */
	void turnAnimations(int player) {
		client client = (client) PlayerHandler.players[player];
		int weapon = client.playerEquipment[client.playerWeapon];
		switch(weapon) {

			case 18353:
			setTurnIndexes(client.playerId, 13219, 13221, 13223, 13222);
			break;
			
						case 4151:
			setTurnIndexes(client.playerId, 11966, 11966, 11967, 820);
			break;


			case 11694:
case 11696:
case 11698:
case 11700:
case 11730:
			setTurnIndexes(client.playerId, 7043, 7044, 7045, 7046);
			break;

			default:
				setTurnIndexes(client.playerId, 820, 823, 822, 821);
				break;
		}
	}
	/**
	 * Used in turnAnimations()
	 * @param player
	 *		player whom calls for the method
	 * @param turn, turn180, turn90CW, turn90CCW
	 *		turn indexes
	 */
	void setTurnIndexes(int player, int turn, int turn180, int turn90CW, int turn90CCW) {
		client client = (client) PlayerHandler.players[player];
		client.turnIndex = turn;
		client.turn180Index = turn180;
		client.turn90CWIndex = turn90CW;
		client.turn90CCWIndex = turn90CCW;
	}
	/**
	 * Block animations
	 * @param player
	 *		player whom calls for the method
	 */
	void blockAnimation(int player) {
		client client = (client) PlayerHandler.players[player];
		int weapon = client.playerEquipment[client.playerWeapon];
		int shield = client.playerEquipment[client.playerShield];
		if (shield >= 0 && shield < 7956) {
			switch(shield) {
				default:
					client.blockIndex = 1156;
					break;
			}
		} else {
			switch(weapon) {
				default:
					client.blockIndex = 424;
					break;
			}
		}
	}
}