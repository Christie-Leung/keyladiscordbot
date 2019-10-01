package Listeners;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public abstract class MessageListener extends ListenerAdapter {

  /*  @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContentRaw();

        if (!event.getAuthor().isBot() && event.getMessage().getContentRaw().startsWith("!")) {

            String x = event.getMessage().getContentRaw();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(x);
            stringBuilder.deleteCharAt(0);

            channel.sendMessage("The message \"" + stringBuilder + "\" is sent by " + event.getAuthor().getName()).queue();

        }
    }*/

    protected JDA jda;

    /**
     */
    public MessageListener() {
        this.jda = jda;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().getId().equals(jda.getSelfUser().getId())) {
            return;
        }
     /*   try {
            if (event.isFromType(ChannelType.PRIVATE)) {
                handlePrivateMessage(event);
            } else {
                handlePublicMessage(event);
            }
        } catch (CommandExecutionException e) {
            System.out.println("CommandExecutionException: " + e.getMessage());
            send(event, ":no_entry: Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            send(event, ":no_entry: Error: " + e.getMessage());
        }*/
    }


    protected void send(MessageReceivedEvent event, String message) {
        event.getChannel().sendMessage(message).queue();
    }


    public abstract List<Object> getCommands();
}

