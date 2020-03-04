package utils;

import models.SimpleItemDefinition;
import sun.java2d.pipe.SpanShapeRenderer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utils.ClientUtils.log;

public final class ItemUtils {
    private static final String MOST_TRADED_URL = "http://services.runescape.com/m=itemdb_oldschool/top100?list=0";

    private static final String ROW_REGEX = "<tr.*?<\\/tr>";
    private static final String ITEM_ID_REGEX = "obj=\\d+";
    private static final String ITEM_NAME_REGEX = "alt=\\\".*?\\\"";

    private static final Pattern rowPattern = Pattern.compile(ROW_REGEX);
    private static final Pattern itemIDPattern = Pattern.compile(ITEM_ID_REGEX);
    private static final Pattern itemNamePattern = Pattern.compile(ITEM_NAME_REGEX);

    private static final String P2P_ITEM_INDICATOR = "memberItem";
    private static final boolean F2P_ITEMS_ONLY = true;

    private static List<SimpleItemDefinition> mostTraded;
    private static Iterator<SimpleItemDefinition> mostTradedIterator;
    private static SimpleItemDefinition currentItem;

    private void ItemUtils() {

    }

    public static void setup() {
        mostTraded = loadMostTraded();
        mostTraded = mostTraded.subList(0, 3);
        mostTradedIterator = mostTraded.listIterator();
    }

    public static SimpleItemDefinition getNextItem() {
        if (mostTradedIterator.hasNext()) {
            currentItem = mostTradedIterator.next();
            return currentItem;
        }
        mostTradedIterator = mostTraded.listIterator();
        currentItem = getNextItem();
        return currentItem;
    }

    public static SimpleItemDefinition getCurrentItem() {
        return currentItem;
    }

    private static List<SimpleItemDefinition> loadMostTraded() {
        String contents = loadPageContents(MOST_TRADED_URL);

        if (contents == null) {
            return new ArrayList<>();
        }

        List<SimpleItemDefinition> items = new ArrayList<>();
        Matcher rowMatcher = rowPattern.matcher(contents);

        while (rowMatcher.find()) {
            String row = rowMatcher.group();
            if (F2P_ITEMS_ONLY && row.contains(P2P_ITEM_INDICATOR)) {
                continue;
            }

            Matcher itemIDMatcher = itemIDPattern.matcher(row);
            Matcher itemNameMatcher = itemNamePattern.matcher(row);

            if (itemIDMatcher.find() && itemNameMatcher.find()) {
                int itemID = Integer.parseInt(itemIDMatcher.group().split("=")[1]);
                String itemName = itemNameMatcher.group()
                        .split("=")[1].replace("\"", "");

                items.add(new SimpleItemDefinition(itemID, itemName));
            }
        }

        return items;
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
