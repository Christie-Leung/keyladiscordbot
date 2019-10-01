package Commands;

import Listeners.CommandListener;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class HelpCommand extends BasicCommand {

    private CommandListener commandListener;

    public HelpCommand(CommandListener commandListener) {
        this.commandListener = commandListener;
    }


    @Override
    public String getName() {
        return "!help";
    }

    @Override
    public String execute(MessageReceivedEvent event, String... parameters) throws Exception {
        StringBuilder bob = new StringBuilder(
                "Hi, faggot!\n\nHere is a list of available commands. Type `!command` " +
                        "here or in a group chat to get detailed information on a " +
                        "command." + "\n```Markdown\n");
  /*      for (int i = 0; i < commandListener.getCommands().size(); i++) {
     bob.append("\n[" + (i + 1) + "]: !" +
       commandListener.getCommands().get(i).getName() + "\n " +
       commandListener.getCommands().get(i).getShortDescription() + "\n");
         }
         bob.append("```");

        EmbedBuilder builder = createEmbedBuilder();
         for (BasicCommand command : commandListener.getCommands()) {
         builder.addField("!" + command.getName(),
        command.getShortDescription(), false);
         }

        Map<String, EmbedBuilder> map = new HashMap<String, EmbedBuilder>();

        List<String> sortedKeys = Arrays.asList(map.keySet().toArray(new String[] {}));
        Collections.sort(sortedKeys);
*/
        return "Yo " + event.getAuthor().getAsMention() + ", ich hab dir die Liste geschickt.";

    }
}

