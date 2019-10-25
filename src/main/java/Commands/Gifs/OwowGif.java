package Commands.Gifs;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class OwowGif extends Command {

    public OwowGif() {
        this.name = "owow";
        this.help = "Oh wow";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        commandEvent.replySuccess("https://tenor.com/1zzr.gif");
    }
}
