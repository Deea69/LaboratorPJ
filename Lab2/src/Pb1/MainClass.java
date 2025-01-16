package Pb1;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) throws FileNotFoundException {
        int index=0;
        String[] judete = new String[40];
       Scanner scanner = new Scanner(new File("src/Pb1/fisiere_in.txt"));
       Scanner scannerTastatura = new Scanner(System.in);
       while(scanner.hasNext()){
            judete[index++]=scanner.nextLine();
       }
        String[] judeteOnly = new String[index];
        judeteOnly = Arrays.copyOf(judete, index);
        Arrays.sort(judeteOnly);
        System.out.println("Judetele ordonate sunt: "+Arrays.toString(judeteOnly));
        System.out.println("Introdu ce judet cauti: ");
        String judetCautat = scannerTastatura.next();
        int indexJudetC = Arrays.binarySearch(judeteOnly, judetCautat);
        System.out.println("Judetul "+judetCautat+" se afla pe pozitia "+indexJudetC);

    }
}
