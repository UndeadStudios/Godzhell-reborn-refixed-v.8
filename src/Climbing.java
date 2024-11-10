/**
 * Climbing handles stairs, ladders
 * @author Andrew (Mr Extremez)
 */

public class Climbing {

    private static final int CLIMB_UP = 828, CLIMB_DOWN = CLIMB_UP;

    public static void handleClimbing(final client client, int objectID, int objectX, int objectY) {
        if (System.currentTimeMillis() - client.climbDelay < 1200) {
            return;
        }
        EventManager.getSingleton().addEvent(client, new Event() {
            @Override
            public void execute(EventContainer container) {
                processClimbing(client, objectID, objectX, objectY);
                container.stop();
            }

            @Override
            public void stop() {
                client.climbDelay = System.currentTimeMillis();
            }
        }, 1+600);
    }

    public static void processClimbing(client client, int objectID, int objectX, int objectY) {
        int chapionsGuildRequiredQP = Math.min(32, QuestAssistant.MAXIMUM_QUESTPOINTS);
        switch (objectID) {
            case 9584:
                if (objectX == 2932 && objectY == 3282) {
                    client.movePlayer(2933, 3282, 0);
                    client.resetWalkingQueue();
                }
                break;

            case 272:
                client.movePlayer(client.absX, client.absY, 1);
                client.resetWalkingQueue();
                break;


            case 273:
                client.movePlayer(client.absX, client.absY, 0);
                client.resetWalkingQueue();
                break;

            case 245:
                if (objectY == 3224) {
                    client.movePlayer(client.absX, client.absY+2, 2);
                    client.resetWalkingQueue();
                } else if (objectY == 3139 || objectX == 2835 || objectX == 2963) {
                    client.movePlayer(client.absX+2, client.absY, 2);
                    client.resetWalkingQueue();
                } else {
                    client.movePlayer(client.absX-2, client.absY, 2);
                    client.resetWalkingQueue();
                }
                break;
            case 246:
                if (objectY == 3224) {
                    client.movePlayer(client.absX, client.absY-2, 1);
                    client.resetWalkingQueue();
                } else if (objectY == 3139 || objectX == 2835 || objectX == 2963) {
                    client.movePlayer(client.absX-2, client.absY, 1);
                    client.resetWalkingQueue();
                } else {
                    client.movePlayer(client.absX+2, client.absY, 1);
                    client.resetWalkingQueue();
                }
                break;

            case 11888:
                if (client.absX == 2908 && client.absY == 3336) {
                    climbUp(client);
                    client.resetWalkingQueue();
                }
                break;

            case 4568:
                if (objectX == 2506 && objectY == 3640) {
                    climbUp(client);
                    client.resetWalkingQueue();
                }
                break;

            case 4569:
                if (objectX == 2506 && objectY == 3640) {
                    handleLadder(client);
                    client.resetWalkingQueue();
                }
                break;

            case 4570:
                if (objectX == 2506 && objectY == 3641) {
                    climbDown(client);
                    client.resetWalkingQueue();
                }
                break;

            case 11889:
                if (client.absX == 2908 && client.absY == 3336) {
                    handleLadder(client);
                    client.resetWalkingQueue();
                }
                break;

            case 11890:
                if (client.absX == 2908 && client.absY == 3336) {
                    climbDown(client);
                    client.resetWalkingQueue();
                }
                break;

            case 9582:
                if (objectX == 2931 && objectY == 3282) {
                    client.movePlayer(2933, 3282, 1);
                    client.resetWalkingQueue();
                }
                break;
            case 1722:
                if (objectX == 2590 && objectY == 3089 && client.heightLevel == 0 && client.absY == 3088) {
                    client.movePlayer(client.absX, 3092, 1);
                } else if (objectX == 2590 && objectY == 3089 && client.heightLevel == 0 && client.absY != 3088) {
                    return;
                }
                if (objectX == 3175 && objectY == 3420 && client.heightLevel == 0 && client.absX == 3177 && client.absX > 3418 && client.absX < 3425) {
                    return;
                } else if (client.absY == 3423) {
                    client.movePlayer(client.absX, 3419, 1);
                    client.resetWalkingQueue();
                }
                if (client.absX == 3098) {
                    client.movePlayer(3102, 3266, 1);
                    client.resetWalkingQueue();
                } else if (client.absY == 3445) {
                    client.movePlayer(3260, 3449, 1);
                    client.resetWalkingQueue();
                } else if (client.absY == 3358 && client.questPoints >= chapionsGuildRequiredQP) {
                    client.movePlayer(client.absX, 3354, 1);
                    client.resetWalkingQueue();
                } else if (client.absY == 3358 && client.questPoints < chapionsGuildRequiredQP) {
                    client.sendMessage("You need " + chapionsGuildRequiredQP + " quest points to use these stairs.");
                } else if (client.absX == 3180) {
                    client.movePlayer(3176, client.absY, 1);
                    client.resetWalkingQueue();
                } else if (client.absX == 3159) {
                    client.movePlayer(3155, 3435, 1);
                    client.resetWalkingQueue();
                } else if (client.absX == 2661) {
                    client.movePlayer(2665, client.absY, 1);
                    client.resetWalkingQueue();
                } else if (client.absY == 3083) {
                    client.movePlayer(client.absX, 3087, 2);
                    client.resetWalkingQueue();
                } else if (client.absY == 3298) {
                    client.movePlayer(client.absX, 3294, 1);
                    client.resetWalkingQueue();
                } else if (client.absY == 3472) {
                    client.movePlayer(client.absX, 3476, 1);
                    client.resetWalkingQueue();
                }
                break;

            case 1723:
                if (client.absX == 3102) {
                    client.movePlayer(3098, 3266, 0);
                    client.resetWalkingQueue();
                } else if (client.absY == 3354 && client.questPoints >= chapionsGuildRequiredQP) {
                    client.movePlayer(client.absX, 3358, 0);
                    client.resetWalkingQueue();
                } else if (client.absY == 3358 && client.questPoints < chapionsGuildRequiredQP) {
                    client.sendMessage("You need " + chapionsGuildRequiredQP + " quest points to use these stairs");
                } else if (client.absY == 3449) {
                    client.movePlayer(3259, 3445, 0);
                    client.resetWalkingQueue();
                } else if (client.absX == 3155) {
                    client.movePlayer(3159, 3435, 0);
                    client.resetWalkingQueue();
                } else if (client.absX == 2665) {
                    client.movePlayer(2661, client.absY, 0);
                    client.resetWalkingQueue();
                } else if (client.absY == 3092) {
                    client.movePlayer(client.absX, 3088, 0);
                    client.resetWalkingQueue();
                } else if (client.absY == 3087) {
                    client.movePlayer(client.absX, 3083, 1);
                    client.resetWalkingQueue();
                } else if (client.absY == 3419) {
                    client.movePlayer(client.absX, 3423, 0);
                    client.resetWalkingQueue();
                } else if (client.absX == 3176) {
                    client.movePlayer(3180, client.absY, 0);
                    client.resetWalkingQueue();
                } else if (client.absY == 3321) {
                    client.movePlayer(client.absX, 3325, 0);
                    client.resetWalkingQueue();
                } else if (client.absY == 3294) {
                    client.movePlayer(client.absX, 3298, 0);
                    client.resetWalkingQueue();
                } else if (client.absY == 3476) {
                    client.movePlayer(client.absX, 3472, 0);
                    client.resetWalkingQueue();
                }
                break;

            case 1733:
                if (objectX == 2569 && objectY == 3122) {
                    client.movePlayer(2569, 9525, 0);
                    client.resetWalkingQueue();
                } else if (client.absX == 3186) {
                    client.movePlayer(3190, 9834, 0);
                    client.resetWalkingQueue();
                } else if (objectX == 2603 && objectY == 3078) {
                   // client.feature("using this staircase");
                    client.resetWalkingQueue();
                } else if (client.absX != 3186) {
                    client.movePlayer(client.absX,
                            client.absY + 6393, 0);
                    client.resetWalkingQueue();
                }
                break;

            case 1734:
                if (objectX == 2569 && objectY == 9522) {
                    client.movePlayer(2569, 3121, 0);
                    client.resetWalkingQueue();
                } else if (client.absX == 3190) {
                    client.movePlayer(3186, 3434, 0);
                    client.resetWalkingQueue();
                } else if (objectX == 3059 && objectY == 9776) {
                    client.movePlayer(3061,
                            client.absY - 6400, 0);
                    client.resetWalkingQueue();
                } else if (client.absX != 3190) {
                    client.movePlayer(client.absX,
                            client.absY - 6396, 0);
                    client.resetWalkingQueue();
                }
                break;

            case 1737:
                if (client.absY == 3294) {
                    client.movePlayer(2661, 3291, 1);
                    client.resetWalkingQueue();
                } else if (client.absY == 3302) {
                    client.movePlayer(2648, 3301, 1);
                    client.resetWalkingQueue();
                } else if (client.absY == 3293) {
                    client.movePlayer(2649, 3296, 1);
                    client.resetWalkingQueue();
                }
                break;

            case 1736:
                if (client.absY == 3291) {
                    client.movePlayer(2662, 3294, 0);
                    client.resetWalkingQueue();
                } else if (client.absY == 3301) {
                    client.movePlayer(2645, 3302, 0);
                    client.resetWalkingQueue();
                } else if (client.absX == 2649) {
                    client.movePlayer(2648, 3293, 0);
                    client.resetWalkingQueue();
                }
                break;

            case 1742:
                if (objectX == 2445 && objectY == 3434) {
                    client.movePlayer(2445, 3433, 1);
                    client.startAnimation(CLIMB_UP);
                    client.resetWalkingQueue();
                } else if (objectX == 2444 && objectY == 3414) {
                    client.movePlayer(2445, 3416, 1);
                    client.startAnimation(CLIMB_UP);
                    client.resetWalkingQueue();
                } else if (objectX == 2455 && objectY == 3417) {
                    client.movePlayer(2457, 3417, 1);
                    client.startAnimation(CLIMB_UP);
                    client.resetWalkingQueue();
                } else if (objectX == 2461 && objectY == 3416) {
                    client.movePlayer(2460, 3417, 1);
                    client.startAnimation(CLIMB_UP);
                    client.resetWalkingQueue();
                } else if (objectX == 2440 && objectY == 3404) {
                    client.movePlayer(2440, 3403, 1);
                    client.startAnimation(CLIMB_UP);
                    client.resetWalkingQueue();
                }
                break;

            case 1744:
                if (objectX == 2445 && objectY == 3434) {
                    client.movePlayer(2445, 3433, 0);
                    client.startAnimation(CLIMB_DOWN);
                    client.resetWalkingQueue();
                } else if (objectX == 2444 || objectX == 2445
                        && objectY == 3415) {
                    client.movePlayer(2444, 3413, 0);
                    client.startAnimation(CLIMB_DOWN);
                    client.resetWalkingQueue();
                } else if (objectX == 2456 && objectY == 3417) {
                    client.movePlayer(2457, 3417, 0);
                    client.startAnimation(CLIMB_DOWN);
                    client.resetWalkingQueue();
                } else if (objectX == 2461 && objectY == 3417) {
                    client.movePlayer(2460, 3417, 0);
                    client.startAnimation(CLIMB_DOWN);
                    client.resetWalkingQueue();
                } else if (objectX == 2440 && objectY == 3404) {
                    client.movePlayer(2440, 3403, 0);
                    client.startAnimation(CLIMB_DOWN);
                    client.resetWalkingQueue();
                }
                break;
            case 7257:
                client.movePlayer(3044, 4973, 1);
                client.startAnimation(827);
                client.sendMessage("You climb down.");
                client.resetWalkingQueue();
                break;
            case 6279:
                if (client.playerHasItem(954, 1)) {
                    client.movePlayer(3206, 9379, 0);
                    client.startAnimation(827);
                    client.sendMessage("You climb down.");
                    client.resetWalkingQueue();
                } else {
                    client.sendMessage(
                            "You need a rope to enter.");
                    return;
                }
                break;

            case 6436:
                //UseOther.useUp(client, objectID);
                client.resetWalkingQueue();
                break;

            case 6434:
            case 5167:
               // UseOther.useDown(client, objectID);
                client.resetWalkingQueue();
                break;
            case 1767:
                if (objectX == 3069 && objectY == 3856) {
                  //  UseOther.useDown(client, objectID);
                    client.resetWalkingQueue();
                } else {
                    client.teleportToX = 2382;
                    client.teleportToY = 4679;
                    client.sendMessage("Welcome To The 2nd Level Of Training.");
                }
                break;
            case 6439:
                client.movePlayer(3309, 2963, 0);
                client.sendMessage("You climb up.");
                client.resetWalkingQueue();
                break;

            case 2408:
                if (client.playerLevel[5] > 0) {
                    client.playerLevel[5] = 0;
                }
                client.refreshSkill(5);
                client.sendMessage(
                        "Your prayer is drained as you enter the dungeon.");
                client.movePlayer(2823, 9771, 0);
                client.startAnimation(827);
                client.sendMessage("You climb down.");
                client.resetWalkingQueue();
                break;
            case 2147:
                client.movePlayer(3104, 9576, 0);
                client.startAnimation(827);
                client.sendMessage("You climb down.");
                client.resetWalkingQueue();
                break;
            case 2148:
                client.movePlayer(3103, 3162, 0);
                client.startAnimation(828);
                client.sendMessage("You climb up.");
                client.resetWalkingQueue();
                break;
            case 4383:
                client.movePlayer(2515, 10007, 0);
                client.startAnimation(827);
                client.sendMessage("You climb down.");
                client.resetWalkingQueue();
                break;
            case 5131:
                client.movePlayer(3549, 9865, 0);
                client.sendMessage("You climb down.");
                client.resetWalkingQueue();
                break;
            case 5130:
                client.movePlayer(3543, 3463, 0);
                client.sendMessage("You climb up.");
                client.resetWalkingQueue();
                break;
            case 4413:
                client.movePlayer(2510, 3644, 0);
                client.startAnimation(828);
                client.sendMessage("You climb up.");
                client.resetWalkingQueue();
                break;
            case 3432:
                client.movePlayer(3440, 9887, 0);
                client.resetWalkingQueue();
                break;
            case 34548:
        if (objectX == 2673 && objectY == 3300) {
            client.movePlayer(2675, 3300, 1);
            client.resetWalkingQueue();
        } else if (objectX == 3204 && objectY == 3207) {
            client.movePlayer(3205, 3209, 1);
            client.resetWalkingQueue();
        } else if (objectX == 2674 && objectY == 3299) {
            Climbing.climbUp(client);
            client.resetWalkingQueue();
        }
                break;
            case 24350:
         if (objectX == 3258 && objectY == 3487) {
             client.movePlayer(3257, 3487, 1);
             client.resetWalkingQueue();
         }
                break;
            case 24073:
       if (objectX == 3144 && objectY == 3447 && client.playerLevel[client.playerCooking] > 31 && client.playerEquipment[client.playerHat] == 1949) {
           client.movePlayer(3143, 3448, 1);
           client.resetWalkingQueue();
       }
                break;
            case 36776:
             if (objectX == 3204 && objectY == 3229) {
                 client.movePlayer(3205, 3228, 1);
                 client.resetWalkingQueue();
             }
             break;
            case 1738:
                 if (objectX == 2895 && objectY == 3513) {
                    client.movePlayer(2897, 3513, 1);
                    client.resetWalkingQueue();
                }
                break;
            case 3443:
                client.movePlayer(3423, 3485, 0);
                break;
            case 1754:
                if (objectX == 3116 && objectY == 3452) {
                    client.movePlayer(3222, 3218, 0);
                    client.startAnimation(CLIMB_DOWN);
                    client.resetWalkingQueue();
                }
                break;
            case 1755:
                if (objectX == 3116 && objectY == 9852) {
                    client.movePlayer(3116, 3451, 0);
                    client.startAnimation(CLIMB_UP);
                    client.resetWalkingQueue();
                } else if (objectX == 3097 && objectY == 9867) {
                    client.movePlayer(3096, 3468, 0);
                    client.startAnimation(CLIMB_UP);
                    client.resetWalkingQueue();
                } else if (objectX == 3237 && objectY == 9858) {
                    client.movePlayer(3238, 3458, 0);
                    client.startAnimation(CLIMB_UP);
                    client.resetWalkingQueue();
                } else if (objectX == 3088 && objectY == 9971) {
                    //UseOther.useUp(client, objectID);
                    client.resetWalkingQueue();
                    // client.startAnimation(CLIMB_UP);
                } else if (objectX == 3209 && objectY == 9616) {
                    // OtherObjects.useUp(client, objectID);
                    client.movePlayer(3209, 3215, 0);
                    client.startAnimation(CLIMB_UP);
                    client.resetWalkingQueue();
                    client.sendMessage("You climb up.");
                } else if (objectX == 3019 && objectY == 9740) {// noord
                    client.movePlayer(3019, 3341, 0);
                    client.startAnimation(CLIMB_UP);
                    client.resetWalkingQueue();
                } else if (objectX == 3020 && objectY == 9739) {// oost
                    client.movePlayer(3021, 3339, 0);
                    client.startAnimation(CLIMB_UP);
                    client.resetWalkingQueue();
                } else if (objectX == 3018 && objectY == 9739) {// wst
                    client.movePlayer(3017, 3339, 0);
                    client.startAnimation(CLIMB_UP);
                    client.resetWalkingQueue();
                } else if (objectX == 3019 && objectY == 9738) {// zuid
                    client.movePlayer(3019, 3337, 0);
                    client.startAnimation(CLIMB_UP);
                    client.resetWalkingQueue();
                } else {
                    //UseOther.useUp(client, objectID);
                }
                break;

            case 2405:
                //UseOther.useUp(client, objectID);
                client.resetWalkingQueue();
                break;

            case 98:
                if (client.nonWild()) {
                    return;
                }
               /* if (!LightSources.playerHasLightSource(client)) {
                    client.movePlayer(2641, 9740, 0);
                    client.resetWalkingQueue();
                    return;
                } else if (LightSources.playerHasLightSource(client)) {
                    client.movePlayer(2641, 9764, 0);
                    client.resetWalkingQueue();
                    return;
                }*/
                break;

            case 96:
                if (client.nonWild()) {
                    return;
                }
              //  LightSources.brightness3(client);
                client.movePlayer(2649, 9804, 0);
                client.resetWalkingQueue();
                break;

            case 2711:
                if (client.absY == 3325) {
                    client.movePlayer(client.absX, 3321, 1);
                    client.resetWalkingQueue();
                }
                break;

            case 4755:
                if (client.absY == 2797) {
                    client.movePlayer(client.absX, 2793, 0);
                    client.resetWalkingQueue();
                }
                break;

            case 4756:
                if (client.absY == 2793) {
                    client.movePlayer(client.absX, 2797, 1);
                    client.resetWalkingQueue();
                }
                break;

            case 4879:
                client.movePlayer(2807, 9200, 0);
                client.sendMessage(
                        "You go down the trapdoor.");
                client.startAnimation(827);
                client.RemoveAllWindows();
                client.resetWalkingQueue();
                break;

            case 5492:
                if (client.playerHasItem(1523, 1)
                        && misc.random(4) < 3) {
                    client.movePlayer(3149, 9652, 0);
                    client.sendMessage(
                            "You go down the trapdoor.");
                    client.startAnimation(827);
                    client.addSkillXP(.5,
                            client.playerThieving);
                    client.RemoveAllWindows();
                } else if (!client.playerHasItem(1523, 1)
                        && misc.random(5) < 2) {
                    client.movePlayer(3149, 9652, 0);
                    client.sendMessage(
                            "You go down the trapdoor.");
                    client.startAnimation(827);
                    client.addSkillXP(.5,
                            client.playerThieving);
                    client.RemoveAllWindows();
                    client.resetWalkingQueue();
                } else if (client.playerHasItem(1523, 1)
                        && misc.random(4) > 3) {
                    client.sendMessage(
                            "You fail to pick the lock.");
                    client
                            .sendMessage(
                                    "Your thieving has been drained, your fingers feel numb.");
                    client.playerLevel[17] = client
                            .getLevelForXP(client.playerXP[17]) - 1;
                    client.refreshSkill(17);
                    client.deleteItem(1523, 1);
                } else if (!client.playerHasItem(1523, 1)
                        && misc.random(5) > 2) {
                    client.sendMessage(
                            "You fail to pick the lock.");
                    client
                            .sendMessage(
                                    "Your thieving has been drained, your fingers feel numb.");
                    client.playerLevel[17] = client
                            .getLevelForXP(client.playerXP[17]) - 1;
                    client.refreshSkill(17);
                }
                break;

            case 6278:
                if (objectX == 2637 && objectY == 3408) {
                    //UseOther.useDown(client, 6278);
                }
                break;

            case 11724:
                if (client.absX == 2971) {
                    client.movePlayer(2968, 3348, 1);
                    client.resetWalkingQueue();
                }
                break;

            case 11725:
                if (client.absY == 3348) {
                    client.movePlayer(2971, 3347, 0);
                    client.resetWalkingQueue();
                }
                break;

            case 1725:
                if (client.absY == 3376) {
                    client.movePlayer(client.absX, 3380, 1);
                    client.resetWalkingQueue();
                } else if (client.absX == 3285 || client.absX == 3286 && client.heightLevel == 0) {
                    client.movePlayer(client.absX, 3492, 1);
                    client.resetWalkingQueue();
                } else if (client.absY == 3509) {
                    client.movePlayer(2751, 3513, 1);
                    client.resetWalkingQueue();
                } else if (client.absX == 3226) {
                    client.movePlayer(3230, 3394, 1);
                    client.resetWalkingQueue();
                }
                break;

            case 5096:
                client.movePlayer(2649, 9591, 0);
                client.resetWalkingQueue();
                break;

            case 1726:
                if (client.absY == 3380 ) {
                    client.movePlayer(client.absX, 3376, 0);
                    client.resetWalkingQueue();
                } else if (client.absY == 3513) {
                    client.movePlayer(2751, 3509, 0);
                    client.resetWalkingQueue();
                } else if (client.absX == 3230) {
                    client.movePlayer(3226, 3394, 0);
                    client.resetWalkingQueue();
                } else if (client.absX == 3285 || client.absX == 3286
                        && client.heightLevel == 1) {
                    client.movePlayer(client.absX, 3496, 0);
                    client.resetWalkingQueue();
                }
                break;

            case 11727:
                if (client.absY == 3350 || client.absY == 3351
                        || client.absY == 3340 || client.absY == 3341
                        || client.absY == 3342) {
                    climbUp(client);
                    client.resetWalkingQueue();
                }
                break;

            case 11728:
                if (client.absY == 3350 || client.absY == 3351
                        || client.absY == 3340 || client.absY == 3341
                        || client.absY == 3342) {
                    climbDown(client);
                    client.resetWalkingQueue();
                }
                break;

            case 11729:
                if (objectX == 2954 && objectY == 3338) {
                    client.movePlayer(2956, 3338, 1);
                    client.resetWalkingQueue();
                } else if (objectX == 2960 && objectY == 3338) {
                    client.movePlayer(2959, 3339, 2);
                    client.resetWalkingQueue();
                } else if (objectX == 2957 && objectY == 3338) {
                    client.movePlayer(2959, 3338, 3);
                    client.resetWalkingQueue();
                }
                break;

            case 11731:
                if (objectX == 2955 && objectY == 3338) {
                    client.movePlayer(2956, 3338, 0);
                } else if (objectX == 2960 && objectY == 3339) {
                    client.movePlayer(2959, 3338, 1);
                } else if (objectX == 2958 && objectY == 3338) {
                    client.movePlayer(2957, 3337, 2);
                }
                break;

            case 11732:
                if (objectX == 3034 && objectY == 3363) {
                    client.movePlayer(3036, 3363, 1);
                } else if (objectX == 3048 && objectY == 3352) {
                    client.movePlayer(3049, 3354, 1);
                }
                break;

            case 11733:
                if (objectX == 3035 && objectY == 3363) {
                    client.movePlayer(3036, 3362, 0);
                } else if (objectX == 3049 && objectY == 3353) {
                    client.movePlayer(3049, 3354, 0);
                }
                break;

            case 11734:
                if (client.absY == 3336) {
                    client.movePlayer(2984, 3340, 2);
                } else if (client.absY == 3380) {
                    client.movePlayer(client.absX, 3384, 1);
                }
                break;

            case 11735:
                if (client.absY == 3340) {
                    client.movePlayer(2984, 3336, 1);
                } else if (client.absY == 3384) {
                    client.movePlayer(client.absX, 3380, 0);
                }
                break;

            case 11736:
                if (client.absY == 3368) {
                    client.movePlayer(client.absX, 3372, 1);
                } else if (client.absY == 3362) {
                    client.movePlayer(client.absX, 3366, 1);
                }
                break;

            case 11737:
                if (client.absY == 3366) {
                    client.movePlayer(client.absX, 3362, 0);
                } else {
                    client.movePlayer(client.absX, 3368, 0);
                }
                break;

            case 12266:
                if (objectX == 3077 && objectY == 3493) {
                    client.movePlayer(3077, 9893, 0);
                    client.startAnimation(827);
                    client.resetWalkingQueue();
                    client.sendMessage("You climb down.");
                }
                break;

            case 12265:
                if (objectX == 3076 && objectY == 9893) {
                    client.movePlayer(3078, 3493, 0);
                    client.startAnimation(828);
                    client.resetWalkingQueue();
                    client.sendMessage("You climb up.");
                }
                break;
        }
    }

