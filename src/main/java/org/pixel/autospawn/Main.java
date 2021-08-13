package org.pixel.autospawn;

import org.bukkit.plugin.java.JavaPlugin;

import org.pixel.autospawn.commands.SetSpawnCommand;
import org.pixel.autospawn.listener.JoinListener;
import org.pixel.autospawn.commands.SpawnCommand;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;

public class Main extends JavaPlugin {
    private static org.pixel.autospawn.Main plugin;

    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        FileConfiguration msg = getPlugin().getConfig();
        msg.set("Messages.Join", "");
        msg.set("Messages.TP", "");
        msg.set("Messages.SetSpawn", "");
        msg.set("Messages.NoPermission", "You don't have permission to do that!");
        msg.set("Messages.SpawnCommand", "Please use /spawn!");
        msg.set("Messages.SpawnCommand", "Please use /spawn!");
        msg.set("Messages.SetSpawnCommand", "Please use /setspawn!");
        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinListener(), this);
    }

    public static org.pixel.autospawn.Main getPlugin() {
        return plugin;
    }
}