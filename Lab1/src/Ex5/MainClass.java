package Ex5;

import java.util.Random;
import java.util.Vector;

public class MainClass {
    public static void generareFibo(Vector<Integer> vect){
        int nr1 = 0;
        int nr2 = 1;
        int nr3;
        vect.addElement(nr1);
        vect.addElement(nr2);
        for(int i =0 ; i<=25;i++)
        {
            nr3 = nr1+nr2;
            nr1 = nr2;
            nr2 = nr3;
            vect.addElement(nr3);
        }
    }
    public static void main(String[] args) {
        int inSir = 0;
        Random randomGen = new Random();
        int numar = randomGen.nextInt(20);
        Vector<Integer> vct = new Vector<>();
        generareFibo(vct);
        System.out.println("Numarul generat este: "+numar);
        for(int i:vct)
            if(i == numar){
            System.out.println("Este in sirul lui Fibonacci");
            inSir = 1;
            }
        if(inSir == 0){
            System.out.println("Nu este in sirul lui Fibonacci");
        }
    }
}


// 0 0 1 1 2 3 5 8 13