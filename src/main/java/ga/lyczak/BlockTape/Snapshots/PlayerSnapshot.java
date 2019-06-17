package ga.lyczak.BlockTape.Snapshots;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayerSnapshot extends Snapshot {
    private Location location;
    private Player player;
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    public void setPlayer(Player player){ this.player = player; }

    public Player getPlayer() {
        return player;
    }

    @Override
    public String toString(){
        return location.getBlock().toString();
    }
}
