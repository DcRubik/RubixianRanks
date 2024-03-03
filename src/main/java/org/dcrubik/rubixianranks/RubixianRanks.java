package org.dcrubik.rubixianranks;

import org.bukkit.event.Listener;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;
import org.dcrubik.rubixianranks.commands.SetRankCommand;
import org.dcrubik.rubixianranks.commands.TestCommand;
import org.dcrubik.rubixianranks.listeners.RankListeners;
import org.dcrubik.rubixianranks.listeners.RankListeners;

import java.util.HashMap;
import java.util.UUID;

public final class RubixianRanks extends JavaPlugin {

    private  static HashMap<UUID, PermissionAttachment> perms = new HashMap<>();
    private static RubixianRanks rank;

    @Override
    public void onEnable() {
        RankListeners rankListeners = new RankListeners();
        rank = this;

        getConfig().options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents((Listener) rankListeners, this);
        getCommand("setrank").setExecutor(new SetRankCommand());
        getCommand("test").setExecutor(new TestCommand());
    }

    @Override
    public void onDisable() {
        rank = null;
        perms.clear();

    }

    public static RubixianRanks getRank(){
        return rank;
    }

    public static HashMap<UUID, PermissionAttachment> getPerms(){
        return perms;
    }

}
