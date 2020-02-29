package utils;

import org.osbot.rs07.script.Script;

public final class ClientUtils {
    public static int TIMEOUT_DURATION = 5000;
    private static Script script;

    private ClientUtils() {

    }

    public static void setup(Script script) {
        ClientUtils.script = script;
    }

    public static void log(String message) {
        script.log(message);
    }

    public static Script getScript() {
        return script;
    }
}
