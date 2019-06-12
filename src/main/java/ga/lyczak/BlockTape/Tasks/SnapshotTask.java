package ga.lyczak.BlockTape.Tasks;

import ga.lyczak.BlockTape.Snapshots.Snapshot;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.LinkedList;

public abstract class SnapshotTask<S extends Snapshot> extends BukkitRunnable {

    protected LinkedList<S> snapshots;

    public SnapshotTask(LinkedList<S> snapshots) {
        this.snapshots = snapshots;
    }
}
