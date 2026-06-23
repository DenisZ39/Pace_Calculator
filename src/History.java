import java.util.ArrayList;

public class History {
        private ArrayList<Pace_calculator> obj;
        public History(){
            this.obj=new ArrayList<>();
        }
        void add(Pace_calculator other){
            obj.add(other);
        }
        void print(){
            if(obj.isEmpty()){
                System.out.println("\nNeed to register races!!\n");
                return;
            }
            int j=1;
            for(var i:obj){
                System.out.printf("\nCursa %d:",j++);
                System.out.printf("\n\t->Distanta: %.2f",i.getDistanta());
                System.out.printf("\n\t->Timp: %02d:%02d:%02d\n",i.getOre(),i.getMinute(),i.getSecunde());
            }
            System.out.print('\n');
        }
        float total_distance(){
            float d=0;
            for(var i:obj){
                d+=i.getDistanta();
            }
            return d;
        }
        void pr() {
            if(obj.isEmpty()){
                System.out.println("\nNeed to register races!!\n");
                return;
            }
            int t = 100000, j = 1, c = 1,ps=1000000;
            float d=0;
            for (var i : obj) {
                if (i.get_s_per_km() < ps) {
                    ps = i.get_s_per_km();
                    t=i.getTotal();
                    d=i.getDistanta();
                    j = c;
                }
                c++;
            }
            int timp_s=(int)(t/d);
            int timp_m=timp_s/60;
            timp_s=timp_s%60;
            System.out.printf("\nBest pace is at race %d: ", j);
            System.out.printf("\n\t->Distance: %.2f",d);
            System.out.printf("\n\t->%02d:%02d\n\n",timp_m,timp_s);
        }
        void longest_run(){
            if(obj.isEmpty()){
                System.out.println("\nNeed to register races!!\n");
                return;
            }
            float d=0;
            int t=100000;
            int j=1,c=1;
            for(var i:obj){
                if(i.getDistanta()>d){
                    d=i.getDistanta();
                    t=i.getTotal();
                    j=c;
                }
                else if(i.getDistanta()==d){
                    if(i.getTotal()<t){
                        t=i.getTotal();
                        j=c;
                    }
                }
                c++;
            }
            System.out.printf("\nLongest run is race %d:",j);
            System.out.printf("\n\t->Distance: %.2f",d);
            int timp_s=(int)(t/d);
            int timp_m=timp_s/60;
            timp_s=timp_s%60;
            System.out.printf("\n\t->Pace is: %02d:%02d min/km\n\n",timp_m,timp_s);
        }
        ArrayList<Pace_calculator> getObj(){
            return obj;
        }
        void setObj(ArrayList<Pace_calculator> p){
            this.obj=p;
        }
}
