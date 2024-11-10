import lombok.SneakyThrows;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Discord extends ListenerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(Discord.class);
    private static final Map<String, TextChannel> channels = new ConcurrentHashMap<>();
    public static JDA jda = null;
    static String token = "MTAwNDExNDAyNTA0ODcxNTM4Ng.GIxORK.0Z86Zz3tmPs98UWvZrPR63km_MdEzPwp_TwtOk";
    public static String token2 = "MTAwNDExNDAyNTA0ODcxNTM4Ng.GIxORK.0Z86Zz3tmPs98UWvZrPR63km_MdEzPwp_TwtOk";

    public static JDA jda2 = null;
    public static String PREFIX = "::";
    public static String OWNER_ROLE = "1074439303981170728";//Currently set to God Tier on beta.
    public static String MANAGER_ROLE = "1074439470943846473";
    public static String DEVELOPER_ROLE = "1064737223884427324";
    public static String ADMIN_ROLE = "1064728188044976168";
    public static String MEMBERS = "1185405350845874236";
    public static String GLOBAL_MOD_ROLE = "1064733810014560357";
    public static String SUPPORT_ROLE = "1064735941178183770";

    /**
     * Write to a channel that contains misc. types of information about player activity.
     *///
    public static void writeserverSyncMessage(String message, Object...args) {
        if(server.isPublic()) {
            sendChannelMessage(1197212577181204610L, message, args);
        }
    }
    public static void writeserverMessages(String message, Object...args) {
        if(server.isPublic()) {
            sendChannelMessage(1197212577181204610L, message, args);
        }
    }
    public static void writeCommandMessages(String message, Object...args) {
        if(server.isPublic()) {
            sendChannelMessage(1189347372367618129L, message, args);
        }
    }
    public static void writeAddressSwapMessage(String message, Object...args) {
        if(server.isPublic()) {
            sendChannelMessage(1197212577181204610L, message, args);
        }
    }
    public static void writeannounceMessage(String message, Object...args) {
        if(server.isPublic()) {
            sendChannelMessage(1197212577181204610L, message, args);
        }
    }
    public static void writeWellMessage(String message, Object...args) {
        if(server.isPublic()) {
            sendChannelMessage(1197212577181204610L, message, args);
        }
    }
    public static void writeBossMessage(String message, Object...args) {
        if(server.isPublic()) {
            sendChannelMessage(1197212577181204610L, message, args);
        }
    }

    public static void writeBugMessage(String message, Object...args) {
        if(server.isPublic()) {
            sendChannelMessage(1197212577181204610L, message, args);
        }
    }

    public static void writetickets(String message, Object...args) {
        if(server.isPublic()) {
            sendChannelMessage(1197212577181204610L, message, args);
        }
    }

    public static void writepunishments(String message, Object...args) {
        if(server.isPublic()) {
            sendChannelMessage(1197212577181204610L, message, args);
        }
    }
    public static void writeDeathMessage(String message, Object...args) {
        if(server.isPublic()) {
            sendChannelMessage(1197212577181204610L, message, args);
        }
    }
    @SneakyThrows
    public static void writeBossMessage() {
        EmbedBuilder db = new EmbedBuilder();
        db.setTitle("Runescape Boss");
        db.setDescription("Glod has spawned ::glod to participate");
        db.setImage("https://media.tenor.com/RPsfJj2LxwQAAAAd/monster-simpsons.gif");
        db.setColor(new java.awt.Color(0xB00D03));
    }
    public static void writeLottery() {
    }
    public static void writkupMessage(String message, Object...args) {
        if(server.isPublic()) {
            sendChannelMessage(1197212577181204610L, message, args);
        }
    }
    public static void writeDropsSyncMessage(String message, Object...args) {
        if(server.isPublic()) {
            sendChannelMessage(1197212577181204610L, message, args);
        }
    }

    public static void writeSuggestionMessage(String message, Object...args) {
        if(server.isPublic()) {
            sendChannelMessage(1197212577181204610L, message, args);
        }
    }

    public static void writeFoeMessage(String message, Object...args) {
        if(server.isPublic()) {
            writeserverSyncMessage(message, args);

            sendChannelMessage(1197212577181204610L, message, args);
        }
    }

    public static void writeReferralMessage(String message, Object...args) {
        if(server.isPublic()) {
            writeserverSyncMessage(message, args);
            sendChannelMessage(1197212577181204610L, message, args);
        }
    }

    public static void writeCheatEngineMessage(String message, Object...args) {
        if (server.isPublic()) {
            writeserverSyncMessage(message, args);
            sendChannelMessage(1197212577181204610L, message, args);
        }
    }
//
//        /**
//         * Write to a channel that should not be ignored by staff.
//         */
//        public static void writeAddressSwapMessage (String message, Object...args){
//            writeserverSyncMessage(message, args);
//       sendChannelMessage(server-bot-notification, message, args);
//        }
//    }

    private static void sendChannelMessage(long channelName, String message, Object...args) {
        if (Config.DISABLE_DISCORD_MESSAGING) {
            return;
        }
            try {
                if (getJDA().getTextChannelById(channelName) != null) {
                    getJDA().getTextChannelById(channelName).
                            sendMessage(misc.replaceBracketsWithArguments(message, args)).queue();
                } else {
                    for (TextChannel textChannel : getJDA().getTextChannels()) {
                        System.out.println(textChannel.getName() + " / " + textChannel.getId() + " / " + textChannel.getIdLong());
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
    }


    public static JDA getJDA() throws LoginException, InterruptedException  {
        if (jda == null) {
            if(Config.UPDATE_DISCORD_STATUS) {
                if (server.isPublic()) {
                    jda = JDABuilder.createDefault(token).build();
                    jda.awaitReady();
                    if (Config.UPDATE_DISCORD_STATUS) {
                        Discord.getJDA().getPresence().setPresence(OnlineStatus.ONLINE, Activity.playing("Ghreborn with " + PlayerHandler.getPlayerCount() + " players!"));
                        //logger.info("Player Status sent");
                    }
                }
            }
        }
        return jda;
    }


    private static boolean enabled() {
        return !Config.DISABLE_DISCORD_MESSAGING;
    }

    public void init() {
        if (Config.DISABLE_DISCORD_MESSAGING)
            return;
        JDABuilder builder = JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.GUILD_PRESENCES)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .enableCache(CacheFlag.ACTIVITY)
                .setMemberCachePolicy(MemberCachePolicy.ONLINE)
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .setChunkingFilter(ChunkingFilter.ALL);

        System.out.println("Loading Discord Bot!");
        try {
            jda = builder.build();

            if (Config.UPDATE_DISCORD_STATUS) {
                try {
                    Discord.getJDA().getPresence().setPresence(OnlineStatus.ONLINE, Activity.playing("Ghreborn with " + PlayerHandler.getPlayerCount() + " players!"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //logger.info("Player Status sent");
            } jda.addEventListener(this);
            jda.getGuilds().forEach(Guild::loadMembers);
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onReady(ReadyEvent event) {
        if (Config.UPDATE_DISCORD_STATUS) {
            jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.playing("Ghreborn with " + PlayerHandler.getPlayerCount() + " players!"));
        }
        System.out.println("sent commands");
        jda.getGuilds().forEach(Guild::loadMembers);

        jda.retrieveCommands();
    }
}
