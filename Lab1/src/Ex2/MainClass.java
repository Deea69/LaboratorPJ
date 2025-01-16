package Ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) throws FileNotFoundException {
        int suma=0, nr_elem=0, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        Scanner scanner = new Scanner(new File("src/Ex2/in.txt"));
        while(scanner.hasNext())
        {
            int nr = scanner.nextInt();
            suma += nr;
            nr_elem++;
            if(nr < min) min = nr;
            if(nr > max) max = nr;
        }
        scanner.close();
        float medie_aritmetica = (float) suma/nr_elem;
        System.out.println("Media aritmetica: "+medie_aritmetica);
        System.out.println("Suma numerelor: "+suma);
        System.out.println("Nr minim: "+min);
        System.out.println("Nr maxim: "+max);
        PrintStream ps = new PrintStream(new File("src/Ex2/out.txt"));
        ps.println("Media aritmetica: "+medie_aritmetica);
        ps.println("Suma numerelor: "+suma);
        ps.println("Nr minim: "+min);
        ps.println("Nr maxim: "+max);
    }
}
