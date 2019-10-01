package Commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public abstract class BasicCommand {

    /**
     * Returns the command's name without prefix. Example: if you return
     * "fancycommand" and the currently configured prefix is "!", the bot will
     * execute your command when a user types "!fancycommand".
     *
     * @return The command's name
     */
    public abstract String getName();

    /**
     * Returns how many parameters the command requires.
     *
     * @return Number of required parameters
     */
    public int getRequiredParameterCount() {
        return 0;
    }

    /**
     * If the command's parameters should not be delimited by spaces, you can
     * override this method.
     *
     * @return The char that parameters are delimited by, for example '='
     */
    public char getParameterDelimiter() {
        return ' ';
    }

    /**
     * Executes the command and returns a String to display in Discord as
     * response. This method is only called if
     * {@link #isExecutable(MessageReceivedEvent, String...)} previously
     * returned <code>true</code>.
     *
     * @param event
     *            The {@link MessageReceivedEvent} that contains the command
     * @param parameters
     *            String Array containing the command's parameters. You can
     *            assume that its size equals the result of
     *            {@link #getRequiredParameterCount()}.
     * @return A message that will be send to the text chat in which the command
     *         has been called
     * @throws Exception
     *             Might throw any kind of exception while executing the command
     */
    public abstract String execute(MessageReceivedEvent event, String... parameters) throws Exception;

    /**
     * Returns a longer description of the command, used when the command is
     * called using the "-help" option.
     *
     * @return The description
     */
    public String getLongDescription() {
        return "(no detailed description available)";
    }

    /**
     * Checks if the command can be executed using the given
     * {@link MessageReceivedEvent} and parameter set. If a user attempts to use
     * a command, this method is called first. If it returns true,
     * {@link #execute(MessageReceivedEvent, String...)}
     *
     * @param event
     *            The {@link MessageReceivedEvent} that contains the command
     * @param parameters
     *            String Array containing the command's parameters. You can
     *            assume that its size equals the result of
     *            {@link #getRequiredParameterCount()}.
     * @return true if the command can be executed.
     */
    public boolean isExecutable(MessageReceivedEvent event, String... parameters) {
        return true;
    }

    /**
     * Returns an example of how the command can be used. Will be displayed when
     * the command is called using the "-help" option.
     *
     * @return The example
     */
    public String getExampleUsage() {
        StringBuilder bob = new StringBuilder("!" + getName());
        for (int i = 0; i < getRequiredParameterCount(); i++) {
            if (i == 0) {
                bob.append(" [parameter0]");
            } else {
                bob.append(getParameterDelimiter() + "[parameter" + i + "]");
            }
        }
        return bob.toString();
    }


}
