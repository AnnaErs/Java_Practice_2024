package Project_Ershova;

import Project_Ershova.tasks.GenericStorage;

public class GenericStorageTest {
    public static void main(String[] args) {
        GenericStorage<String> stringStorage = new GenericStorage<>();
        stringStorage.addItem("Привет");
        stringStorage.addItem("Мир");
        System.out.println("Содержимое хранилища строк: " + stringStorage);

        GenericStorage<Integer> intStorage = new GenericStorage<>();
        intStorage.addItem(10);
        intStorage.addItem(20);
        System.out.println("Содержимое хранилища чисел: " + intStorage);
    }
}
