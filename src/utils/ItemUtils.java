package utils;

import org.osbot.rs07.api.def.ItemDefinition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static utils.ClientUtils.log;

public final class ItemUtils {
    private static final String MOST_TRADED_URL = "http://services.runescape.com/m=itemdb_oldschool/top100?list=0";
    private static final boolean F2P_ITEMS_ONLY = true;

    private static List<ItemDefinition> mostTraded;

    private ItemUtils() {

    }

    public static void setup() {
        mostTraded = loadMostTraded();

    }

    private static List<ItemDefinition> loadMostTraded() {
        String contents = loadPageContents(MOST_TRADED_URL);
        return new ArrayList<>();
    }

    private static String loadPageContents(String address) {
        try {
            URL url = new URL(address);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            String inputLine;
            StringBuffer contents = new StringBuffer();

            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                while ((inputLine = in.readLine()) != null) {
                    contents.append(inputLine);
                }
            }

            return contents.toString();
        } catch (Exception e) {
            // TODO: Proper error handling
            log(e.getMessage());
            return null;
        }
    }
}
