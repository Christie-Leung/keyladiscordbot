package Commands.Gifs;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class YesGif extends Command {

    public YesGif() {
        this.name = "yes";
        this.help = "Yes Thanos";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        commandEvent.replySuccess("https://tenor.com/7zZn.gif");
    }
}
