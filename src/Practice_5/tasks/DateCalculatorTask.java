package Practice_5.tasks;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;

public class DateCalculatorTask extends Task {
    private Scanner scanner;

    public DateCalculatorTask(Scanner scanner) {
        super("Расчет возраста");
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        LocalDate birthDate = getDateFromUser("Введите дату вашего рождения (DD.MM.YYYY): ");
        LocalDate otherDate = getDateFromUser("Введите дату для расчета (DD.MM.YYYY): ");
        printAgeDifference(birthDate, otherDate);
    }

    private LocalDate getDateFromUser(String prompt) {
        LocalDate date = null;
        while (date == null) {
            System.out.print(prompt);
            String dateStr = scanner.nextLine();
            date = parseDate(dateStr);
            if (date == null) {
                System.out.println("Неправильный формат даты. Попробуйте снова.");
            }
        }
        return date;
    }

    private LocalDate parseDate(String dateStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private void printAgeDifference(LocalDate birthDate, LocalDate otherDate) {
        Period period = otherDate.isBefore(birthDate) ? Period.between(otherDate, birthDate) : Period.between(birthDate, otherDate);
        System.out.println(otherDate.isBefore(birthDate) ?
                "Эта дата была за " + formatPeriod(period) + " до вашего рождения." :
                "Вам в эту дату будет ровно " + formatPeriod(period) + ".");
    }

    private String formatPeriod(Period period) {
        StringBuilder result = new StringBuilder();
        if (period.getYears() != 0) result.append(period.getYears()).append(" ").append(declineYears(period.getYears())).append(" ");
        if (period.getMonths() != 0) result.append(period.getMonths()).append(" ").append(declineMonths(period.getMonths())).append(" ");
        if (period.getDays() != 0) result.append(period.getDays()).append(" ").append(declineDays(period.getDays())).append(" ");
        return result.toString().trim();
    }

    private String declineYears(int years) {
        if (years % 10 == 1 && years % 100 != 11) {
            return "год";
        } else if (years % 10 >= 2 && years % 10 <= 4 && (years % 100 < 10 || years % 100 >= 20)) {
            return "года";
        } else {
            return "лет";
        }
    }

    private String declineMonths(int months) {
        if (months == 1) {
            return "месяц";
        } else if (months >= 2 && months <= 4) {
            return "месяца";
        } else {
            return "месяцев";
        }
    }

    private String declineDays(int days) {
        if (days == 1) {
            return "день";
        } else if (days >= 2 && days <= 4) {
            return "дня";
        } else {
            return "дней";
        }
    }
}

