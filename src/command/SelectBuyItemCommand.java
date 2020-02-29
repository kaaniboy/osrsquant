package command;

import org.osbot.rs07.api.def.ItemDefinition;
import org.osbot.rs07.api.ui.RS2Widget;
import utils.GEUtils;

import static utils.ClientUtils.log;

/*
An alternative is to use the existing getOverallPrice method,
but its response can be outdated because it pulls from the
OSBuddy API.

See: https://osbot.org/forum/topic/149620-return-value/?ct=1583006970
 */
public class CheckPriceCommand extends Command {
    private static final String SELECT_ITEM = "Select";
    private ItemDefinition item;

    public CheckPriceCommand(ItemDefinition item) {
        this.item = item;
    }

    @Override
    public boolean execute() {
        script.getKeyboard().typeString(item.getName().toLowerCase());

        RS2Widget firstResultWidget = GEUtils.getFirstSearchResultWidget();
        if (firstResultWidget == null) {
            return false;
        }

        return firstResultWidget.interact(SELECT_ITEM);
    }
}
