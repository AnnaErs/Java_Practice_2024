package Project_Ershova.tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static <T> List<T> filterItems(List<T> items, FilterCondition<T> condition) {
        return items.stream().filter(condition::test).collect(Collectors.toList());
    }

    public interface FilterCondition<T> {
        boolean test(T item);
    }
}
