package com.megahdrive.ntools.Commands;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Rules implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command command, String label, String[] args) {
        if (s instanceof Player) {
            ((Player) s).sendMessage(Component.text(
                    "                                   §3Rules\n" +
                    "§6=====================================================\n" +
                    "§o§3These rules are simplified. Please view the Discord for details.\n" +
                    "§r§6=====================================================§3\n" +
                    "1. Hacking and/or cheating by usage of external tools is not allowed.\n" +
                    "2. Use of major exploits, whether found or distributed, is not allowed.\n" +
                    "3. Usage of inappropriate language or symbols beyond a PG-13 rating is not allowed.\n" +
                    "4. Usage of alternate accounts for the purpose of ban-evading is disallowed.\n" +
                    "5. Usage of any device, redstone or otherwise, to lag or otherwise prevent server performance intentionally is not allowed." +
                    "6. Griefing itself is not permitted and pranks are allowed only if they are easy to remove.\n" +
                    "7. No discrimination based on race, ethnicity, nationality, gender identity, biological sex, sexual orientation, religion, or other part of an identity will be tolerated.\n" +
                    "8. No bullying or targeted harassment is allowed under any circumstances.\n" +
                    "§6=====================================================§3\n" +
                    "These rules will be heavily enforced. Details on violations and their consequences are available in the Discord."));
        }
        return true;
    }
}
