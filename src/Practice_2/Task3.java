package Practice_2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Программа проверяет, имеются ли нечетные цифры в записи числа N.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число N: ");
        int N = scanner.nextInt();

        boolean hasOddDigit = false;

        while (N > 0) {
            int digit = N % 10;
            if (digit % 2 != 0) {
                hasOddDigit = true;
                break;
            }
            N /= 10;
        }

        System.out.println(hasOddDigit ? "Есть нечетные цифры." : "Нечетных цифр нет.");
    }
}
