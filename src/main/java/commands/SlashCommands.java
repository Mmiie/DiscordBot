package commands;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;

public class SlashCommands extends ListenerAdapter{

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
    	
    	Member user;
    	
        if(event.getName().equals("kick")) {
            event.getGuild().kick(event.getOption("user").getAsMember()).queue();
            event.reply(event.getOption("user").getAsUser() + " is kicked from the server for the reason : " + event.getOption("reason").getAsString()).queue();
        }
        
        if(event.getName().equals("test")) {
            event.reply("its working").queue();
        }
        
        if(event.getName().equals("ban")) {
        	
        	user = event.getOption("user").getAsMember();
        	
        	event.getGuild().ban(user, 1000, TimeUnit.DAYS).queue();
        	event.reply(event.getOption("user") + " is banned from the server").queue();
        }
        
        if(event.getName().equals("time-out")) {
        	
        	event.getGuild().timeoutFor(event.getOption("user").getAsMember(),event.getOption("time").getAsLong(), TimeUnit.SECONDS).queue();
        	
        	event.reply(event.getOption("user").getAsUser() + " is timed out for "+event.getOption("time").getAsString() + " seconds").queue();
        }
        
        if(event.getName().equals("untime-out")) {
        	
        	event.getGuild().removeTimeout(event.getOption("user").getAsMember()).queue();
        	
        	event.reply(event.getOption("user").getAsUser() + " is untimed out").queue();
        }
        
    }
}
