package Project_Ershova;

import Project_Ershova.tasks.Utils;

import java.util.Arrays;
import java.util.List;

public class UtilsTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = Utils.filterItems(numbers, num -> num % 2 == 0);

        System.out.println("Чётные числа: " + evenNumbers);

        List<String> names = Arrays.asList("Анна", "Борис", "Вера");
        List<String> filteredNames = Utils.filterItems(names, name -> name.startsWith("А"));

        System.out.println("Имена на букву А: " + filteredNames);
    }
}
