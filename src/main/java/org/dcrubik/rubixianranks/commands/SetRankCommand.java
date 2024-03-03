package org.dcrubik.rubixianranks.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.dcrubik.rubixianranks.managers.RankManager;
import org.dcrubik.rubixianranks.storage.Rank;

public class SetRankCommand implements CommandExecutor {

    //              /setrank <player> <rank>

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            if(args.length == 2){
                if(Bukkit.getPlayer(args[0]) != null){
                    Player target = Bukkit.getPlayer(args[0]);

                    switch (args[1]){
                        case "owner":
                            RankManager.setRank(Rank.OWNER, target);
                            target.sendMessage(ChatColor.GREEN + "You are now OWNER!");
                            return true;
                        case "admin":
                            RankManager.setRank(Rank.ADMIN, target);
                            target.sendMessage(ChatColor.GREEN + "You are now ADMIN!");
                            return true;
                        case "gm":
                            RankManager.setRank(Rank.GM, target);
                            target.sendMessage(ChatColor.GREEN + "You are now GM!");
                            return true;
                        case "mod":
                            RankManager.setRank(Rank.MOD, target);
                            target.sendMessage(ChatColor.GREEN + "You are now MOD!");
                            return true;
                        case "helper":
                            RankManager.setRank(Rank.HELPER, target);
                            target.sendMessage(ChatColor.GREEN + "You are now HELPER!");
                            return true;
                        case "builder":
                            RankManager.setRank(Rank.BUILDER, target);
                            target.sendMessage(ChatColor.GREEN + "You are now BUILDER!");
                            return true;
                        case "youtuber":
                            RankManager.setRank(Rank.YOUTUBER, target);
                            target.sendMessage(ChatColor.GREEN + "You are now YOUTUBER!");
                            return true;
                        case "yt":
                            RankManager.setRank(Rank.YT, target);
                            target.sendMessage(ChatColor.GREEN + "You are now YT!");
                            return true;
                        case "vip":
                            RankManager.setRank(Rank.VIP, target);
                            target.sendMessage(ChatColor.GREEN + "You are now VIP!");
                            return true;
                        case "default":
                            RankManager.setRank(Rank.DEFAULT, target);
                            target.sendMessage(ChatColor.GREEN + "You are now Default!");
                            return true;
                        default:
                            player.sendMessage(ChatColor.RED + "The rank hasn't been found!");
                            player.sendMessage(ChatColor.RED + "Options for ranks are: OWNER, ADMIN, GM, MOD, HELPER, BUILDER, YOUTUBER, YT, VIP, DEFAULT");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Player not found! =(");
                }

            } else {
                player.sendMessage(ChatColor.RED + "Use: /setrank <player> <rank>");
            }
        }

        return true;
    }
}
