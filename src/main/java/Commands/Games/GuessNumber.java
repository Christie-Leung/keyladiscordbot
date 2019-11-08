package Commands.Games;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.concurrent.TimeUnit;

public class GuessNumber extends Command {

    private final EventWaiter waiter;

    public GuessNumber(EventWaiter waiter) {
        this.waiter = waiter;
        this.name = "guess";
        this.help = "Generates a random number between 1-500 where you have to guess the number";
    }

    @Override
    protected void execute(CommandEvent event) {
        String number = String.valueOf((Math.random() * 500));

        event.reply("Guess a number.");
        waiter.waitForEvent(MessageReceivedEvent.class,
                e -> e.getAuthor().equals(event.getAuthor())
                        && e.getChannel().equals(event.getChannel())
                        && !e.getMessage().equals(event.getMessage()),
                e -> {
                    do {
                        event.replyWarning("Guess again");
                    } while(!event.getMessage().getContentRaw().contains(number));
                    event.replySuccess("Yess you guessed the number correctly");
                },
                1, TimeUnit.MINUTES, () -> event.reply("Sorry, you took too long."));
    }
}