    public static void climbUp(client player) {
        if (System.currentTimeMillis() - player.climbDelay < 1200) {
            return;
        }

        switch (player.heightLevel) {
            case -1:
                player.movePlayer(player.absX, player.absY, 0);
                player.climbDelay = System.currentTimeMillis();
                player.sendMessage("You climb up.");
                player.startAnimation(CLIMB_UP);
                player.resetWalkingQueue();
                player.RemoveAllWindows();
                break;
            case 0:
                player.movePlayer(player.absX, player.absY, 1);
                player.climbDelay = System.currentTimeMillis();
                player.sendMessage("You climb up.");
                player.startAnimation(CLIMB_UP);
                player.resetWalkingQueue();
                player.RemoveAllWindows();
                break;
            case 1:
                player.movePlayer(player.absX, player.absY, 2);
                player.climbDelay = System.currentTimeMillis();
                player.sendMessage("You climb up.");
                player.startAnimation(CLIMB_UP);
                player.resetWalkingQueue();
                player.RemoveAllWindows();
                break;
            case 2:
                player.movePlayer(player.absX, player.absY, 3);
                player.climbDelay = System.currentTimeMillis();
                player.sendMessage("You climb up.");
                player.startAnimation(CLIMB_UP);
                player.resetWalkingQueue();
                player.RemoveAllWindows();
                break;
            default:
                if (player.heightLevel > 3) {
                    climbDown(player);
                    player.resetWalkingQueue();
                }
                player.sendMessage("This object is currently not supported.");
                System.out.println("Bug detected with climbing up object " + player.objectId + " objectX " + player.objectX + " objectY " + player.objectY + ".");
                break;
        }
    }

