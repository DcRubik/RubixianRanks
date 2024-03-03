package org.dcrubik.rubixianranks.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.permissions.PermissionAttachment;
import org.dcrubik.rubixianranks.RubixianRanks;
import org.dcrubik.rubixianranks.storage.Rank;
import org.bukkit.entity.Player;

import java.util.UUID;

public class RankManager {

    public static void setRank(Rank rank, Player player) {
        RubixianRanks main = RubixianRanks.getRank();
        FileConfiguration config = main.getConfig();
        String uuid = player.getUniqueId().toString();

        if (config.contains(uuid)) {
            removePermissions(player);
        }
        config.set(uuid, rank.name());
        main.saveConfig();
        setPermissions(player, rank); // Aquí es donde se llama al método setPermissions
    }

    public static Rank getRank(Player player) {
        RubixianRanks main = RubixianRanks.getRank();
        FileConfiguration config = main.getConfig();

        return Rank.valueOf(config.getString(player.getUniqueId().toString()));
    }

    public static void setPermissions(Player player, Rank rank) {
        RubixianRanks main = RubixianRanks.getRank();
        FileConfiguration config = main.getConfig();
        UUID uuid = player.getUniqueId();

        PermissionAttachment attachment = player.addAttachment(main);
        RubixianRanks.getPerms().put(uuid, attachment);

        for (String perm : rank.getPermissions()) {
            String truncatedPerm = perm.substring(0, Math.min(perm.length(), 16));
            attachment.setPermission(truncatedPerm, true);
        }
    }

    public static void removePermissions(Player player) {
        RubixianRanks main = RubixianRanks.getRank();
        FileConfiguration config = main.getConfig();
        UUID uuid = player.getUniqueId();
        Rank rank = getRank(player);

        if (RubixianRanks.getPerms().containsKey(uuid)) {
            PermissionAttachment attachment = RubixianRanks.getPerms().get(uuid);

            if (attachment != null) {
                for (String perm : rank.getPermissions()) {
                    if (attachment.getPermissions().containsKey(perm)) {
                        attachment.unsetPermission(perm);
                    }
                }
            }

            RubixianRanks.getPerms().remove(uuid);
        }
    }
}
