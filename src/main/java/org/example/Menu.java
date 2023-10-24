package org.example;

public class Menu {

    public Menu() {
        menu();
    }

    public void menu() {
        while (true) {
            printMenu();
            switch (Main.scanner.next()) {
                case "1":
                    Player.getUserName();
                    Game.start();
                    break;
                case "2":
                    System.out.print("Введіть ім'я гравця: ");
                    Player.setUserName(Main.scanner.next());
                    break;
                case "3":
                    JsonFileRecording.printStats();
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Оберіть пункт із списку");
            }
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

