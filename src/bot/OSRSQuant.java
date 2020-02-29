package bot;

import java.util.LinkedList;
import java.util.Queue;
import java.awt.*;

import command.*;
import org.osbot.rs07.api.def.ItemDefinition;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import utils.ClientUtils;
import utils.GEUtils;

@ScriptManifest(
        name = "OSRS Quant",
        author = "kaaniboy,steven85048",
        version = 1.0,
        info = "",
        logo = ""
)
public class OSRSQuant extends Script {
    private static final int LOOP_TIME = 800;

    private Queue<Command> commands = new LinkedList<>();

    @Override
    public void onStart() {
        ClientUtils.setup(this);
        GEUtils.setup(this);

        commands.offer(new OpenGECommand());
        commands.offer(new OpenBuyScreenCommand());
        commands.offer(new SelectBuyItemCommand(ItemDefinition.forId(1333)));
    }

    @Override
    public void onExit() {
        // Code here will execute after the script ends
    }

    @Override
    public int onLoop() {
        if (commands.isEmpty()) {
            log("There are no commands in the queue");
            return LOOP_TIME;
        }

        Command command = commands.peek();
        if (command.execute()) {
            commands.poll();
        }

        return LOOP_TIME;
    }

    @Override
    public void onPaint(Graphics2D g) {
        // This is where you will put your code for paint(s)
    }
}