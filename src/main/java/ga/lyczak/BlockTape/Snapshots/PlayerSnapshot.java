package ga.lyczak.BlockTape.Snapshots;

import org.bukkit.Location;

public class PlayerSnapshot extends Snapshot {
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString(){
        return location.getBlock().toString();
    }
}
