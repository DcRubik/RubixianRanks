package org.dcrubik.rubixianranks.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.dcrubik.rubixianranks.RubixianRanks;
import org.dcrubik.rubixianranks.managers.NametagManager;
import org.dcrubik.rubixianranks.managers.RankManager;
import org.dcrubik.rubixianranks.storage.Rank;
import org.bukkit.entity.Player;

public class RankListeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        RubixianRanks main = RubixianRanks.getRank();
        FileConfiguration config = main.getConfig();
        Player player = e.getPlayer();
        String uuid = player.getUniqueId().toString();

        if(!config.contains(uuid)){
            RankManager.setRank(Rank.DEFAULT, player);
        } else {
            Rank rank = RankManager.getRank(player);
            RankManager.removePermissions(player);
            RankManager.setPermissions(player, rank);
        }

        NametagManager.setNametag(player);
        NametagManager.newTag(player);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        NametagManager.removeTag(e.getPlayer());
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
        String message = e.getMessage();
        String name = player.getDisplayName();

        e.setCancelled(true);
        Bukkit.broadcastMessage(RankManager.getRank(player).getPrefix() + name + ChatColor.WHITE + ": " + ChatColor.WHITE +  message);
    }
}
