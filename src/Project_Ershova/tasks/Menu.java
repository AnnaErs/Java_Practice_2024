package Project_Ershova.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<AbstractTask> tasks;

    public Menu(List<AbstractTask> tasks) {
        this.tasks = new ArrayList<>(tasks);
        this.tasks.sort((a, b) -> a.getName().compareTo(b.getName())); // Сортировка задач по имени
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            printMenu();
            String choice = scanner.nextLine();

            try {
                int taskIndex = Integer.parseInt(choice) - 1;
                if (taskIndex >= 0 && taskIndex < tasks.size()) {
                    tasks.get(taskIndex).execute();
                } else if (taskIndex == tasks.size()) {
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
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).getName());
        }
        System.out.println((tasks.size() + 1) + ". Выход из программы");
        System.out.print("Выберите опцию: ");
    }
}
