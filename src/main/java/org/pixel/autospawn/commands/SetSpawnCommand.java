package org.pixel.autospawn.commands;


import org.pixel.autospawn.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("command.setspawn")) {
                if (args.length == 0) {
                    FileConfiguration cfg = Main.getPlugin().getConfig();
                    Location loc = p.getLocation();
                    cfg.set("Spawn.World", loc.getWorld().getName());
                    cfg.set("Spawn.X", Double.valueOf(loc.getX()));
                    cfg.set("Spawn.Y", Double.valueOf(loc.getY()));
                    cfg.set("Spawn.Z", Double.valueOf(loc.getZ()));
                    cfg.set("Spawn.Yaw", Float.valueOf(loc.getYaw()));
                    cfg.set("Spawn.Pitch", Float.valueOf(loc.getPitch()));
                    Main.getPlugin().saveConfig();
                    FileConfiguration msg = Main.getPlugin().getConfig();
                    String SpawnSet = msg.getString("Messages.SetSpawn");
                    p.sendMessage(SpawnSet);
                } else {
                    FileConfiguration msg = Main.getPlugin().getConfig();
                    String str = msg.getString("Messages.SetSpawnCommand");
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