package ga.lyczak.BlockTape.Tasks;

import ga.lyczak.BlockTape.Recordings.EntityRecording;
import ga.lyczak.BlockTape.Recordings.PlayerRecording;
import ga.lyczak.BlockTape.Snapshots.EntitySnapshot;
import ga.lyczak.BlockTape.Snapshots.PlayerSnapshot;
import org.bukkit.entity.*;
import org.bukkit.entity.Player;

import java.util.LinkedList;

public class EntitySnapshotTask extends SnapshotTask<EntitySnapshot>{
    private Entity target;
    private int recordTime;
    private EntityRecording entityRecording;
    public EntitySnapshotTask(LinkedList<EntitySnapshot> snapshots, Entity target, int recordTime, EntityRecording entityRecording) {
        super(snapshots);
        this.target = target;
        this.recordTime = recordTime;
        this.entityRecording = entityRecording;
        //BlockTapePlugin.getInstance().logMessage("In Constructor");
    }

    public void run() {
        //BlockTapePlugin.getInstance().logMessage("Run");
        if(recordTime > 0 && !target.isDead()) {
            EntitySnapshot s = new EntitySnapshot(target, target.getLocation());
            snapshots.add(s);
            recordTime--;
        }
        else{

            this.cancel();
            entityRecording.stopRecording();
        }
    }
    public void stop(){
        recordTime = 0;
    }


}
