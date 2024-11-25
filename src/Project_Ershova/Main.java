package Project_Ershova;

import java.util.Scanner;

import Project_Ershova.tasks.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Task[] tasks = null;
        try {
            tasks = new Task[]{
                    new DateCalculatorTask(scanner),
                    new DeveloperInfoTask("Информация о программе", "Программа вычисляет возраст на заданную дату."),
                    new DeveloperInfoTask("Информация о разработчике", "Информация о разработчике: Ершова Анна."),
                    new JokeProviderTask("src/Project_Ershova/jokes.txt")
            };
        } catch (CustomCheckedException e) {
            throw new RuntimeException(e);
        }

        Menu menu = new Menu(tasks);
        menu.run();
    }
}


