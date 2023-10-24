package org.example;

import java.util.Arrays;

public class MapRendering {
    public static char[][] map;
    public final static int MAP_SIZE = 3;
    public final static char EMPTY_FIELD = '■';
    public final static char O_CHAR = '⬤';
    public final static char X_CHAR = '✘';

    //ІНІЦІАЛІЗУЄ НОВУ КАРТУ, ТА ЗАПОВНЮЄ ВСІ ПУСТІ КЛІТИНКИ СИМВОЛАМИ КВАДРАТИКУ
    public static void initMap() {
        map = new char[MAP_SIZE][MAP_SIZE];
        for (char[] row : map) {
            Arrays.fill(row, EMPTY_FIELD);
        }
        printGameMap();
    }

    //ВИВОДИТЬ ІГРОВЕ ПОЛЕ У КОНСОЛЬ
    public static void printGameMap() {
        System.out.println("Хід гравця: " + Player.getUserName());

        // Виводимо номери стовпців
        System.out.print("     ");
        for (int i = 1; i <= MAP_SIZE; i++) {
            System.out.printf("%d       ", i);
        }
        System.out.println();


        for (int vertical = 0; vertical < MAP_SIZE; vertical++) {
            char[] rowLabels = {'A', 'B', 'C'};
            System.out.print(rowLabels[vertical]);

            for (int horizontal = 0; horizontal < MAP_SIZE; horizontal++) {
                System.out.printf(" |  %c  |", map[vertical][horizontal]);
            }
            System.out.println();

            if (vertical < MAP_SIZE - 1) {
                System.out.print("   ");
                System.out.print("—".repeat(21));
                System.out.println();
            }
        }
    }
}


