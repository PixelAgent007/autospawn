package org.pixel.autospawn.commands;

import org.pixel.autospawn.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("command.spawn")) {
                if (args.length == 0) {
                    FileConfiguration cfg = Main.getPlugin().getConfig();
                    World world = Bukkit.getWorld(cfg.getString("Spawn.World"));
                    double x = cfg.getDouble("Spawn.X");
                    double y = cfg.getDouble("Spawn.Y");
                    double z = cfg.getDouble("Spawn.Z");
                    float yaw = (float)cfg.getDouble("Spawn.Yaw");
                    float pitch = (float)cfg.getDouble("Spawn.Pitch");
                    Location loc = new Location(world, x, y, z, yaw, pitch);
                    String str = cfg.getString("Messages.TP");
                    p.sendMessage(str);
                    p.teleport(loc);
                } else {
                    FileConfiguration msg = Main.getPlugin().getConfig();
                    String str = msg.getString("Messages.SpawnCommand");
                    p.sendMessage(str);
                }
            } else {
                FileConfiguration msg = Main.getPlugin().getConfig();
                String NoPermission = msg.getString("Messages.NoPermission");
                p.sendMessage(NoPermission);
            }
        }
        return false;
    }
}

