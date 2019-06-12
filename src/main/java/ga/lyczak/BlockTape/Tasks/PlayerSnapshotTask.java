package ga.lyczak.BlockTape.Tasks;

import ga.lyczak.BlockTape.BlockTapePlugin;
import ga.lyczak.BlockTape.Recordings.PlayerRecording;
import ga.lyczak.BlockTape.Snapshots.PlayerSnapshot;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedList;

public class PlayerSnapshotTask extends SnapshotTask<PlayerSnapshot> {
    private Player target;
    private int recordTime;
    private PlayerRecording playerRecording;
    public PlayerSnapshotTask(LinkedList<PlayerSnapshot> snapshots, Player target, int recordTime, PlayerRecording playerRecording) {
        super(snapshots);
        this.target = target;
        this.recordTime = recordTime;
        this.playerRecording = playerRecording;
        //BlockTapePlugin.getInstance().logMessage("In Constructor");
    }

    public void run() {
        //BlockTapePlugin.getInstance().logMessage("Run");
        if(recordTime > 0) {
            PlayerSnapshot s = new PlayerSnapshot();
            s.setLocation(target.getLocation());
            snapshots.add(s);
            recordTime--;
        }
        else{

            this.cancel();
            playerRecording.stopRecording();
        }
    }
    public void stop(){
        recordTime = 0;
    }


}
