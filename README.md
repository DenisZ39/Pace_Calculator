# Pace Calculator

A lightweight, object-oriented Java CLI application for runners to calculate target running pace (`min/km`), track personal records, and persist race history in CSV format.

## Features

- **Pace Calculation**: Computes required running pace (`MM:SS min/km`) from any distance (km) and target duration (`HH:MM:SS`).
- **Best Pace (PR)**: Finds the race with the fastest pace across your history.
- **Longest Run**: Identifies your longest recorded distance (breaking ties by fastest time).
- **Total Distance**: Sums the total kilometers logged across all races.
- **CSV Persistence**: Automatically loads past races from `History.csv` on startup and saves updates on exit.
- **Input Validation**: Handles invalid numeric inputs, zero/negative values, and normalizes overflow seconds/minutes (e.g., `90` seconds → `1` minute `30` seconds).

## Project Structure

```text
src/
├── Main.java             # CLI menu loop and formatted console output
├── Race.java             # Domain model encapsulating race distance, duration, and pace math
├── History.java          # Manages the collection of races and computes statistics (PR, longest run, total km)
├── RaceInputReader.java  # Reads and validates user input from the console
└── FileManager.java      # Reads and writes race history to History.csv
```

## Requirements

- **Java 14 or higher** (tested with OpenJDK 25 / 26; compatible with Java 17 and 21 LTS).

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/DenisZ39/Pace_Calculator.git
   cd Pace_Calculator
   ```

2. Compile the source files:
   ```bash
   javac -d out src/*.java
   ```

3. Run the application:
   ```bash
   java -cp out Main
   ```

## Example Usage

```text
***********************
    Pace Calculator
***********************
1. Calculate Pace
2. Best Pace (PR)
3. Longest Run
4. Total Distance
5. Race History
6. Exit
***********************
Choose an option (1-6): 1

Enter target distance (km): 10
Enter target time:
	Hours: 0
	Minutes: 45
	Seconds: 30

Required pace: 04:33 min/km
```
