package Practice_4;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateCalculator dateCalculator = new DateCalculator(scanner);
        DeveloperInfo developerInfo = new DeveloperInfo();
        JokeProvider jokeProvider = new JokeProvider();

        boolean exit = false;
        while (!exit) {
            printMainMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    dateCalculator.calculateAge();
                    break;
                case "2":
                    developerInfo.printProgramInfo();
                    break;
                case "3":
                    developerInfo.printDeveloperInfo();
                    break;
                case "4":
                    jokeProvider.tellAJoke();
                    break;
                case "5":
                    exit = true;
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("\nГлавное меню:");
        System.out.println("1. Выполнить расчет");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. Рассказать шутку");
        System.out.println("5. Выход из программы");
        System.out.print("Выберите опцию: ");
    }
}



