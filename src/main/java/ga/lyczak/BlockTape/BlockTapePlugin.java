package ga.lyczak.BlockTape;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

@Plugin(name = "BlockTape", version = "1.0")
@Author(name = "glyczak and Dwlee99")
public class BlockTapePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("BlockTape started up!");
    }

    @Override
    public void onDisable() {
        getLogger().info("BlockTape shut down!");
    }
}