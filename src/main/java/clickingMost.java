import java.util.Optional;

public class clickingMost {

    public void clicking(int a) {
        client c = (client) PlayerHandler.players[a];
        if (c.debugMessages) {
            c.sM("Button id " + c.actionButtonId);
        }
        LeatherMaking.craftLeather(c, c.actionButtonId);
        c.getGlassBlowing().handleActionButtin(c.actionButtonId);
        c.getSmithing().getBar(c, c.actionButtonId);
        if (c.playerIsfFetching) {
            Fletching.attemptData(c, c.actionButtonId);
        }
        for (CraftingData.tanningData t : CraftingData.tanningData.values()) {
            if (c.actionButtonId == t.getButtonId(c.actionButtonId)) {
                Tanning.tanHide(c, c.actionButtonId);
            }
        }
        if (c.getDialogue() != null && c.getDialogue().clickButton(c.actionButtonId)) {
            return;
        }
        switch (c.actionButtonId) {
            case 250002:
                c.closeInterface();
                break;

            case 72096: //Allow Teleport
                c.getClan().allowTeleport(c);
                break;
            case 72099: //Allow Copy kit
                c.getClan().allowCopyKit(c);
                break;

            case 34142: // tab 1
                c.getSkillInterfaces().menuCompilation(1);
                break;

            case 34119: // tab 2
                c.getSkillInterfaces().menuCompilation(2);
                break;

            case 34120: // tab 3
                c.getSkillInterfaces().menuCompilation(3);
                break;

            case 34123: // tab 4
                c.getSkillInterfaces().menuCompilation(4);
                break;

            case 34133: // tab 5
                c.getSkillInterfaces().menuCompilation(5);
                break;

            case 34136: // tab 6
                c.getSkillInterfaces().menuCompilation(6);
                break;

            case 34139: // tab 7
                c.getSkillInterfaces().menuCompilation(7);
                break;

            case 34155: // tab 8
                c.getSkillInterfaces().menuCompilation(8);
                break;

            case 34158: // tab 9
                c.getSkillInterfaces().menuCompilation(9);
                break;

            case 34161: // tab 10
                c.getSkillInterfaces().menuCompilation(10);
                break;

            case 59199: // tab 11
                c.getSkillInterfaces().menuCompilation(11);
                break;

            case 59202: // tab 12
                c.getSkillInterfaces().menuCompilation(12);
                break;
            case 59203: // tab 13
                c.getSkillInterfaces().menuCompilation(13);
                break;

            case 33206: // attack
                c.getSkillInterfaces().attackComplex(1);
                c.getSkillInterfaces().selected = 0;
                break;
            case 33209: // strength
                c.getSkillInterfaces().strengthComplex(1);
                c.getSkillInterfaces().selected = 1;
                break;
            case 33212: // Defence
                c.getSkillInterfaces().defenceComplex(1);
                c.getSkillInterfaces().selected = 2;
                break;
            case 33215: // range
                c.getSkillInterfaces().rangedComplex(1);
                c.getSkillInterfaces().selected = 3;
                break;
            case 33218: // prayer
                c.getSkillInterfaces().prayerComplex(1);
                c.getSkillInterfaces().selected = 4;
                break;
            case 33221: // mage
                c.getSkillInterfaces().magicComplex(1);
                c.getSkillInterfaces().selected = 5;
                break;
            case 33224: // runecrafting
                c.getSkillInterfaces().runecraftingComplex(1);
                c.getSkillInterfaces().selected = 6;
                break;
            case 33207: // hp
                c.getSkillInterfaces().hitpointsComplex(1);
                c.getSkillInterfaces().selected = 7;
                break;
            case 33210: // agility
                c.getSkillInterfaces().agilityComplex(1);
                c.getSkillInterfaces().selected = 8;
                break;
            case 33213: // herblore
                c.getSkillInterfaces().herbloreComplex(1);
                c.getSkillInterfaces().selected = 9;
                break;
            case 33216: // theiving
                c.getSkillInterfaces().thievingComplex(1);
                c.getSkillInterfaces().selected = 10;
                break;
            case 33219: // crafting
                c.getSkillInterfaces().craftingComplex(1);
                c.getSkillInterfaces().selected = 11;
                break;
            case 33222: // fletching
                c.getSkillInterfaces().fletchingComplex(1);
                c.getSkillInterfaces().selected = 12;
                break;
            case 47130:// slayer
                c.getSkillInterfaces().slayerComplex(1);
                c.getSkillInterfaces().selected = 13;
                break;
            case 33208: // mining
                c.getSkillInterfaces().miningComplex(1);
                c.getSkillInterfaces().selected = 14;
                break;
            case 33211: // smithing
                c.getSkillInterfaces().smithingComplex(1);
                c.getSkillInterfaces().selected = 15;
                break;
            case 33214: // fishing
                c.getSkillInterfaces().fishingComplex(1);
                c.getSkillInterfaces().selected = 16;
                break;
            case 33217: // cooking
                c.getSkillInterfaces().cookingComplex(1);
                c.getSkillInterfaces().selected = 17;
                break;
            case 33220: // firemaking
                c.getSkillInterfaces().firemakingComplex(1);
                c.getSkillInterfaces().selected = 18;
                break;
            case 33223: // woodcut
                c.getSkillInterfaces().woodcuttingComplex(1);
                c.getSkillInterfaces().selected = 19;
                break;
            case 54104: // farming
                c.getSkillInterfaces().farmingComplex(1);
                c.getSkillInterfaces().selected = 20;
                break;
            case 34185:
            case 34193:
            case 34189:
                if (c.clickedSpinning) {
                    Spinning.getAmount(c, 1);
                }
                break;

            case 34184:
            case 34188:
            case 34192:
                if (c.clickedSpinning) {
                    Spinning.getAmount(c, 5);
                }
                break;

            case 34183:
            case 34187:
            case 34191:
                if (c.clickedSpinning) {
                    Spinning.getAmount(c, 10);
                }
                break;

            case 34182:
            case 34186:
            case 34190:
                if (c.clickedSpinning) {
                    Spinning.getAmount(c, 28);
                }
                break;
            case 34245:
                if (c.showedUnfire) {
                    Pottery.makeUnfire(c, 1787, 6.3, 1, 1);
                }
                if (c.showedFire) {
                    Pottery.makeFire(c, 1787, 1931, 1, 6.3, 1);
                }
                break;
            case 34244:
                if (c.showedUnfire) {
                    Pottery.makeUnfire(c, 1787, 6.3, 1, 5);
                }
                if (c.showedFire) {
                    Pottery.makeFire(c, 1787, 1931, 1, 6.3, 5);
                }
                break;
            case 34243:
                if (c.showedUnfire) {
                    Pottery.makeUnfire(c, 1787, 6.3, 1, 10);
                }
                if (c.showedFire) {
                    Pottery.makeFire(c, 1787, 1931, 1, 6.3, 10);
                }
                break;
            case 34242:
                if (c.showedUnfire) {
                    Pottery.makeUnfire(c, 1787, 6.3, 1, 28);
                }
                if (c.showedFire) {
                    Pottery.makeFire(c, 1787, 1931, 1, 6.3, 28);
                }
                break;
            // item 2
            case 34249:
                if (c.showedUnfire) {
                    Pottery.makeUnfire(c, 1789, 15, 7, 1);
                }
                if (c.showedFire) {
                    Pottery.makeFire(c, 1789, 2313, 7, 10, 1);
                }
                break;
            case 34248:
                if (c.showedUnfire) {
                    Pottery.makeUnfire(c, 1789, 15, 7, 5);
                }
                if (c.showedFire) {
                    Pottery.makeFire(c, 1789, 2313, 7, 10, 5);
                }
                break;
            case 34247:
                if (c.showedUnfire) {
                    Pottery.makeUnfire(c, 1789, 15, 7, 10);
                }
                if (c.showedFire) {
                    Pottery.makeFire(c, 1789, 2313, 7, 10, 10);
                }
                break;
            case 34246:
                if (c.showedUnfire) {
                    Pottery.makeUnfire(c, 1789, 15, 7, 28);
                }
                if (c.showedFire) {
                    Pottery.makeFire(c, 1789, 2313, 7, 10, 28);
                }
                break;
            // item 3
            case 34253:
                if (c.showedUnfire) {
                    Pottery.makeUnfire(c, 1791, 18, 8, 1);
                }
                if (c.showedFire) {
                    Pottery.makeFire(c, 1791, 1923, 8, 15, 1);
                }
                break;
            case 34252:
                if (c.showedUnfire) {
                    Pottery.makeUnfire(c, 1791, 18, 8, 5);
                }
                if (c.showedFire) {
                    Pottery.makeFire(c, 1791, 1923, 8, 15, 5);
                }
                break;
            case 34251:
                if (c.showedUnfire) {
                    Pottery.makeUnfire(c, 1791, 18, 8, 10);
                }
                if (c.showedFire) {
                    Pottery.makeFire(c, 1791, 1923, 8, 15, 10);
                }
                break;
            case 34250:
                if (c.showedUnfire) {
                    Pottery.makeUnfire(c, 1791, 18, 8, 28);
                }
                if (c.showedFire) {
                    Pottery.makeFire(c, 1791, 1923, 8, 15, 28);
                }
                break;
            case 73137:
                c.sendequmentscreen();
                break;
            case 74112:
                c.closeInterface();
                break;
            case 58074:
                c.getBankPin().close();
                break;

            case 75247:
            case 75222:
                c.setSidebarInterface(2, 18859);
                break;
            case 73167:
            case 75248:
                c.setSidebarInterface(2, 19409);
                break;

            case 73202:
                c.showInterface(17890);
                break;

            case 69230:
                c.RemoveAllWindows();
                break;

            case 73200:
                c.setSidebarInterface(12, 18891);
                break;

            case 73250:
                c.setSidebarInterface(12, 147);
                break;

            case 73220:
                if (c.actionTimer == 0)
                    c.setAnimation(855);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(855);
                break;
            case 73205:
                if (c.actionTimer == 0)
                    c.setAnimation(856);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(856);
                break;
            case 73206:
                if (c.actionTimer == 0)
                    c.setAnimation(858);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(858);
                break;
            case 73207:
                if (c.actionTimer == 0)
                    c.setAnimation(859);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(859);
                break;
            case 73208:
                if (c.actionTimer == 0)
                    c.setAnimation(857);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(857);
                break;
            case 73209:
                if (c.actionTimer == 0)
                    c.setAnimation(863);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(853);
                break;
            case 73210:
                if (c.actionTimer == 0)
                    c.setAnimation(2113);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(2113);
                break;
            case 73211:
                if (c.actionTimer == 0)
                    c.setAnimation(862);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(862);
                break;
            case 73212:
                if (c.actionTimer == 0)
                    c.setAnimation(864);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(864);
                break;
            case 73213:
                if (c.actionTimer == 0)
                    c.setAnimation(861);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(861);
                break;
            case 73214:
                if (c.actionTimer == 0)
                    c.setAnimation(2109);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(2109);
                break;
            case 73215:
                if (c.actionTimer == 0)
                    c.setAnimation(2111);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(2111);
                break;
            case 73216:
                if (c.actionTimer == 0)
                    c.setAnimation(866);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(866);
                break;

            case 73217:
                if (c.actionTimer == 0)
                    c.setAnimation(2106);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(2106);
                break;
            case 73218:
                if (c.actionTimer == 0)
                    c.setAnimation(2107);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(2107);
                break;
            case 73219:
                if (c.actionTimer == 0)
                    c.setAnimation(2108);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(2108);
                break;


            case 73221:
                if (c.actionTimer == 0)
                    c.setAnimation(860);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(860);
                break;

            case 73222:
                if (c.actionTimer == 0)
                    c.lowGFX(1702, 0);
                c.setAnimation(1374);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(1374);
                break;
            case 73223:
                if (c.actionTimer == 0)
                    c.setAnimation(2105);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(2105);
                break;

            case 73224:
                if (c.actionTimer == 0)
                    c.setAnimation(2110);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(2110);
                break;
            case 73225:
                if (c.actionTimer == 0)
                    c.setAnimation(865);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(865);
                break;
            case 73226:
                if (c.actionTimer == 0)
                    c.setAnimation(2112);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(2112);
                break;
            case 73227:
                if (c.actionTimer == 0)
                    c.setAnimation(0x84F);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(0x84F);
                break;
            case 73228:
                if (c.actionTimer == 0)
                    c.setAnimation(0x850);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(0x850);
                break;
            case 73229:
                if (c.actionTimer == 0)
                    c.setAnimation(1131);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(1131);
                break;
            case 73230:
                if (c.actionTimer == 0)
                    c.setAnimation(1130);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(1130);
                break;
            case 73231:
                if (c.actionTimer == 0)
                    c.setAnimation(1129);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(1129);
                break;
            case 73232:
                if (c.actionTimer == 0)
                    c.setAnimation(1128);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(1128);
                break;


            case 73236:
                if (c.actionTimer == 0)
                    c.setAnimation(4275);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(4275);
                break;

            case 73235:
                if (c.actionTimer == 0)
                    c.setAnimation(4280);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(4280);
                break;

            case 73234:
                if (c.actionTimer == 0)
                    c.setAnimation(1745);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(1745);
                break;

            case 73233:
                if (c.actionTimer == 0)
                    c.setAnimation(4276);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(4276);
                break;

            case 73237:
                if (c.actionTimer == 0)
                    c.setAnimation(3544);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(3544);
                break;

            case 73238:
                if (c.actionTimer == 0)
                    c.setAnimation(3543);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(3543);
                break;
            case 73239:
                if (c.actionTimer == 0)
                    c.lowGFX(1244, 0);
                c.setAnimation(7272);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(7272);
                break;


            case 73240:
                if (c.actionTimer == 0)
                    c.setAnimation(2836);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(2836);
                break;

            case 73241:
                if (c.actionTimer == 0)
                    c.setAnimation(6111);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(6111);
                break;


            case 73243:
                if (c.actionTimer == 0)
                    c.setAnimation(7531);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(7531);
                break;
            case 73244:
                if (c.actionTimer == 0)
                    c.lowGFX(1537, 0);
                c.setAnimation(2414);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(2414);
                break;

            case 73246:
                if (c.actionTimer == 0)
                    c.lowGFX(1734, 0);
                c.setAnimation(9990);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(9990);
                break;

            case 73247:
                if (c.actionTimer == 0)
                    c.lowGFX(1864, 0);
                c.setAnimation(10530);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(10530);
                break;
            case 73245:
                if (c.actionTimer == 0)
                    c.lowGFX(1553, 0);
                c.setAnimation(8770);
                c.stopMovement();
                c.actionTimer = AnimationLength.getFrameLength(8770);
                break;
            case 73249:
                if (c.actionTimer == 0)
                    c.turkeydelay = 28;
                c.actionTimer = 5;
                break;

            case 73248:
                if (c.actionTimer == 0)
                    c.lowGFX(1973, 0);
                c.setAnimation(11044);
                c.stopMovement();
                c.actionTimer = 2;
                break;

            case 23132: //unmorph
                c.isMorphed = false;
                c.setSidebarInterface(1, 3917);
                c.setSidebarInterface(2, 638);
                c.setSidebarInterface(3, 3213);
                c.setSidebarInterface(4, 1644);
                c.setSidebarInterface(5, 5608);
                if (c.ancients == 0) {
                    c.setSidebarInterface(6, 1151);
                } else if (c.ancients == 1) {
                    c.setSidebarInterface(6, 12855);
//} else if (c.playerMagicBook == 2) {
                    //c.setSidebarInterface(6, 29999);
                }
                c.setSidebarInterface(7, 18128);
                c.setSidebarInterface(8, 5065);
                c.setSidebarInterface(9, 5715);
                c.setSidebarInterface(10, 2449);
                c.setSidebarInterface(11, 904);
                c.setSidebarInterface(12, 147);
                c.setSidebarInterface(13, 962);
                c.setSidebarInterface(0, 2423);
                if (c.playerEquipment[c.playerRing] == 7927) {
                    c.deleteequiment(c.playerEquipment[c.playerRing], c.playerRing);
                    c.addItem(7927, 1);
                }
                c.isNpc = false;
                c.updateRequired = true;
                c.appearanceUpdateRequired = true;
                break;

            case 73175:
            case 75221:
                c.setSidebarInterface(2, 638);
                break;

            case 58025:
            case 58026:
            case 58027:
            case 58028:
            case 58029:
            case 58030:
            case 58031:
            case 58032:
            case 58033:
            case 58034:
                c.getBankPin().pinEnter(c.actionButtonId);
                break;

            case 75249:
                c.customCommand("StaffList");
                break;
/*
		case 33206:
			Prestige.prestigeSkill(c, 0);
			break;
		case 33209:
			Prestige.prestigeSkill(c, 1);
			break;
		case 33212:
			Prestige.prestigeSkill(c, 2);
			break;
		case 33207:
			Prestige.prestigeSkill(c, 3);
			break;
		case 33215:
			Prestige.prestigeSkill(c, 4);
			break;
		case 33218:
			Prestige.prestigeSkill(c, 5);
			break;
		case 33221:
			Prestige.prestigeSkill(c, 6);
			break;
		case 33217:
			Prestige.prestigeSkill(c, 7);
			break;
		case 33223:
			Prestige.prestigeSkill(c, 8);
			break;
		case 33222:
			Prestige.prestigeSkill(c, 9);
			break;
		case 33214:
			Prestige.prestigeSkill(c, 10);
			break;
		case 33220:
			Prestige.prestigeSkill(c, 11);
			break;
		case 33219:
			Prestige.prestigeSkill(c, 12);
			break;
		case 33211:
			Prestige.prestigeSkill(c, 13);
			break;
		case 33208:
			Prestige.prestigeSkill(c, 14);
			break;
		case 34157:
			Prestige.prestigeSkill(c, 15);
			break;
		case 33210:
			Prestige.prestigeSkill(c, 16);
			break;
		case 33216:
			Prestige.prestigeSkill(c, 17);
			break;
		case 47130:
			Prestige.prestigeSkill(c, 18);
			break;
		case 54104:
			Prestige.prestigeSkill(c, 19);
			break;
		case 33224:
			Prestige.prestigeSkill(c, 20);
			break;
		case 105244:
			Prestige.prestigeSkill(c, 21);
			break;
		case 105243:
			Prestige.prestigeSkill(c, 22);
			break;
		case 105245:
			Prestige.prestigeSkill(c, 23);
			break;
		case 105246:
			Prestige.prestigeSkill(c, 24);
			break;*/


            case 73143:
                c.sM("Coming soon");
                break;
            case 28164:
            case 28165:
            case 28166:
            case 28168:
            case 28215:
            case 28171:
            case 28172:
            case 28178:
                break;

            case 28173:
            case 28174:
            case 28169:
            case 28175:
            case 28167:
            case 28176:
            case 28177:
            case 28179:
            case 28180:
                break;

            case 29063: // axes
                if (c.playerEquipment[c.playerWeapon] == 1377 && c.specialAmount <= 99) { // dba
                    c.specialDamage = 0;
                    c.specialDamage2 = 0;
                    c.sendMessage("You do not have enough special energy left.");
                }
                if (c.playerEquipment[c.playerWeapon] == 1377 && c.specialAmount >= 100) { // dba
                    c.specialDamage = 0;
                    c.specialDamage2 = 0;
                    c.startAnimation(1670);
                    c.animation(246, c.absY, c.absX);
                    c.specialAmount -= 100;
                }
                c.specialAttacks();
                c.specialAttacks2();
                c.specialAttacks3();
                c.specialAttacks4();
                c.specialAttacks5();
                c.specialAttacks6();
                break;

            case 29113: // bows
            case 33033: // halberds
            case 29163: // swords
            case 29138: // dds
            case 48023: // whip
                try {
                    if (c.usingSpecial) {
                        c.usingSpecial = false;
                    } else if (!c.usingSpecial) {
                        c.usingSpecial = true;
                    }
                    c.specialAttacks();
                    c.specialAttacks2();
                    c.specialAttacks3();
                    c.specialAttacks4();
                    c.specialAttacks5();
                    c.specialAttacks6();
                } catch (Exception popo) {
                }
                break;

            // These values speak for themselves
            // case 4126: windstrike break;
            case 14067: // Char design accept button
                c.RemoveAllWindows();
                break;


            case 9118:
                c.RemoveAllWindows();
                break;

            case 33190:
                if (c.playerHasItemAmount(1734, 1) && c.playerLevel[12] >= 0) {
                    c.addItem(1059, 1);
                    c.deleteItem(1734, c.getItemSlot(1734), 1);
                    c.deleteItem(1741, c.getItemSlot(1741), 1);
                    c.addSkillXP((20 * c.playerLevel[12]), 12);
                    c.sendMessage("You make some gloves!");
                } else {
                    c.sendMessage("You havnt got any thread!");
                }
                break;

            case 33193:
                if (c.playerHasItemAmount(1734, 1) && c.playerLevel[12] >= 4) {
                    c.addItem(1061, 1);
                    c.deleteItem(1734, c.getItemSlot(1734), 1);
                    c.deleteItem(1741, c.getItemSlot(1741), 1);
                    c.addSkillXP((40 * c.playerLevel[12]), 12);
                    c.sendMessage("You make some boots!");
                } else {
                    c.sendMessage("You havnt got any thread!");
                }
                break;

            case 33205:
                if (c.playerHasItemAmount(1734, 2) && c.playerLevel[12] >= 9) {
                    c.addItem(1167, 1);
                    c.deleteItem(1734, c.getItemSlot(1734), 2);
                    c.deleteItem(1741, c.getItemSlot(1741), 1);
                    c.addSkillXP((60 * c.playerLevel[12]), 12);
                    c.sendMessage("You make a leather cowl!!");
                } else {
                    c.sendMessage("You havnt got any thread!");
                }
                break;

            case 33196:
                if (c.playerHasItemAmount(1734, 2) && c.playerLevel[12] >= 14) {
                    c.addItem(1063, 1);
                    c.deleteItem(1734, c.getItemSlot(1734), 2);
                    c.deleteItem(1741, c.getItemSlot(1741), 1);
                    c.addSkillXP((80 *  c.playerLevel[12]), 12);
                    c.sendMessage("You make some leather vambraces!");
                } else {
                    c.sendMessage("You havnt got any thread!");
                }
                break;

            case 33199:
                if (c.playerHasItemAmount(1741, 1) && c.playerHasItemAmount(1734, 6) && c.playerLevel[12] >= 34) {
                    c.addItem(1095, 1);
                    c.deleteItem(1734, c.getItemSlot(1734), 4);
                    c.deleteItem(1741, c.getItemSlot(1741), 2);
                    c.addSkillXP((140 *  c.playerLevel[12]), 12);
                    c.sendMessage("You make some leather chaps!!");
                } else {
                    c.sendMessage("You need 6 thread and 1 piece of soft leather to make this!");
                }
                break;

            case 33187:
                if (c.playerHasItemAmount(1734, 15) && c.playerHasItemAmount(1741, 1) && c.playerLevel[12] >= 29) {
                    c.addItem(1129, 1);
                    c.deleteItem(1734, c.getItemSlot(1734), 5);
                    c.deleteItem(1741, c.getItemSlot(1741), 3);
                    c.addSkillXP((120 *  c.playerLevel[12]), 12);
                    c.sendMessage("You make a leather body!!");
                } else {
                    c.sendMessage("You need 15 thread and 1 pieces of soft leather to make this!");
                }
                break;

            case 33202:
                if (c.playerHasItemAmount(1734, 2) && c.playerHasItemAmount(1741, 1) && c.playerLevel[12] >= 34) {
                    c.addItem(1169, 1);
                    c.deleteItem(1734, c.getItemSlot(1734), 2);
                    c.deleteItem(1741, c.getItemSlot(1741), 1);
                    c.addSkillXP((140 *  c.playerLevel[12]), 12);
                    c.sendMessage("You make a coif!!");
                } else {
                    c.sendMessage("You need 2 thread and 1 piece of soft leather to make this!");
                }
                break;

            case 9178:
                if (c.holyBook) {
                    c.RemoveAllWindows();
                    c.preach1 = true;
                    c.holyBook1 = true;
                    if (c.preach1) {
                        c.txt4 = "In the name of Saradomin,";
                        c.string4UpdateRequired = true;
                        c.preachTimer = 7;
                        c.preach1 = false;
                        c.preach2 = true;
                    }
                } else if (c.unholyBook) {
                    c.RemoveAllWindows();
                    c.preach1 = true;
                    c.unholyBook1 = true;
                    if (c.preach1) {
                        c.txt4 = "Two great warriors, joined by hand,";
                        c.string4UpdateRequired = true;
                        c.preachTimer = 7;
                        c.preach1 = false;
                        c.preach2 = true;
                    }
                } else if (c.balanceBook) {
                    c.RemoveAllWindows();
                    c.preach1 = true;
                    c.balanceBook1 = true;
                    if (c.balanceBook1) {
                        c.txt4 = "Light and dark, day and night,";
                        c.string4UpdateRequired = true;
                        c.preachTimer = 7;
                        c.preach1 = false;
                        c.preach2 = true;
                    }
                }
                break;

            case 9179:
                if (c.holyBook) {
                    c.RemoveAllWindows();
                    c.preach1 = true;
                    c.holyBook2 = true;
                    if (c.preach1) {
                        c.txt4 = "Thy cause was false, thine skills did lack,";
                        c.string4UpdateRequired = true;
                        c.preachTimer = 7;
                        c.preach1 = false;
                        c.preach2 = true;
                    }
                } else if (c.unholyBook) {
                    c.RemoveAllWindows();
                    c.preach1 = true;
                    c.unholyBook2 = true;
                    if (c.preach1) {
                        c.	txt4 = "The weak deserve to die,";
                        c.	string4UpdateRequired = true;
                        c.	preachTimer = 7;
                        c.	preach1 = false;
                        c.	preach2 = true;
                    }
                } else if (c.balanceBook) {
                    c.RemoveAllWindows();
                    c.preach1 = true;
                    c.balanceBook2 = true;
                    if (c.preach1) {
                        c.	txt4 = "Thy death was not in vain,";
                        c.	string4UpdateRequired = true;
                        c.	preachTimer = 7;
                        c.	preach1 = false;
                        c.	preach2 = true;
                    }
                }
                break;
            case 73242:
                if(c.wearingCape(c.playerEquipment[c.playerCape])) {
                    c.stopMovement();
                    c.lowGFX(c.skillcapeGfx(c.playerEquipment[c.playerCape]), 0);
                    c.startAnimation(c.skillcapeEmote(c.playerEquipment[c.playerCape]));
                } else {
                    c.sendMessage("You must be wearing a Skillcape to do this emote.");
                }
                break;
            case 9180:
                if (c.holyBook) {
                    c.RemoveAllWindows();
                    c.preach1 = true;
                    c.holyBook3 = true;
                    if (c.preach1) {
                        c.	txt4 = "Go in peace in the name of Saradomin,";
                        c.	string4UpdateRequired = true;
                        c.	preachTimer = 7;
                        c.	preach1 = false;
                        c.	preach2 = true;
                    }
                } else if (c.unholyBook) {
                    c.RemoveAllWindows();
                    c.preach1 = true;
                    c.unholyBook3 = true;
                    if (c.preach1) {
                        c.	txt4 = "May your bloodthirst be never sated,";
                        c.	string4UpdateRequired = true;
                        c.	preachTimer = 7;
                        c.	preach1 = false;
                        c.	preach2 = true;
                    }
                } else if (c.balanceBook) {
                    c.RemoveAllWindows();
                    c.preach1 = true;
                    c.balanceBook3 = true;
                    if (c.preach1) {
                        c.	txt4 = "May you walk the path, and never fall,";
                        c.	string4UpdateRequired = true;
                        c.	preachTimer = 7;
                        c.	preach1 = false;
                        c.	preach2 = true;
                    }
                }
                break;

            case 9181:
                if (c.holyBook) {
                    c.RemoveAllWindows();
                    c.preach1 = true;
                    c.holyBook4 = true;
                    if (c.preach1) {
                        c.	txt4 = "Protect yourself, protect your friends,";
                        c.	string4UpdateRequired = true;
                        c.	preachTimer = 7;
                        c.	preach1 = false;
                        c.	preach2 = true;
                    }
                } else if (c.unholyBook) {
                    c.RemoveAllWindows();
                    c.preach1 = true;
                    c.unholyBook4 = true;
                    if (c.preach1) {
                        c.	txt4 = "Strike fast, strike hard, strike true,";
                        c.	string4UpdateRequired = true;
                        c.	preachTimer = 7;
                        c.	preach1 = false;
                        c.	preach2 = true;
                    }
                } else if (c.balanceBook) {
                    c.RemoveAllWindows();
                    c.preach1 = true;
                    c.balanceBook4 = true;
                    if (c.preach1) {
                        c.	txt4 = "The trees, the earth, the sky, the waters,";
                        c.	string4UpdateRequired = true;
                        c.	preachTimer = 7;
                        c.	preach1 = false;
                        c.	preach2 = true;
                    }
                }
                break;

            case 153:
            case 152:
                c.updateRunningToggled(!c.isRunningToggled());
                break;

            case 130: // close interface
                c.println_debug("Closing Interface");
                break;

            case 168:
            case 73100:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("home"); // made by traxxas
                }
                break;

            case 32195: //1st ancient tele
                if (!c.playerHasItemAmount(2996, 1)) {
                    c.sendMessage("You Need 1 ticket to buy");
                } else if (c.playerHasItemAmount(2996, 1)) {
                    c.deleteItem(2996, c.getItemSlot(2996), 1);
                    {
                        c.addSkillXP((5 *  c.playerLevel[16]), 16);
                    }
                }
                break;

            case 32197: //1st ancient tele
                if (!c.playerHasItemAmount(2996, 10)) {
                    c.sendMessage("You Need 10 tickets to buy");
                } else if (c.playerHasItemAmount(2996, 10)) {
                    c.deleteItem(2996, c.getItemSlot(2996), 10);
                    {
                        c.addSkillXP((15 *  c.playerLevel[16]), 16);
                    }
                }
                break;

            case 32198: //1st ancient tele
                if (!c.playerHasItemAmount(2996, 25)) {
                    c.sendMessage("You Need 25 tickets to buy");
                } else if (c.playerHasItemAmount(2996, 25)) {
                    c.deleteItem(2996, c.getItemSlot(2996), 25);
                    {
                        c.	addSkillXP((20 *  c.playerLevel[16]), 16);
                    }
                }
                break;

            case 32199: //1st ancient tele
                if (!c.playerHasItemAmount(2996, 100)) {
                    c.sendMessage("You Need 100 tickets to buy");
                } else if (c.playerHasItemAmount(2996, 100)) {
                    c.deleteItem(2996, c.getItemSlot(2996), 100);
                    {
                        c.	addSkillXP((60 *  c.playerLevel[16]), 16);
                    }
                }
                break;

            case 32200: //1st ancient tele
                if (!c.playerHasItemAmount(2996, 1000)) {
                    c.sendMessage("You Need 1000 tickets to buy");
                } else if (c.playerHasItemAmount(2996, 1000)) {
                    c.deleteItem(2996, c.getItemSlot(2996), 1000);
                    {
                        c.	addSkillXP((250 *  c.playerLevel[16]), 16);
                    }
                }
                break;

            case 32190: //1st ancient tele
                if (!c.playerHasItemAmount(2996, 3)) {
                    c.sendMessage("You Need 3 tickets to buy");
                } else if (c.playerHasItemAmount(2996, 3)) {
                    c.deleteItem(2996, c.getItemSlot(2996), 3);
                    {
                        c.	addItem(2998, 1);
                    }
                }
                break;

            case 32201: //1st ancient tele
                if (!c.playerHasItemAmount(2996, 10)) {
                    c.sendMessage("You Need 10 tickets to buy");
                } else if (c.playerHasItemAmount(2996, 10)) {
                    c.deleteItem(2996, c.getItemSlot(2996), 10);
                    {
                        c.	addItem(3000, 1);
                    }
                }
                break;

            case 32189: //1st ancient tele
                if (!c.playerHasItemAmount(2996, 800)) {
                    c.sendMessage("You Need 800 tickets to buy");
                } else if (c.playerHasItemAmount(2996, 800)) {
                    c.deleteItem(2996, c.getItemSlot(2996), 800);
                    {
                        c.	addItem(2997, 1);
                    }
                }
                break;


            case 169:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("Train"); // made by traxxas
                }
                break;


