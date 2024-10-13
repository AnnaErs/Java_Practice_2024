package Practice_1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = getValidInteger(scanner, "Введите первое число: ");
        int b = getValidInteger(scanner, "Введите второе число: ");
        int c = getValidInteger(scanner, "Введите третье число: ");

        // Нахождение суммы двух наибольших чисел
        int sum;
        if (a >= b && a >= c) {
            sum = a + Math.max(b, c);
        } else if (b >= a && b >= c) {
            sum = b + Math.max(a, c);
        } else {
            sum = c + Math.max(a, b);
        }

        System.out.println("Сумма двух наибольших чисел: " + sum);
    }

    private static int getValidInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }
    }
}
