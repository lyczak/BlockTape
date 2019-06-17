package ga.lyczak.BlockTape.Recordings;

import ga.lyczak.BlockTape.BlockTapePlugin;
import ga.lyczak.BlockTape.Snapshots.PlayerSnapshot;
import ga.lyczak.BlockTape.Tasks.PlayerSnapshotTask;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;


import java.util.LinkedList;

public class PlayerRecording extends Recording<PlayerSnapshot> {


    PlayerSnapshotTask playerSnapshotTask;
    Scene scene;
    LinkedList<PlayerSnapshot> snapshots = new LinkedList<PlayerSnapshot>();
    public boolean startRecording(Scene scene, Player player) {
        BlockTapePlugin blockTapePlugin = BlockTapePlugin.getInstance();
        this.scene = scene;
        playerSnapshotTask = new PlayerSnapshotTask(snapshots, player, BlockTapePlugin.DEFAULT_RECORD_TIME, this);
        BlockTapePlugin.logMessage("Start Recording");
        playerSnapshotTask.runTaskTimer(blockTapePlugin, 1, BlockTapePlugin.TICKS_PER_SNAPSHOT);

        return true;

    }
    public boolean startRecording(){
        return false;
    }

    public void stopRecording() {
        playerSnapshotTask.stop();
        Tape<PlayerSnapshot> tape = new Tape<PlayerSnapshot>(snapshots);
        scene.addTape(tape);

    }
}
