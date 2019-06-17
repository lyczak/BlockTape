package ga.lyczak.BlockTape.Recordings;

import ga.lyczak.BlockTape.BlockTapePlugin;
import ga.lyczak.BlockTape.Snapshots.EntitySnapshot;
import ga.lyczak.BlockTape.Snapshots.PlayerSnapshot;
import ga.lyczak.BlockTape.Tasks.EntitySnapshotTask;
import ga.lyczak.BlockTape.Tasks.PlayerSnapshotTask;
import org.bukkit.entity.*;

import java.util.LinkedList;

public class EntityRecording extends Recording {
    public EntitySnapshotTask entitySnapshotTask;
    public Scene scene;


    LinkedList<EntitySnapshot> snapshots = new LinkedList<EntitySnapshot>();

    public boolean startRecording(Scene scene, Entity entity) {
        BlockTapePlugin blockTapePlugin = BlockTapePlugin.getInstance();
        entitySnapshotTask = new EntitySnapshotTask(snapshots, entity, BlockTapePlugin.DEFAULT_RECORD_TIME, this);
        //BlockTapePlugin.logMessage("Start Recording");
        entitySnapshotTask.runTaskTimer(blockTapePlugin, 1, BlockTapePlugin.TICKS_PER_SNAPSHOT);
        this.scene = scene;

        return true;

    }
    public boolean startRecording(){
        return false;
    }

    public void stopRecording() {
        entitySnapshotTask.stop();
        Tape<EntitySnapshot> tape = new Tape<EntitySnapshot>(snapshots);
        scene.addTape(tape);

    }
}
