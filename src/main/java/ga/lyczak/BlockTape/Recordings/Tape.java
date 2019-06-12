package ga.lyczak.BlockTape.Recordings;

import ga.lyczak.BlockTape.Snapshots.Snapshot;

import java.util.LinkedList;

public class Tape<S extends Snapshot> {
    LinkedList<S> snapshots;
    public Tape(LinkedList<S> snapshots){
        this.snapshots = snapshots;
    }
    @Override
    public String toString(){
        String s = "";
        for (int i = 0; i < snapshots.size(); i++) {
            s += snapshots.toString() + "\n";
        }
        return s;
    }
}
