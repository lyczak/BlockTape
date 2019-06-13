package ga.lyczak.BlockTape.Tasks;

import ga.lyczak.BlockTape.Recordings.Tape;
import ga.lyczak.BlockTape.Snapshots.PlayerSnapshot;
import ga.lyczak.BlockTape.Snapshots.Snapshot;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.LinkedList;

public class PlayBackPlayerTapeTask extends BukkitRunnable {
    private LinkedList<PlayerSnapshot> snapshots;
    private int currentIndex = 0;
    private Entity armorStand;
    public PlayBackPlayerTapeTask(Tape<PlayerSnapshot> tape){
        snapshots = tape.getSnapshots();
    }
    @Override
    public void run() {
        if(currentIndex == 0){
            Location startLocation = snapshots.get(0).getLocation();
            armorStand = startLocation.getWorld().spawnEntity(startLocation, EntityType.ARMOR_STAND);
            currentIndex++;
        }
        else if(currentIndex < snapshots.size()){
            armorStand.teleport(snapshots.get(currentIndex).getLocation());
            currentIndex++;
        }
        else{
            this.cancel();
        }
    }
}
