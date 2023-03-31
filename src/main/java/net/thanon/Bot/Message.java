package net.thanon.Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Message extends ListenerAdapter {
    private final String prefix = BotMain.prefix;
    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        if(e.getMessage().getContentStripped().startsWith(prefix + "user-info")) {
            Member member = e.getMessage().getMentions().getMembers().get(0);
            MessageEmbed embed = new EmbedBuilder()
                    .setTitle("User info about: " + member.getEffectiveName())
                    .setColor(Color.green)
                    .setDescription("Name: " + member.getEffectiveName()
                            + "\nNickname: " + member.getNickname()
                            + "\nRole: " + member.getRoles().get(0).getName())
                    .build();
            e.getChannel().sendMessageEmbeds(embed).queue();
        }
        if(e.getMessage().getContentStripped().startsWith(prefix + "role-info")) {
            Role role = e.getMessage().getMentions().getRoles().get(0);
            MessageEmbed embed = new EmbedBuilder()
                    .setTitle("Role info about: " + role.getName())
                    .setColor(role.getColor())
                    .setDescription("Name: " + role.getName()
                            + "\nId: " + role.getId()
                            + "\nColor: " + role.getColor())
                    .build();
            e.getChannel().sendMessageEmbeds(embed).queue();
        }
    }
}
