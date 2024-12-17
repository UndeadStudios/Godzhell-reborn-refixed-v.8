import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 * A list of all connections <code>InetAddress</code>
 *
 * @author Daniel
 */
public final class ConnectionList {
    public static int MAX_CONNECTIONS_PER_IP = 2000;
    public static ArrayList<String> bannedUid = new ArrayList<String>();
    private static ConnectionList instance = null;
    public boolean stabletest = false;
    private Map<InetAddress, Integer> connectionMap = null;

    /**
     * Private constructor for this class
     */
    private ConnectionList() {
        connectionMap = new Hashtable<InetAddress, Integer>(500);
    }

    /**
     * @return the instance of this class
     */
    public static ConnectionList getInstance() {
        if (instance == null) {
            instance = new ConnectionList();
        }
        return instance;
    }

    /**
     * Filters the connection
     *
     * @param address the <code>InetAddress</code> of the connection
     */
    public void addConnection(final InetAddress address) {
        if (filter(address)) {
            if (connectionMap.containsKey(address)) {
                connectionMap.put(address, connectionMap.get(address) + 1);
            } else {
                connectionMap.put(address, 1);
            }
        }
    }

    /**
     * Removes a <code>InetAddress</code> from the map
     *
     * @param address the <code>InetAddress</code> removed
     */
    public void remove(final InetAddress address) {
        if (connectionMap.containsKey(address)) {
            if (connectionMap.get(address) > 1) {
                connectionMap.put(address, connectionMap.get(address) - 1);
            } else {
                connectionMap.remove(address);
            }
        }
    }

    public boolean filter(final InetAddress address) {
        if (connectionMap.containsKey(address)) {
            return connectionMap.get(address) < MAX_CONNECTIONS_PER_IP;
        }
        return true;
    }

    /**
     * @return the connectionMap
     */
    public Map<InetAddress, Integer> getConnectionMap() {
        return connectionMap;
    }
}