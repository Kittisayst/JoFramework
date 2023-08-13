package Tools;

public class JoActionCommand {

    private final String actionCommand;

    public JoActionCommand(String actionCommand) {
        this.actionCommand = actionCommand;
    }

    public boolean isCommand(String command) {
        if (actionCommand != null) {
            return actionCommand.equals(command);
        } else {
            return false;
        }
    }
}
