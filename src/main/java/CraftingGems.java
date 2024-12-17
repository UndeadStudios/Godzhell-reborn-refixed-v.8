/**
 * 
 * @author Hood Niqqa
 * credits: phl0w for helping me using enums
 */
public class CraftingGems {
	client c;
	
	public CraftingGems(client c) {
		this.c = c;
	}
public enum craftGems {
	OPAL(1625,1609,1,15, 890),
	JADE(1627,1611,13,20, 891),
	TOPAZ(1629,1613,16,25, 892),
	SAPPHIRE(1623,1607,20,50, 888),
	EMERALD(1621,1605,27,67, 889),
	RUBY(1619,1603,34,85, 887),
	DIAMOND(1617,1601,43,107, 887),
	DRAGONSTONE(1631,1615,55,137, 885),
	ONYX(6571,6573,67,167, 885);
	public int uncutID,cutID,levelReq,exp, animation;
	
	private craftGems(int uncutID, int cutID, int levelReq,int exp, int animation) {
		this.uncutID = uncutID;
		this.cutID = cutID;
		this.levelReq = levelReq;
		this.exp = exp;
		this.animation = animation;
	}
	public int getUncut() {
		return uncutID;
		
	}
	public int getCut() {
		return cutID;
	}
	public int getLevelReq() {
		return levelReq;
	}
	public int getEXP() {
	return exp;
	}
	public int getAnimation() {
		return animation;
	}
	}
public void handleChisel(int id1, int id2) {
    cutGem((id1 == 1755) ? id2 : id1);
}
private craftGems forGem(int id) {
	for (craftGems g : craftGems.values()) {
		if (g.getUncut() == id) {
			return g;
		}
	}
	return null;
}


    public void cutGem(int id) {
    	craftGems gem = forGem(id);
    	if (gem != null) {
			c.isCrafting = true;
			EventManager.getSingleton().addEvent(c,new Event() {

				public void execute(EventContainer container) {
					if (!c.playerHasItem(gem.getUncut(), 1)) {
						container.stop();
						return;
					}
					if(!c.isCrafting){
						container.stop();
					}
					if (c.playerHasItem(gem.getUncut(), 1)) {
						if (c.playerLevel[c.playerCrafting] >= gem.getLevelReq()) {
							c.deleteItem2(gem.getUncut(),1);
							c.addItem(gem.getCut(), 1);
							c.sendSound(soundList.CUT_GEM, 100, 0);
							c.addSkillXP(gem.getEXP()* Config.CRAFTING_EXPERIENCE, c.playerCrafting);
							c.startAnimation(gem.getAnimation());
						} else {
							c.sendMessage("You need a level of" +gem.getLevelReq()+ "to cut this gem");
						}
					}
				}

				@Override
				public void stop() {

				}
			}, AnimationLength.getFrameLength(gem.getAnimation())*600);

    	}
    }
}