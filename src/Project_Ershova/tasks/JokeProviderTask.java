package Project_Ershova.tasks;

import java.io.*;
import java.util.*;

public class JokeProviderTask extends AbstractTask {
    private Set<String> jokes; // Используем HashSet для исключения повторений
    private Random random = new Random();

    public JokeProviderTask(String filePath) throws CustomCheckedException {
        super("Рассказ шуток");
        this.jokes = loadJokesFromFile(filePath);
    }

    @Override
    public void execute() {
        if (jokes.isEmpty()) {
            System.out.println("\nНет доступных шуток!");
            return;
        }
        int index = random.nextInt(jokes.size());
        String joke = new ArrayList<>(jokes).get(index); // Преобразуем HashSet в ArrayList для случайного доступа
        System.out.println("\nШутка: " + joke);
    }

    private Set<String> loadJokesFromFile(String filePath) throws CustomCheckedException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Set<String> jokesSet = new HashSet<>();
            String line;
            while ((line = reader.readLine()) != null) {
                jokesSet.add(line.trim());
            }
            return jokesSet;
        } catch (FileNotFoundException e) {
            throw new CustomCheckedException("Файл с шутками не найден: " + filePath);
        } catch (IOException e) {
            throw new CustomCheckedException("Ошибка чтения файла с шутками: " + filePath);
        }
    }
}
