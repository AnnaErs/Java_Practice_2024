package Project_Ershova;

import Project_Ershova.tasks.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание задач
        List<AbstractTask> tasks = new ArrayList<>();
        try {
            tasks.add(new DateCalculatorTask(scanner));
            tasks.add(new DeveloperInfoTask("Информация о программе", "Программа вычисляет возраст на заданную дату."));
            tasks.add(new DeveloperInfoTask("Информация о разработчике", "Информация о разработчике: Ершова Анна."));
            tasks.add(new JokeProviderTask("src/Project_Ershova/jokes.txt"));
        } catch (CustomCheckedException e) {
            System.err.println("Ошибка инициализации задач: " + e.getMessage());
            return;
        }

        // Создание меню и запуск программы
        Menu menu = new Menu(tasks);
        menu.run();
    }
}
