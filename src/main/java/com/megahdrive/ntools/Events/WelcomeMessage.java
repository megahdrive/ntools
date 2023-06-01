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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WelcomeMessage implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        String playerName = p.getName();
        Bukkit.getScheduler().runTaskLater(JavaPlugin.getPlugin(Ntools.class), () -> {
            p.sendMessage(Component.text("§3Welcome to OpenSMP, §l" + playerName +
                    "§r§3. The current server time is " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a"))));
            if (!p.hasPlayedBefore()) {
                p.sendMessage(Component.text("§3As a first-time player, you can check out our rules by running /rules."));
            }
            p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1f, 1f);
        }, 20);
    }
}
