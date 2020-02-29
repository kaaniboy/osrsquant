package command;

import org.osbot.rs07.api.GrandExchange;
import utils.GEUtils;

import static utils.ClientUtils.log;

public class BuyGECommand extends Command {
    @Override
    public boolean execute() {
        GrandExchange.Box box = GEUtils.getFirstAvailableBox();
        if (box == null) {
            log("NULL BOX!");
        } else {
            log(GEUtils.getFirstAvailableBox().name());
        }
        return true;
    }
}
