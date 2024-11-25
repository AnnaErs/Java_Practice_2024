package Project_Ershova.tasks;

import java.io.*;
import java.util.*;

public class JokeProviderTask extends Task {
    private String[] jokes;
    private Random random = new Random();

    public JokeProviderTask(String filePath) throws CustomCheckedException {
        super("Рассказ шуток");
        this.jokes = loadJokesFromFile(filePath);
    }

    @Override
    public void execute() {
        if (jokes.length == 0) {
            System.out.println("\nНет доступных шуток!");
            return;
        }
        int index = random.nextInt(jokes.length);
        System.out.println("\nШутка: " + jokes[index]);
    }

    private String[] loadJokesFromFile(String filePath) throws CustomCheckedException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<String> jokesList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                jokesList.add(line);
            }
            return jokesList.toArray(new String[0]);
        } catch (FileNotFoundException e) {
            throw new CustomCheckedException("Файл с шутками не найден: " + filePath);
        } catch (IOException e) {
            throw new CustomCheckedException("Ошибка чтения файла с шутками: " + filePath);
        }
    }

    @Override
    public String toString() {
        return "JokeProviderTask: [шуток в файле = " + jokes.length + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        JokeProviderTask that = (JokeProviderTask) obj;
        return Arrays.equals(jokes, that.jokes);
    }
}