            case 164:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("Skill"); // made by traxxas
                }
                break;

            case 165:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("edge"); // made by traxxas
                }
                break;

            case 161:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.start(new ThevelocationsDialogue());
                }
                break;

            case 13362:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("mining"); // made by traxxas
                }
                break;

            case 13363:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("Shilo"); // made by traxxas
                }
                break;

            case 170:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.start(new FishingDialogue()); // made by traxxas
                }
                break;


            case 52057:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("gwd"); // made by traxxas
                }
                break;

            case 171:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("hang"); // made by traxxas
                }
                break;

            case 52050:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("Mining"); // made by traxxas
                }
                break;

            case 52051:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("Kbd"); // made by traxxas
                }
                break;


            case 52052:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("ports"); // made by traxxas
                }
                break;

            case 52053:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("Dagannoth"); // made by traxxas
                }
                break;

            case 52054:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("pkland"); // made by traxxas
                }
                break;

            case 52056:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("PartyHat"); // made by traxxas
                }
                break;

            case 163:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("barrows"); // made by traxxas
                }
                break;

            case 167:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("shops"); // made by traxxas
                }
                break;


            case 166:
                // TWIST
                if (c.emotes == 0) {
                    c.emotes = 1;
                    c.playerStandIndex = 921;
                    c.updateRequired = true;
                    c.appearanceUpdateRequired = true;
                } else {
                    c.emotes = 0;
                    c.playerStandIndex = c.playerStandIndex;
                    c.updateRequired = true;
                    c.appearanceUpdateRequired = true;
                }
                break;
            case 2155:
                if (c.commandEmotes) {
                }
                if (!c.commandEmotes) {
                    c.setAnimation(0x46B); //glass box emote
                }
                break;

            case 25103:
                if (c.commandEmotes) {
                }
                if (!c.commandEmotes) {
                    c.setAnimation(0x46A); //climb rope emote
                }
                break;

            case 25106:
                if (c.commandEmotes) {
                }
                if (!c.commandEmotes) {
                    c.setAnimation(0x469); //lean emote
                }
                break;

            case 2154:
                if (c.commandEmotes) {
                }
                if (!c.commandEmotes) {
                    c.setAnimation(0x468); //glass wall emote
                }
                break;

            case 52071:
                if (c.commandEmotes) {
                }
                if (!c.commandEmotes) {
                    c.setAnimation(0x84F); //goblin bow emote
                }
                break;

            case 52072:
                if (c.commandEmotes) {
                }
                if (!c.commandEmotes) {
                    c.setAnimation(0x850); //goblin dance emote
                }
                break;

            case 72032:
                if (c.commandEmotes) {
                }
                if (!c.commandEmotes) {
                    c.setAnimation(3544); //zombie walk emote
                }
                break;

            case 72033:
                if (c.commandEmotes) {
                }
                if (!c.commandEmotes) {
                    c.setAnimation(3543); //zombie dance emote
                }
                break;

            case 72254:
                if (c.commandEmotes) {
                }
                if (!c.commandEmotes) {
                    c.setAnimation(6111); //rabit hop emote
                }
                break;

            case 59062:
                if (c.commandEmotes) {
                }
                if (!c.commandEmotes) {
                    c.setAnimation(2836); //scared emote
                }
                break;

            case 52055:
                // spin
                if (c.emotes == 0) {
                    c.emotes = 1;
                    c.playerStandIndex = 3399;
                    c.updateRequired = true;
                    c.appearanceUpdateRequired = true;
                } else {
                    c.emotes = 0;
                    c.playerStandIndex = c.playerStandIndex;
                    c.updateRequired = true;
                    c.appearanceUpdateRequired = true;
                }
                break;

            case 4140: //varrock
                if (c.teleblock) { //Made Traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    if(c.actionTimer == 0) {
                        c.addSkillXP((50 * c.playerLevel[6]), 6);
                        c.teleportToX = 3209;
                        c.teleportToY = 3423;
                        c.heightLevel = 0;
                        c.sendMessage("You Teleport To Varrock");
                    }
                }
                break;

            case 4143: //1st ancient tele
                if (c.teleblock) { //Made by Traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    if(c.actionTimer == 0) {
                        c.addSkillXP((75 * c.playerLevel[6]), 6);
                        c.teleportToX = 3221;
                        c.teleportToY = 3219;
                        c.heightLevel = 0;
                        c.actionTimer = 3;
                        c.sendMessage("You Teleport To lumby");
                    }
                }
                break;

            case 4146: //1st ancient tele
                if (c.teleblock) { //Made by Traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    if(c.actionTimer == 0) {
                        c.addSkillXP((100 * c.playerLevel[6]), 6);
                        c.teleportToX = 2964;
                        c.teleportToY = 3378;
                        c.heightLevel = 0;
                        c.actionTimer = 3;
                        c.sendMessage("You Teleport To falador");
                    }
                }
                break;

            case 4150: //1st ancient tele
                if (c.teleblock) { //Made Traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    if(c.actionTimer == 0) {
                        c.addSkillXP((200 * c.playerLevel[6]), 6);
                        c.teleportToX = 2757;
                        c.teleportToY = 3479;
                        c.heightLevel = 0;
                        c.actionTimer = 3;
                        c.sendMessage("You Teleport To Camelot");
                    }
                }
                break;

            case 49022: //1st ancient tele
                if (c.teleblock) { //Made Traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    if(c.actionTimer == 0) {
                        c.addSkillXP((200 * c.playerLevel[6]), 6);
                        c.teleportToX = 2757;
                        c.teleportToY = 3479;
                        c.heightLevel = 0;
                        c.actionTimer = 3;
                        c.sendMessage("You Teleport To Camelot");
                        c.closeInterface();
                    }
                }
                break;


            case 172:
                if (c.teleblock) { // made by traxxas
                    c.sendMessage("A magical force stops you from teleporting.");
                } else {
                    c.customCommand("wcing"); // made by traxxas
                }
                break;

            case 9125: // Accurate
            case 22228: // punch (unarmed)
            case 48010: // flick (whip)
            case 21200: // spike (pickaxe)
            case 1080: // bash (staff)
            case 6168: // chop (axe)
            case 6236: // accurate (long bow)
            case 17102: // accurate (darts)
            case 8234: // stab (dagger)
                c.FightType = 1;
                c.SkillID = 0;
                break;

            case 9126: // Defensive
            case 22229: // block (unarmed)
            case 21201: // block (pickaxe)
            case 1078: // focus - block (staff)
            case 6169: // block (axe)
            case 33019: // fend (hally)
            case 18078: // block (spear)
            case 8235: // block (dagger)
                c.FightType = 4;
                c.SkillID = 1;
                break;

            case 9127: // Controlled
            case 48009: // lash (whip)
            case 33018: // jab (hally)
            case 6234: // longrange (long bow)
            case 18077: // lunge (spear)
            case 18080: // swipe (spear)
            case 18079: // pound (spear)
            case 17100: // longrange (darts)
                c.FightType = 3;
                c.SkillID = 3;
                break;

            case 9128: // Aggressive
            case 22230: // kick (unarmed)
            case 21203: // impale (pickaxe)
            case 21202: // smash (pickaxe)
            case 1079: // pound (staff)
            case 6171: // hack (axe)
            case 6170: // smash (axe)
            case 33020: // swipe (hally)
            case 6235: // rapid (long bow)
            case 17101: // repid (darts)
            case 8237: // lunge (dagger)
            case 8236: // slash (dagger)
                c.FightType = 2;
                c.SkillID = 2;
                break;

            case 9154: // Log out
            {
                if (c.jailed == 1) {
                    c.sendMessage("You cant log out when jailed.");
                    return;
                } else if (c.jailed == 0) {
                    c.logout();
                    c.savechar();
                    server.lottery.saveLists();
                    c.savefile = true;
                }
            }
            break;

            case 21011:
                c.takeAsNote = false;
                break;

            case 21010:
                c.takeAsNote = true;
                break;

            case 13092:
                if (c.tradeWith > 0) {
                    if (PlayerHandler.players[c.tradeWith].tradeStatus == 2) {
                        c.	tradeStatus = 3;
                        c.	sendFrame126("Waiting for other c...", 3431);
                    } else if (PlayerHandler.players[c.tradeWith].tradeStatus == 3) {
                        c.	tradeStatus = 3;
                        // TradeGoConfirm();
                    }
                }
                break;

            case 13218:
                if (c.tradeWith > 0) {
                    if (PlayerHandler.players[c.tradeWith].tradeStatus == 3) {
                        c.	tradeStatus = 4;
                        c.	sendFrame126("Waiting for other c...", 3535);
                    } else if (PlayerHandler.players[c.tradeWith].tradeStatus == 4) {
                        c.	tradeStatus = 4;
                        // ConfirmTrade();
                    }
                }
                break;

            case 9167:
                if (c.NpcDialogue == 4) { // bank
                    c.NpcDialogue = 0;
                    c.NpcDialogueSend = false;
                    c.openUpBank();
                }
                if (c.skillcape == 1) {
                    c.WanneShop = 61; // Skill Cape Shop
                    c.skillcape = 0;
                }
                break;

            case 9168:
                if (c.NpcDialogue == 4) { // bank
                    c.NpcDialogue = 0;
                    c.NpcDialogueSend = false;
                    c.openUpPinSettings();
                }
                if (c.skillcape == 1) {
                    c.WanneShop = 103; // Skill Cape Shop
                    c.skillcape = 0;
                }
                break;
            case 74127:
                c.showInterface(19073);
                break;
            case 9169:
                if (c.NpcDialogue == 4) { // bank
                    c.NpcDialogue = 5;
                    c.NpcDialogueSend = false;
                    c.nextDialogue(5);
                }
                if (c.skillcape == 1) {
                    c.WanneShop = 104; // Skill Cape Shop
                    c.skillcape = 0;
                }
                break;
            case 56109:
                if (c.NpcDialogue == 7) { // bank
                    c.NpcDialogue = 8;
                    c.NpcDialogueSend = false;
                    c.nextDialogue(8);
                }
                break;

            case 56110:
                if (c.NpcDialogue == 7) { // bank
                    c.NpcDialogue = 11;
                    c.NpcDialogueSend = false;
                    c.nextDialogue(11);
                }
                break;

           /* case 9157:
                if (c.NpcDialogue == 2) {
                    c.NpcDialogue = 0;
                    c.NpcDialogueSend = false;
                    c.openUpShop(55);
                } else if (c.NpcDialogue == 15) {
                    c.NpcDialogue = 16;
                    c.NpcDialogueSend = false;
                    c.nextDialogue(16);
                } else if (c.NpcDialogue == 9999) {
                    c.NpcDialogue = 1000;
                    c.NpcDialogueSend = false;
                    c.nextDialogue(1000);
                } else if (c.NpcDialogue == 41) {
                    c.NpcDialogue = 0;
                    c.NpcDialogueSend = false;
                    c.RemoveAllWindows();
                    c.sendMessage("You board the ship.");
                    c.travelboat1 = true;
                    c.traveltime = 30;
                } else if (c.NpcDialogue == 43) {
                    c.NpcDialogue = 0;
                    c.NpcDialogueSend = false;
                    c.RemoveAllWindows();
                    c.sendMessage("You board the ship.");
                    c.travelboat2 = true;
                    c.traveltime = 30;
                } else if (c.NpcDialogue == 302) {
                    c.NpcDialogue = 303;
                    c.NpcDialogueSend = false;
                    c.q3stage = 1;
                } else if (c.NpcDialogue == 306) {
                    c.NpcDialogue = 307;
                    c.NpcDialogueSend = false;
                } else if (c.NpcDialogue == 0) {
                    c.NpcDialogue = 1340;
                    c.sendFrame126("Mmk thanks for reading!", 4885);
                    c.RemoveAllWindows();
                    c.NpcDialogueSend = false;
                } else if (c.NpcDialogue == 14601) {
                    c.NpcDialogue = 14602;
                    c.NpcDialogueSend = false;
                } else if (c.NpcDialogue == 14603) {
                    c.NpcDialogue = 14604;
                    c.NpcDialogueSend = false;
                } else if (c.NpcDialogue == 2260) { // Mage Of Zamorak
                    c.NpcDialogue = 0;
                    c.NpcDialogueSend = false;
                    c.sendMessage("You teleport to the abyss.");
                    c.teleportToX = 3040;
                    c.teleportToY = 4842;
                } else if (c.NpcDialogue == 1002) { // Dark Mage
                    c.NpcDialogue = 0;
                    c.NpcDialogueSend = false;
                    c.stillgfx(435, c.absY, c.absX);
                    c.RemoveAllWindows();
                    if (c.ancients == 1) {
                        c.	setSidebarInterface(6, 1151); // magic tab (ancient = 12855);
                        c.	ancients = 0;
                        c.	sendMessage("The dark mage converts back to normal magic!");
                    } else {
                        c.	setSidebarInterface(6, 12855); // magic tab (ancient = 12855);
                        c.	ancients = 1;
                        c.	sendMessage("The dark mage converts you to ancient magicks!");
                    }
                } else if (c.duelring) {
                    c.teleportToX = 2837;
                    c.teleportToY = 9581;
                    c.heightLevel = 0;
                    c.sendMessage("You teleport to the TzTok-Jad's lair");
                    c.sendMessage("As you materialize, you feel the air around you grow hot");
                    c.duelring = false;
                    c.RemoveAllWindows();
                } else if (c.OptionObject == 2466) {
                    c.sendMessage("Welcome to Saradomin's team!");
                    c.teleportToX = 2387;
                    c.teleportToY = 3116;
                    c.OptionObject = -1;
                    c.RemoveAllWindows();
                } else if (c.JunaTele == 1) {
                    c.RemoveAllWindows();
                    c.teleportToX = 3253;
                    c.teleportToY = c.absY;
                    c.JunaTele = -1;
                } else if (c.JunaTele == 2) {
                    c.RemoveAllWindows();
                    c.teleportToX = 3251;
                    c.teleportToY = c.absY;
                    c.JunaTele = -1;
                } else if (c.NpcDialogue == 627) {
                    if (c.playerHasItem(8851, 200)) {
                        c.movePlayer(2847, 3540, 2);
                        c.closeInterface();
                        c.getWarriorsGuild().cycle();
                    } else {
                        c.talk2(9760, "You need at least 200 warrior guild tokens.",
                                "You can get some by operating the armour animator.", 4289);
                        c.setNext = 0;
                    }
                    c.NpcDialogue = -1;
                } else if (c.NpcDialogue == 186) {
                    c.NpcDialogue = 187;
                    c.NpcDialogueSend = false;
                } else if (c.NpcDialogue == 325){
                    c.NpcDialogue = 326;
                    c.NpcDialogueSend = false;
                } else if (c.NpcDialogue == 620) {
                    if (c.playerHasItem(4671) == true) {
                        c.deleteItem(4671, c.getItemSlot(4671), 1);
                        c.NpcDialogue = 0;
                        c.NpcDialogueSend = false;
                        c. teleportToX = 3544;
                        c.teleportToY = 3427;
                        c.sendMessage("-He Teleports you then runs away-");
                        c.sendMessage("Go through the swamp, i would kill those ghasts if i were you..");
                        c.heightLevel = 0;
                        c.RemoveAllWindows();
                    } else {
                        c.NpcDialogue = 0;
                        c.NpcDialogueSend = false;
                        c.sendMessage("You do not have the ice Diamond in your inventory.");
                        c.RemoveAllWindows();
                    }
                } else if (c.NpcDialogue == 819) {
                    if (c.playerHasItem(4672) == true) {
                        c.deleteItem(4672, c.getItemSlot(4672), 1);
                        c.IsSnowing = 3;
                        c.NpcDialogue = 0;
                        c.NpcDialogueSend = false;
                        c.teleportToX = 3233;
                        c.teleportToY = 9317;
                        c.addItem(6099, 1);
                        c.addItem(565, 300);
                        c.addItem(560, 300);
                        c.addItem(555, 500);
                        c.addItem(562, 300);
                        c.deleteItem(275, c.getItemSlot(275), 1);
                        c.sendMessage("CONGRATULATIONS");
                        c.sendMessage("YOU HAVE UNLOCKED ANCIENT MAGIKS!");
                        c.addSkillXP((100000 * c.playerLevel[6]), 6);
                        PlayerHandler.messageToAll = c.playerName + " has just completed Desert Tresure!";
                        c.heightLevel = 0;
                        c.RemoveAllWindows();
                    } else {
                        c.NpcDialogue = 0;
                        c.NpcDialogueSend = false;
                        c.sendMessage("You do not have the Smoke Diamond in your inventory.");
                        c.RemoveAllWindows();
                    }
                } else if (c.NpcDialogue == 906) {
                    if (c.playerHasItem(4673) == true) {
                        c.deleteItem(4673, c.getItemSlot(4673), 1);
                        c.NpcDialogue = 0;
                        c.NpcDialogueSend = false;
                        c.teleportToX = 3206;
                        c.teleportToY = 9378;
                        c.sendMessage("ah..thanksss");
                        c.sendMessage("-you get teleported to your last task");
                        c.IsSnowing = 5;
                        c.heightLevel = 0;
                        c.RemoveAllWindows();
                    } else {
                        c.NpcDialogue = 0;
                        c.NpcDialogueSend = false;
                        c.sendMessage("You do not have the Shadow Diamond in your inventory.");
                        c.RemoveAllWindows();
                    }
                } else if (c.NpcDialogue == 665) {
                    if (c.playerHasItem(995) && c.playerHasItemAmount(995, 199999999) && (c.playerLevel[15] >= 56) && c.playerLevel[6] >= 82 == true) {
                        c.deleteItem(995, c.getItemSlot(995), 199999999);
                        c.NpcDialogue = 0;
                        c.NpcDialogueSend = false;
                        c.sendMessage("If i were you..i would get the following items in your bank.");
                        c.sendMessage("Get the following,");
                        c.sendMessage("1 yew log");
                        c.sendMessage("1 RAW manta ray");
                        c.sendMessage("1 tinderbox");
                        c.sendMessage("1 soul rune");
                        c.sendMessage("1 coif");
                        c.sendMessage("1 Bronze platebody");
                        c.sendMessage("You will not need these right now..but later, they will be needed");
                        c.IsSnowing = 3;
                        c.teleportToX = 2843;
                        c.teleportToY = 3674;
                        c.heightLevel = 0;
                        c.RemoveAllWindows();
                    } else {
                        c.NpcDialogue = 0;
                        c.NpcDialogueSend = false;
                        c.sendMessage("You must have 82 magic & 56 Herblore as well as 200m to start this quest.");
                        c.RemoveAllWindows();
                    }
                } else if (c.NpcDialogue == 1921) {
                    if (c.playerHasItem(4670) == true) {
                        c.deleteItem(4670, c.getItemSlot(4670), 1);
                        c.NpcDialogue = 0;
                        c.NpcDialogueSend = false;
                        c.IsSnowing = 3;
                        c.teleportToX = 2545;
                        c.teleportToY = 3422;
                        c.heightLevel = 0;
                        c.RemoveAllWindows();
                    } else {
                        c.NpcDialogue = 0;
                        c.NpcDialogueSend = false;
                        c.sendMessage("You do not have the Blood Diamond in your inventory.");
                        c.RemoveAllWindows();
                    }
                } else if (c.NpcDialogue == 1973) {
                    if (c.playerHasItem(1515) && c.playerHasItemAmount(389, 1) && c.playerHasItemAmount(590, 1) && c.playerHasItemAmount(566, 1) && c.playerHasItemAmount(1117, 1) && c.playerHasItemAmount(1169, 1) == true) {
                        c.deleteItem(1515, c.getItemSlot(1515), 1);
                        c.deleteItem(389, c.getItemSlot(389), 1);
                        c.deleteItem(590, c.getItemSlot(590), 1);
                        c.deleteItem(566, c.getItemSlot(566), 1);
                        c.deleteItem(1117, c.getItemSlot(1117), 1);
                        c.deleteItem(1169, c.getItemSlot(1169), 1);
                        c.NpcDialogue = 0;
                        c.NpcDialogueSend = false;
                        c.IsSnowing = 3;
                        c.teleportToX = 2629;
                        c.teleportToY = 5069;
                        c.heightLevel = 0;
                        c.RemoveAllWindows();
                    } else {
                        c.NpcDialogue = 0;
                        c.NpcDialogueSend = false;
                        c.sendMessage("You do not have the items needed in your inventory.");
                        c.RemoveAllWindows();
                    }
                }

                break;*/
            case 32017:
                if(c.NpcDialogue == 14330){
                    c.NpcDialogue = 14331;
                    c.NpcDialogueSend = false;
                    c.nextDialogue(14331);
                }
                break;
            case 164035:
            case 164036:
            case 164037:
                int index = c.actionButtonId - 164034;
                String[] removed = c.getSlayer().getRemoved();
                if (index < 0 || index > removed.length - 1) {
                    return;
                }
                if (removed[index].isEmpty()) {
                    c.sendMessage("There is no task in this slow that is being blocked.");
                    return;
                }
                removed[index] = "";
                c.getSlayer().setRemoved(removed);
                c.getSlayer().updateCurrentlyRemoved();
                break;

            case 164028:
                c.getSlayer().cancelTask();
                break;
            case 164029:
                c.getSlayer().removeTask();
                break;

            case 160045:
            case 162033:
            case 164021:
                if (c.testinterfaceId != 41000)
                    c.getSlayer().handleInterface("buy");
                break;

            case 160047:
            case 162035:
            case 164023:
                if (c.testinterfaceId != 41500)
                    c.getSlayer().handleInterface("learn");
                break;

            case 160049:
            case 162037:
            case 164025:
                if (c.testinterfaceId != 42000)
                    c.getSlayer().handleInterface("assignment");
                break;

            case 162030:
            case 164018:
            case 160042:
                c.closeInterface();
                break;
            case 32018:
                if(c.NpcDialogue == 14330) {
                    Optional<SlayerTask> task = c.getSlayer().getTask();
                    Optional<SlayerMaster> master = SlayerMaster.get(c.talkingNpc);
                    Optional<SlayerMaster> myMaster = SlayerMaster.get(c.getSlayer().getMaster());

                    if (task.isPresent() && master.isPresent() && myMaster.isPresent()) {
                        if (c.getSlayer().getMaster() != master.get().getId()) {
                            if (myMaster.get().getLevel() < master.get().getLevel()) {
                                c.talk3(9847, "You have an easier task from a different master.",
                                        "If you cannot complete their task, you cannot start",
                                        "one of mine. You must finish theirs first.", c.talkingNpc);
                                c.RemoveAllWindows();
                                c.NpcDialogueSend = false;
                                return;
                            }
                        } else {
                            if (c.talkingNpc == 8461) {
                                c.NpcDialogue = 14333;
                                c.NpcDialogueSend = false;
                            } else if (c.talkingNpc == 8464) {
                                c.talk3(9847,
                                        "You currently have " + c.getSlayer().getTaskAmount() + " "
                                                + c.getSlayer().getTask().get().getPrimaryName() + " to kill.",
                                        "Talk to Turael for an easier task. If you",
                                        "obtain an easier task your consecutive tasks will be reset.", c.talkingNpc);
                                c.NpcDialogueSend = false;
                            }
                        }

                    } else {
                        c.getSlayer().createNewTask(c.talkingNpc);
                    }
                }
                break;
                /*
            case 9158:
                if (c.NpcDialogue == 2) {
                    c.NpcDialogue = 0;
                    c.NpcDialogueSend = false;
                    c.RemoveAllWindows();
                } else if (c.NpcDialogue == 15) {
                    c.NpcDialogue = 18;
                    c.NpcDialogueSend = false;
                    c.nextDialogue(18);
                } else if (c.NpcDialogue == 620) {
                    c.NpcDialogue = 621;
                    c.RemoveAllWindows();
                    c.NpcDialogueSend = false;
                } else if (c.NpcDialogue == 906) {
                    c.NpcDialogue = 907;
                    c.RemoveAllWindows();
                    c.NpcDialogueSend = false;
                } else if (c.NpcDialogue == 665) {
                    c.NpcDialogue = 666;
                    c.RemoveAllWindows();
                    c.NpcDialogueSend = false;
                } else if(c.NpcDialogue == 1539){
                    c.NpcDialogue = 1540;
                    c.NpcDialogueSend = false;
                } else  if (c.NpcDialogue == 325) {
                    //server.lottery.enterLottery(c);
                    //c.sM("Lottery Has been Disabled.");
                    c.RemoveAllWindows();
                    c.NpcDialogueSend = false;
                } else  if (c.NpcDialogue == 186) {
                    c.NpcDialogue = 189;
                    c.NpcDialogueSend = false;
                } else if (c.NpcDialogue == 1921) {
                    c.NpcDialogue = 1922;
                    c.RemoveAllWindows();
                    c.NpcDialogueSend = false;
                } else if (c.NpcDialogue == 1973) {
                    c. NpcDialogue = 1974;
                    c.RemoveAllWindows();
                    c.NpcDialogueSend = false;
                } else if (c.NpcDialogue == 819) {
                    c.NpcDialogue = 820;
                    c.RemoveAllWindows();
                    c.NpcDialogueSend = false;
                }
                break;*/

            case 32029:
                if (c.Fishingspots) {
                    c.heightLevel = 0;
                    c.teleportToX = 2849;
                    c.teleportToY = 3436;
                    c.RemoveAllWindows();
                    c.Fishingspots = false;
                } else if (c.Trainingteleports) {
                    c.teleportToX = 3097;
                    c.teleportToY = 9869;
                    c.heightLevel = 0;
                    c.Trainingteleports = false;
                    c.RemoveAllWindows();
                } else if (c.Miningspots) {
                    c.teleportToX = 3229;
                    c.teleportToY = 3150;
                    c.heightLevel = 0;
                    c.Miningspots = false;
                    c.RemoveAllWindows();
                }
                break;

            case 32030:
                if (c.Fishingspots) {
                    c.heightLevel = 0;
                    c.teleportToX = 3105;
                    c.teleportToY = 3433;
                    c.RemoveAllWindows();
                    c.Fishingspots = false;
                } else if (c.Trainingteleports) {
                    c.teleportToX = 2713;
                    c.teleportToY = 9564;
                    c.heightLevel = 0;
                    c.Trainingteleports = false;
                    c.RemoveAllWindows();
                } else if (c.Miningspots) {
                    c.teleportToX = 3084;
                    c.teleportToY = 3417;
                    c.heightLevel = 0;
                    c.Miningspots = false;
                    c.RemoveAllWindows();
                }
                break;

            case 32031:
                if (c.Fishingspots) {
                    c.heightLevel = 0;
                    c.teleportToX = 2923;
                    c.teleportToY = 3172;
                    c.RemoveAllWindows();
                    c.Fishingspots = false;
                } else if (c.Trainingteleports) {
                    c.teleportToX = 2884;
                    c.teleportToY = 9799;
                    c.heightLevel = 0;
                    c.Trainingteleports = false;
                    c.RemoveAllWindows();
                } else if (c.Miningspots) {
                    c.teleportToX = 3185;
                    c.teleportToY = 3371;
                    c.heightLevel = 0;
                    c.Miningspots = false;
                    c.RemoveAllWindows();
                }
                break;
            case 32032:
                if (c.Fishingspots) {
                    c.heightLevel = 0;
                    c.teleportToX = 3243;
                    c.teleportToY = 3161;
                    c.RemoveAllWindows();
                    c.Fishingspots = false;
                } else if (c.Miningspots) {
                    c.teleportToX = 2976;
                    c.teleportToY = 3236;
                    c.heightLevel = 0;
                    c.Miningspots = false;
                    c.RemoveAllWindows();
                }
                break;
            case 32033:
                if (c.Fishingspots) {
                    c.heightLevel = 0;
                    c.teleportToX = 2595;
                    c.teleportToY = 3420;
                    c.RemoveAllWindows();
                    c.Fishingspots = false;
                } else if (c.Miningspots) {
                    c.teleportToX = 3044;
                    c.teleportToY = 9778;
                    c.heightLevel = 0;
                    c.Miningspots = false;
                    c.RemoveAllWindows();
                }
                break;
            case 1097:
                c.setSidebarInterface(0, 1829);
                break;

            case 7212:
                c.setSidebarInterface(0, 328);
                break;

            case 3162:
                c.InWildrange = true;
                break;

            case 3163:
                c.InWildrange = false;
                break;

            case 24135: // Clue debug set to on
            {
                c.sendMessage("Clue debugging set to true.");
                c.cluedebug = true;
                break;
            }

            case 24134: // Clue debug set to off
            {
                c.sendMessage("Clue debugging set to false.");
                c.cluedebug = false;
                break;
            }

        }
    }
}
