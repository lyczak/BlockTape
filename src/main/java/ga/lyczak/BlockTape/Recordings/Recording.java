package ga.lyczak.BlockTape.Recordings;

import ga.lyczak.BlockTape.BlockTapePlugin;
import ga.lyczak.BlockTape.Snapshots.Snapshot;

import java.util.LinkedList;

public abstract class Recording<S extends Snapshot> {
    protected LinkedList<S> snapshots;


    protected boolean finishedRecording;

    public Recording() {
        snapshots = new LinkedList<S>();
    }

    public abstract boolean startRecording();

}
