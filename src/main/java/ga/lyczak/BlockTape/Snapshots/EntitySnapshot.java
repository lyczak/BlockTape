package ga.lyczak.BlockTape.Snapshots;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class EntitySnapshot<S extends Entity> extends Snapshot {
    private Location location;
    private S entity;

    public EntitySnapshot(S entity, Location location){
        this.entity = entity;
        this.location = location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public Location getLocation() {
        return location;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(S entity) {
        this.entity = entity;
    }
}
