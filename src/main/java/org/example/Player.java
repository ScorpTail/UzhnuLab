package org.example;

public class Player {
    private static String userName = null;

    //ГРАВЕЦЬ: ТУТ ЙОГО КРОКИ ТА МОЖЛИВІСТЬ ЗАДАТИ ЗНАК
    /*public static void human() {
        int positionX = -1;
        int positionY = -1;
        do {
            System.out.println("Введіть координати клітинки Горизонтально 1, 2 або 3");
            String valueX = Main.scanner.next();
            if (isNumeric(valueX)) {
                positionX = Integer.parseInt(valueX) - 1;
            } else {
                continue;
            }
            positionY = RulesChecking.revertCharToNumber();
        } while (!RulesChecking.isCellValid(positionX, positionY));

        MapRendering.map[positionY][positionX] = MapRendering.X_CHAR;
    }*/
    public static void human() {
        int positionX;
        int positionY;

        while (true) {
            System.out.println("Введіть координати клітинки Горизонтально 1, 2 або 3");
            String valueX = Main.scanner.next();

            if (isNumeric(valueX)) {
                positionX = Integer.parseInt(valueX) - 1;
            } else {
                System.out.println("Некоректне значення. Введіть число від 1 до 3.");
                continue;
            }

            positionY = RulesChecking.revertCharToNumber();

            if (RulesChecking.isCellValid(positionX, positionY)) {
                break;
            } else {
                System.out.println("Обрана клітинка вже зайнята або поза межами гри. Спробуйте ще раз.");
            }
        }

        MapRendering.map[positionY][positionX] = MapRendering.X_CHAR;
    }

    public static String getUserName() {
        if (userName == null) {
            System.out.print("Введіть ваше ім'я для початку гри: ");
            Player.setUserName(Main.scanner.next());
        }
        return userName;
    }

    private static boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void setUserName(String userName) {
        Player.userName = userName;
    }
}

