package com.nachtraben.tohsaka.commands;

import com.nachtraben.core.command.GuildCommandSender;
import com.nachtraben.core.commandmodule.Cmd;
import com.nachtraben.core.commandmodule.CommandSender;
import com.nachtraben.core.utils.StringUtils;
import com.nachtraben.tohsaka.Tohsaka;

import java.util.Map;

import static com.nachtraben.core.utils.StringUtils.format;


/**
 * Created by NachtRaben on 1/18/2017.
 */
public class AdminCommands {

    @Cmd(name = "invite", format = "", description = "Generates the invite link for the bot.")
    public void invite(CommandSender sender, Map<String, String> args) {
		if(sender instanceof GuildCommandSender) {
			GuildCommandSender sendee = (GuildCommandSender) sender;
			sendee.getChannel().sendMessage(format("Here is my invite link! https://discordapp.com/oauth2/authorize?client_id=%s&scope=bot&permissions=%s", sendee.getMessage().getJDA().getSelfUser().getId(), "2146958463")).queue();
		}
    }

    @Cmd(name = "shutdown", format = "", description = "Shuts down Tohsaka.")
    public void onShutdown(CommandSender sender, Map<String, String> args) {
        Tohsaka.getInstance().shutdown();
    }
    
    @Cmd(name = "ping", format = "", description = "Gives you the ping of the bot.")
    public void ping(CommandSender sender) {
		if(sender instanceof GuildCommandSender) {
			GuildCommandSender sendee = (GuildCommandSender) sender;
			Long start = System.currentTimeMillis();
			sendee.getChannel().sendTyping().queue(aVoid -> sendee.getChannel().sendMessage(StringUtils.format("Pong: `%s`ms.", System.currentTimeMillis() - start)).queue());
		}
    }

}