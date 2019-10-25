import Commands.General.Help;
import Commands.Random.SpamCommand;
import ComparingDateTime.CompareDates;
import ComparingDateTime.ScheduleSql;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MessageListener extends ListenerAdapter {

    private CompareDates calendar = new CompareDates();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        JDA jda = event.getJDA();
        MessageChannel channel = event.getChannel();
        final Timer timer = new Timer("Timer");
        EmbedBuilder eb = new EmbedBuilder();


        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                List<String> schedule = ScheduleSql.getDate();
                for (String str : schedule) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime date = LocalDateTime.parse(str, formatter);
                    if(LocalDateTime.now().isAfter(date)) {
                        String description = ScheduleSql.getFromDate(Timestamp.valueOf(date)).getDescription();
                        long name = ScheduleSql.get(description).getNameID();
                        LocalDateTime time = ScheduleSql.get(description).getTimestamp().toLocalDateTime();
                        ScheduleSql.delete(description);
                        User user = jda.getUserById(name);
                        channel.sendMessage("Reminder! <@!" + name + ">\n").queue();
                        channel.sendMessage(eb
                                .setColor(new Color(177, 240, 216))
                                .addField("Reminder!", "I was told to remind you of " + description + "! Now go do it >:V", false)
                                .build()).queue();
                        if(user != null) {
                            SpamCommand.sendPrivateEmbedMessage(user, calendar.compareDates(description, time));
                        }
                        ScheduleSql.delete(description);
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(repeatedTask, 0, 6000);

        if(!event.getAuthor().isBot()) {
            System.out.println("[" + event.getGuild().getName() + "] (" + event.getAuthor().getName() + ") - " + event.getMessage().getContentRaw());
        }
        if(!event.getAuthor().isBot() && event.getMessage().getContentRaw().startsWith("!")) {

            String x = event.getMessage().getContentRaw().toLowerCase();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(x);
            stringBuilder.deleteCharAt(0);
            String msg = stringBuilder.toString();
            int characters = stringBuilder.length();

            channel.sendMessage("The message \"" + stringBuilder + "\" is sent by " + event.getAuthor().getName()).queue();
            if(characters <= 200) {
                if(msg.startsWith("test")) {
                    channel.sendMessage("test").queue();
                } else {
                    int roll = (int) Math.floor(Math.random() * 100) - 1;
                    switch (stringBuilder.toString()) {
                        // People
                        case "racool":
                            channel.sendMessage(Strings.racool).tts(true).queue();
                            break;
                        case "josh":
                            channel.sendMessage(Strings.josh).tts(true).queue();
                            break;
                        case "server":
                            channel.sendMessage(Strings.server).tts(true).queue();
                            break;
                        case "keith":
                            channel.sendMessage(Strings.keith).tts(true).queue();
                            break;
                        case "carter":
                            if(roll % 2 == 0) {
                                channel.sendMessage(Strings.carterWrath).queue();
                            } else {
                                channel.sendMessage(Strings.carter).tts(true).queue();
                            }
                            break;
                        case "christie":
                            channel.sendMessage(Strings.christie).tts(true).queue();
                            break;
                        //random
                        case "help":
                            channel.sendMessage(Help.getHelp().build()).queue();
                            break;
                        case "ree":
                            channel.sendMessage(Strings.ree).tts(true).queue();
                            break;
                        case "christmas":
                            channel.sendMessage(calendar.compareDates("Christmas Countdown", LocalDateTime.of(2019, 12, 25, 0, 0, 0)).build()).queue();
                            break;
                        case "halloween":
                            channel.sendMessage(calendar.compareDates("Halloween Countdown", LocalDateTime.of(2019, 10, 31, 0, 0, 0)).build()).queue();
                            break;
                        default:
                            channel.sendMessage(msg).tts(true).queue();
                            break;

                    }
                }
            } else {
                channel.sendMessage("```This exceeds the character limit```").queue();
                channel.sendMessage("Your msg has " + characters + " charcaters!").queue();
            }

        }
    }



   /* protected JDA jda;


    public MessageListener() {
        this.jda = jda;
    }
    */

  /*  @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().getId().equals(jda.getSelfUser().getId())) {
            return;
        }
        try {
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
        }

    }
    */
}

