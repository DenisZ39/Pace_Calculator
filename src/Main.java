import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        History history = new History(fileManager.loadHistory());
        RaceInputReader inputReader = new RaceInputReader();

        try (Scanner scanner = new Scanner(System.in)) {
            scanner.useLocale(Locale.US);
            boolean isRunning = true;

            while (isRunning) {
                printMenu();
                int choice = readMenuChoice(scanner);

                switch (choice) {
                    case 1 -> {
                        Race race = inputReader.readRace(scanner);
                        System.out.printf("%nRequired pace: %s%n%n", race.getFormattedPace());
                        history.add(race);
                    }
                    case 2 -> printBestPace(history);
                    case 3 -> printLongestRun(history);
                    case 4 -> System.out.printf(Locale.US, "%nTotal distance across all races: %.2f km%n%n", history.getTotalDistance());
                    case 5 -> printHistory(history);
                    case 6 -> {
                        isRunning = false;
                        fileManager.saveHistory(history.getRaces());
                        System.out.println("\nRace history saved. Good luck with your runs!");
                    }
                    default -> System.out.println("\nInvalid option. Please choose a number between 1 and 6.\n");
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("***********************");
        System.out.println("    Pace Calculator    ");
        System.out.println("***********************");
        System.out.println("1. Calculate Pace");
        System.out.println("2. Best Pace (PR)");
        System.out.println("3. Longest Run");
        System.out.println("4. Total Distance");
        System.out.println("5. Race History");
        System.out.println("6. Exit");
        System.out.println("***********************");
    }

    private static int readMenuChoice(Scanner scanner) {
        while (true) {
            System.out.print("Choose an option (1-6): ");
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            System.out.println("Invalid choice! Please enter a number.\n");
            scanner.next();
        }
    }

    private static void printBestPace(History history) {
        Optional<Race> bestRace = history.getBestPaceRace();
        if (bestRace.isEmpty()) {
            System.out.println("\nNo races recorded yet.\n");
            return;
        }

        Race race = bestRace.get();
        int index = history.getRaces().indexOf(race) + 1;
        System.out.printf(Locale.US, "%nBest pace is Race #%d:%n", index);
        System.out.printf(Locale.US, "\t-> Distance: %.2f km%n", race.getDistanceKm());
        System.out.printf(Locale.US, "\t-> Time: %s%n", race.getFormattedTime());
        System.out.printf(Locale.US, "\t-> Pace: %s%n%n", race.getFormattedPace());
    }

    private static void printLongestRun(History history) {
        Optional<Race> longestRace = history.getLongestRun();
        if (longestRace.isEmpty()) {
            System.out.println("\nNo races recorded yet.\n");
            return;
        }

        Race race = longestRace.get();
        int index = history.getRaces().indexOf(race) + 1;
        System.out.printf(Locale.US, "%nLongest run is Race #%d:%n", index);
        System.out.printf(Locale.US, "\t-> Distance: %.2f km%n", race.getDistanceKm());
        System.out.printf(Locale.US, "\t-> Time: %s%n", race.getFormattedTime());
        System.out.printf(Locale.US, "\t-> Pace: %s%n%n", race.getFormattedPace());
    }

    private static void printHistory(History history) {
        if (history.isEmpty()) {
            System.out.println("\nNo races recorded yet.\n");
            return;
        }

        List<Race> races = history.getRaces();
        for (int i = 0; i < races.size(); i++) {
            Race race = races.get(i);
            System.out.printf(Locale.US, "%nRace #%d:%n", i + 1);
            System.out.printf(Locale.US, "\t-> Distance: %.2f km%n", race.getDistanceKm());
            System.out.printf(Locale.US, "\t-> Time: %s%n", race.getFormattedTime());
            System.out.printf(Locale.US, "\t-> Pace: %s%n", race.getFormattedPace());
        }
        System.out.println();
    }
}
