package Commands.Gifs;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class IndeedGif extends Command {

    public IndeedGif() {
        this.name = "indeed";
        this.help = "Indeed Indeed Indeed Indeed";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        commandEvent.replySuccess("https://tenor.com/s1Ve.gif");
    }
}
