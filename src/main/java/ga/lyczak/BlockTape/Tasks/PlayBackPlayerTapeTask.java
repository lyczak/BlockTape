package ga.lyczak.BlockTape.Tasks;

import ga.lyczak.BlockTape.BlockTapePlugin;
import ga.lyczak.BlockTape.Recordings.Tape;
import ga.lyczak.BlockTape.Snapshots.PlayerSnapshot;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.LinkedList;

public class PlayBackPlayerTapeTask extends BukkitRunnable {
    private LinkedList<PlayerSnapshot> snapshots;
    private int currentIndex = 0;
    private ArmorStand armorStand;
    private Player player;
    private EntityEquipment equipment;
    public PlayBackPlayerTapeTask(Tape<PlayerSnapshot> tape){
        snapshots = tape.getSnapshots();
        this.player = snapshots.get(0).getPlayer();
    }
    @Override
    public void run() {
        if(currentIndex >= snapshots.size()){
            armorStand.remove();
            this.cancel();
            return;
        }
        PlayerSnapshot snapshot = snapshots.get(currentIndex);
        if(currentIndex == 0){
            Location startLocation = snapshot.getLocation();
            armorStand = (ArmorStand) startLocation.getWorld().spawnEntity(startLocation, EntityType.ARMOR_STAND);

            armorStand.setCustomName(player.getDisplayName());

            ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1,(byte) 3);
            SkullMeta meta = (SkullMeta) skull.getItemMeta();
            meta.setOwner(player.getDisplayName());
            skull.setItemMeta(meta);
            armorStand.setHelmet(skull);

            armorStand.setGravity(false);

            armorStand.setBoots(snapshot.getBoots());
            armorStand.setLeggings(snapshot.getLeggings());
            armorStand.setChestplate(snapshot.getChestplate());
            armorStand.setItemInHand(snapshot.getHand());

            currentIndex++;
        }
        else{
            armorStand.setBoots(snapshot.getBoots());
            armorStand.setLeggings(snapshot.getLeggings());
            armorStand.setChestplate(snapshot.getChestplate());
            armorStand.setItemInHand(snapshot.getHand());

            armorStand.teleport(snapshot.getLocation());

            currentIndex++;
        }

    }
}
