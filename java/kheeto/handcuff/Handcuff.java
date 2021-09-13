package kheeto.handcuff;

import kheeto.handcuff.items.Handcuffs;
import kheeto.handcuff.items.HandcuffsKeys;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Handcuff extends JavaPlugin {

    public static List<Player> handcuffedPlayers;

    @Override
    public void onEnable() {
        // Attiva le manette
        handcuffedPlayers = new ArrayList<Player>();
        Handcuffs.setUp();
        HandcuffsKeys.setUp();

        // Attiva i comandi
        getCommand("manette").setExecutor(new CommandsManager());
        getCommand("arresta").setExecutor(new CommandsManager());

        // Scrive che il plugin è stato attivato
        System.out.println("[Handcuffs] Plugin attivato");
    }

    @Override
    public void onDisable() {
        System.out.println("[Handcuffs] Plugin disattivato");
    }
}
