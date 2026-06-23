import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    void main() {
        //calculator de pace
        scanner.useLocale(Locale.US);
        boolean isRunning = true;
        History history = new History();
        FileManager fileManager = new FileManager();
        history.setObj(fileManager.saved_history());
        while (isRunning) {
            System.out.println("***********************");
            System.out.println("Calculator pentru pace!");
            System.out.println("***********************");
            System.out.println("1. Calculare Pace");
            System.out.println("2. Best pace");
            System.out.println("3. Longest run");
            System.out.println("4. Total distance from all races");
            System.out.println("5. History");
            System.out.println("6. Exit");
            System.out.println("***********************");

            System.out.println("Alege optiunea dorita (1-6)!");
            int alege=0;
            while(alege==0) {
                if (scanner.hasNextInt()) {
                    alege = scanner.nextInt();
                } else {
                    System.out.println("Invalid choice!!!\nNeed to be a number!!\n");
                    scanner.next();
                }
            }
            switch (alege) {
                case 1 -> {
                    Read_Race_info r = new Read_Race_info();
                    Pace_calculator obj = r.add(scanner);
                    history.add(obj);
                }
                case 2 -> history.pr();
                case 3 -> history.longest_run();
                case 4 -> System.out.printf("\nTotal distance from all races is: %.2f\n\n", history.total_distance());
                case 5 -> history.print();
                case 6 -> {
                    isRunning = false;
                    System.out.println("Multumesc ca mi-ai folosit programul.\nMult succes!!!!!");
                    fileManager.SaveHistory(history.getObj());
                }
                default -> System.out.println("\nOptiunea aleasa nu exista in meniu\n");
            }
        }
        scanner.close();
    }
}