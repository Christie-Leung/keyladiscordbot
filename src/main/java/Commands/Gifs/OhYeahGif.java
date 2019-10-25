package Commands.Gifs;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class OhYeahGif extends Command {

    public OhYeahGif() {
        this.name = "ohyeah";
        this.help = "oh yeah";
    }

    @Override
    protected void execute(CommandEvent e) {
        e.replySuccess("https://tenor.com/GeSt.gif");
    }
}
