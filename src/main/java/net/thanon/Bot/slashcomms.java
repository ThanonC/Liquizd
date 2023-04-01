package net.thanon.Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class slashcomms extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent e) {
        if (e.getName().equals("about")) {
            e.deferReply().queue();
            MessageEmbed embed = new EmbedBuilder()
                    .setTitle("About Liquizd bot")
                    .setDescription("Liquizd is a bot by ThanonGaming")
                    .setFooter("By - ThanonGaming - https://discord.gg/aCP2yQJMKS")
                    .setColor(Color.green)
                    .build();
            e.getHook().sendMessageEmbeds(embed).queue();
        }
        if(e.getName().equals("user-info")) {
            Member member = e.getOption("member").getAsMember();
            e.deferReply().queue();
            MessageEmbed embed = new EmbedBuilder()
                    .setTitle("User info about: " + member.getEffectiveName())
                    .setColor(Color.green)
                    .setDescription("Name: " + member.getEffectiveName()
                            + "\nNickname: " + member.getNickname()
                            + "\nRole: " + member.getRoles().get(0).getName())
                    .build();
            e.getHook().sendMessageEmbeds(embed).queue();
        }
        if(e.getName().equals("random-fact")) {
            String[] rf = {"Thanon was 15. when he made with HahahaKnalla (he was 11) a mc Server called TerraNetwork", "Thanon started with Liquizd when he was 15", "Thanon Loves programming, he started learning HTML, css and Python when he was 11 and learned java when he was 12", "Thanon = Kai", "?-=?"};
            e.deferReply().queue();
            e.getHook().sendMessage(rf[(int) (Math.random() * 5)]).queue();
        }
        /*if(e.getName().equals("ticket")) {
            e.getGuild().createTextChannel("Ticket" + Math.random() * 2958).deadline(5).queue();
        }*/
    }
}
