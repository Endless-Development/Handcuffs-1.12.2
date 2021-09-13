package kheeto.handcuff;

import kheeto.handcuff.items.Handcuffs;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandsManager implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {

            if(cmd.getName().equalsIgnoreCase(("manette"))) {

                Player player = (Player) sender;
                if(player.hasPermission("handcuffs")) {

                    player.getInventory().addItem(Handcuffs.customItem);
                    sender.sendMessage(ChatColor.GREEN + "Hai ricevuto le manette.");
                    return true;
                }

                sender.sendMessage(ChatColor.RED + "Non hai il permesso per usare quel comando.");
                return true;

            } else if(cmd.getName().equalsIgnoreCase(("arresta"))) {

                Player player = (Player) sender;
                if(player.hasPermission("handcuffs.arresta")) {

                    if(player.getInventory().getItemInMainHand() == Handcuffs.customItem) {

                        if(args.length > 0) {

                            if(Bukkit.getPlayer(args[0]) != null) {

                                Player target = Bukkit.getPlayer(args[0]);

                                if(((Player) sender).canSee(target)) {

                                    Handcuff.handcuffedPlayers.add(target);

                                    sender.sendMessage(ChatColor.GREEN + "Hai ammanettato " +
                                            ChatColor.WHITE + target.getDisplayName());
                                    return true;
                                }

                                sender.sendMessage(ChatColor.RED + "Puoi ammanettare solo player che puoi vedere.");
                                return true;
                            }

                            sender.sendMessage(ChatColor.RED + "Giocate non trovato.");
                            return true;
                        }

                        sender.sendMessage(ChatColor.RED + "Devi specificare un player da ammanettare.");
                        return true;
                    }

                    sender.sendMessage(ChatColor.RED + "Non hai le manette in mano.");
                    return true;
                }

                sender.sendMessage(ChatColor.RED + "Non hai il permesso per usare quel comando.");
                return true;
            }

            return true;
        }

        sender.sendMessage(("Devi essere un player per usare questo comando"));

        return true;
    }
}
