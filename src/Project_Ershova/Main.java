package Project_Ershova;

import Project_Ershova.tasks.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AbstractTask[] tasks;
        try {
            tasks = new AbstractTask[]{
                    new DateCalculatorTask(scanner),
                    new DeveloperInfoTask("Информация о программе", "Устали считать, сколько лет назад поженились ваши родители? Сколько лет двоюродной сестре? Вам поможет данная программа, которая вычисляет разницу между двумя датами."),
                    new DeveloperInfoTask("Информация о разработчике", "Информация о разработчике: Ершова Анна."),
                    new JokeProviderTask("src/Project_Ershova/jokes.txt")
            };
        } catch (CustomCheckedException e) {
            System.err.println("Ошибка инициализации задач: " + e.getMessage());
            return;
        }

        // Создаем меню и запускаем его
        Menu menu = new Menu(tasks);
        menu.run();
    }
}
