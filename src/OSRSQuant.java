import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;
import java.awt.*;

@ScriptManifest(name = "OSRS Quant", author = "kaaniboy,steven85048", version = 1.0, info = "", logo = "")
public class OSRSQuant extends Script {
    @Override
    public void onStart() {
        // Code here will execute before the loop is started
    }

    @Override
    public void onExit() {
        // Code here will execute after the script ends
    }

    @Override
    public int onLoop() {
        // The amount of time in milliseconds before the loop starts over
        return 100;
    }

    @Override
    public void onPaint(Graphics2D g) {
        // This is where you will put your code for paint(s)
    }
}