public class RulesChecking {

    //ПЕРЕВОДИТЬ БУКВИ(ВЕРТИКАЛЬ) У ЧИСЛО ЗНАЧЕННЯ
    public static int revertCharToNumber() {
        System.out.println("Оберіть вертикаль: A, B, C");
        String input = Main.scanner.next();
        return switch (input) {
            case "a","A" -> 0;
            case "b","B" -> 1;
            case "c","C" -> 2;
            default -> {
                System.out.println("Некоректне значення! Виберіть A, B або C.");
                yield revertCharToNumber();
            }
        };
    }


    //ПЕРЕВІРКА ЧИ НЕ ВИХОДИТЬ ГРАВЕЦЬ ЗА МЕЖІ ІГРОВОГО ПОЛЯ ТА ЧИ ГРАВЕЦЬ НЕ НАМАГАЄТЬСЯ ЗАЙНЯТИ ЗАЙМАНЕ РАНІШЕ ПОЛЕ
    public static boolean isCellValid(int x, int y) {
        boolean isOutOfMap = isCellOutOfMap(x) || isCellOutOfMap(y);
        boolean isNotEmpty = MapRendering.map[y][x] != MapRendering.EMPTY_FIELD;

        return !isOutOfMap && !isNotEmpty;
    }


    //ПЕРЕВІРКА ЧИ КЛІТИНКА НЕ ВИЙШЛА ЗА МЕЖІ
    public static boolean isCellOutOfMap(int position) {
        if (position < 0 || position >= MapRendering.MAP_SIZE) {
            System.out.println("НЕ коректне значення!");
            return true;
        }

        return false;
    }

    //ПЕРЕВІРКА ЯКИЙ ГРАВЕЦЬ ПЕРЕМІШ (ЖИВА ЛЮДИНА ЧИ КОМП)
    public static boolean checkWin(char playerChar) {
        if (MapRendering.map[0][0] == playerChar && MapRendering.map[0][1] == playerChar && MapRendering.map[0][2] == playerChar)
            return true;
        if (MapRendering.map[1][0] == playerChar && MapRendering.map[1][1] == playerChar && MapRendering.map[1][2] == playerChar)
            return true;
        if (MapRendering.map[2][0] == playerChar && MapRendering.map[2][1] == playerChar && MapRendering.map[2][2] == playerChar)
            return true;

        if (MapRendering.map[0][0] == playerChar && MapRendering.map[1][0] == playerChar && MapRendering.map[2][0] == playerChar)
            return true;
        if (MapRendering.map[0][1] == playerChar && MapRendering.map[1][1] == playerChar && MapRendering.map[2][1] == playerChar)
            return true;
        if (MapRendering.map[0][2] == playerChar && MapRendering.map[1][2] == playerChar && MapRendering.map[2][2] == playerChar)
            return true;

        if (MapRendering.map[0][0] == playerChar && MapRendering.map[1][1] == playerChar && MapRendering.map[2][2] == playerChar)
            return true;
        if (MapRendering.map[0][2] == playerChar && MapRendering.map[1][1] == playerChar && MapRendering.map[2][0] == playerChar)
            return true;

        return false;
    }


    //ПЕРЕВІРКА ЧИ ЗАЛИШИЛИСЬ ЩЕ ХОДИ(ПУСТІ КЛІТИНКИ) НА КАРТІ
    public static boolean checkDraft() {
        for (char[] row : MapRendering.map) {
            for (char cell : row) {
                if (cell == MapRendering.EMPTY_FIELD) {
                    return false;
                }
            }
        }
        return true;
    }

}
