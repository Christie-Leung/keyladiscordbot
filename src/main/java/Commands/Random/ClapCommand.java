package Commands.Random;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class ClapCommand extends Command {

    public ClapCommand() {
        this.name = "clap";
        this.help = "clap";
        this.arguments = "string...";
    }

    @Override
    protected void execute(CommandEvent event) {
        String str = event.getArgs();
        StringBuilder string = new StringBuilder();
        string.append(" :clap: ");

        for (Character c : str.toCharArray()) {
            if(!Character.isWhitespace(c)) { // Check if not white space print the char
                string.append(c);
            } else {
                string.append(" :clap: ");
            }
        }
        string.append(" :clap: ");

        event.replySuccess(string.toString());
    }
}
