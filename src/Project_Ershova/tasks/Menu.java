package Project_Ershova.tasks;

import java.util.Scanner;
import java.util.Arrays;

public class Menu {
    private AbstractTask[] tasks;

    public Menu(AbstractTask[] tasks) {
        this.tasks = tasks.clone();
        Arrays.sort(this.tasks); // Сортировка задач по имени
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            printMenu();
            String choice = scanner.nextLine();

            try {
                int taskIndex = Integer.parseInt(choice) - 1;
                if (taskIndex >= 0 && taskIndex < tasks.length) {
                    tasks[taskIndex].execute();
                } else if (taskIndex == tasks.length) {
                    exit = true;
                    System.out.println("Выход из программы...");
                } else {
                    System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Введите число.");
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("\nГлавное меню:");
        for (int i = 0; i < tasks.length; i++) {
            System.out.println((i + 1) + ". " + tasks[i].getName());
        }
        System.out.println((tasks.length + 1) + ". Выход из программы");
        System.out.print("Выберите опцию: ");
    }
}
