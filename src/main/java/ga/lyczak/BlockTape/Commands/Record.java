package ga.lyczak.BlockTape.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;
import ga.lyczak.BlockTape.Recordings.PlayerRecording;
import ga.lyczak.BlockTape.Recordings.Recording;
import ga.lyczak.BlockTape.Snapshots.PlayerSnapshot;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("record")
@Description("Record a player's movements to play back later.")
public class Record extends BaseCommand {
    @Subcommand("me")
    public void onRecordMe(Player player, String[] args) {


        PlayerRecording playerRecording = new PlayerRecording();
        playerRecording.startRecording(player);


    }
}
