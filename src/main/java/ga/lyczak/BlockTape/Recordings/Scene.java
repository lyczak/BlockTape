package ga.lyczak.BlockTape.Recordings;

import java.util.ArrayList;
import java.util.Collection;

import ga.lyczak.BlockTape.BlockTapePlugin;
import org.bukkit.entity.*;
public class Scene {
    ArrayList<Tape> tapes = new ArrayList<>();
    Collection<Entity> entities;
    public Scene(Collection<Entity> entities){
        this.entities = entities;
        for(Entity e: entities){
            if(e instanceof Player){
                PlayerRecording recording = new PlayerRecording();
                recording.startRecording(this, (Player) e);
            }
            else{
                EntityRecording recording = new EntityRecording();
                recording.startRecording(this, e);
            }
        }
    }
    public void run(){
        for(Tape t: tapes){
            t.run();
        }
    }
    public void addTape(Tape t){
        tapes.add(t);
        //BlockTapePlugin.logMessage("Added");
    }
}
