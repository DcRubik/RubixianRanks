package org.dcrubik.rubixianranks.storage;

import org.bukkit.ChatColor;

public enum Rank {

    OWNER(ChatColor.RED + "[" + ChatColor.RED + "OWNER" + ChatColor.RED + "] ", new String[]{"test.use"}),
    ADMIN(ChatColor.RED + "[" + ChatColor.RED + "ADMIN" + ChatColor.RED + "] ",  new String[]{"test.use"}),
    GM(ChatColor.DARK_GREEN + "[" + ChatColor.DARK_GREEN + "GM" + ChatColor.DARK_GREEN + "] ",  new String[]{"fly.use"}),
    MOD(ChatColor.DARK_GREEN + "[" + ChatColor.DARK_GREEN + "MOD" + ChatColor.DARK_GREEN + "] ",  new String[]{"fly.use"}),
    HELPER(ChatColor.RED + "[" + ChatColor.WHITE + "HELPER" + ChatColor.BLUE + "] ",  new String[]{"fly.use"}),
    BUILDER(ChatColor.DARK_AQUA + "[" + ChatColor.DARK_AQUA + "BUILDER" + ChatColor.DARK_AQUA + "] ",  new String[]{"fly.use"}),
    YOUTUBER(ChatColor.RED + "[" + ChatColor.WHITE + "YOUTUBE" + ChatColor.RED + "] ",  new String[]{"fly.use"}),
    YT(ChatColor.GOLD + "[" + ChatColor.GOLD + "YT" + ChatColor.GOLD + "] ",  new String[]{"fly.use"}),
    VIP(ChatColor.RED + "[" + ChatColor.WHITE + "VIP" + ChatColor.RED + "] ",  new String[]{"fly.use"}),
    DEFAULT(ChatColor.GRAY + " " + ChatColor.GRAY,  new String[]{});

    private String prefix;
    private String[] permissions;

    Rank(String prefix, String[] permissions){
        this.prefix = prefix;
        this.permissions = permissions;
    }

    public String getPrefix() {
        return prefix;
    }

    public String[] getPermissions(){
        return permissions;
    }
}
