package command;

public class BuyHighForMarginCommand extends Command {
    @Override
    public boolean execute() {
        this.script.getGrandExchange().buyItem()
    }
}
