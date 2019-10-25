package Commands.Random;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.concurrent.TimeUnit;

public class SpamCommand extends Command {

    private final EventWaiter waiter;

    public SpamCommand(EventWaiter waiter) {
        this.name = "spam";
        this.help = "wellllll";
        this.waiter = waiter;
    }

    public static void sendPrivateMessage(User user, String content) {
        // notice that we are not placing a semicolon (;) in the callback this time!
        user.openPrivateChannel().queue((channel) -> channel.sendMessage(content).queue());
    }

    public static void sendPrivateEmbedMessage(User user, EmbedBuilder content) {
        user.openPrivateChannel().queue((channel) -> channel.sendMessage(content.build()).queue());
    }

    @Override
    protected void execute(CommandEvent event) {

        String[] items = event.getArgs().split("\\s+");
        if(items.length >= 1) {
            User user = event.getMessage().getMentionedUsers().get(0);

            event.reply("What do you want to spam them with?");
            waiter.waitForEvent(MessageReceivedEvent.class,
                    // make sure it's by the same user, and in the same channel, and for safety, a different message
                    e -> e.getAuthor().equals(event.getAuthor())
                            && e.getChannel().equals(event.getChannel())
                            && !e.getMessage().equals(event.getMessage()),
                    // respond, inserting the name they listed into the response
                    e -> {
                        for (int x = 0; x < 10; x++) {
                            sendPrivateMessage(user, e.getMessage().getContentDisplay());
                        }
                    },
                    // if the user takes more than a minute, time out
                    1, TimeUnit.MINUTES, () -> event.reply("Sorry, you took too long."));
            sendPrivateMessage(user, "hi");
        } else {
            event.replyWarning("You stoopid");
        }
    }

}
