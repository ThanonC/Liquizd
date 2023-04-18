package net.thanon.Bot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.concrete.VoiceChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.managers.AudioManager;
import net.thanon.Liquizd;

import java.awt.*;
import java.util.EnumSet;
import java.util.Objects;

import static net.thanon.Bot.BotMain.bot;

public class slashcomms extends ListenerAdapter {
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
        if(e.getName().equals("twitch")) {
            e.deferReply().queue();
            e.getHook().sendMessage("phanter blacks twitch: https://www.twitch.tv/panter_black09").queue();
        }
        if(e.getName().equals("link")) {
            Member member = e.getMember();
            member.getUser().openPrivateChannel().queue(privateChannel -> {
                privateChannel.sendMessage("WIP").queue();
            });
            return;
        }
        if(e.getName().equals("ticket")) {
            e.getGuild().createTextChannel("ticket-" + Math.random() * 21).addPermissionOverride(e.getMember(), EnumSet.of(Permission.VIEW_CHANNEL), null).queue();
            e.deferReply().queue();
            e.getHook().sendMessage("ticket created").queue();
        }
        if(e.getName().equals("clear")) {
            int number = e.getOption("amount").getAsInt();
            e.getChannel().delete().queue();
        }
    }
}
