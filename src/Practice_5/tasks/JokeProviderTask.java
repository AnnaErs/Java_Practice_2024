package Practice_5.tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class JokeProviderTask extends Task {
    private String[] jokes;
    private Random random = new Random();

    public JokeProviderTask(String filePath) {
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

    private String[] loadJokesFromFile(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            return lines.toArray(new String[0]);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла с шутками: " + e.getMessage());
            return new String[0];
        }
    }
}

