package command;

import org.osbot.rs07.api.ui.RS2Widget;
import utils.GEUtils;

import static utils.ClientUtils.log;

/*
An alternative is to use the existing getOverallPrice method,
but its response can be outdated because it pulls from the
OSBuddy API.

See: https://osbot.org/forum/topic/149620-return-value/?ct=1583006970
 */
public class RetrievePriceCommand extends Command {
    @Override
    public boolean execute() {
        RS2Widget priceWidget = GEUtils.getPriceWidget();
        if (priceWidget == null) {
            return false;
        }

        int price = Integer.parseInt(priceWidget.getMessage().replace(",", ""));
        return true;
    }
}
