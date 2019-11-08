import Commands.Games.GuessNumber;
import Commands.Gifs.*;
import Commands.People.KeylaCommand;
import Commands.Random.*;
import Commands.Random.MovieList.MovieListCommand;
import Commands.Random.MovieList.MovieListSql;
import ComparingDateTime.ScheduleSql;
import ComparingDateTime.Timezones.TimezoneSql;
import ComparingDateTime.Timezones.Timezones;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class KeylaBot extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {

        ScheduleSql sql = new ScheduleSql();
        ScheduleSql.getConn();

        TimezoneSql timezoneSql = new TimezoneSql();
        TimezoneSql.getConn();

        MovieListSql movieListSql = new MovieListSql();
        MovieListSql.getConn();

        MessageListener messageListener = new MessageListener();
        EventWaiter waiter = new EventWaiter();

        String ownerId = "@!301028982684516352";

        CommandClientBuilder client = new CommandClientBuilder();
        client.setPrefix("!");
        client.setOwnerId(ownerId);
        client.setActivity(Activity.watching("you"));
        client.addCommands(
                new KeylaCommand(),
                new DisappointedGif(),
                new DistoomuchGif(),
                new IdgafGif(),
                new IdiotGif(),
                new IndeedGif(),
                new OrllyGif(),
                new OwowGif(),
                new YesGif(),
                new ConversationCommand(waiter),
                new ScheduleCommand(waiter, sql),
                new Timezones(timezoneSql),
                new SpamCommand(waiter),
                new DeleteLineCommand(),
                new SighGif(),
                new ClapCommand(),
                new CompareDatesCommand(),
                new OhYeahGif(),
                new PrayGif(),
                new EightBallCommand(),
                new MovieListCommand(waiter, movieListSql),
                new GuessNumber(waiter)
        );

        new JDABuilder("NjI2NTg3Nzg0NTA4ODY2NjAw.XbJC8A.3bZfUdDTnIhDtW1bC2IKX2YcO6U")
                .addEventListeners(messageListener, client.build(), waiter)
                .build();

    }
}
