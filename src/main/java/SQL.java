import java.sql.*;
import java.security.MessageDigest;


public class SQL {


	public static Connection con = null;
	public static Statement stmt;
	public static boolean connectionMade;
	public static void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost/highscores","root","june1394");
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static ResultSet query(String s) throws SQLException {
		try {
			if (s.toLowerCase().startsWith("select")) {
				ResultSet rs = stmt.executeQuery(s);
				return rs;
			} else {
				stmt.executeUpdate(s);
			}
			return null;
		} catch (Exception e) {
			destroyConnection();
			createConnection();
			e.printStackTrace();
		}
		return null;
	}

	public static void destroyConnection() {
		try {
			stmt.close();
			con.close();
			connectionMade = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean saveHighScore(client clientToSave) {
		try {
			query("DELETE FROM `skills` WHERE playerName = '"+clientToSave.playerName+"';");
			query("DELETE FROM `skillsoverall` WHERE playerName = '"+clientToSave.playerName+"';");
			query("INSERT INTO `skills` (`playerName`,`Attacklvl`,`Attackxp`,`Defencelvl`,`Defencexp`,`Strengthlvl`,`Strengthxp`,`Hitpointslvl`,`Hitpointsxp`,`Rangelvl`,`Rangexp`,`Prayerlvl`,`Prayerxp`,`Magiclvl`,`Magicxp`,`Cookinglvl`,`Cookingxp`,`Woodcuttinglvl`,`Woodcuttingxp`,`Fletchinglvl`,`Fletchingxp`,`Fishinglvl`,`Fishingxp`,`Firemakinglvl`,`Firemakingxp`,`Craftinglvl`,`Craftingxp`,`Smithinglvl`,`Smithingxp`,`Mininglvl`,`Miningxp`,`Herblorelvl`,`Herblorexp`,`Agilitylvl`,`Agilityxp`,`Thievinglvl`,`Thievingxp`,`Slayerlvl`,`Slayerxp`,`Farminglvl`,`Farmingxp`,`Runecraftlvl`,`Runecraftxp`) VALUES ('"+clientToSave.playerName+"',"+clientToSave.playerLevel[0]+","+clientToSave.playerXP[0]+","+clientToSave.playerLevel[1]+","+clientToSave.playerXP[1]+","+clientToSave.playerLevel[2]+","+clientToSave.playerXP[2]+","+clientToSave.playerLevel[3]+","+clientToSave.playerXP[3]+","+clientToSave.playerLevel[4]+","+clientToSave.playerXP[4]+","+clientToSave.playerLevel[5]+","+clientToSave.playerXP[5]+","+clientToSave.playerLevel[6]+","+clientToSave.playerXP[6]+","+clientToSave.playerLevel[7]+","+clientToSave.playerXP[7]+","+clientToSave.playerLevel[8]+","+clientToSave.playerXP[8]+","+clientToSave.playerLevel[9]+","+clientToSave.playerXP[9]+","+clientToSave.playerLevel[10]+","+clientToSave.playerXP[10]+","+clientToSave.playerLevel[11]+","+clientToSave.playerXP[11]+","+clientToSave.playerLevel[12]+","+clientToSave.playerXP[12]+","+clientToSave.playerLevel[13]+","+clientToSave.playerXP[13]+","+clientToSave.playerLevel[14]+","+clientToSave.playerXP[14]+","+clientToSave.playerLevel[15]+","+clientToSave.playerXP[15]+","+clientToSave.playerLevel[16]+","+clientToSave.playerXP[16]+","+clientToSave.playerLevel[17]+","+clientToSave.playerXP[17]+","+clientToSave.playerLevel[18]+","+clientToSave.playerXP[18]+","+clientToSave.playerLevel[19]+","+clientToSave.playerXP[19]+","+clientToSave.playerLevel[20]+","+clientToSave.playerXP[21]+");");
			query("INSERT INTO `skillsoverall` (`playerName`,`lvl`,`xp`) VALUES ('"+clientToSave.playerName+"',"+(clientToSave.getLevelForXP(clientToSave.playerXP[0]) + clientToSave.getLevelForXP(clientToSave.playerXP[1]) + clientToSave.getLevelForXP(clientToSave.playerXP[2]) + clientToSave.getLevelForXP(clientToSave.playerXP[3]) + clientToSave.getLevelForXP(clientToSave.playerXP[4]) + clientToSave.getLevelForXP(clientToSave.playerXP[5]) + clientToSave.getLevelForXP(clientToSave.playerXP[6]) + clientToSave.getLevelForXP(clientToSave.playerXP[7]) + clientToSave.getLevelForXP(clientToSave.playerXP[8]) + clientToSave.getLevelForXP(clientToSave.playerXP[9]) + clientToSave.getLevelForXP(clientToSave.playerXP[10]) + clientToSave.getLevelForXP(clientToSave.playerXP[11]) + clientToSave.getLevelForXP(clientToSave.playerXP[12]) + clientToSave.getLevelForXP(clientToSave.playerXP[13]) + clientToSave.getLevelForXP(clientToSave.playerXP[14]) + clientToSave.getLevelForXP(clientToSave.playerXP[15]) + clientToSave.getLevelForXP(clientToSave.playerXP[16]) + clientToSave.getLevelForXP(clientToSave.playerXP[17]) + clientToSave.getLevelForXP(clientToSave.playerXP[18]) + clientToSave.getLevelForXP(clientToSave.playerXP[19]) + clientToSave.getLevelForXP(clientToSave.playerXP[20]))+","+((clientToSave.playerXP[0]) + (clientToSave.playerXP[1]) + (clientToSave.playerXP[2]) + (clientToSave.playerXP[3]) + (clientToSave.playerXP[4]) + (clientToSave.playerXP[5]) + (clientToSave.playerXP[6]) + (clientToSave.playerXP[7]) + (clientToSave.playerXP[8]) + (clientToSave.playerXP[9]) + (clientToSave.playerXP[10]) + (clientToSave.playerXP[11]) + (clientToSave.playerXP[12]) + (clientToSave.playerXP[13]) + (clientToSave.playerXP[14]) + (clientToSave.playerXP[15]) + (clientToSave.playerXP[16]) + (clientToSave.playerXP[17]) + (clientToSave.playerXP[18]) + (clientToSave.playerXP[19]) + (clientToSave.playerXP[20]) + (clientToSave.playerXP[21]))+");");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}