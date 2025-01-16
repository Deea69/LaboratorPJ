package Pb2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainApp {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/Pb2/produse.csv"));
        List<produs> listaProduse = new ArrayList<produs>();
        scanner.useDelimiter(",");
        while(scanner.hasNextLine()) {
            String nume = scanner.next();
            float pret = Float.parseFloat(scanner.next());
            int cantitate = Integer.parseInt(scanner.next());
            LocalDate dataExp = LocalDate.parse(scanner.next());
            System.out.println("nume"+nume+"\tpret"+pret+"\tcantitate"+cantitate);
        }
    }
}
