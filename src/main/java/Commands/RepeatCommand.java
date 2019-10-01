package Commands;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class RepeatCommand extends BasicCommand {

    /**
     * Returns the command's name without prefix. Example: if you return
     * "fancycommand" and the currently configured prefix is "!", the bot will
     * execute your command when a user types "!fancycommand".
     *
     * @return The command's name
     */
    @Override
    public String getName() {
        return "!";
    }

    @Override
    public String execute(MessageReceivedEvent event, String... parameters) {
        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContentRaw();
        String y = null;

        if(!event.getAuthor().isBot() && event.getMessage().getContentRaw().startsWith("!")) {

            String x = event.getMessage().getContentRaw();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(x);
            stringBuilder.deleteCharAt(0);
            channel.sendMessage("The message \"" +
                    stringBuilder + "\" was sent by " +
                    event.getAuthor().getName());
        }
        return y;
    }
}
