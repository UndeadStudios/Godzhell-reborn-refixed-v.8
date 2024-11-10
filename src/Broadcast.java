
/**
 * @author Ynneh
 */
public class Broadcast {

    private String url;

    private Position teleport;

    private final String message;

    private BroadcastType type;

    public int index;

    public boolean sendChatMessage;

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getUrl() {
        return url;
    }

    public String getMessage() {
        return message;
    }

    public BroadcastType getType() {
        return type;
    }

    public Position getTeleport() {
        return teleport;
    }

    public Broadcast(String message) {
        this.message = message;
    }

    public Broadcast addLink(String url) {
        this.url = url;
        return this;
    }

    public Broadcast addTeleport(Position teleport) {
        this.teleport = teleport;
        return this;
    }

    public Broadcast copyMessageToChatbox() {
        this.sendChatMessage = true;
        return this;
    }


    public Broadcast submit() {
        type = teleport != null ? BroadcastType.TELEPORT : url != null ? BroadcastType.LINK : BroadcastType.MESSAGE;
        BroadcastManager.addIndex(this);
        return this;
    }
}
