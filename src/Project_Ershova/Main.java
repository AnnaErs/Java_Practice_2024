package Project_Ershova;

import Project_Ershova.tasks.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание задач с использованием обновленного AbstractTask
        AbstractTask[] tasks;
        try {
            tasks = new AbstractTask[]{
                    new DateCalculatorTask(scanner),
                    new DeveloperInfoTask("Информация о программе", "Программа вычисляет возраст на заданную дату."),
                    new DeveloperInfoTask("Информация о разработчике", "Информация о разработчике: Ершова Анна."),
                    new JokeProviderTask("src/Project_Ershova/jokes.txt")
            };
        } catch (CustomCheckedException e) {
            System.err.println("Ошибка инициализации задач: " + e.getMessage());
            return; // Завершаем выполнение, если возникла ошибка
        }

        // Создание меню и запуск программы
        Menu menu = new Menu(tasks);
        menu.run();
    }
}
