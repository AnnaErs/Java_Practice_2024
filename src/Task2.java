import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение x: ");
        double x = scanner.nextDouble();

        // Формула: y = x * sqrt(x) + x^5 + exp(x)
        double y = x * Math.sqrt(x) + Math.pow(x, 5) + Math.exp(x);

        System.out.printf("Значение функции y = %.3f (округлено до тысячных).%n", y);
        System.out.print("Желаете получить значение неокруглённое? (введите + или -): ");

        String input = scanner.next();

        if (input.equals("+")) {
            System.out.println("Неокруглённое значение y = " + y);
        } else if (input.equals("-")) {
            System.out.println("Для того, чтобы посчитать y ещё раз перезапустите программу");
        } else {
            System.out.println("Некорректный ввод. До свидания, я так не играю!");
            scanner.next();
        }


        //тут можно было использовать цикл, но я решила не усложнять, раз в задании этого не требуется

        scanner.close();
    }
}
