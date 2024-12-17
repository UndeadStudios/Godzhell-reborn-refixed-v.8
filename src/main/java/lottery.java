
import java.io.*;
import java.util.ArrayList;


/**
* @Author chri55w
*/

public class lottery {
	
	public lottery() { //constructor
	
	}
	
	public ArrayList<String> lotteryPlayerNames = new ArrayList<String> (); //players (playername)
	public ArrayList<String> unclaimedWinners = new ArrayList<String> (); //Winners that havent claimed
	public int lotteryFund = 0;
	public int prizeAmount = 500; //jackpot amount (in millions)
	public int entryPrice = 10; //price to enter lottery (in millions)
	public int maximumEntryTimes = 5; //maximum times 1 player can enter per draw
	public long lastAnnouncment;
	public int announcmentFrequency = 10; //announcment frequency in mins
	public final String[] dir = {"./Data/lottery/lotteryNames.dat" , "./Data/lottery/unclaimedWinners.dat", "./Data/lottery/fund.dat"};

	public void process() {
		if (lotteryFund >= prizeAmount * 1000000) {
			drawLottery();
		}
		if (System.currentTimeMillis() - lastAnnouncment > (1000 * 60 * announcmentFrequency)) {
			announceFund();
			lastAnnouncment = System.currentTimeMillis();
		}
		
	}
	public int checkEntriesCount(client c) {
		int entries = 0;
		entries = 0;
		for (int indexes = 0; indexes < lotteryPlayerNames.size(); indexes++) {
			if (lotteryPlayerNames.get(indexes).equalsIgnoreCase("" + c.playerName)) {
				entries += 1;
			}
		}		
		return entries;
	}
	public void enterLottery(client c) {
		if (checkEntriesCount(c) < maximumEntryTimes) {
			if (c.playerHasItemAmount(995, entryPrice * 1000000)) {
				lotteryPlayerNames.add(c.playerName);
				lotteryFund += ((entryPrice * 1000000)*.75);
				c.deleteItem(995, entryPrice * 1000000);
				c.sendMessage("You have been entered into the lottery, when the lottery fund reaches 150m a winner");
				c.sendMessage("will be drawn");
			} else {
				c.sendMessage("You dont have enough cash!");
			}
		} else {
			c.sendMessage("You have already entered 5 times!");
		}
	}
		
	public void drawLottery() {
		boolean prizeGiven = false;
		int arraySize = lotteryPlayerNames.size() -1;
		int winner = misc.random(arraySize);
		try {
			String player = lotteryPlayerNames.get(winner);
			client c = null;
			for(int i = 0; i < PlayerHandler.players.length; i++) {
				if(PlayerHandler.players[i] != null) {
					if(PlayerHandler.players[i].playerName.equalsIgnoreCase(player)) {
						c = (client)PlayerHandler.players[i];
						c.sendMessage("You have won the lottery!");
						prizeGiven = true;
						if (c.freeSlots() > 0) {
							c.addItem(995,prizeAmount * 1000000);
						} else {
							c.sendMessage("You do not have enough room in your inventory to claim your reward!");
							c.sendMessage("We will try to add your reward again when you next login.");
							unclaimedWinners.add(c.playerName);
						}
					}
				}
			}
			if (prizeGiven == false) {
				unclaimedWinners.add(lotteryPlayerNames.get(winner));
				prizeGiven = true;
			}
			for (int j = 0; j < PlayerHandler.players.length; j++) {
				if (PlayerHandler.players[j] != null) {
					client all = (client)PlayerHandler.players[j];
					all.sendMessage("@red@[Lottery]The Lottery has been won by " + lotteryPlayerNames.get(winner));
				}
			}
		} catch (Exception e) {
			System.out.println("Lottery draw failed!");
		}
		lotteryFund = 0;
		lotteryPlayerNames.clear();
		prizeGiven = false;
	}
	public void
	announceFund() {
		int fund = lotteryFund / 1000000;
		PlayerHandler.messageToAll = "@red@[Lottery]The Lottery Fund is currently at " + fund + "m. Enter by talking to lottie at Skillz";

	}
	public void checkUnclaimedWinners(client c) {
		if (unclaimedWinners.contains(c.playerName)) {
			if (c.freeSlots() > 0) {
				c.sendMessage("It's your lucky day! you have won the lottery");
				c.addItem(995,prizeAmount * 1000000);
				unclaimedWinners.remove(unclaimedWinners.indexOf(c.playerName));
			} else {
				c.sendMessage("You have won the lottery but do not have space for the reward!");
			}
		}
	}
	
	
	// aleksandr update, save and load arrayList
	
	public void saveLists() {
		for(int i = 0; i < 3; i++)
			saveList(i);
	}
	
	public void loadLists() {
		for(int i = 0; i < 3; i++)
			loadList(i);
	}
	
	/*serialize arraylist*/
	public void saveList(int i) {
	    try {
	        FileOutputStream fout = new FileOutputStream(dir[i]);
	        ObjectOutputStream oos = new ObjectOutputStream(fout);
	        if(i == 2) {
	        	oos.writeInt(lotteryFund);
	        } else {
	        	oos.writeObject(i == 0 ? lotteryPlayerNames : unclaimedWinners);
	        }
	        oos.close();
	    }
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    }
	}

     
     
    /*unserialize arraylist */
	@SuppressWarnings("unchecked")
	public void loadList(int i) {
		try {
			FileInputStream fin = new FileInputStream(dir[i]);
			ObjectInputStream ois = new ObjectInputStream(fin);
			if(i == 2) {
				lotteryFund = ois.readInt();
			} else {
				if(i == 0) {
					lotteryPlayerNames = (ArrayList<String>) ois.readObject();
				} else {
					unclaimedWinners = (ArrayList<String>) ois.readObject();
				}
			}

			for (String s : (i == 0 ? lotteryPlayerNames : unclaimedWinners)) {
				System.out.println(s);
			}

			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}