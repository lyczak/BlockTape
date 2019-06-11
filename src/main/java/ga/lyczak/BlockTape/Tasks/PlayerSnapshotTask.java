package ga.lyczak.BlockTape.Tasks;

import ga.lyczak.BlockTape.Snapshots.PlayerSnapshot;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedList;

public class PlayerSnapshotTask extends SnapshotTask<PlayerSnapshot> {
    private Player target;

    public PlayerSnapshotTask(JavaPlugin plugin, LinkedList<PlayerSnapshot> snapshots, Player target) {
        super(plugin, snapshots);
        this.target = target;
    }

    public void run() {
        PlayerSnapshot s = new PlayerSnapshot();
        s.setLocation(target.getLocation());
        snapshots.add(s);
    }
}
