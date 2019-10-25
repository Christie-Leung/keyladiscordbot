package Commands.Gifs;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class DisappointedGif extends Command {

    public DisappointedGif() {
        this.name = "disappointed";
        this.help = "Reality is often disappointing";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        commandEvent.replySuccess("https://tenor.com/66gI.gif");
    }
}
