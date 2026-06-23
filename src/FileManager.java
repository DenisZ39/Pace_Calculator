import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    File save_history=new File("History.csv");
    void SaveHistory(ArrayList<Pace_calculator> p){
        try {
            FileWriter fileWriter=new FileWriter(save_history);
            for(var i:p){
               fileWriter.write(i.toCSV());
               fileWriter.write("\n");
            }
            fileWriter.close();
        }
        catch (Exception e){
            System.out.println("Error, can't write in file "+e.getMessage());
        }
    }
    ArrayList<Pace_calculator> saved_history(){
        ArrayList<Pace_calculator> obj=new ArrayList<>();
        try {
            Scanner reader=new Scanner(save_history);
            while (reader.hasNextLine()){
                String a=reader.nextLine();
                String[] s=a.split(",");
                float distanta=Float.parseFloat(s[0]);
                int ore=Integer.parseInt(s[1]);
                int minute=Integer.parseInt(s[2]);
                int secunde=Integer.parseInt(s[3]);
                Pace_calculator paceCalculator=new Pace_calculator(distanta,ore,minute,secunde);
                obj.add(paceCalculator);
            }
        }
        catch (Exception e){
            System.out.println("Error, can't read file "+e.getMessage());
        }
        return obj;
    }
}
