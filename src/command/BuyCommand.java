package command;

import org.osbot.rs07.api.GrandExchange;
import org.osbot.rs07.api.def.ItemDefinition;
import utils.GEUtils;

public class BuyCommand extends Command {
    private final ItemDefinition item;
    private int price;
    private int quantity;

    public BuyCommand(ItemDefinition item, int price, int quantity) {
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
                item.getId(),
                item.getName().toLowerCase(),
                price,
                quantity
        );
    }
}
