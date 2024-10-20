package Practice_2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Программа вычисляет выражение для arctg(X), используя сумму ряда.");
        Scanner scanner = new Scanner(System.in);

        double X = 0;
        int N = 0;

        while (Math.abs(X) >= 1) {
            System.out.print("Введите число X (|X| < 1): ");
            X = scanner.nextDouble();
            if (Math.abs(X) >= 1) {
                System.out.println("Неверное значение X. Оно должно быть по модулю меньше 1.");
            }
        }

        while (N <= 0) {
            System.out.print("Введите целое число N (больше 0): ");
            N = scanner.nextInt();
            if (N <= 0) {
                System.out.println("N должно быть больше 0. Попробуйте снова.");
            }
        }

        double result = 0;
        for (int n = 0; n < N; n++) {
            result += Math.pow(-1, n) * Math.pow(X, 2 * n + 1) / (2 * n + 1);
        }

        System.out.println("Результат: " + result);
    }
}
