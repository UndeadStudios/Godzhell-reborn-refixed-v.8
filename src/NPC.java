public class NPC {
    public final int[][] fearShadow = new int[100][100];
    public final int[][] CONTAIN_THIS = new int[2][2];
    public boolean faceUpdateRequired;
    public int face;
    public int npcId;
    public int prayerUsed = 0;
    public int extraHitDelay = 0, glod, deadCyle = 1;
    public int diliHits = 30, nexStage = 0, cooldown = 0, mustDie = 0;
    /**
     * Face
     */
    //public int FocusPointX = -1, FocusPointY = -1;
    //public int face = 0;
    public int npcType;
    public boolean fighting = false;
    public int focusPointX, focusPointY;
    public int hitDiff2 = 0;
    public boolean hitUpdateRequired2;
    public int PoisonDelay = 999999;
    public int PoisonClear = 0;
    public int absX, absY;
    public int heightLevel;
    public boolean FaceDirection;
    public int FocusPointX;
    public int FocusPointY;
    public int makeX, makeY, moverangeX1, moverangeY1, moverangeX2, moverangeY2, moveX, moveY, direction, walkingType, attacknpc, followPlayer;
    public int spawnX, spawnY;
    public int viewX, viewY;
    public boolean walkingHome, underAttack;
    public int HP, MaxHP, hitDiff, MaxHit, animNumber, actionTimer, StartKilling, enemyX, enemyY;
    public boolean IsDead, DeadApply, NeedRespawn, IsUnderAttack, IsClose, Respawns, IsUnderAttackNpc, IsAttackingNPC, poisondmg, walkingToPlayer, followingPlayer;
    public int[] Killing = new int[PlayerHandler.maxPlayers];
    public boolean RandomWalk;
    public boolean dirUpdateRequired;
    public boolean animUpdateRequired;
    public boolean hitUpdateRequired;
    public boolean updateRequired;
    public boolean textUpdateRequired;
    public boolean faceToUpdateRequired;
    public boolean attackable = true;
    public String textUpdate;
    public int spawnedBy;
    public int Killes;
    public int endGfx;
    public int freezeTimer, killerId;
    public long lastDamageTaken;
    public int underAttackBy;
    public int attackTimer;
    public boolean summoner;
    public int summonedBy;
    public int hitDelayTimer;
    public int attackType;
    public int projectileId;
    public int oldIndex;
    public int attack;
    public int killedBy;
    public int lastX;
    public int lastY;
    public boolean randomWalk;
    int npcSize;
    private Tile currentTile;
    private boolean transformUpdateRequired = false;
    public int transformId;
    private boolean gfxUpdateRequired = false;
    private boolean faceEntityUpdateRequired = false, isTransformed = false;
    private boolean forceMovementUpdateRequired;
    private long lastRandomWalk;
    private long lastRandomWalkHome;

    private long randomWalkDelay;
    private long randomStopDelay;
    private boolean teleporting;

    public NPC(int _npcId, int _npcType) {
        npcId = _npcId;
        npcType = _npcType;
        direction = -1;
        IsDead = false;
        DeadApply = false;
        actionTimer = 0;
        RandomWalk = true;
        StartKilling = 0;
        IsUnderAttack = false;
        IsClose = false;
        for (int i = 0; i < Killing.length; i++) {
            Killing[i] = 0;
        }
    }
    public long getLastRandomWalk() {
        return lastRandomWalk;
    }

    public long getLastRandomWalkhome() {
        return lastRandomWalkHome;
    }

    public void setLastRandomWalkHome(long lastRandomWalkHome) {
        this.lastRandomWalkHome = lastRandomWalkHome;
    }
    public long getRandomWalkDelay() {
        return randomWalkDelay;
    }
    /**
     * Teleport
     * @param x
     * @param y
     * @param z
     */
    public void teleport(int x, int y, int z) {
        teleporting = true;
        absX = x;
        absY = y;
        heightLevel = z;
    }
    public void setRandomWalkDelay(long randomWalkDelay) {
        this.randomWalkDelay = randomWalkDelay;
    }
    public void faceplayer(int i) {
        face = i + 32768;
        faceEntityUpdateRequired = true;
        updateRequired = true;
    }

    public void updateface(stream stream1) {
        stream1.writeWord(face);
    }

    public int getNPCSize() {
        return NPCSize.getNPCSize(npcType);
    }

    public String Glod() {
        int talk = misc.random(2);
        switch (talk) {
            case 1:
                return "Glod Angry!";
            case 2:
                return "Glod Bash!";
        }
        return "Glod Smash!";
    }

    public void updateNPCMovement(stream str) {
        if (direction == -1) {
            // don't have to update the npc position, because the npc is just standing
            if (updateRequired) {
                // tell client there's an update block appended at the end
                str.writeBits(1, 1);
                str.writeBits(2, 0);
            } else {
                str.writeBits(1, 0);
            }
        } else {
            // send "walking packet"
            str.writeBits(1, 1);
            str.writeBits(2, 1);        // updateType
            str.writeBits(3, misc.xlateDirectionToClient[direction]);
            if (updateRequired) {
                str.writeBits(1, 1);        // tell client there's an update block appended at the end
            } else {
                str.writeBits(1, 0);
            }
        }
    }

    public void forceChat(String text) {
        textUpdate = text;
        textUpdateRequired = true;
        updateRequired = true;
    }

    public void faceNPC(int i) {
        face = i;
        faceEntityUpdateRequired = true;
        updateRequired = true;
    }

    public void facePlayer(int player) {
        face = player + 32768;
        faceEntityUpdateRequired = true;
        updateRequired = true;
    }

    public boolean animals() {
        switch (npcType) {
            case 5103:
            case 5104:
            case 5105:
                return true;
            default:
                return false;
        }
    }

    public void gethurt(int amount) {
        if (hitUpdateRequired && !hitUpdateRequired2) {
            hitUpdateRequired = true;
            hitDiff2 = amount;
        }
        if (!hitUpdateRequired) {
            hitUpdateRequired = true;
            hitDiff = amount;
        }
        updateRequired = true;
        HP -= amount;
    }

    public int getKiller() {
        int Killer = 0;
        int Count = 0;
        for (int i = 1; i < PlayerHandler.maxPlayers; i++) {
            if (false) {
                Killer = i;
                Count = 1;
            } else {
                if (Killing[i] > Killing[Killer]) {
                    Killer = i;
                    Count = 1;
                } else if (Killing[i] == Killing[Killer]) {
                    Count++;
                }
            }
        }
        return Killer;
    }
    public void shearSheep(client player, int itemNeeded, int itemGiven, int animation, final int currentId, final int newId, int transformTime) {
        if (!player.playerHasItem(itemNeeded)) {
            player.sendMessage("You need " + Item.getItemName(itemNeeded).toLowerCase() + " to do that.");
            return;
        }
        if (transformId == newId) {
            player.sendMessage("This sheep has already been shorn.");
            return;
        }
        if (NPCHandler.npcs[npcId].isTransformed) {
            return;
        }
        if (animation > 0) {
            player.startAnimation(animation);
        }
        requestTransform(newId);
        player.addItem(itemGiven, 1);
        player.sendMessage("You get some " + Item.getItemName(itemGiven).toLowerCase() + ".");
        EventManager.getSingleton().addEvent(player,new Event() {

            @Override
            public void execute(EventContainer container) {
                requestTransform(currentId);
                container.stop();
            }

            @Override
            public void stop() {
                NPCHandler.npcs[npcId].isTransformed = false;
            }
        }, transformTime * 600);
    }

    public void appendNPCUpdateBlock(stream str) {
        if (!updateRequired)
            return; // nothing required
        int updateMask = 0;
        if (animUpdateRequired)
            updateMask |= 0x10;
        if(hitUpdateRequired2)
            updateMask |= 8;
        if (gfxUpdateRequired)
            updateMask |= 0x80;
        if (faceEntityUpdateRequired)
            updateMask |= 0x20;
        if (textUpdateRequired)
            updateMask |= 1;
        if (hitUpdateRequired)
            updateMask |= 0x40;
        if (transformUpdateRequired)
            updateMask |= 2;
        if (FocusPointX != -1)
            updateMask |= 4;
        /*
         * if(updateMask >= 0x100) { // byte isn't sufficient updateMask |=
         * 0x40; // indication for the client that updateMask is stored in a
         * word str.writeByte(updateMask & 0xFF); str.writeByte(updateMask >>
         * 8); } else {
         */
        str.writeUnsignedWord(updateMask);
        // }

        // now writing the various update blocks itself - note that their order
        // crucial
        if (animUpdateRequired)
            appendAnimUpdate(str);
        if (hitUpdateRequired2)
            appendHitUpdate2(str);
        if (gfxUpdateRequired)
            appendMask80Update(str);
        if (faceEntityUpdateRequired)
            appendFaceEntity(str);
        if (textUpdateRequired) {
            str.writeString(textUpdate);
        }
        if (hitUpdateRequired)
            appendHitUpdate(str);
        if (transformUpdateRequired)
            appendTransformUpdate(str);
        if (FocusPointX != -1)
            appendSetFocusDestination(str);
        // TODO: add the various other update blocks
    }
    public int mask80var1 = 0;
    public int mask80var2 = 0;
    public void appendMask80Update(stream str) {
        str.writeUnsignedWord(mask80var1);
        str.writeDWord(mask80var2);
    }
    public void gfx100(int gfx) {
        mask80var1 = gfx;
        mask80var2 = 6553600;
        gfxUpdateRequired = true;
        updateRequired = true;
    }
    public void gfx100(int gfx, int height) {
        mask80var1 = gfx;
        mask80var2 = 65536 * height;
        gfxUpdateRequired = true;
        updateRequired = true;
    }
    public void gfx0(int gfx) {
        mask80var1 = gfx;
        mask80var2 = 65536;
        gfxUpdateRequired = true;
        updateRequired = true;
    }
    public void requestTransform(int id) {
        transformId = id;
        transformUpdateRequired = true;
        updateRequired = true;
    }
    public void clearUpdateFlags() {
        updateRequired = false;
        animUpdateRequired = false;
        hitUpdateRequired2 = false;
        gfxUpdateRequired = false;
        faceEntityUpdateRequired = false;
        textUpdateRequired = false;
        hitUpdateRequired = false;
        transformUpdateRequired = false;
        textUpdate = null;
        moveX = 0;
        moveY = 0;
        teleporting = false;
        direction = -1;
        focusPointX = -1;
        focusPointY = -1;
    }


    // returns 0-7 for next walking direction or -1, if we're not moving
    public int getNextWalkingDirection() {
        int dir;

        dir = misc.direction(absX, absY, (absX + moveX), (absY + moveY));
        if (dir == -1) {
            return -1;
        }
        if (teleporting)
            return -1;
        dir >>= 1;
        absX += moveX;
        absY += moveY;
        return dir;
    }

    public void getNextNPCMovement(final int i) {
        direction = -1;
        if (freezeTimer == 0) {
            direction = getNextWalkingDirection();
        }
    }
    public void appendFaceEntity(stream str) {
        str.writeUnsignedWord(face);
    }
    protected void appendHitUpdate(stream str) {
        try {
            HP -= hitDiff;
            if (HP <= 0) {
                IsDead = true;
            }
            str.writeByteC(hitDiff); // What the perseon got 'hit' for
            if (hitDiff > 0 && !poisondmg) {
                str.writeByteS(1); // 0: red hitting - 1: blue hitting
            } else if (hitDiff > 0 && poisondmg) {
                str.writeByteS(2); // 0: red hitting - 1: blue hitting
            } else {
                str.writeByteS(0); // 0: red hitting - 1: blue hitting
            }
            str.writeWord(HP); // Their current hp, for HP bar
            str.writeWord(MaxHP); // Their max hp, for HP bar
            poisondmg = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void appendHitUpdate2(stream str) {
        try {
            HP -= hitDiff;
            if (HP <= 0) {
                IsDead = true;
            }
            str.writeByteA(hitDiff); // What the perseon got 'hit' for
            if (hitDiff > 0 && !poisondmg) {
                str.writeByteC(1); // 0: red hitting - 1: blue hitting
            } else if (hitDiff > 0 && poisondmg) {
                str.writeByteC(2); // 0: red hitting - 1: blue hitting
            } else {
                str.writeByteC(0); // 0: red hitting - 1: blue hitting
            }
            str.writeWord(HP); // Their current hp, for HP bar
            str.writeWord(MaxHP); // Their max hp, for HP bar
            poisondmg = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TurnNpcTo(int i, int j) {
        FocusPointX = 2 * i + 1;
        FocusPointY = 2 * j + 1;
        updateRequired = true;
        FaceDirection = true;
    }

    private void appendSetFocusDestination(stream stream1) {
        if (stream1 != null) {
            stream1.writeWordBigEndian(FocusPointX);
            stream1.writeWordBigEndian(FocusPointY);
        }
    }


    public void appendAnimUpdate(stream str) {
        str.writeWordBigEndian(animNumber);
        str.writeByte(1);
    }
    public void appendTransformUpdate(stream str) {
        str.writeWordBigEndianA(transformId);
    }

    public void appendDirUpdate(stream str) {
        str.writeWord(direction);
    }

    public void appendFaceToUpdate(stream str) {
        str.writeWordBigEndian(viewX);
        str.writeWordBigEndian(viewY);
    }

    public boolean inMulti() {
        return (absX >= 3136 && absX <= 3327 && absY >= 3519 && absY <= 3607)
                || (absX >= 3190 && absX <= 3327 && absY >= 3648 && absY <= 3839)
                || (absX >= 3200 && absX <= 3390 && absY >= 3840 && absY <= 3967)
                || (absX >= 2992 && absX <= 3007 && absY >= 3912 && absY <= 3967)
                || (absX >= 2946 && absX <= 2959 && absY >= 3816 && absY <= 3831)
                || (absX >= 3008 && absX <= 3199 && absY >= 3856 && absY <= 3903)
                || (absX >= 3008 && absX <= 3071 && absY >= 3600 && absY <= 3711)
                || (absX >= 3072 && absX <= 3327 && absY >= 3608 && absY <= 3647)
                || (absX >= 2624 && absX <= 2690 && absY >= 2550 && absY <= 2619)
                || (absX >= 2371 && absX <= 2422 && absY >= 5062 && absY <= 5117)
                || (absX >= 2896 && absX <= 2927 && absY >= 3595 && absY <= 3630)
                || (absX >= 2892 && absX <= 2932 && absY >= 4435 && absY <= 4464)
                || (absX >= 2256 && absX <= 2287 && absY >= 4680 && absY <= 4711);
    }

    public boolean inWild() {
        return absX > 2941 && absX < 3392 && absY > 3518 && absY < 3966
                || absX > 2941 && absX < 3392 && absY > 9918 && absY < 10366;
    }

    public int getX() {
        return absX;
    }

    public int getY() {
        return absY;
    }

    public int getId() {
        // TODO Auto-generated method stub
        return npcType;
    }

    public int getProjectileDelay () {
        return 0;
    }
}
