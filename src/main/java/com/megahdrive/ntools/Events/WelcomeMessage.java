package com.megahdrive.ntools.Events;

import com.megahdrive.ntools.Ntools;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.bukkit.Bukkit.getServer;

public class WelcomeMessage implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        String playerName = p.getName();
        LocalTime localTime = LocalTime.now();
        Bukkit.getScheduler().runTaskLater(JavaPlugin.getPlugin(Ntools.class), () -> {
            p.sendMessage(Component.text("§3Welcome to OpenSMP, §l" + playerName +
                    "§r§3. The current server time is §l" + localTime.format(DateTimeFormatter.ofPattern("hh:mm:ss a")) + "§r§3. " +
                    "The current TPS is §l" + Math.round(getServer().getTPS()[0]) + "§r§3."));
            p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1f, 1f);
        }, 20);
    }
}
