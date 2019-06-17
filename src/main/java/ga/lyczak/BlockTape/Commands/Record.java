package ga.lyczak.BlockTape.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;
import ga.lyczak.BlockTape.BlockTapePlugin;
import ga.lyczak.BlockTape.Recordings.PlayerRecording;
import ga.lyczak.BlockTape.Recordings.Recording;
import ga.lyczak.BlockTape.Recordings.Scene;
import ga.lyczak.BlockTape.Snapshots.PlayerSnapshot;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@CommandAlias("record")
@Description("Record a player's movements to play back later.")
public class Record extends BaseCommand {
    @Subcommand("me")
    public void onRecordMe(Player player, String[] args) {
        Location location = player.getLocation();
        Collection<Entity> nearbyEntities = location.getWorld().getNearbyEntities(location, 128, 128, 128);
        Scene scene = new Scene(nearbyEntities);
        BlockTapePlugin.addScene(scene);



    }
}
