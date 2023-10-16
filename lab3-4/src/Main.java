import java.util.Scanner;

class Main {
    public static char[][] map;
    public static Scanner scanner;

    public static void main(String[] args) {
        MapRendering.initMap();
        while (true) {
            Player.human();
            MapRendering.printGameMap();
            if (RulesChecking.checkWin(MapRendering.X_CHAR)) {
                System.out.println("Гру закінчено! Переможець гравець");
                break;
            }
            if (RulesChecking.checkDraft()) {
                System.out.println("Гру закінчено!");
                break;
            }

            AI ai = new AI(map);
            ai.makeAIMove();
            MapRendering.printGameMap();
            if (RulesChecking.checkWin(MapRendering.O_CHAR)) {
                System.out.println("Гру закінчено! Переміг комп'ютер");
                break;
            }
            if (RulesChecking.checkDraft()) {
                System.out.println("Гру закінчено!");
                break;
            }
        }
    }

}
