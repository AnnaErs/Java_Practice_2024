package Project_Ershova.tasks;

import java.util.ArrayList;
import java.util.List;

public class GenericStorage<T> {
    private List<T> items;

    public GenericStorage() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public void removeItem(int index) {
        items.remove(index);
    }

    public List<T> getAllItems() {
        return new ArrayList<>(items);
    }

    @Override
    public String toString() {
        return "GenericStorage{" +
                "items=" + items +
                '}';
    }
}
