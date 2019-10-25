package Commands.Gifs;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class OrllyGif extends Command {

    public OrllyGif() {
        this.name = "orlly";
        this.help = "Really?";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        commandEvent.replySuccess("https://tenor.com/bbnbo.gif");
    }
}
