import java.util.Scanner;

public class MapRendering {
    public static final int MAP_SIZE = 3;
    public final static char EMPTY_FIELD = '■';
    public final static char O_CHAR = '⬤';
    public final static char X_CHAR = '✘';

    //ІНІЦІАЛІЗУЄ НОВУ КАРТУ, ТА ЗАПОВНЮЄ ВСІ ПУСТІ КЛІТИНКИ СИМВОЛАМИ КВАДРАТИКУ
    public static void initMap() {
        Main.map = new char[MAP_SIZE][MAP_SIZE];
        for (int vertical = 0; vertical < MAP_SIZE; vertical++) {
            for (int horizontal = 0; horizontal < MAP_SIZE; horizontal++) {
                Main.map[vertical][horizontal] = EMPTY_FIELD;
            }
        }

        printGameMap();
    }

    //ВИВОДИТЬ ІГРОВЕ ПОЛЕ У КОНСОЛЬ
    public static void printGameMap() {
        System.out.println(" ———————————————————");
        for (int i = 1; i < MAP_SIZE + 1; i++) {
            System.out.print("    " + i + "  ");
        }
        System.out.println();
        for (int vertical = 0; vertical < MAP_SIZE; vertical++) {
            char[] s = {'A', 'B', 'C'};
            System.out.print(s[vertical]);
            for (int horizontal = 0; horizontal < MAP_SIZE; horizontal++) {
                System.out.print(" | " + Main.map[vertical][horizontal] + " | ");
            }
            System.out.println();
        }
        System.out.println(" ———————————————————");

        Main.scanner = new Scanner(System.in);
    }
}
