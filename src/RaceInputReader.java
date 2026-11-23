import java.util.Scanner;

public class RaceInputReader {

    public Race readRace(Scanner scanner) {
        float distance = readPositiveFloat(scanner, "\nEnter target distance (km): ");

        while (true) {
            System.out.println("Enter target time:");
            int hours = readNonNegativeInt(scanner, "\tHours: ", "Hours cannot be negative.");
            int minutes = readNonNegativeInt(scanner, "\tMinutes: ", "Minutes cannot be negative.");
            int seconds = readNonNegativeInt(scanner, "\tSeconds: ", "Seconds cannot be negative.");

            if (hours * 3600 + minutes * 60 + seconds <= 0) {
                System.out.println("Invalid time! Total time must be greater than 00:00:00.\n");
                continue;
            }

            return new Race(distance, hours, minutes, seconds);
        }
    }

    private float readPositiveFloat(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextFloat()) {
                float value = scanner.nextFloat();
                if (value > 0) {
                    return value;
                }
                System.out.println("Distance must be greater than 0.\n");
            } else {
                System.out.println("Invalid input! Please enter a valid number.\n");
                scanner.next();
            }
        }
    }

    private int readNonNegativeInt(Scanner scanner, String prompt, String negativeError) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value >= 0) {
                    return value;
                }
                System.out.println(negativeError + "\n");
            } else {
                System.out.println("Invalid input! Please enter a whole number.\n");
                scanner.next();
            }
        }
    }
}
