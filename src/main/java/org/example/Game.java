package org.example;

public class Game {
    public static void start() {
        MapRendering.initMap();

        while (true) {
            Player.human();
            MapRendering.printGameMap();

            if (RulesChecking.checkWin(MapRendering.X_CHAR)) {
                System.out.println("Гру закінчено! Переможець " + Player.getUserName());
                JsonFileRecording.addStats(Player.getUserName(),2);
                break;
            }

            if (RulesChecking.checkDraft()) {
                System.out.println("Гру закінчено!");
                JsonFileRecording.addStats(Player.getUserName(),1);
                break;
            }

            AI ai = new AI(MapRendering.map);
            ai.makeAIMove();
            MapRendering.printGameMap();

            if (RulesChecking.checkWin(MapRendering.O_CHAR)) {
                //запис результату перемог комп'ютера
                System.out.println("Гру закінчено! Переміг комп'ютер");
                break;
            }

            if (RulesChecking.checkDraft()) {
                System.out.println("Гру закінчено!");
                JsonFileRecording.addStats(Player.getUserName(),1);
                break;
            }
        }
    }
}
