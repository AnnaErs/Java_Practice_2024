package Practice_3;

import java.util.Scanner;

//Вывод элементов квадратной матрицы "уголками":
//Дана квадратная матрица A порядка M. Начиная с элемента A1,1, вывести ее элементы следующим образом («уголками»):
//все элементы первого столбца;
//элементы последней строки, кроме первого (уже выведенного) элемента;
//оставшиеся элементы второго столбца; оставшиеся элементы предпоследней строки и т. д.;
//последним выводится элемент A1,M.

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите порядок матрицы M: ");
        int M = scanner.nextInt();

        int[][] matrix = new int[M][M];
        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Элементы матрицы, выведенные \"уголками\":");
        printCorners(matrix, M);
    }

    public static void printCorners(int[][] matrix, int M) {
        for (int layer = 0; layer < (M + 1) / 2; layer++) {
            // Первый столбец текущего слоя
            for (int i = layer; i < M - layer; i++) {
                System.out.print(matrix[i][layer] + " ");
            }
            // Последняя строка текущего слоя
            for (int j = layer + 1; j < M - layer; j++) {
                System.out.print(matrix[M - layer - 1][j] + " ");
            }
            // Последний столбец текущего слоя
            for (int i = M - layer - 2; i >= layer; i--) {
                System.out.print(matrix[i][M - layer - 1] + " ");
            }
            // Первая строка текущего слоя
            for (int j = M - layer - 2; j > layer; j--) {
                System.out.print(matrix[layer][j] + " ");
            }
        }
    }
}
