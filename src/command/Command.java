package command;

import utils.ClientUtils;
import org.osbot.rs07.script.Script;

public abstract class Command {
    protected Script script;

    public Command() {
        this.script = ClientUtils.getScript();
    }

    public abstract boolean execute();
}
