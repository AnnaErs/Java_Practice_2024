package Practice_3;

import java.util.Scanner;
import java.util.Arrays;

//Объединение двух отсортированных массивов:
//Даны два массива A и B размера N, элементы которых упорядочены по возрастанию.
//Объединить эти массивы так, чтобы результирующий массив C (размера 2N) остался упорядоченным по возрастанию.
//Реализовать в виде отдельного статического метода.

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массивов N: ");
        int N = scanner.nextInt();

        int[] A = new int[N];
        int[] B = new int[N];

        System.out.println("Введите элементы массива A по возрастанию:");
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        System.out.println("Введите элементы массива B по возрастанию:");
        for (int i = 0; i < N; i++) {
            B[i] = scanner.nextInt();
        }

        int[] C = mergeSortedArrays(A, B);

        System.out.println("Объединенный и отсортированный массив:");
        System.out.println(Arrays.toString(C));
    }

    public static int[] mergeSortedArrays(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        int i = 0, j = 0, k = 0;

        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }

        while (i < A.length) {
            C[k++] = A[i++];
        }

        while (j < B.length) {
            C[k++] = B[j++];
        }

        return C;
    }
}
