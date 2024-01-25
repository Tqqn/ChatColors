package com.tqqn.chatcolors;

import com.tqqn.chatcolors.colors.Colors;
import com.tqqn.chatcolors.listeners.ChatListener;
import com.tqqn.chatcolors.listeners.InteractInventoryListener;
import com.tqqn.chatcolors.listeners.JoinListener;
import com.tqqn.chatcolors.listeners.QuitListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class ChatColors extends JavaPlugin {

    private PlayerManager playerManager;
    private HashMap<Material, Colors> loadedColors;

    @Override
    public void onEnable() {
        this.playerManager = new PlayerManager(this);
        loadColors();
        registerListeners();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadColors() {
        loadedColors = new HashMap<>();
        for (Colors color : Colors.values()) {
            loadedColors.put(color.getGuiMaterial(), color);
        }
    }

    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new ChatListener(playerManager), this);
        pluginManager.registerEvents(new JoinListener(playerManager), this);
        pluginManager.registerEvents(new QuitListener(playerManager), this);
        pluginManager.registerEvents(new InteractInventoryListener(playerManager), this);
    }

    public HashMap<Material, Colors> getLoadedColors() {
        return loadedColors;
    }
}