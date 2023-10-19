import java.util.Scanner;

class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Menu();
        MapRendering.initMap();

        while (true) {
            Player.human();
            MapRendering.printGameMap();

            if (RulesChecking.checkWin(MapRendering.X_CHAR)) {
                //запис результату перемог гравця
                System.out.println("Гру закінчено! Переможець " + Player.getUserName());
                break;
            }

            if (RulesChecking.checkDraft()) {
                System.out.println("Гру закінчено!");
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
                break;
            }
        }
    }

    public static boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
