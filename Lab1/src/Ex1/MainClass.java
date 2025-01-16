package Ex1;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lungine: ");
        int lung = scanner.nextInt();
        System.out.print("Latime: ");
        int lat = scanner.nextInt();
        int arie = lat * lung;
        int perimetru = lung * 2 + lat * 2;
        System.out.println("Aria este "+arie+" si perimetrul este "+perimetru);
    }
}
