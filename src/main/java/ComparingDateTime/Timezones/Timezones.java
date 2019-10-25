package ComparingDateTime.Timezones;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Timezones extends Command {

    public Timezones(TimezoneSql timezoneSql) {
        this.name = "timezone";
        this.help = "saves user timezone";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {


    }
}
