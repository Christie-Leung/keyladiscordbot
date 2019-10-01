package Listeners;

import Commands.BasicCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

public class CommandListener extends MessageListener {

    private List<BasicCommand> commands = new ArrayList<BasicCommand>();

    /**
     * @param jda
     */
    public CommandListener(JDA jda) {
        super();
    }

    @Override
    public List<Object> getCommands() {
        return null;
    }


    private String executeCommand(MessageReceivedEvent event, BasicCommand command, String... parameters) throws Exception {
        return command.execute(event, parameters);
    }


}