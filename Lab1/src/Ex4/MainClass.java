package Ex4;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        Random randomGen = new Random();
        int nr1 = randomGen.nextInt(31);
        int nr2 = randomGen.nextInt(30);
        System.out.println("Numar 1= "+nr1+"| Numar 2= "+nr2);

        while(nr1 != nr2){
            if(nr1 > nr2)
                nr1 -= nr2;
            else
                nr2 -= nr1;
        }
        System.out.println("CMMDC= "+nr1);
    }
}
