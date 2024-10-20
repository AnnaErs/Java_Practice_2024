package Practice_2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Программа принимает два вещественных числа, сортирует их, и находит целые числа c и d.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое вещественное число a: ");
        double a = scanner.nextDouble();

        System.out.print("Введите второе вещественное число b: ");
        double b = scanner.nextDouble();

        processNumbers(a, b);
    }

    public static void processNumbers(double a, double b) {
        double max = Math.max(a, b);
        double min = Math.min(a, b);

        System.out.println("Числа в порядке возрастания: " + min + ", " + max);

        int c = (int) Math.ceil(max);
        int d = (int) Math.floor(min);

        System.out.println("c >= max(a,b): " + c + " >= " + max);
        System.out.println("min(a,b) >= d: " + min + " >= " + d);
    }
}
