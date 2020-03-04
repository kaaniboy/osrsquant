package command;

import java.util.List;

public class CompoundCommand extends Command {
    List<Command> commands;

    protected CompoundCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public boolean execute() {
        for (Command command : commands) {
            boolean success = command.execute();
            if (!success) {
                return false;
            }
        }

        return true;
    }
}
