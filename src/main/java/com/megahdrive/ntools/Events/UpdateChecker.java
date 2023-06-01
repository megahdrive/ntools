package com.megahdrive.ntools.Events;

import com.megahdrive.ntools.Ntools;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class UpdateChecker implements Listener {
    private String version = "1";
    private String updateEndpoint = "https://raw.githubusercontent.com/megahdrive/megahdrive/main/Remote.txt";

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) throws IOException {
        Player p = event.getPlayer();
        if (p.isOp()) {
            URL endpointUrl = new URL(updateEndpoint);
            InputStream is = endpointUrl.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String compareVersion = br.readLine();

            if (!Objects.equals(version, compareVersion)) {
                Bukkit.getScheduler().runTaskLater(JavaPlugin.getPlugin(Ntools.class), () ->
                        p.sendMessage(Component.text("§6Hi, operator! An update is available for ntools.\nCurrent version: " + version + "\nLatest version: " + compareVersion)), 20);
            }

            br.close();
            is.close();
        }
    }
}
