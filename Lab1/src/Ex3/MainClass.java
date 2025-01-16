package Ex3;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        int nr_elem=0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Numar: ");
        int numar = scanner.nextInt();
        System.out.println("Divizori: ");
        for(int i=1; i<=numar/2 ;i++)
            if(numar % i == 0) {
                System.out.print(i + " ");
                nr_elem++;
            }
        System.out.println(" ");
        if(nr_elem==1)
            System.out.println("Nr prim");
    }
}
