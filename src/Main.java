import java.lang.classfile.Signature;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args){
        //calculator de pace
        scanner.useLocale(Locale.US);
        int ore,minute,secunde;
        boolean isRunning=true;
        int alege;

        while (isRunning) {
            System.out.println("***********************");
            System.out.println("Calculator pentru pace!");
            System.out.println("***********************");
            System.out.println("1. Adauga distanta!");
            System.out.println("2. Exit");
            System.out.println("***********************");

            System.out.println("Alege optiunea dorita (1-2)!");
            alege = scanner.nextInt();

            switch (alege) {
                case 1 ->pace();
                case 2 -> {
                    isRunning = false;
                    System.out.println("Multumesc ca mi-ai folosit programul.\nMult succes!!!!!");
                }
                default -> System.out.println("Optiunea aleasa nu exista in meniu");
            }
        }

        scanner.close();
    }
    static float timp(){
        float ore,minute,secunde;
        System.out.println("Adauga timpul dorit!");
        System.out.print("\tOre: ");
        ore=scanner.nextFloat();
        System.out.print("\tminute: ");
        minute=scanner.nextFloat();
        if(minute>60){
            ore+=minute%60;
            minute-=minute/60*60;
        }
        System.out.print("\tsecunde: ");
        secunde=scanner.nextFloat();
        if(secunde>60){
            minute+=secunde%60;
            secunde-=secunde/60*60;
        }
        return 3600*ore+60*minute+secunde;
    }
    static float pace(){
        float distanta;
        System.out.print("Adauga distanta dorita (km) : ");
        distanta=scanner.nextFloat();
        if(distanta<=0){
            System.out.println("Distanta trebuie sa fie o valoare mai mare decat 0!!!");
            return 0;
        }
        float timpul=timp();
        if(timpul<=0) {
            System.out.println("Timpul dorit trebuie sa fie o valoare mai mare decat 0!!!");
            return 0;
        }
        int pace_s=(int)(timpul/distanta);
        int pace_m=pace_s/60;
        pace_s=pace_s%60;
        System.out.printf("Pace-ul necesar este %02d:%02d min/km\n\n",pace_m,pace_s);
        return 0;
    }
}