package ga.lyczak.BlockTape.Tasks;

import ga.lyczak.BlockTape.BlockTapePlugin;
import ga.lyczak.BlockTape.Recordings.Tape;
import ga.lyczak.BlockTape.Snapshots.EntitySnapshot;
import ga.lyczak.BlockTape.Snapshots.PlayerSnapshot;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.LinkedList;

public class PlayBackEntityTapeTask extends BukkitRunnable {
    private LinkedList<EntitySnapshot> snapshots;
    private int currentIndex = 0;
    private Entity entity;
    public PlayBackEntityTapeTask(Tape<EntitySnapshot> tape){
        snapshots = tape.getSnapshots();
    }
    @Override
    public void run() {

        EntityType entityType = snapshots.get(0).getEntity().getType();
        if(entityType != EntityType.DROPPED_ITEM) {
            if (currentIndex == 0) {
                Location startLocation = snapshots.get(0).getLocation();
                this.entity = startLocation.getWorld().spawnEntity(startLocation, entityType);
                entity.teleport(startLocation);
                currentIndex++;
            } else if (currentIndex < snapshots.size()) {
                entity.teleport(snapshots.get(currentIndex).getLocation());
                currentIndex++;
            } else {
                entity.remove();
                this.cancel();
            }
        }
        else{
            this.cancel();
        }

    }
}
