package net.thanon.Bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.thanon.Liquizd;
import net.thanon.Utils.Config;

public class BotMain {
    public static JDA bot;
    public static String prefix = Liquizd.config.get("PREFIX");
    public static String[] act = {"with lava", "with Matrix"};
    public BotMain() throws InterruptedException {
        bot = JDABuilder.createDefault(Liquizd.config.get("TOKEN"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MODERATION, GatewayIntent.GUILD_WEBHOOKS)
                .enableCache(CacheFlag.VOICE_STATE, CacheFlag.MEMBER_OVERRIDES)
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setActivity(Activity.playing(act[(int) (Math.random() * 2)]))
                .addEventListeners(new slashcomms())
                .addEventListeners(new RandomListener())
                .addEventListeners(new Message())
                .build().awaitReady();
        Guild guild = bot.getGuildById("1090986538713755719");
        if(guild != null) {
            guild.upsertCommand("link", "link").queue();
            guild.upsertCommand("suggestion", "suggests something to the dev").addOption(OptionType.STRING, "suggestion", "suggestion").queue();
        }
        Guild pbc = bot.getGuildById("1043551409183932466");
        if(pbc != null) {
            pbc.upsertCommand("twitch", "shows phanter blacks twitch").queue();
        }
        bot.upsertCommand("about", "about the bot").queue();
        bot.upsertCommand("user-info", "gives the info about a user").addOption(OptionType.MENTIONABLE, "member", "member").queue();
        bot.upsertCommand("random-fact", "gives a random fact").queue();
        bot.upsertCommand("shutdown", "shutdown").queue();
        bot.upsertCommand("ticket", "generates a ticket").queue();
        bot.upsertCommand("suggestion", "suggests something to the dev").addOption(OptionType.STRING, "suggestion", "suggestion").queue();
    }
}