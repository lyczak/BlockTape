package ga.lyczak.BlockTape.Tasks;

import ga.lyczak.BlockTape.Snapshots.Snapshot;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.LinkedList;

public abstract class SnapshotTask<S extends Snapshot> extends BukkitRunnable {
    protected final JavaPlugin plugin;
    protected LinkedList<S> snapshots;

    public SnapshotTask(JavaPlugin plugin, LinkedList<S> snapshots) {
        this.plugin = plugin;
        this.snapshots = snapshots;
    }
}
