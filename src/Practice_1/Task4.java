package Practice_1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

//Эта программа будет вычислять возраст или количество лет до/после даты рождения:

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Описание программы
        System.out.println("Эта программа вычисляет возраст на заданную дату.");

        // Ввод даты рождения
        System.out.print("Введите дату вашего рождения (год-месяц-день): ");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateStr);

        // Ввод другой даты
        System.out.print("Введите дату для расчета (год-месяц-день): ");
        String otherDateStr = scanner.nextLine();
        LocalDate otherDate = LocalDate.parse(otherDateStr);

        // Проверка, дата из прошлого или будущего
        if (otherDate.isBefore(birthDate)) {
            Period period = Period.between(otherDate, birthDate);
            System.out.printf("Данная дата была за %d лет, %d месяцев и %d дней до вашего рождения.%n",
                    period.getYears(), period.getMonths(), period.getDays());
        } else {
            Period period = Period.between(birthDate, otherDate);
            System.out.printf("Вам в эту дату будет %d лет, %d месяцев и %d дней.%n",
                    period.getYears(), period.getMonths(), period.getDays());
        }
    }
}
