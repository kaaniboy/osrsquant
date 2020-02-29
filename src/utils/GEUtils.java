package utils;

import org.osbot.rs07.api.GrandExchange;
import org.osbot.rs07.api.GrandExchange.Box;
import org.osbot.rs07.script.Script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GEUtils {
    private static final int F2P_BOX_COUNT = 3;

    private static Script script;

    private GEUtils() {

    }

    public static void setup(Script script) {
        GEUtils.script = script;
    }

    public static Box getFirstAvailableBox() {
        List<Box> boxes = new ArrayList<>(Arrays.asList(Box.values()));

        if (!script.worlds.isMembersWorld()) {
            boxes = boxes.subList(0, F2P_BOX_COUNT);
        }

        for (Box box : boxes) {
            if (script.getGrandExchange().getStatus(box) == GrandExchange.Status.EMPTY) {
                return box;
            }
        }
        return null;
    }
}
