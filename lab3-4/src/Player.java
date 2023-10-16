public class Player {
    //ГРАВЕЦЬ: ТУТ ЙОГО КРОКИ ТА МОЖЛИВІСТЬ ЗАДАТИ ЗНАК
    public static void human() {
        int positionX = 0;
        int positionY = 0;
        do {
            System.out.println("Введіть координати клітинки Горизонтально 1, 2 або 3");
            String valueX = Main.scanner.next();
            if (isNumeric(valueX)) {
                positionX = Integer.parseInt(valueX) - 1;
            } else {
                System.out.println("Некоректне значення");
                continue;
            }
            positionY = RulesChecking.revertCharToNumber();
        } while (!RulesChecking.isCellValid(positionX, positionY));

        Main.map[positionY][positionX] = MapRendering.X_CHAR;
    }
    public static boolean isNumeric(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
