package ga.lyczak.BlockTape.Tasks;

import ga.lyczak.BlockTape.Recordings.Tape;
import ga.lyczak.BlockTape.Snapshots.PlayerSnapshot;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.LinkedList;

public class PlayBackPlayerTapeTask extends BukkitRunnable {
    private LinkedList<PlayerSnapshot> snapshots;
    private int currentIndex = 0;
    private ArmorStand armorStand;
    public PlayBackPlayerTapeTask(Tape<PlayerSnapshot> tape){
        snapshots = tape.getSnapshots();
    }
    @Override
    public void run() {
        if(currentIndex == 0){
            Location startLocation = snapshots.get(0).getLocation();
            Player player = snapshots.get(0).getPlayer();
            armorStand = (ArmorStand) startLocation.getWorld().spawnEntity(startLocation, EntityType.ARMOR_STAND);
            armorStand.setCustomName(player.getDisplayName());
            ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1,(byte) 3);
            SkullMeta meta = (SkullMeta) skull.getItemMeta();
            meta.setOwner(player.getDisplayName());
            skull.setItemMeta(meta);
            armorStand.setHelmet(skull);
            currentIndex++;
        }
        else if(currentIndex < snapshots.size()){
            armorStand.teleport(snapshots.get(currentIndex).getLocation());

            currentIndex++;
        }
        else{
            armorStand.remove();
            this.cancel();
        }
    }
}
