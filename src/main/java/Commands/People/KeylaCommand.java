package Commands.People;


import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class KeylaCommand extends Command {

    public KeylaCommand() {
        this.name = "keyla";
        this.help = "does keyla-y stoog";
    }


    @Override
    protected void execute(CommandEvent commandEvent) {
        commandEvent.replySuccess("__***THE WRATH OF KEYLA BAGUETTA***__\n" +
                ":cloud_lightning: :fire: :oncoming_police_car: :police_car: :oncoming_police_car: :regional_indicator_k: :regional_indicator_e: :regional_indicator_y: :regional_indicator_l: :regional_indicator_a: :oncoming_police_car: :police_car: :oncoming_police_car: :fire: :cloud_lightning:");
    }
}
