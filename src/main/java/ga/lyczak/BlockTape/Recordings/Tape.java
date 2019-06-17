package ga.lyczak.BlockTape.Recordings;

import ga.lyczak.BlockTape.BlockTapePlugin;
import ga.lyczak.BlockTape.Snapshots.EntitySnapshot;
import ga.lyczak.BlockTape.Snapshots.PlayerSnapshot;
import ga.lyczak.BlockTape.Snapshots.Snapshot;
import ga.lyczak.BlockTape.Tasks.PlayBackEntityTapeTask;
import ga.lyczak.BlockTape.Tasks.PlayBackPlayerTapeTask;

import java.util.LinkedList;

public class Tape<S extends Snapshot> {
    LinkedList<S> snapshots;
    public Tape(LinkedList<S> snapshots){
        this.snapshots = snapshots;
    }
    @Override
    public String toString(){
        return "";
    }

    public LinkedList<S> getSnapshots() {
        return snapshots;
    }
    public void run(){
        if(snapshots.getFirst() instanceof PlayerSnapshot){
            PlayBackPlayerTapeTask playBack = new PlayBackPlayerTapeTask((Tape<PlayerSnapshot>) this);
            playBack.runTaskTimer(BlockTapePlugin.getInstance(), 1, BlockTapePlugin.TICKS_PER_SNAPSHOT);
        }
        else if(snapshots.getFirst() instanceof EntitySnapshot){
            PlayBackEntityTapeTask playBack = new PlayBackEntityTapeTask((Tape<EntitySnapshot>) this);
            playBack.runTaskTimer(BlockTapePlugin.getInstance(), 1, BlockTapePlugin.TICKS_PER_SNAPSHOT);
        }
    }
}
