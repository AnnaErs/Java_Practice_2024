package Practice_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;
import java.util.Scanner;
import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        Random random = new Random();

        while (!exit) {
            printMainMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    performAgeCalculation(scanner);
                    break;
                case "2":
                    printProgramInfo();
                    break;
                case "3":
                    printDeveloperInfo();
                    break;
                case "4":
                    tellAJoke(random);
                    break;
                case "5":
                    exit = true;
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Неверный ввод. Попробуйте снова.");
            }
        }
    }

    // Метод для вывода главного меню
    public static void printMainMenu() {
        System.out.println("\nГлавное меню:");
        System.out.println("1. Выполнить расчет");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. Рассказать шутку");
        System.out.println("5. Выход из программы");
        System.out.print("Выберите опцию: ");
    }

    // Метод для выполнения расчета возраста
    public static void performAgeCalculation(Scanner scanner) {
        LocalDate[] dates = new LocalDate[2]; // массив для хранения дат: [дата рождения, другая дата]

        dates[0] = getDateFromUser(scanner, "Введите дату вашего рождения (DD.MM.YYYY): ");
        dates[1] = getDateFromUser(scanner, "Введите дату для расчета (DD.MM.YYYY): ");

        calculateAndPrintAge(dates);
    }

    // Метод для ввода даты с консоли
    public static LocalDate getDateFromUser(Scanner scanner, String prompt) {
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

    // Метод для парсинга даты
    public static LocalDate parseDate(String dateStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    // Метод для расчета и вывода возраста или времени до/после даты рождения
    public static void calculateAndPrintAge(LocalDate[] dates) {
        LocalDate birthDate = dates[0];
        LocalDate otherDate = dates[1];
        Period period;

        if (otherDate.isBefore(birthDate)) {
            period = Period.between(otherDate, birthDate);
            System.out.println("Данная дата была за " + formatPeriod(period) + " до вашего рождения.");
        } else {
            period = Period.between(birthDate, otherDate);
            System.out.println("Вам в эту дату будет ровно " + formatPeriod(period) + ".");
        }
    }

    // Метод для форматирования периода
    public static String formatPeriod(Period period) {
        StringBuilder result = new StringBuilder();
        if (period.getYears() != 0) {
            result.append(period.getYears()).append(" ").append(declineYears(period.getYears())).append(" ");
        }
        if (period.getMonths() != 0) {
            result.append(period.getMonths()).append(" ").append(declineMonths(period.getMonths())).append(" ");
        }
        if (period.getDays() != 0) {
            result.append(period.getDays()).append(" ").append(declineDays(period.getDays())).append(" ");
        }
        return result.toString().trim();
    }

    // Методы для склонения

    // Метод для склонения слова "год"
    public static String declineYears(int years) {
        if (years % 10 == 1 && years % 100 != 11) {
            return "год";
        } else if (years % 10 >= 2 && years % 10 <= 4 && (years % 100 < 10 || years % 100 >= 20)) {
            return "года";
        } else {
            return "лет";
        }
    }

    // Метод для склонения слова "месяц"
    public static String declineMonths(int months) {
        if (months == 1) {
            return "месяц";
        } else if (months >= 2 && months <= 4) {
            return "месяца";
        } else {
            return "месяцев";
        }
    }

    // Метод для склонения слова "день"
    public static String declineDays(int days) {
        if (days == 1) {
            return "день";
        } else if (days >= 2 && days <= 4) {
            return "дня";
        } else {
            return "дней";
        }
    }

    // Метод для вывода информации о программе
    public static void printProgramInfo() {
        System.out.println("\nПрограмма вычисляет возраст на заданную дату.");
    }

    // Метод для вывода информации о разработчике
    public static void printDeveloperInfo() {
        System.out.println("\nИнформация о разработчике: Ершова Анна.");
    }

    // Метод для вывода случайной шутки
    public static void tellAJoke(Random random) {
        String[] jokes = {"— Что, здорово? — крикнул ему из поднебесья Винни-Пух. — Ну, на кого я похож?\n" + "— На медведя, который летит на воздушном шаре!\n" + "— А на маленькую черную тучку разве не похож? — тревожно спросил Пух.\n" + "— Не очень.\n" + "— Ну ладно, может быть, отсюда больше похоже.\n" + "\n" + "А. Милн. Винни-Пух и все-все-все", "Человека красит одежда. Голые люди имеют крайне малое влияние в обществе, а то и совсем никакого.\n" + "\n" + "М. Твен", "Есть только две бесконечные вещи: Вселенная и глупость. Хотя насчет Вселенной я не уверен.\n" + "\n" + "Альберт Эйнштейн", "Решение сложной задачи поручайте ленивому сотруднику: он найдет более легкий путь.\n" + "\n" + "Закон Хлейда", "Если возникает критическая ситуация, будите меня в любое время дня и ночи — даже если я на заседании кабинета министров.\n" + "\n" + "Рональд Рейган", "Симпсоны смотрят результаты лотереи.\n" + "Гомер. Этот парень, конечно, выиграл много денег, но есть одна вещь, которую не купишь ни за какие деньги!\n" + "Мардж. И что же это?\n" + "Гомер. Динозавр!", "Hа стpойку собиpается приехать комиссия. Пpоpаб инстpуктиpует pабочих: — Что бы ни случилось, делайте вид, что так и должно быть. \n Комиссия пpиехала, осматpивает. Вдpуг pухнула одна стена. \n Рабочий, pадостно посмотpев на часы: — Десять тpидцать пять. Точно по гpафику!", "Работа программиста и шамана имеет много общего — оба бормочут непонятные слова, совершают непонятные действия и не могут объяснить, как оно работает.", "— Почему ваши дети программиста всё время ссорятся?\n — Конфликт версий", "Один монитор — обычный программист, два монитора — продвинутый программист, три монитора — системный программист, четыре монитора — охранник."};


        int index = random.nextInt(jokes.length);
        System.out.println("\nШутка: " + jokes[index]);
    }
}

