package command;

import models.SimpleItemDefinition;
import org.osbot.rs07.api.ui.RS2Widget;
import utils.GEUtils;

public class SelectBuyItemCommand extends Command {
    private static final String SELECT_ITEM = "Select";
    private SimpleItemDefinition item;

    public SelectBuyItemCommand(SimpleItemDefinition item) {
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
