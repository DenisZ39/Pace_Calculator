import java.util.Scanner;

public class Read_Race_info {


    Pace_calculator add(Scanner scanner) {
        System.out.print("\nAdauga distanta dorita (km): ");
        float d = scanner.nextFloat();
        if (d <= 0) {
            System.out.println("Distanta trebuie sa fie o valoare mai mare decat 0!!!\n");
            return null;
        }
        System.out.println("Adauga timpul dorit!!");
        System.out.print("\t\tOre: ");
        int ore = scanner.nextInt();
        if (ore < 0) {
            System.out.println("Numar de ore invalid!!\n");
            return null;
        }
        System.out.print("\t\tMinute: ");
        int minute = scanner.nextInt();
        if (minute < 0) {
            System.out.println("Numar de minute invalid!!\n");
            return null;
        }
        System.out.print("\t\tSecunde: ");
        int secunde = scanner.nextInt();
        if (secunde < 0) {
            System.out.println("Numar de secunde invalid!!\n");
            return null;
        }
        if (secunde >= 60) {
            minute += secunde / 60;
            secunde = secunde % 60;
        }
        if (minute >= 60) {
            ore += minute / 60;
            minute = minute % 60;
        }
        Pace_calculator obj = new Pace_calculator(d, ore, minute, secunde);
        obj.pace_necesar();
        return obj;
    }
}
