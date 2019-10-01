import Listeners.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.List;

public class KeylaBot extends ListenerAdapter {

    private static ArrayList commands = new ArrayList();


    public static void main (String[] args) throws LoginException {
        JDA jda = new JDABuilder("NjI2NTg3Nzg0NTA4ODY2NjAw.XYwYBQ.geOnmu6vzZ9qmh9dj1X_BN9PRj4")
                .addEventListeners(new MessageListener() {
                    @Override
                    public List<Object> getCommands() {
                        return null;
                    }
                })
                .build();
/*
        CommandListener commandListener = new CommandListener(jda);
        addCommands(commandListener);
        jda.addEventListener(commandListener);
        */

     //   commands.add(new PingCommand());
    }
/*
    private static void addCommands(CommandListener commandListener) {
        List<Object> commands = commandListener.getCommands();
        commands.add(new HelpCommand(commandListener));
        commands.add(new RepeatCommand());
    }
    */

}
