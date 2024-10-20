package Practice_2;

import java.util.Scanner;
import java.util.InputMismatchException;

//Выполнила Ершова Анна Дмитриевна, РИМ-140970
//Вариант 10

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Программа считает сумму ряда: Σ 1 / ln(n) для n от 2 до N.");
        Scanner scanner = new Scanner(System.in);

        int N = 0;
        while (N <= 1) {
            System.out.print("Введите целое число N (больше 1): ");
            try {
                N = scanner.nextInt();
                if (N <= 1) {
                    System.out.println("N должно быть больше 1. Попробуйте снова.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Неправильный ввод. Введите целое число.");
                scanner.next();
            }
        }

        double sum = 0;
        for (int n = 2; n <= N; n++) {
            sum += 1 / Math.log(n);
        }

        System.out.println("Сумма ряда: " + sum);
    }
}
