package org.dcrubik.rubixianranks.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)  {
        if(sender instanceof Player){
            Player player = (Player) sender;

            if(player.hasPermission("test.use")) {
                player.sendMessage(ChatColor.GREEN + "Test has been a successful! =D");
            } else {
                player.sendMessage(ChatColor.RED + "You need to be admin or higher to do this");
            }
        }
        return false;
    }
}
