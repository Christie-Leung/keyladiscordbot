package Commands.Gifs;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class IdiotGif extends Command {

    public IdiotGif() {
        this.name = "idiot";
        this.help = "Idiot Sandwich";

    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        commandEvent.replySuccess("https://tenor.com/rEQV.gif");
    }
}