    public static void climbDown(client player) {
        if (System.currentTimeMillis() - player.climbDelay < 1200) {
            return;
        }
        if (player.heightLevel > 3) {
            player.movePlayer(player.absX, player.absY, 3);
            player.climbDelay = System.currentTimeMillis();
            player.sendMessage("You climb down.");
            player.startAnimation(CLIMB_DOWN);
            player.resetWalkingQueue();
            player.RemoveAllWindows();
        }
        switch (player.heightLevel) {
            case 1:
                player.movePlayer(player.absX, player.absY, 0);
                player.climbDelay = System.currentTimeMillis();
                player.sendMessage("You climb down.");
                player.startAnimation(CLIMB_DOWN);
                player.resetWalkingQueue();
                player.RemoveAllWindows();
                break;
            case 2:
                player.movePlayer(player.absX, player.absY, 1);
                player.climbDelay = System.currentTimeMillis();
                player.sendMessage("You climb down.");
                player.startAnimation(CLIMB_DOWN);
                player.resetWalkingQueue();
                player.RemoveAllWindows();
                break;
            case 3:
                player.movePlayer(player.absX, player.absY, 2);
                player.climbDelay = System.currentTimeMillis();
                player.sendMessage("You climb down.");
                player.startAnimation(CLIMB_DOWN);
                player.resetWalkingQueue();
                player.RemoveAllWindows();
                break;
            default:
                if (player.heightLevel < 0) {
                    climbUp(player);
                }
                player.sendMessage("This object is currently not supported.");
                System.out.println("Bug detected with climbing down object " + player.objectId + " objectX " + player.objectX + " objectY " + player.objectY + ".");
                break;
        }
    }

