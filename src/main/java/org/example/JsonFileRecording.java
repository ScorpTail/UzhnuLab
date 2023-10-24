package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class JsonFileRecording {

    private final static String STATS_FILE_PATH = "./src/main/resources/user-info.json";

    public static void printStats() {
        JSONArray players = getStatsJSON();
        try {
            System.out.printf("| %-10s | %-8s |%n", "Ім'я користувача", "РАХУНОК");
            System.out.printf("-------------------------%n");
            for (Object objPlayer : players) {
                JSONObject player = (JSONObject) objPlayer;
                String name = (String) player.get("name");
                Long score = (Long) player.get("score");
                System.out.printf("| %-10s | %-8s |%n", name, score);
                if (players.indexOf(player) == players.size() - 1) {
                    System.out.printf("-------------------------%n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static JSONArray getStatsJSON() {
        JSONParser textToJsonParser = new JSONParser();
        JSONArray players = new JSONArray();

        try {
            File file = new File(STATS_FILE_PATH);

            if (file.exists() && file.length() > 0) {
                try (FileReader readingJsonFile = new FileReader(STATS_FILE_PATH)) {
                    Object obj = textToJsonParser.parse(readingJsonFile);
                    JSONObject jsonObject = (JSONObject) obj;
                    players = (JSONArray) jsonObject.get("players");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sortArray(players);
    }


    private static JSONArray sortArray(JSONArray jsonArray) {

        JSONArray sortedJsonArray = new JSONArray();

        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (Object o : jsonArray) {
            jsonValues.add((JSONObject) o);
        }

        jsonValues.sort(new Comparator<JSONObject>() {
            private static final String KEY = "score";

            @Override
            public int compare(JSONObject a, JSONObject b) {
                Long scoreA = (Long) a.get(KEY);
                Long scoreB = (Long) b.get(KEY);

                // Для сортування за спаданням змініть порядок scoreB і scoreA
                return scoreB.compareTo(scoreA);
            }
        });

        sortedJsonArray.addAll(jsonValues);

        return sortedJsonArray;
    }

    private static JSONObject createPlayer(String name, long score) {
        JSONObject player = new JSONObject();
        player.put("name", name);
        player.put("score", score);
        return player;
    }

    public static void addStats(String name, long score) {
        JSONArray jsonFileOfPlayers = getStatsJSON();
        boolean isPlayerExist = false;
        for (Object playerObj : jsonFileOfPlayers) {
            JSONObject player = (JSONObject) playerObj;
            if (player.get("name").equals(name)) {
                long currentScore = Long.parseLong(player.get("score").toString());
                isPlayerExist = true;
                player.replace("score", currentScore + score);
                break;
            }
        }

        if (!isPlayerExist) {
            jsonFileOfPlayers.add(createPlayer(name, score));
        }

        writeToFile(jsonFileOfPlayers);
    }

    private static void writeToFile(JSONArray players) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("players", players);

            try (FileWriter fileWriter = new FileWriter(STATS_FILE_PATH)) {
                fileWriter.write(jsonObject.toJSONString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Помилка при записі в файл: " + e.getMessage());
        }
    }

}
