package net.thanon.Bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.thanon.Liquizd;

public class BotMain {
    public static JDA bot;
    public static String prefix = Liquizd.config.get("PREFIX");
    public static String[] act = {"Liquizd!", "l?"};
    public BotMain() {
        bot = JDABuilder.createDefault(Liquizd.config.get("TOKEN"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MODERATION)
                .enableCache(CacheFlag.VOICE_STATE, CacheFlag.MEMBER_OVERRIDES)
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setActivity(Activity.listening(act[(int) (Math.random() * 2)]))
                .addEventListeners(new Message())
                .build();
    }
}