package Commands.Gifs;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class IdgafGif extends Command {

    public IdgafGif() {
        this.name = "idgaf";
        this.help = "idgaf elsa";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {
        commandEvent.replySuccess("https://tenor.com/phPD.gif");
    }
}
