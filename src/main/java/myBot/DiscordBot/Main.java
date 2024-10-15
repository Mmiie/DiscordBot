package myBot.DiscordBot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;

import javax.security.auth.login.LoginException;

import commands.SlashCommands;
import net.dv8tion.jda.api.JDA;

public class Main extends ListenerAdapter{

    public static void main(String[] args) throws LoginException , InterruptedException{

        JDABuilder jdaB = JDABuilder.createDefault("add a bot token here");
        JDA jda = jdaB
                .addEventListeners(new SlashCommands())
                .build();

        jda.upsertCommand("kick", "kick a user")
                .addOption(OptionType.USER, "user", "kick that user", true)
                .addOption(OptionType.STRING, "reason", "the reason of the kick", true)
                .setGuildOnly(true)
                .queue();
        
        jda.upsertCommand("ban", "ban a user")
                .addOption(OptionType.USER, "banned_user", "ban that user", true)
                .addOption(OptionType.STRING, "reason", "the reason of the ban", true)
                .setGuildOnly(true)
                .queue();   //it doesn't work :(
        
        
        jda.upsertCommand("test", "for testing")
        .setGuildOnly(true)
        .queue(); //a test to see if the bot commands is working
        
        jda.upsertCommand("time-out", "time out a user")
        .addOption(OptionType.USER, "user", "the user you want to time out", true)
        .addOption(OptionType.INTEGER, "time", "idk", true)
        .setGuildOnly(true)
        .queue();
        
        
        jda.upsertCommand("untime-out", "remove a timeout from a user")
        .addOption(OptionType.USER, "user", "the user you want to remove the time-out from", true)
        .setGuildOnly(true)
        .queue();
        
    }
}
