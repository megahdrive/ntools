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

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WelcomeMessage implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        String playerName = p.getName();
        Bukkit.getScheduler().runTaskLater(JavaPlugin.getPlugin(Ntools.class), () -> {
            p.sendMessage(Component.text("§3Welcome to OpenSMP, §l" + playerName +
                    "§r§3. It's currently " + new SimpleDateFormat("hh:mm:ss a").format(Calendar.getInstance().getTime()) + "§r§3 " +
                    "on " + new SimpleDateFormat("mm-dd-yy").format(Calendar.getInstance().getTime())));
            p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1f, 1f);
        }, 20);
    }
}
