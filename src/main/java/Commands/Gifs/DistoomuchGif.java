package Commands.Gifs;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class DistoomuchGif extends Command {

    public DistoomuchGif() {
        this.name = "distoomuch";
        this.help = "Dis tew much";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        commandEvent.replySuccess("https://tenor.com/wXIe.gif");
    }
}
