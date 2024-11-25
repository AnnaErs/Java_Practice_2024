package Practice_5;

import java.util.Scanner;

import Practice_5.tasks.JokeProviderTask;
import Practice_5.tasks.Task;
import Practice_5.tasks.DateCalculatorTask;
import Practice_5.tasks.DeveloperInfoTask;
import Practice_5.tasks.Menu;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Task[] tasks = {
                new DateCalculatorTask(scanner),
                new DeveloperInfoTask("Информация о программе", "Программа вычисляет возраст на заданную дату."),
                new DeveloperInfoTask("Информация о разработчике", "Информация о разработчике: Ершова Анна."),
                new JokeProviderTask("src/Practice_5/jokes.txt")
        };

        Menu menu = new Menu(tasks);
        menu.run();
    }
}


