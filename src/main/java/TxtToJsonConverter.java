import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Arrays;
import java.util.Optional;

public class TxtToJsonConverter {

    public static void main(String[] args) {
        String inputDir = "./Data/characters_txt/"; // Directory where old .txt files are stored
        String outputDir = "./Data/characters/"; // Directory for converted JSON files

        File dir = new File(inputDir);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Input directory not found.");
            return;
        }

        // Create the output directory if it doesn't exist
        File outDir = new File(outputDir);
        if (!outDir.exists()) {
            outDir.mkdirs();
        }

        for (File file : dir.listFiles((d, name) -> name.endsWith(".txt"))) {
            String playerName = file.getName().replace(".txt", "");
            PlayerData playerData = readOldTxtFile(file, playerName);
            if (playerData != null) {
                saveAsJson(playerData, outputDir + playerName + ".json");
            }
        }
    }

    public static PlayerData readOldTxtFile(File file, String playerName) {
        PlayerData playerData = new PlayerData();
        if (playerData.getPlayerEquipment() == null) {
            playerData.setPlayerEquipment(new int[14]); // Adjust size as needed
        }
        if (playerData.getPlayerEquipmentN() == null) {
            playerData.setPlayerEquipmentN(new int[14]); // Adjust size as needed
        }
        if (playerData.getPlayerAppearance() == null) {
            playerData.setPlayerAppearance(new int[13]); // Adjust size as needed
        }
        if (playerData.getPlayerColor() == null) {
            playerData.setPlayerColor(new int[5]); // Adjust size as needed
        }
        if (playerData.getPlayerLevel() == null) {
            playerData.setPlayerLevel(new int[25]); // Adjust size as needed
        }
        if (playerData.getPlayerXP() == null) {
            playerData.setPlayerXP(new int[25]); // Adjust size as needed
        }
        if (playerData.getPlayerItems() == null) {
            playerData.setPlayerItems(new int[28]); // Adjust size as needed
            Arrays.fill(playerData.getPlayerItems(), -1);
        }
        if (playerData.getPlayerItemsN() == null) {
            playerData.setPlayerItemsN(new int[28]); // Adjust size as needed
        }
        if (playerData.getBankItems() == null) {
            playerData.setBankItems(new int[352]); // Adjust size as needed
            Arrays.fill(playerData.getBankItems(), -1);
        }
        if (playerData.getBankItemsN() == null) {
            playerData.setBankItemsN(new int[352]); // Adjust size as needed
        }
        if (playerData.getBankItems2() == null) {
            playerData.setBankItems2(new int[352]); // Adjust size as needed
            Arrays.fill(playerData.getBankItems2(), -1);
        }
        if (playerData.getBankItemsN2() == null) {
            playerData.setBankItemsN2(new int[352]); // Adjust size as needed
        }
        if (playerData.getBankItems3() == null) {
            playerData.setBankItems3(new int[352]); // Adjust size as needed
            Arrays.fill(playerData.getBankItems3(), -1);
        }
        if (playerData.getBankItemsN3() == null) {
            playerData.setBankItemsN3(new int[352]); // Adjust size as needed
        }
        if (playerData.getFriends() == null) {
            playerData.setFriends(new long[200]); // Adjust size as needed
        }
        if (playerData.getIgnores() == null) {
            playerData.setIgnores(new long[100]); // Adjust size as needed
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int readMode = 0;
            String[] token3;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                int spot = line.indexOf("=");

                if (line.equals("[ACCOUNT]")) {
                    readMode = 1;
                    continue;
                } else if (line.equals("[CHARACTER]")) {
                    readMode = 2;
                    continue;
                } else if (line.equals("[EQUIPMENT]")) {
                    readMode = 3;
                    continue;
                } else if (line.equals("[LOOK]")) {
                    readMode = 4;
                    continue;
                } else if (line.equals("[COLOR]")) {
                    readMode = 5;
                    continue;
                } else if (line.equals("[SKILLS]")) {
                    readMode = 6;
                    continue;
                } else if (line.equals("[ITEMS]")) {
                    readMode = 7;
                    continue;
                } else if (line.equals("[BANK]")) {
                    readMode = 8;
                    continue;
                } else if (line.equals("[BANK2]")) {
                    readMode = 9;
                    continue;
                } else if (line.equals("[BANK3]")) {
                    readMode = 10;
                    continue;
                } else if (line.equals("[FRIENDS]")) {
                    readMode = 11;
                    continue;
                } else if (line.equals("[IGNORES]")) {
                    readMode = 12;
                    continue;
                } else if (line.equals("[EOF]")) {
                    break;
                }

                if (spot > -1) {
                    String token = line.substring(0, spot).trim();
                    String token2 = line.substring(spot + 1).trim();
                    token3 = token2.split("\t");

                    switch (readMode) {
                        case 1: // Account section
                            if (token.equals("character-username")) {
                                playerData.setUsername(token2);
                            } else if (token.equals("character-password")) {
                                playerData.setPassword(token2);
                            }
                            break;

                        case 2: // Character section
                            if (token.equals("displayName")) {
                                playerData.setDisplayName(token2);
                            } else if (token.equals("character-height")) {
                                playerData.setHeightLevel(Integer.parseInt(token2));
                            } else if (token.equals("character-posx")) {
                                playerData.setAbsX(Integer.parseInt(token2));
                            } else if (token.equals("character-posy")) {
                                playerData.setAbsY(Integer.parseInt(token2));
                            } else if (token.equals("character-rights")) {
                                playerData.setRights(Integer.parseInt(token2));
                            } else if (token.equals("run-energy")) {
                                playerData.setRunEnergy(Integer.parseInt(token2));
                            } else if (token.equals("isRunning2")) {
                                playerData.setRunningToggled(Boolean.parseBoolean(token2));
                            } else if (token.equals("days")) {
                                playerData.setDaysPlayed(Long.parseLong(token2));
                            } else if (token.equals("hours")) {
                                playerData.setHoursPlayed(Long.parseLong(token2));
                            } else if (token.equals("minutes")) {
                                playerData.setMinutesPlayed(Long.parseLong(token2));
                            } else if (token.equals("seconds")) {
                                playerData.setSecondsPlayed(Double.parseDouble(token2));
                            } else if (token.equals("amDonated")) {
                                playerData.setAmDonated(Integer.parseInt(token2));
                            } else if (token.equals("hasfirstfloorDone")) {
                                playerData.setHasFirstFloorDone(Boolean.parseBoolean(token2));
                            } else if (token.equals("hassecoundfloorDone")) {
                                playerData.setHasSecondFloorDone(Boolean.parseBoolean(token2));
                            } else if (token.equals("hasthirdfloorDone")) {
                                playerData.setHasThirdFloorDone(Boolean.parseBoolean(token2));
                            } else if (token.equals("hasfourthfloorDone")) {
                                playerData.setHasFourthFloorDone(Boolean.parseBoolean(token2));
                            } else if (token.equals("skull-timer")) {
                                playerData.setSkullTimer(Integer.parseInt(token2));
                            } else if (token.equals("character-ismember")) {
                                playerData.setPlayerIsMember(Integer.parseInt(token2));
                            } else if (token.equals("character-isdonated")) {
                                playerData.setPlayerHasDonated(Integer.parseInt(token2));
                            } else if (token.equals("character-isjailed")) {
                                playerData.setJailed(Integer.parseInt(token2));
                            } else if (token.equals("character-messages")) {
                                playerData.setPlayerMessages(Integer.parseInt(token2));
                            } else if (token.equals("character-lastconnection")) {
                                playerData.setPlayerLastConnect(token2);
                            } else if (token.equals("character-uid")) {
                                playerData.setPlayerUID(Integer.parseInt(token2));
                            } else if (token.equals("character-mac-address")) {
                                playerData.setMacAddress(token2);
                            } else if (token.equals("character-uuid")) {
                                playerData.setUuid(token2);
                            } else if (token.equals("character-countryCode")) {
                                playerData.setCountryCode(token2);
                            } else if (token.equals("character-lastlogin")) {
                                playerData.setPlayerLastLogin(Integer.parseInt(token2));
                            } else if (token.equals("character-energy")) {
                                playerData.setPlayerEnergy(Integer.parseInt(token2));
                            } else if (token.equals("character-gametime")) {
                                playerData.setPlayerGameTime(Integer.parseInt(token2));
                            } else if (token.equals("character-gamecount")) {
                                playerData.setPlayerGameCount(Integer.parseInt(token2));
                            } else if (token.equals("character-loyaltyRank")) {
                                playerData.setLoyaltyRank(Integer.parseInt(token2));
                            } else if (token.equals("character-prestigeLevel")) {
                                playerData.setPrestigeLevel(Integer.parseInt(token2));
                            } else if (token.equals("slayer-task")) {
                                // Retrieve the SlayerTask using the token2 value, which could be a task name or ID
                                Optional<SlayerTask> task = SlayerMaster.get(token2);
                                playerData.setSlayerTask(task);
                            } else if (token.equals("slayer-master")) {
                                playerData.setSlayerMaster(Integer.parseInt(token2));
                            } else if (token.equals("slayer-task-amount")) {
                                playerData.setSlayerTaskAmount(Integer.parseInt(token2));
                            } else if (token.equals("slayer-points")) {
                                playerData.setSlayerPoints(Integer.parseInt(token2));
                            } else if (token.equals("slayer-recipe")) {
                                playerData.setSlayerRecipe(Boolean.parseBoolean(token2));
                            } else if (token.equals("slayer-helmet")) {
                                playerData.setSlayerHelmet(Boolean.parseBoolean(token2));
                            } else if (token.equals("slayer-imbued-helmet")) {
                                playerData.setSlayerImbuedHelmet(Boolean.parseBoolean(token2));
                            } else if (token.equals("bigger-boss-tasks")) {
                                playerData.setBiggerBossTasks(Boolean.parseBoolean(token2));
                            } else if (token.equals("cerberus-route")) {
                                playerData.setCerberusRoute(Boolean.parseBoolean(token2));
                            } else if (token.equals("superior-slayer")) {
                                playerData.setSuperiorSlayer(Boolean.parseBoolean(token2));
                            }
                            break;

                        case 3: // Equipment section
                            if (token.equals("character-equip")) {
                                int index = Integer.parseInt(token3[0]);
                                int itemId = Integer.parseInt(token3[1]);
                                int itemAmount = Integer.parseInt(token3[2]);

                                // Ensure no invalid index access
                                if (index >= 0 && index < playerData.getPlayerEquipment().length) {
                                    playerData.getPlayerEquipment()[index] = itemId;
                                    playerData.getPlayerEquipmentN()[index] = itemAmount;
                                }
                            }
                            break;

                        case 4: // Look section
                            if (token.equals("character-look")) {
                                int index = Integer.parseInt(token3[0]);
                                int lookValue = Integer.parseInt(token3[1]);
                                if (index >= 0 && index < playerData.getPlayerAppearance().length) {
                                    playerData.getPlayerAppearance()[index] = lookValue;
                                }
                            }
                            break;

                        case 5: // Color section
                            if (token.equals("character-color")) {
                                int index = Integer.parseInt(token3[0]);
                                int colorValue = Integer.parseInt(token3[1]);
                                if (index >= 0 && index < playerData.getPlayerColor().length) {
                                    playerData.getPlayerColor()[index] = colorValue;
                                }
                            }
                            break;

                        case 6: // Skills section
                            if (token.equals("character-skill")) {
                                int index = Integer.parseInt(token3[0]);
                                int skillLevel = Integer.parseInt(token3[1]);
                                int skillXP = Integer.parseInt(token3[2]);
                                if (index >= 0 && index < playerData.getPlayerLevel().length) {
                                    playerData.getPlayerLevel()[index] = skillLevel;
                                    playerData.getPlayerXP()[index] = skillXP;
                                }
                            }
                            break;

                        case 7: // Items section
                            if (token.equals("character-item")) {
                                int index = Integer.parseInt(token3[0]);
                                int itemId = Integer.parseInt(token3[1]);
                                int itemAmount = Integer.parseInt(token3[2]);
                                if (index >= 0 && index < playerData.getPlayerItems().length) {
                                    playerData.getPlayerItems()[index] = itemId;
                                    playerData.getPlayerItemsN()[index] = itemAmount;
                                }
                            }
                            break;

                        case 8: // Bank section
                            if (token.equals("character-bank")) {
                                int index = Integer.parseInt(token3[0]);
                                int itemId = Integer.parseInt(token3[1]);
                                int itemAmount = Integer.parseInt(token3[2]);
                                if (index >= 0 && index < playerData.getBankItems().length) {
                                    playerData.getBankItems()[index] = itemId;
                                    playerData.getBankItemsN()[index] = itemAmount;
                                }
                            }
                            break;

                        case 9: // Bank2 section
                            if (token.equals("character-bank2")) {
                                int index = Integer.parseInt(token3[0]);
                                int itemId = Integer.parseInt(token3[1]);
                                int itemAmount = Integer.parseInt(token3[2]);
                                if (index >= 0 && index < playerData.getBankItems2().length) {
                                    playerData.getBankItems2()[index] = itemId;
                                    playerData.getBankItemsN2()[index] = itemAmount;
                                }
                            }
                            break;

                        case 10: // Bank3 section
                            if (token.equals("character-bank3")) {
                                int index = Integer.parseInt(token3[0]);
                                int itemId = Integer.parseInt(token3[1]);
                                int itemAmount = Integer.parseInt(token3[2]);
                                if (index >= 0 && index < playerData.getBankItems3().length) {
                                    playerData.getBankItems3()[index] = itemId;
                                    playerData.getBankItemsN3()[index] = itemAmount;
                                }
                            }
                            break;

                        case 11: // Friends section
                            if (token.equals("character-friend")) {
                                int index = Integer.parseInt(token3[0]);
                                long friendId = Long.parseLong(token3[1]);
                                if (index >= 0 && index < playerData.getFriends().length) {
                                    playerData.getFriends()[index] = friendId;
                                }
                            }
                            break;

                        case 12: // Ignores section
                            if (token.equals("character-ignore")) {
                                int index = Integer.parseInt(token3[0]);
                                long ignoreId = Long.parseLong(token3[1]);
                                if (index >= 0 && index < playerData.getIgnores().length) {
                                    playerData.getIgnores()[index] = ignoreId;
                                }
                            }
                            break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + file.getName());
            return null;
        }
        return playerData;
    }

    private static void saveAsJson(PlayerData playerData, String outputPath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(outputPath)) {
            gson.toJson(playerData, writer);
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + outputPath);
        }
    }
}
