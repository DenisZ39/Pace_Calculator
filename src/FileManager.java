import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    private static final String DEFAULT_FILE_PATH = "History.csv";
    private final File historyFile;

    public FileManager() {
        this(DEFAULT_FILE_PATH);
    }

    public FileManager(String filePath) {
        this.historyFile = new File(filePath);
    }

    public void saveHistory(List<Race> races) {
        try (FileWriter fileWriter = new FileWriter(historyFile)) {
            for (Race race : races) {
                fileWriter.write(race.toCsv());
                fileWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error: Could not write to history file (" + e.getMessage() + ").");
        }
    }

    public List<Race> loadHistory() {
        List<Race> races = new ArrayList<>();
        if (!historyFile.exists()) {
            return races;
        }

        try (Scanner reader = new Scanner(historyFile)) {
            int lineNumber = 0;
            while (reader.hasNextLine()) {
                lineNumber++;
                String line = reader.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length != 4) {
                    System.out.println("Warning: Skipping malformed line " + lineNumber + " in " + historyFile.getName() + ".");
                    continue;
                }

                try {
                    float distance = Float.parseFloat(parts[0].trim());
                    int hours = Integer.parseInt(parts[1].trim());
                    int minutes = Integer.parseInt(parts[2].trim());
                    int seconds = Integer.parseInt(parts[3].trim());
                    races.add(new Race(distance, hours, minutes, seconds));
                } catch (IllegalArgumentException e) {
                    System.out.println("Warning: Skipping invalid entry on line " + lineNumber + " in " + historyFile.getName() + ".");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Could not read history file (" + e.getMessage() + ").");
        }

        return races;
    }
}
