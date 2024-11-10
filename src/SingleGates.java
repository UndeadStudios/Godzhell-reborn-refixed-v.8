public class SingleGates extends GateHandler {

    public static void useSingleGate(client player, int objectId) {
        switch (objectId) {
            case 3444:
                openSingleGate(player, 3444, 3405, 9894, 3405, 9895, 0, player.absY == 9894 ? 1 : -1, 0, 3);
                break;
            case 3445:
                openSingleGate(player, 3445, 3432, 9897, 3431, 9897, player.absX == 3432 ? -1 : 1, 0, 3, 2);
                break;
        }
    }

}