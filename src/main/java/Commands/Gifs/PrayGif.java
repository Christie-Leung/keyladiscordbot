package Commands.Gifs;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class PrayGif extends Command {
    public PrayGif() {
        this.name = "pray";
        this.help = "yes";
    }

    @Override
    protected void execute(CommandEvent e) {
        e.replySuccess("https://tenor.com/T5O9.gif");
    }
}
