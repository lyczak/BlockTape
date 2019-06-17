package ga.lyczak.BlockTape.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;
import ga.lyczak.BlockTape.BlockTapePlugin;
import ga.lyczak.BlockTape.Recordings.Scene;
import ga.lyczak.BlockTape.Recordings.Tape;
import ga.lyczak.BlockTape.Snapshots.Snapshot;
import ga.lyczak.BlockTape.Tasks.PlayBackPlayerTapeTask;
import org.bukkit.entity.Player;

import java.util.LinkedList;

@CommandAlias("playback")
@Description("Plays back a recording")
public class PlayBack extends BaseCommand {
    @Default
    public void onPlayBack(Player player, String[] args) {
        int numToPlay = 0;
        if(args.length == 0){
            player.sendRawMessage("Please indicate which recording to play back");
        }
        else{
            try {
                numToPlay = Integer.parseInt(args[0]);
            }
            catch(NumberFormatException e){
                player.sendRawMessage("Please input a number to indicate the recording you would like to play back");
            }
        }
        LinkedList<Scene> scenes = BlockTapePlugin.getScenes();
        if(numToPlay > 0 && numToPlay < scenes.size() + 1){
            Scene toPlay = scenes.get(numToPlay - 1);
            toPlay.run();

        }
    }
}
