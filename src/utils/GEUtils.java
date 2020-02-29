package utils;

import org.osbot.rs07.api.GrandExchange;
import org.osbot.rs07.api.GrandExchange.Box;
import org.osbot.rs07.api.ui.RS2Widget;
import org.osbot.rs07.script.Script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GEUtils {
    private static final int F2P_BOX_COUNT = 3;

    // Widget IDs
    private static int CHATBOX_WIDGET_ID;
    private static int GE_WIDGET_ID;

    private static final int SEARCH_WIDGET_ID = 53;
    private static final int PRICE_WIDGET_ID = 26;

    private static Script script;

    private GEUtils() {

    }

    public static void setup(Script script) {
        GEUtils.script = script;

        CHATBOX_WIDGET_ID = script.getChatbox().getInterfaceId();
        GE_WIDGET_ID = script.getGrandExchange().getInterfaceId();
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

    public static RS2Widget getFirstSearchResultWidget() {
        return script.getWidgets().get(CHATBOX_WIDGET_ID, SEARCH_WIDGET_ID, 1);
    }

    public static RS2Widget getPriceWidget() {
        return script.getWidgets().get(GE_WIDGET_ID, PRICE_WIDGET_ID);
    }
}
