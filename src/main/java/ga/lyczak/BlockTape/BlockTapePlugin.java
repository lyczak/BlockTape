package ga.lyczak.BlockTape;

import co.aikar.commands.PaperCommandManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;
import org.bukkit.scheduler.BukkitScheduler;

@Plugin(name = "BlockTape", version = "1.0")
@Author(name = "glyczak and Dwlee99")
public class BlockTapePlugin extends JavaPlugin {
    private static BlockTapePlugin plugin;
    private static BukkitScheduler scheduler;
    private static PaperCommandManager commandManager;

    @Override
    public void onEnable() {
        plugin = this;
        scheduler = getServer().getScheduler();
        registerCommands();
    }

    @Override
    public void onDisable() {
        getLogger().info("BlockTape shut down!");
    }

    private void registerCommands() {
        commandManager = new PaperCommandManager(plugin);
    }
}