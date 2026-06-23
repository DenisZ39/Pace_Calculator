import java.lang.classfile.attribute.SyntheticAttribute;
import java.util.Scanner;

public class Read_Race_info {


    Pace_calculator add(Scanner scanner) {
        System.out.print("\nAdauga distanta dorita (km): ");
        float d=-1;
        while(d==-1) {
            if (scanner.hasNextFloat() ) {
                d = scanner.nextFloat();
                if (d <=0) {
                    System.out.println("Distanta trebuie sa fie o valoare mai mare decat 0!!!\n");
                    d=-1;
                }
            } else {
                System.out.println("Need to be a number!!!\n");
                scanner.next();
            }
        }
        boolean ok=false;
        int ore=0,minute=0,secunde=0;
        while(!ok) {
            System.out.println("Adauga timpul dorit!!");
            System.out.print("\t\tOre: ");
            ore = -1;
            while (ore == -1) {
                if (scanner.hasNextInt()) {
                    ore = scanner.nextInt();
                    if (ore < 0) {
                        System.out.println("Numar de ore invalid!!\n");
                        ore = -1;
                    }
                } else {
                    System.out.println("Need to be a number!!!\n");
                    scanner.next();
                }
            }
            System.out.print("\t\tMinute: ");
            minute = -1;
            while (minute == -1) {
                if (scanner.hasNextInt()) {
                    minute = scanner.nextInt();
                    if (minute < 0) {
                        System.out.println("Numar de minute invalid!!\n");
                        minute = -1;
                    }
                } else {
                    System.out.println("Need to be a number!!!\n");
                    scanner.next();
                }
            }
            System.out.print("\t\tSecunde: ");
            secunde = -1;
            while (secunde == -1) {
                if (scanner.hasNextInt()) {
                    secunde = scanner.nextInt();
                    if (secunde < 0) {
                        System.out.println("Numar de secunde invalid!!\n");
                        secunde = -1;
                    }
                } else {
                    System.out.println("Need to be a number!!!\n");
                    scanner.next();
                }
            }
            if (3600 * ore + 60 * minute + secunde <= 0) {
                System.out.println("Invalid Time!!!\nNeed to be a time greater than 00:00:00!!!\n\n");
            } else ok = true;
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
