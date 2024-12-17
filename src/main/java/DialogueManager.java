
public class DialogueManager {
	
    public static void sendItem2(client player, String text1, String text2, int item1, int item2) {
    	player.sendFrame126(text1, 6232);
    	player.sendFrame126(text2, 6233);
    	player.sendFrame246(6235, 170, item1);
    	player.sendFrame246(6236, 170, item2);
		player.sendFrame164(6231);
	}
    
    public static void sendItem2zoom(client player, String text1, String text2, int item1, int item2) {
    	player.sendFrame126(text1, 6232);
    	player.sendFrame126(text2, 6233);
    	player.sendFrame246(6235, 130, item1);
    	player.sendFrame246(6236, 100, item2);
    	player.sendFrame164(6231);
    }
	
	public static void sendItem1(client player, String text, int item) {
		player.sendFrame126(text, 308);
		player.sendFrame246(307, 200, item);
		player.sendFrame164(306);
	}
	
	public static void makeItem3(client player, int itemId1, String itemName1, int itemId2, String itemName2, int itemId3, String itemName3) {
		player.sendFrame164(8880);
		player.sendFrame246(8883, 190, itemId1);
		player.sendFrame246(8884, 190, itemId2);
		player.sendFrame246(8885, 190, itemId3);
		player.sendFrame126(itemName1, 8889);
		player.sendFrame126(itemName2, 8893);
		player.sendFrame126(itemName3, 8897);
	}

	public static void sendInformationBox(client player, String title, String line1, String line2, String line3, String line4) {
		player.sendFrame126(title, 6180);
		player.sendFrame126(line1, 6181);
		player.sendFrame126(line2, 6182);
		player.sendFrame126(line3, 6183);
		player.sendFrame126(line4, 6184);
		player.sendFrame164(6179);
	}

	public static void sendNpcChat(client player, int npcId, Emotion emotion, String... lines) {
		String npcName = server.npcHandler.GetNpcName(npcId);
		switch (lines.length) {
		case 1:
			player.sendFrame200(4883, emotion.getEmoteId());
			player.sendFrame126(npcName, 4884);
			player.sendFrame126(lines[0], 4885);
			player.sendFrame75(npcId, 4883);
			player.sendFrame164(4882);
			break;
		case 2:
			player.sendFrame200(4888, emotion.getEmoteId());
			player.sendFrame126(npcName, 4889);
			player.sendFrame126(lines[0], 4890);
			player.sendFrame126(lines[1], 4891);
			player.sendFrame75(npcId, 4888);
			player.sendFrame164(4887);
			break;
		case 3:
			player.sendFrame200(4894, emotion.getEmoteId());
			player.sendFrame126(npcName, 4895);
			player.sendFrame126(lines[0], 4896);
			player.sendFrame126(lines[1], 4897);
			player.sendFrame126(lines[2], 4898);
			player.sendFrame75(npcId, 4894);
			player.sendFrame164(4893);
			break;
		case 4:
			player.sendFrame200(4901, emotion.getEmoteId());
			player.sendFrame126(npcName, 4902);
			player.sendFrame126(lines[0], 4903);
			player.sendFrame126(lines[1], 4904);
			player.sendFrame126(lines[2], 4905);
			player.sendFrame126(lines[3], 4906);
			player.sendFrame75(npcId, 4901);
			player.sendFrame164(4900);
		}
	}

	public static void sendOption(client player, String... options) {
		if (options.length < 2) {
			return;
		}
		switch (options.length) {
		case 1:
			throw new IllegalArgumentException("1 option is not possible! (DialogueManager.java)");
		case 2:
			player.sendFrame126(options[0], 2461);
			player.sendFrame126(options[1], 2462);
			player.sendFrame164(2459);
			break;
		case 3:
			player.sendFrame126(options[0], 2471);
			player.sendFrame126(options[1], 2472);
			player.sendFrame126(options[2], 2473);
			player.sendFrame164(2469);
			break;
		case 4:
			player.sendFrame126(options[0], 2482);
			player.sendFrame126(options[1], 2483);
			player.sendFrame126(options[2], 2484);
			player.sendFrame126(options[3], 2485);
			player.sendFrame164(2480);
			break;
		case 5:
			player.sendFrame126(options[0], 2494);
			player.sendFrame126(options[1], 2495);
			player.sendFrame126(options[2], 2496);
			player.sendFrame126(options[3], 2497);
			player.sendFrame126(options[4], 2498);
			player.sendFrame164(2492);
		}
	}

	public static void sendPlayerChat(client player, Emotion emotion, String... lines) {
		switch (lines.length) {
		case 1:
			player.sendFrame200(969, emotion.getEmoteId());
			player.sendFrame126(player.playerName, 970);
			player.sendFrame126(lines[0], 971);
			player.sendFrame185(969);
			player.sendFrame164(968);
			break;
		case 2:
			player.sendFrame200(974, emotion.getEmoteId());
			player.sendFrame126(player.playerName, 975);
			player.sendFrame126(lines[0], 976);
			player.sendFrame126(lines[1], 977);
			player.sendFrame185(974);
			player.sendFrame164(973);
			break;
		case 3:
			player.sendFrame200(980, emotion.getEmoteId());
			player.sendFrame126(player.playerName, 981);
			player.sendFrame126(lines[0], 982);
			player.sendFrame126(lines[1], 983);
			player.sendFrame126(lines[2], 984);
			player.sendFrame185(980);
			player.sendFrame164(979);
			break;
		case 4:
			player.sendFrame200(987, emotion.getEmoteId());
			player.sendFrame126(player.playerName, 988);
			player.sendFrame126(lines[0], 989);
			player.sendFrame126(lines[1], 990);
			player.sendFrame126(lines[2], 991);
			player.sendFrame126(lines[3], 992);
			player.sendFrame185(987);
			player.sendFrame164(986);
		}
	}

