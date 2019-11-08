package Commands.General;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class Help {

    public static EmbedBuilder getHelp() {
        EmbedBuilder eb = new EmbedBuilder();

        eb.setColor(Color.PINK);

        eb.addField("Commands", "Prefix is !", false);
        eb.addField("Peoples", "Racool - *says Yes Racool*" +
                "\nServer - *says Yes ServerRakoolio*" +
                "\nKeith - *says Yes Keith*" +
                "\nCarter - *says Yes Carter*" +
                "\nKeyla - *superior*", false);
        eb.addField("Gifs", "Disappointed - *Reality is often Disappointing*" +
                "\nOrlly - *Spiderman Really*" +
                "\nYes - *Yes Thanos*" +
                "\nIdiot - *Idiot Sandwich*" +
                "\nIdgaf - *Elsa*" +
                "\ndistoomuch - *Dis Tew Much*" +
                "\nowow - *Oh Wow*" +
                "\nIndeed - *Indeed Indeed Indeed Indeed*" +
                "\nSigh - *smh my head*", false);
        eb.addField("Random Stoof", "Help - *you stoopid >:V*" +
                "\nChristmas - *Christmas Countdown*" +
                "\nHalloween - *Halloween Countdown*" +
                "\nSpam - *hmm what is this*" +
                "\nRee - *Hmm I wonder what this does*" +
                "\nClap - *claps duhh*" +
                "\n8ball - *8ball*" +
                "\nSchedule add [yyyy mm dd HH MM ss] - *schedules an event*" +
                "\nSchedule delete [description] - *deletes a scheduled event*" +
                "\nSchedule getAll - *gets all scheduled events*" +
                "\nSchedule get [description]" +
                "\nMovieList add - *adds a movie*" +
                "\nMovieList delete [pos] - *deletes a movie from set position*" +
                "\nMovieList see - *gives the whole list of movies*", false);
        eb.setFooter("Made by the amazing me");
        eb.setThumbnail("https://static.highsnobiety.com/thumbor/D2-CEHR7chIZL5d1ckMynmWDdgU=/fit-in/480x320/smart/static.highsnobiety.com/wp-content/uploads/2019/05/03122833/pokemon-detective-pikachu-critic-reviews-01.jpg");
        return eb;
    }
}



