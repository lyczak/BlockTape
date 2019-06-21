package ga.lyczak.BlockTape;

import co.aikar.commands.PaperCommandManager;
import ga.lyczak.BlockTape.Commands.PlayBack;
import ga.lyczak.BlockTape.Commands.Record;
import ga.lyczak.BlockTape.Commands.ViewRecordings;
import ga.lyczak.BlockTape.Recordings.Scene;
import ga.lyczak.BlockTape.Recordings.Tape;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.LinkedList;


@Plugin(name = "BlockTape", version = "1.0")
@Author(name = "glyczak and Dwlee99")
public class BlockTapePlugin extends JavaPlugin {
    private static BlockTapePlugin plugin;
    private static BukkitScheduler scheduler;
    private static PaperCommandManager commandManager;

    public static final int TICKS_PER_SNAPSHOT = 1;
    public static final int DEFAULT_RECORD_TIME = 20 * 20; //ticks
    public static final int ENTITY_RECORD_RADIUS = 128; //blocks

    private static LinkedList<Scene> scenes = new LinkedList<>();

    public static BlockTapePlugin getInstance() {
        if (plugin == null || !plugin.isEnabled()) {
            throw new RuntimeException("Plugin is disabled or undefined.");
        }
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info("BlockTape started up");

        scheduler = getServer().getScheduler();
        //getLogger().info("Scheduler Made");
        registerCommands();
    }

    @Override
    public void onDisable() {
        getLogger().info("BlockTape shut down!");
    }

    private void registerCommands() {
        //getLogger().info("In Register Commands");
        commandManager = new PaperCommandManager(plugin);
        //getLogger().info("New Command Manager");
        commandManager.enableUnstableAPI("help");
        //getLogger().info("Enabled Unstable API");

        commandManager.registerCommand(new Record());
        commandManager.registerCommand(new ViewRecordings());
        commandManager.registerCommand(new PlayBack());
        //getLogger().info("Registered record command");
    }

    public BukkitScheduler getScheduler(){
        return scheduler;
    }
    public static void logMessage(String s){
        plugin.getLogger().info(s);
    }
    public static void addScene(Scene scene){
        scenes.add(scene);
    }
    public static LinkedList<Scene> getScenes(){
        return scenes;
    }
}