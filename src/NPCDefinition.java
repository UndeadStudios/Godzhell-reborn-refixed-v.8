import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author Relex lawl / iRageQuit2012
 *
 * Manages NPC attributes, such as size, attack speed, poison immunity, etc.
 * Still to add: hitpoints/constitution, attack (accuracy), defense, combat styles which can be performed.
 */

public class NPCDefinition {
	
	/**
	 * NPCDefinition array containing every npc definition instance.
	 */
	public static NPCDefinition[] definitions;
	
	/**
	 * String leading to the directory of which the xml file is stored.
	 */
	private static final String DIRECTORY = "./data/npcDefinitions.xml";
	
	/**
	 * Initializes the reading of xml file containing the item definitions.
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public static void init() throws SAXException, IOException, ParserConfigurationException {
		int pointers = 0;
		long startup = System.currentTimeMillis();
		System.out.println("Loading npc definitions...");
		definitions = new NPCDefinition[8589 + 1];
		File fXmlFile = new File(DIRECTORY);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("npcDefinitions");
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) nNode;
				int id = Integer.parseInt(getValue("id", element));
				try {
					NPCDefinition definition = new NPCDefinition();
					definition.id = id;
					definition.name = getValue("name", element);
					definition.examine = getValue("examine", element);
					definition.combat = Integer.parseInt(getValue("combat", element));
					definition.size = Integer.parseInt(getValue("size", element));
					definition.attackable = Boolean.parseBoolean((getValue("attackable", element)));
					definition.aggressive = Boolean.parseBoolean((getValue("aggressive", element)));
					definition.poisonous = Boolean.parseBoolean(getValue("poisonous", element));
					definition.respawn = Integer.parseInt(getValue("respawn", element));
					definition.maxHit = Integer.parseInt(getValue("maxHit", element));
					definition.hitpoints = Integer.parseInt(getValue("hitpoints", element));;
					definition.attackSpeed = Integer.parseInt(getValue("attackSpeed", element));
					definition.attackAnim = Integer.parseInt(getValue("attackAnim", element));
					definition.defenceAnim = Integer.parseInt(getValue("defenceAnim", element));
					definition.deathAnim = Integer.parseInt(getValue("deathAnim", element));
					definition.attackBonus = Integer.parseInt(getValue("attackBonus", element));
					definition.defenceMelee = Integer.parseInt(getValue("defenceMelee", element));
					definition.defenceRange = Integer.parseInt(getValue("defenceRange", element));
					definition.defenceMage = Integer.parseInt(getValue("defenceMage", element));
					definitions[id] = definition;
					pointers++;
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
		}
		System.out.println("Loaded " + pointers + " npc definitions in " + (System.currentTimeMillis() - startup) + "ms");
	}
	
	/**
	 * Returns NPCDefinition instance for a specified NPC Id.
	 * @param id	NPC Id to fetch definition for.
	 * @return		definitions[id].
	 */
	public static NPCDefinition forId(int id) {
		if (definitions[id] == null) {
			return new NPCDefinition();
		}
		return definitions[id];
	}

	/**
	 * Gets tag value from XML entry.
	 * @param sTag			XML tag String.
	 * @param eElement		XML Element Object.
	 * @return				Integer.parseInt(((Node) lastNodeList.item(0)).getNodeValue()).
	 */
	private static String getValue(String sTag, Element eElement) {
		NodeList nodeList = eElement.getElementsByTagName(sTag);
	    Element element = (Element) nodeList.item(0);
	    NodeList lastNodeList = element.getChildNodes();
		return ((Node) lastNodeList.item(0)).getNodeValue();
	}
	
	/**
	 * The npc's id.
	 */
	private static int id;
	private String name, examine;
	private static int respawn = 0;

	private int combat = 0;

	private static int hitpoints = 1;

	private int maxHit = 0;

	private int size = 1;

	private static int attackSpeed = 4000;

	private static int attackAnim = 422;

	private int defenceAnim = 404;

	private static int deathAnim = 2304;

	private int attackBonus = 20;

	private int defenceMelee = 20;

	private int defenceRange = 20;

	private int defenceMage = 20;

	private boolean attackable = false;
	private boolean aggressive = false;
	private boolean retreats = false;
	private boolean poisonous = false;
	
	/**
	 * Returns the npc's id.
	 * @return	id.
	 */
	public static int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getExamine() {
		return examine;
	}

	public  int getDeathAnim() {
		return deathAnim;
	}

	public int getBlockAnim() {
		return defenceAnim;
	}

	public int getAttackAnim() {
		return attackAnim;
	}

	public int getCombat() {
		return combat;
	}

	public int getSize() {
		return size;
	}

	public boolean isAggressive() {
		return aggressive;
	}

	public boolean retreats() {
		return retreats;
	}

	public boolean isPoisonous() {
		return poisonous;
	}

	public int getHitpoints() {
		return hitpoints;
	}

	public int getMaxhit() {
		return maxHit;
	}
	public static int getattackSpeed(){
		return attackSpeed;
	}
}