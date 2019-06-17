package ga.lyczak.BlockTape.Snapshots;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class PlayerSnapshot extends Snapshot {
    private Location location;
    private Player player;

    public PlayerSnapshot(Player player, Location location) {
        this.player = player;
        this.location = location;
    }

    public void setPlayer(Player player){ this.player = player; }

    public Player getPlayer(){
      return player;
    }

    public Location getLocation() {
        return location;
    }

}
