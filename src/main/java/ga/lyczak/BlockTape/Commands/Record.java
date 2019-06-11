package ga.lyczak.BlockTape.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;
import ga.lyczak.BlockTape.Recordings.Recording;
import ga.lyczak.BlockTape.Snapshots.PlayerSnapshot;
import org.bukkit.command.CommandSender;

@Description("Record a player's movements to play back later.")
public class Record extends BaseCommand {
    @Subcommand("me")
    public void onRecordMe(CommandSender sender) {
    }
}
