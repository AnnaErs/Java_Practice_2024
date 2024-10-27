package Practice_3;
import java.util.Scanner;

//Проверка чередования четных и нечетных чисел:
//Дан целочисленный массив размера N. Проверить, чередуются ли в нем четные и нечетные числа.
//Если чередуются, то вывести 0, если нет, то вывести порядковый номер первого элемента, нарушающего закономерность.

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива N: ");
        int N = scanner.nextInt();

        int[] array = new int[N];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        boolean isAlternating = true;
        for (int i = 1; i < N; i++) {
            if (array[i] % 2 == array[i - 1] % 2) {
                System.out.println("Нарушение чередования на индексе: " + i);
                isAlternating = false;
                break;
            }
        }

        if (isAlternating) {
            System.out.println("Чередование четных и нечетных чисел соблюдено.");
        }
    }
}
