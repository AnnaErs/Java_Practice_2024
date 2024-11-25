package Project_Ershova.tasks;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;

public class DateCalculatorTask extends AbstractTask {
    private Scanner scanner;

    public DateCalculatorTask(Scanner scanner) {
        super("Расчёт возраста");
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            LocalDate birthDate = getDateFromUser("Введите дату вашего рождения (DD.MM.YYYY): ");
            LocalDate otherDate = getDateFromUser("Введите дату для расчета (DD.MM.YYYY): ");
            printAgeDifference(birthDate, otherDate);
        } catch (CustomCheckedException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private LocalDate getDateFromUser(String prompt) throws CustomCheckedException {
        LocalDate date = null;
        while (date == null) {
            System.out.print(prompt);
            String dateStr = scanner.nextLine();
            try {
                date = parseDate(dateStr);
            } catch (DateTimeParseException e) {
                System.out.println("Неправильный формат даты. Попробуйте снова.");
            }
        }
        if (date.isAfter(LocalDate.now())) {
            throw new CustomCheckedException("Дата не может быть в будущем: " + date);
        }
        return date;
    }

    private LocalDate parseDate(String dateStr) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(dateStr, formatter);
    }

    private void printAgeDifference(LocalDate birthDate, LocalDate otherDate) {
        Period period = Period.between(birthDate, otherDate);
        System.out.println("Разница: " + period.getYears() + " лет, " + period.getMonths() + " месяцев, " + period.getDays() + " дней.");
    }
}
