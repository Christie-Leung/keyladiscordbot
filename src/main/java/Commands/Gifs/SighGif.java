package Commands.Gifs;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class SighGif extends Command {

    public SighGif() {
        this.name = "sigh";
        this.help = "sigh";
    }

    @Override
    protected void execute(CommandEvent event) {
        int roll = (int) Math.floor(Math.random() * 100) - 1;
        if(roll % 2 == 0) {
            event.replySuccess("https://tenor.com/wYwq.gif");
        } else {
            event.replySuccess("https://tenor.com/Uipp.gif");
        }
    }
}
