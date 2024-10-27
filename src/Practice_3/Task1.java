package Practice_3;

import java.util.Scanner;
//Выполнила Ершова А.Д. Вариант 10

//Последовательность чисел Фибоначчи:
//Дано целое число N (> 2).
//Сформировать и вывести целочисленный массив размера N, содержащий N первых элементов последовательности чисел Фибоначчи

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число N (> 2): ");
        int N = scanner.nextInt();

        if (N <= 2) {
            System.out.println("Ошибка: N должно быть больше 2.");
            return;
        }

        int[] fibonacci = new int[N];
        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for (int i = 2; i < N; i++) {
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
        }

        System.out.println("Первые " + N + " элементов последовательности Фибоначчи:");
        for (int num : fibonacci) {
            System.out.print(num + " ");
        }
    }
}