	public static void sendStatement(client player, String... lines) {
		switch (lines.length) {
		case 1:
			player.sendFrame126(lines[0], 357);
			player.sendFrame164(356);
			break;
		case 2:
			player.sendFrame126(lines[0], 360);
			player.sendFrame126(lines[1], 361);
			player.sendFrame164(359);
			break;
		case 3:
			player.sendFrame126(lines[0], 364);
			player.sendFrame126(lines[1], 365);
			player.sendFrame126(lines[2], 366);
			player.sendFrame164(363);
			break;
		case 4:
			player.sendFrame126(lines[0], 369);
			player.sendFrame126(lines[1], 370);
			player.sendFrame126(lines[2], 371);
			player.sendFrame126(lines[3], 372);
			player.sendFrame164(368);
			break;
		case 5:
			player.sendFrame126(lines[0], 375);
			player.sendFrame126(lines[1], 376);
			player.sendFrame126(lines[2], 377);
			player.sendFrame126(lines[3], 378);
			player.sendFrame126(lines[4], 379);
			player.sendFrame164(374);
		}
	}

	public static void sendTimedNpcChat(client player, int npcId, Emotion emotion, String... lines) {
		String npcName = server.npcHandler.GetNpcName(npcId);
		switch (lines.length) {
		case 2:
			player.sendFrame200(12379, emotion.getEmoteId());
			player.sendFrame126(npcName, 12380);
			player.sendFrame126(lines[0], 12381);
			player.sendFrame126(lines[1], 12382);
			player.sendFrame75(npcId, 12379);
			player.sendFrame164(12378);
			break;
		case 3:
			player.sendFrame200(12384, emotion.getEmoteId());
			player.sendFrame126(npcName, 12385);
			player.sendFrame126(lines[0], 12386);
			player.sendFrame126(lines[1], 12387);
			player.sendFrame126(lines[2], 12388);
			player.sendFrame75(npcId, 12384);
			player.sendFrame164(12383);
			break;
		case 4:
			player.sendFrame200(11892, emotion.getEmoteId());
			player.sendFrame126(npcName, 11893);
			player.sendFrame126(lines[0], 11894);
			player.sendFrame126(lines[1], 11895);
			player.sendFrame126(lines[2], 11896);
			player.sendFrame126(lines[3], 11897);
			player.sendFrame75(npcId, 11892);
			player.sendFrame164(11891);
		}
	}

	public static void sendTimedPlayerChat(client player, Emotion emotion, String... lines) {
		switch (lines.length) {
		case 1:
			player.sendFrame200(12774, emotion.getEmoteId());
			player.sendFrame126(player.playerName, 12775);
			player.sendFrame126(lines[0], 12776);
			player.sendFrame185(12774);
			player.sendFrame164(12773);
			break;
		case 2:
			player.sendFrame200(12778, emotion.getEmoteId());
			player.sendFrame126(player.playerName, 12779);
			player.sendFrame126(lines[0], 12780);
			player.sendFrame126(lines[1], 12781);
			player.sendFrame185(12778);
			player.sendFrame164(12777);
			break;
		case 3:
			player.sendFrame200(12783, emotion.getEmoteId());
			player.sendFrame126(player.playerName, 12784);
			player.sendFrame126(lines[0], 12785);
			player.sendFrame126(lines[1], 12786);
			player.sendFrame126(lines[2], 12787);
			player.sendFrame185(12783);
			player.sendFrame164(12782);
			break;
		case 4:
			player.sendFrame200(11885, emotion.getEmoteId());
			player.sendFrame126(player.playerName, 11886);
			player.sendFrame126(lines[0], 11887);
			player.sendFrame126(lines[1], 11888);
			player.sendFrame126(lines[2], 11889);
			player.sendFrame126(lines[3], 11890);
			player.sendFrame185(11885);
			player.sendFrame164(11884);
		}
	}

	public static void sendTimedStatement(client player, String... lines) {
		switch (lines.length) {
		case 1:
			player.sendFrame126(lines[0], 12789);
			player.sendFrame164(12788);
			break;
		case 2:
			player.sendFrame126(lines[0], 12791);
			player.sendFrame126(lines[1], 12792);
			player.sendFrame164(12790);
			break;
		case 3:
			player.sendFrame126(lines[0], 12794);
			player.sendFrame126(lines[1], 12795);
			player.sendFrame126(lines[2], 12796);
			player.sendFrame164(12793);
			break;
		case 4:
			player.sendFrame126(lines[0], 12798);
			player.sendFrame126(lines[1], 12799);
			player.sendFrame126(lines[2], 12800);
			player.sendFrame126(lines[3], 12801);
			player.sendFrame164(12797);
			break;
		case 5:
			player.sendFrame126(lines[0], 12803);
			player.sendFrame126(lines[1], 12804);
			player.sendFrame126(lines[2], 12805);
			player.sendFrame126(lines[3], 12806);
			player.sendFrame126(lines[4], 12807);
			player.sendFrame164(12802);
		}
	}
}