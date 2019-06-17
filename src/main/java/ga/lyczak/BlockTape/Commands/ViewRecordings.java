package ga.lyczak.BlockTape.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import ga.lyczak.BlockTape.BlockTapePlugin;
import ga.lyczak.BlockTape.Recordings.Scene;
import ga.lyczak.BlockTape.Recordings.Tape;
import org.bukkit.entity.Player;

import java.util.LinkedList;

@CommandAlias("viewrecordings")
@Description("Displays the recordings saved")
public class ViewRecordings extends BaseCommand {
    @Default
    public void onView(Player player, String[] args){
        LinkedList<Scene> scenes = BlockTapePlugin.getScenes();

    }
}
