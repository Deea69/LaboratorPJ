package Pb2;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


class Vers{
    private String vers;
    public Vers(String versPoez){
        vers = versPoez;
    }

    public int getNrCuv2(){
        return vers.split(" ").length;
    }

    public int getCuvinte(){
        int nrSpatii=0;
        vers = vers.trim();
        for(int i = 0; i<vers.length(); i++){
            if(vers.charAt(i)==' '){
                nrSpatii++;
            }
        }
        int nrCuv = nrSpatii+1;
        return nrCuv;
    }

    public int getVocale(){
        int nrVoc = 0;
        vers=vers.trim();
        for(int i = 0; i<vers.length(); i++){
            if(vers.charAt(i)=='a' || vers.charAt(i)=='A' || vers.charAt(i)=='e'
            || vers.charAt(i)=='E' || vers.charAt(i)=='i' || vers.charAt(i)=='I'
            || vers.charAt(i)=='o' || vers.charAt(i)=='O' || vers.charAt(i)=='u'
            || vers.charAt(i)=='U'){
                nrVoc++;
            }
        }
        return nrVoc;
    }
    public int cautareGrupare(String grupare){
        int lungimeGrupare = grupare.length();
        String gruparePeVers = vers.substring(vers.length()-lungimeGrupare);

        if(grupare.compareTo(gruparePeVers)==0)
            return 1;
        else
            return 0;
    }

    public boolean cautareGrupare2(String grupare){
        return vers.endsWith(grupare);
    }

    public void toUpper(){
        vers = vers.toUpperCase();
    }
}


public class MainClass {
    public static void main(String[] args) throws FileNotFoundException {
        Random rand = new Random();
        File fisier_out = new File("cantec_out.txt");
        Scanner scanner = new Scanner(new File("src/Pb2/cantec_in.txt"));
        PrintStream print_out = new PrintStream(new File("src/Pb2/cantec_out.txt"));
        Scanner scannerGrupare = new Scanner(System.in);
        System.out.println("Care este gruparea pe care o cautati: ");
        String grupareCautata = scannerGrupare.next();
        while(scanner.hasNext()){
            String versCitit = scanner.nextLine();
            Vers vers = new Vers(versCitit);
            float nrRand = rand.nextFloat(1);
            System.out.println(nrRand);
            if(nrRand<0.5){
                versCitit= versCitit.toUpperCase();
            }
            print_out.print(versCitit+" Cuv: ");
            int nrCuv = vers.getCuvinte();
            print_out.print(nrCuv+" Nr vocale: ");
            int nrVoc = vers.getVocale();
            print_out.print(nrVoc);
            if(vers.cautareGrupare(grupareCautata)==1)
                print_out.println(" * ");
            else print_out.println(" ");

        }
    }
}
