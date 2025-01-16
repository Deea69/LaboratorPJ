package Pb1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class mainApp {
    public static void main(String[] args) throws FileNotFoundException {
        List<parabola> listaParabole = new ArrayList<parabola>();
        Scanner scanner = new Scanner(new File("src/Pb1/in.txt"));
        while(scanner.hasNextLine()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            listaParabole.add(new parabola(a, b, c));

        }
        for(parabola p:listaParabole){
            System.out.print("Functia: "+p);
            System.out.println(" | Cu varful: "+p.varfulParabolei());
        }
        System.out.println("");
        int a = listaParabole.get(2).getA();
        int b = listaParabole.get(2).getB();
        int c = listaParabole.get(2).getC();
        System.out.println("Pentru parabolele "+listaParabole.get(1)+" si "+listaParabole.get(2)
        + " mijlocul segmentului care le uneste varfurile este "+listaParabole.get(1).mijloculSegm(a,b,c));
        System.out.println("Pentru parabolele "+listaParabole.get(1)+" si "+listaParabole.get(2)
                + " lungimea segmentului care le uneste varfurile este "+listaParabole.get(1).lungimeaSegmn(a,b,c));
    }
}
