package Practice_4;

import java.util.Scanner;

public class Task1 {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Считывание координат для каждой вершины
        System.out.print("Введите координаты вершины A через пробел (x y): ");
        Point a = new Point(scanner.nextDouble(), scanner.nextDouble());

        System.out.print("Введите координаты вершины B через пробел (x y): ");
        Point b = new Point(scanner.nextDouble(), scanner.nextDouble());

        System.out.print("Введите координаты вершины C через пробел (x y): ");
        Point c = new Point(scanner.nextDouble(), scanner.nextDouble());

        // Создание объекта треугольника
        Triangle triangle = new Triangle(a, b, c);

        // Отображение информации о треугольнике
        triangle.displayInfo();

        scanner.close();
    }

}
