package Practice_4;

public class Triangle {
    // Координаты вершин треугольника
    private Point a, b, c;

    // Конструктор
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Метод для вычисления длины стороны
    private double sideLength(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    // Длины сторон
    public double getSideAB() {
        return sideLength(a, b);
    }

    public double getSideBC() {
        return sideLength(b, c);
    }

    public double getSideCA() {
        return sideLength(c, a);
    }

    // Периметр треугольника
    public double getPerimeter() {
        return getSideAB() + getSideBC() + getSideCA();
    }

    // Площадь треугольника по формуле Герона
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - getSideAB()) * (s - getSideBC()) * (s - getSideCA()));
    }

    // Метод для отображения информации о треугольнике
    public void displayInfo() {
        System.out.println("Стороны треугольника: ");
        System.out.println("AB: " + getSideAB());
        System.out.println("BC: " + getSideBC());
        System.out.println("CA: " + getSideCA());
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
    }
}

