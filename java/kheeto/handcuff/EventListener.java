package kheeto.handcuff;

import kheeto.handcuff.items.Handcuffs;
import kheeto.handcuff.items.HandcuffsKeys;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent ev) {

        Player p = ev.getPlayer();

        if(Handcuff.handcuffedPlayers.contains(p)) {
            ev.setCancelled(true);
            p.sendMessage(ChatColor.RED + "Sei ammanettato, non puoi muoverti!");
        }

    }

    @EventHandler
    public void onPlayerDamageEntity(EntityDamageByEntityEvent ev) {

        if(ev.getDamager() instanceof Player) {

            Player p = (Player) ev.getDamager();
            Player target = (Player) ev.getEntity();

            if(Handcuff.handcuffedPlayers.contains(p)) {
                p.sendMessage(ChatColor.RED + "Sei ammanettato, non puoi attaccare le entità o i player!");
                ev.setCancelled(true);
            } else {
                if(p.getInventory().getItemInMainHand() == HandcuffsKeys.customItem) {

                    if(Handcuff.handcuffedPlayers.contains(target)) {
                        p.sendMessage(ChatColor.GREEN + "Hai liberato " + target.getDisplayName() + " dalle manette!");
                        Handcuff.handcuffedPlayers.remove(target);
                        ev.setCancelled(true);
                    }

                    p.sendMessage(ChatColor.RED + "Hai attaccato un giocatore che non era ammanettato!");
                    ev.setCancelled(true);

                }
            }
        }

    }
}
