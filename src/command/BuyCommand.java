package command;

import models.SimpleItemDefinition;
import org.osbot.rs07.api.GrandExchange;
import utils.GEUtils;

public class BuyCommand extends Command {
    private final SimpleItemDefinition item;
    private int price;
    private int quantity;

    public BuyCommand(SimpleItemDefinition item, int price, int quantity) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public boolean execute() {
        GrandExchange.Box box = GEUtils.getFirstAvailableBox();
        if (box == null) {
            return false;
        }

        return script.getGrandExchange().buyItem(
                item.getID(),
                item.getName().toLowerCase(),
                price,
                quantity
        );
    }
}
