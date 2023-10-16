public class RulesChecking {

    //ПЕРЕВОДИТЬ БУКВИ(ВЕРТИКАЛЬ) У ЧИСЛО ЗНАЧЕННЯ
    public static int revertCharToNumber() {
        int result;
        Main.scanner.nextLine();
        System.out.println("Оберіть вертикаль: A, B, C");
        switch (Main.scanner.next()) {
            case "A":
                result = 0;
                break;
            case "B":
                result = 1;
                break;
            case "C":
                result = 2;
                break;
            default:
                return revertCharToNumber();
        }
        return result;
    }

    //ПЕРЕВІРКА ЧИ НЕ ВИХОДИТЬ ГРАВЕЦЬ ЗА МЕЖІ ІГРОВОГО ПОЛЯ ТА ЧИ ГРАВЕЦЬ НЕ НАМАГАЄТЬСЯ ЗАЙНЯТИ ЗАЙМАНЕ РАНІШЕ ПОЛЕ
    public static boolean isCellValid(int x, int y) {
        if (isCellOutOfMap(x) || isCellOutOfMap(y)) {
            return false;
        }

        if (Main.map[y][x] != MapRendering.EMPTY_FIELD) {
            return false;
        }

        return true;
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
        if (Main.map[0][0] == playerChar && Main.map[0][1] == playerChar && Main.map[0][2] == playerChar)
            return true;
        if (Main.map[1][0] == playerChar && Main.map[1][1] == playerChar && Main.map[1][2] == playerChar)
            return true;
        if (Main.map[2][0] == playerChar && Main.map[2][1] == playerChar && Main.map[2][2] == playerChar)
            return true;


        if (Main.map[0][0] == playerChar && Main.map[1][0] == playerChar && Main.map[2][0] == playerChar)
            return true;
        if (Main.map[0][1] == playerChar && Main.map[1][1] == playerChar && Main.map[2][1] == playerChar)
            return true;
        if (Main.map[0][2] == playerChar && Main.map[1][2] == playerChar && Main.map[2][2] == playerChar)
            return true;

        if (Main.map[0][2] == playerChar && Main.map[1][1] == playerChar && Main.map[2][2] == playerChar)
            return true;
        if (Main.map[0][2] == playerChar && Main.map[1][1] == playerChar && Main.map[2][0] == playerChar)
            return true;

        return false;
    }

    //ПЕРЕВІРКА ЧИ ЗАЛИШИЛИСЬ ЩЕ ХОДИ(ПУСТІ КЛІТИНКИ) НА КАРТІ
    public static boolean checkDraft() {
        for (int i = 0; i < MapRendering.MAP_SIZE; i++) {
            for (int j = 0; j < MapRendering.MAP_SIZE; j++) {
                if (Main.map[i][j] == MapRendering.EMPTY_FIELD) {
                    return false;
                }
            }
        }

        return true;
    }
}
