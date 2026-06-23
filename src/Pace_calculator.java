

public class Pace_calculator {
    private final float distanta;
    private final int ore,minute,secunde;
    public Pace_calculator(float d,int o,int m,int s){
       this.distanta=d;
       this.ore=o;
       this.minute=m;
       this.secunde=s;
    }
    int getTotal(){
        return 3600*ore+60*minute+secunde;
    }
    void pace_necesar(){
        int total=getTotal();
        if(total==0){
            System.out.println("Timpul dorit trebuie sa fie mai mare decat 0!!!\n");
            return;
        }
        int timp_s=(int)(total/distanta);
        int timp_m=timp_s/60;
        timp_s=timp_s%60;
        System.out.printf("Pace-ul necesar este %02d:%02d min/km!!\n\n",timp_m,timp_s);
    }

}
