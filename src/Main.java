import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner scanner=new Scanner(System.in);
    void main(){
        //calculator de pace
        scanner.useLocale(Locale.US);
        boolean isRunning=true;
        int alege;
        History p=new History();

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
            alege = scanner.nextInt();

            switch (alege) {
                case 1 ->{
                    Read_Race_info r=new Read_Race_info();
                    Pace_calculator obj=r.add(scanner);
                    p.add(obj);
                }
                case 2 -> p.pr();
                case 3 -> p.longest_run();
                case 4 -> System.out.printf("\nTotal distance from all races is: %.2f\n\n",p.total_distance());
                case 5 -> p.print();
                case 6 -> {
                    isRunning = false;
                    System.out.println("Multumesc ca mi-ai folosit programul.\nMult succes!!!!!");
                }
                default -> System.out.println("Optiunea aleasa nu exista in meniu");
            }
        }
        scanner.close();
    }

}