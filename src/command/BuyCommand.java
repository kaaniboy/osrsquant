package command;

import org.osbot.rs07.api.GrandExchange;
import utils.GEUtils;

import static utils.ClientUtils.log;

public class BuyGECommand extends Command {
    private static final int FIRE_RUNE_ID = 554;
    @Override
    public boolean execute() {
        GrandExchange.Box box = GEUtils.getFirstAvailableBox();
        if (box == null) {
            log("No G.E. boxes are available");
            return false;
        }

        script.getGrandExchange().buyItem(FIRE_RUNE_ID, "fire rune", 5,1);

        return true;
    }
}