    public static void handleLadder(client player) {
       // player.getDialogueHandler().sendOption("Climb Up.", "Climb Down.");
        //player.dialogueAction = 147;
    }

    private static void close(client client, int actionButtonId) {
        if (actionButtonId == 9157) {
            client.sendMessage("You climb up.");
            client.startAnimation(CLIMB_UP);
            client.resetWalkingQueue();
        } else if (actionButtonId == 9158) {
            client.sendMessage("You climb down.");
            client.startAnimation(827);
            client.resetWalkingQueue();
        }
        client.RemoveAllWindows();
       // client.nextChat = 0;
    }

    public static void handleLadderButtons(client client, int actionButtonId) {
        switch (actionButtonId) {
            case 9157:
                if (client.heightLevel == 1) {
                    client.movePlayer(client.absX, client.absY, 2);
                    close(client, actionButtonId);
                } else if (client.heightLevel == 2) {
                    client.movePlayer(client.absX, client.absY, 3);
                    close(client, actionButtonId);
                }
                break;
            case 9158:
                if (client.heightLevel == 2) {
                    client.movePlayer(client.absX, client.absY, 1);
                    close(client, actionButtonId);
                } else if (client.heightLevel == 1) {
                    client.movePlayer(client.absX, client.absY, 0);
                    close(client, actionButtonId);
                }
                break;
        }
    }
}