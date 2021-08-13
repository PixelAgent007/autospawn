package org.pixel.autospawn.listener;

import org.pixel.autospawn.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        FileConfiguration cfg = Main.getPlugin().getConfig();
        boolean TpOnJoin = cfg.getBoolean("TpOnJoin");
        if (TpOnJoin) {
            Player p = e.getPlayer();
            World world = Bukkit.getWorld(cfg.getString("Spawn.World"));
            double x = cfg.getDouble("Spawn.X");
            double y = cfg.getDouble("Spawn.Y");
            double z = cfg.getDouble("Spawn.Z");
            float yaw = (float)cfg.getDouble("Spawn.Yaw");
            float pitch = (float)cfg.getDouble("Spawn.Pitch");
            Location loc = new Location(world, x, y, z, yaw, pitch);
            p.teleport(loc);
        }
    }
}
