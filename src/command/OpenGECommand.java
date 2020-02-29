package command;

import org.osbot.rs07.api.model.NPC;
import utils.Timing;

import static bot.ClientUtils.TIMEOUT_DURATION;

import static bot.ClientUtils.log;

public class OpenGECommand extends Command {
    private final String GE_CLERK_NAME = "Grand Exchange Clerk";
    private final String GE_CLERK_EXCHANGE = "Exchange";

    @Override
    public boolean execute() {
        NPC clerk = script.getNpcs().closest(GE_CLERK_NAME);
        if (clerk == null) {
            log("Failed to locate GE clerk");
            return false;
        }
        clerk.interact(GE_CLERK_EXCHANGE);
        Timing.waitCondition(() -> script.getGrandExchange().isOpen(), TIMEOUT_DURATION);

        return script.getGrandExchange().isOpen();
    }
}
