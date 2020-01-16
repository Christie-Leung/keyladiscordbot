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
        final LocalDateTime[] date = new LocalDateTime[1];
        int year = LocalDateTime.now().getYear();


        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                List<String> schedule = ScheduleSql.getDate();
                if(!schedule.isEmpty()) {
                    for (String str : schedule) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        date[0] = LocalDateTime.parse(str, formatter);
                    }
                    if(LocalDateTime.now().isAfter(date[0])) {
                        String description = ScheduleSql.getFromDate(Timestamp.valueOf(date[0])).getDescription();
                        long name = ScheduleSql.get(description).getNameID();
                        ScheduleSql.delete(description);
                        User user = jda.getUserById(name);
                        eb.setColor(new Color(177, 240, 216))
                                .addField("Reminder!", "I was told to remind you of " + description + "! Now go do it >:V", false)
                                .build();
                        if(user != null) {
                            SpamCommand.sendPrivateEmbedMessage(user, eb);
                        }
                        ScheduleSql.delete(description);
                    }
                }

            }

        };
        timer.scheduleAtFixedRate(repeatedTask, 0, 6000);

        if(!event.getAuthor().isBot() &&
                event.isFromGuild()) {
            User keyla = jda.getUserById("301028982684516352");
            String msg;
            if(keyla != null) {
                if(event.getMessage().getContentRaw().contains("@!301028982684516352")) {
                    msg = event.getMessage().getContentRaw().replace("@!301028982684516352", "me ping");
                } else {
                    msg = event.getMessage().getContentRaw();
                }
                SpamCommand.sendPrivateMessage(keyla, "[" + event.getGuild().getName() + ": " + event.getChannel().getName() + "] (" + event.getAuthor().getName() + ") - " + msg);
            }
        }

        String x = event.getMessage().getContentRaw().toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();

        System.out.println(event.getMessage().getContentRaw());

        if(!event.getAuthor().isBot() && event.getMessage().getContentRaw().startsWith("!")) {

            stringBuilder.append(x);
            stringBuilder.deleteCharAt(0);
            String msg = stringBuilder.toString();
            int characters = stringBuilder.length();

            if(characters <= 200) {
                if(msg.startsWith("test")) {
                    channel.sendMessage("test").queue();
                } else if(msg.equalsIgnoreCase(">:V")) {
                    channel.sendMessage("<:latino:631336237197688833>").queue();
                } else {
                    int roll = (int) Math.floor(Math.random() * 100) - 1;
                    switch (stringBuilder.toString()) {
                        // People
                        case "die":
                            channel.sendMessage("<:mercy_assassinate:631336123678982145>").queue();
                            break;
                        case "tea":
                            channel.sendMessage("<:mercy_tea:631336204763398144>").queue();
                            break;
                        case "ew":
                            channel.sendMessage("<:keylastupidface:630989473554890752>").queue();
                            break;
                        case "catblob":
                            channel.sendMessage("<a:meow:667208085533753344>").queue();
                            break;
                        case "pepepagun":
                            channel.sendMessage("<a:PepegaGun:667211084595462165>").queue();
                            break;
                        case "peepoclap":
                            channel.sendMessage("<a:peepoClap:667211297573568552>").queue();
                            break;
                        case "feelsrainman":
                            channel.sendMessage("<a:FeelsRainMan:667211370466377760>").queue();
                            break;
                        case "hackermans":
                            channel.sendMessage("<a:HACKERMANS:667211334638764043>").queue();
                            break;
                        case "firepanda":
                            channel.sendMessage("<a:FirePanda:667209510745669662>").queue();
                            break;
                        case "kirbdance":
                            channel.sendMessage("<a:KirbDance:667211208020983809>").queue();
                            break;
                        case "monkaextreme":
                            channel.sendMessage("<a:monkaExtreme:667211256347885578>").queue();
                            break;
                        case "monkaomega":
                            channel.sendMessage("<a:monkaOmega:667211149057589251>").queue();
                            break;
                        case "racuwu":
                            channel.sendMessage(Strings.racuwu).tts(true).queue();
                            break;
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
                            channel.sendMessage(calendar.compareDates("Christmas Countdown", LocalDateTime.of(year, 12, 25, 0, 0, 0)).build()).queue();
                            break;
                        case "halloween":
                            channel.sendMessage(calendar.compareDates("Halloween Countdown", LocalDateTime.of(year, 10, 31, 0, 0, 0)).build()).queue();
                            break;
                      /*  default:
                            channel.sendMessage(msg).tts(true).queue();
                            break;*/

                    }
                }
            } else if(msg.contains("roblox") || msg.contains("fuck") || msg.contains("fornite")) {
                channel.deleteMessageById(channel.getLatestMessageId()).queue();
            } else {
                channel.sendMessage("```This exceeds the character limit```").queue();
                channel.sendMessage("Your msg has " + characters + " characters!").queue();
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

