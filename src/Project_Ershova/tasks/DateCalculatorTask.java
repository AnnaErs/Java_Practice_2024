package Project_Ershova.tasks;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;

public class DateCalculatorTask extends AbstractTask {
    private Scanner scanner;

    public DateCalculatorTask(Scanner scanner) {
        super("Расчёт разницы между двумя датами");
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        try {
            LocalDate firstDate = getDateFromUser("Введите первую дату (DD.MM.YYYY): ");
            LocalDate otherDate = getDateFromUser("Введите вторую дату (DD.MM.YYYY): ");
            printAgeDifference(firstDate, otherDate);
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
