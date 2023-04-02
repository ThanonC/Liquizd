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

public class BotMain {
    public static JDA bot;
    public static String prefix = Liquizd.config.get("PREFIX");
    public static String[] act = {"Liquizd!", prefix};
    public BotMain() {
        bot = JDABuilder.createDefault(Liquizd.config.get("TOKEN"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MODERATION)
                .enableCache(CacheFlag.VOICE_STATE, CacheFlag.MEMBER_OVERRIDES)
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setActivity(Activity.listening(act[(int) (Math.random() * 2)]))
                .addEventListeners(new slashcomms())
                .addEventListeners(new Message())
                .build().awaitReady();
        Guild guild = bot.getGuildById("1090986538713755719");
        if(guild != null) {
            guild.upsertCommand("about", "test").queue();
            guild.upsertCommand("user-info", "gives the info about a user").addOption(OptionType.MENTIONABLE, "member", "member").queue();
            guild.upsertCommand("random-fact", "gives a random fact").queue();
            //guild.upsertCommand("ticket", "generates a ticket").queue();
        }
        bot.upsertCommand("about", "about the bot").queue();
        bot.upsertCommand("user-info", "gives the info about a user").addOption(OptionType.MENTIONABLE, "member", "member").queue();
        bot.upsertCommand("random-fact", "gives a random fact").queue();
        //bot.upsertCommand("ticket", "generates a ticket").queue();
    }
}