public class Menu {

    public Menu() {
        this.printMenu();
        menu();
    }

    public void menu() {
        switch (Main.scanner.next()) {
            case "1":
                Player.getUserName();
                break;
            case "2":
                System.out.print("Введіть ім'я гравця: ");
                Player.setUserName(Main.scanner.next());
                break;
            case "3":
            case "4":
                System.exit(0);
                break;
            default:
                System.out.println("Оберіть пункт із списку");
        }
    }

    public void printMenu() {
        System.out.println("=".repeat(20));
        System.out.println("1. Почати Гру");
        System.out.println("2. Змінити ім'я гравця");
        System.out.println("3. Таблиця рейтингу");
        System.out.println("4. Вийти");
        System.out.println("=".repeat(20));
    }
}
