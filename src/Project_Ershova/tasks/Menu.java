package Project_Ershova.tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map<String, AbstractTask> taskMap;

    public Menu(AbstractTask[] tasks) {
        taskMap = new HashMap<>();
        for (AbstractTask task : tasks) {
            taskMap.put(task.getName(), task);
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            printMenu();
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("выход")) {
                exit = true;
                System.out.println("Выход из программы...");
            } else if (taskMap.containsKey(choice)) {
                taskMap.get(choice).execute();
            } else {
                System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("\nГлавное меню:");
        for (String taskName : taskMap.keySet()) {
            System.out.println("- " + taskName);
        }
        System.out.println("Напишите 'выход', чтобы завершить работу.");
        System.out.print("Выберите опцию: ");
    }
}
