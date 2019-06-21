package ga.lyczak.BlockTape.Snapshots;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class PlayerSnapshot extends Snapshot {
    private Location location;
    private Player player;
    private ItemStack helmet;
    private ItemStack chestplate;
    private ItemStack leggings;
    private ItemStack boots;
    private ItemStack hand;
    private boolean isDead;

    public ItemStack getChestplate() {
        return chestplate;
    }

    public ItemStack getLeggings() {
        return leggings;
    }

    public ItemStack getBoots() {
        return boots;
    }

    public ItemStack getHand() {
        return hand;
    }

    public ItemStack getHelmet() {
        return helmet;
    }

    public PlayerSnapshot(Player player, Location location) {
        this.player = player;
        this.location = location;
        EntityEquipment equipment = player.getEquipment();
        helmet = equipment.getHelmet();
        chestplate = equipment.getChestplate();
        leggings = equipment.getLeggings();
        boots = equipment.getBoots();
        hand = equipment.getItemInHand();
        isDead = player.isDead();


    }

    public void setPlayer(Player player){ this.player = player; }

    public Player getPlayer(){
      return player;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isDead() {
        return isDead;
    }
}
