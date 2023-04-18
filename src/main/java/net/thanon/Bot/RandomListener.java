package net.thanon.Bot;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RandomListener extends ListenerAdapter {
    public void onGuildMemberJoin(GuildMemberJoinEvent e) {
        e.getGuild().getDefaultChannel().asNewsChannel().sendMessage("Welcome " + e.getMember().getEffectiveName() + "on "+ e.getGuild().getName()).queue();
    }
}
