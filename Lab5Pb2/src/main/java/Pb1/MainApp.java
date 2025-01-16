package Pb1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class MainApp {
        public static void scriere(List<PerecheNumere> lista) {
            try {
                ObjectMapper mapper=new ObjectMapper();
                File file=new File("src/main/resources/perechi.json");
                mapper.writeValue(file,lista);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static List<PerecheNumere> citire() {
            try {
                File file=new File("src/main/resources/perechi.json");
                ObjectMapper mapper=new ObjectMapper();
                List<PerecheNumere> perechi = mapper
                        .readValue(file, new TypeReference<List<PerecheNumere>>(){});
                return perechi;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
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

          List<PerecheNumere> persoane=citire();
          System.out.println(persoane);
          for(PerecheNumere p:persoane){
              System.out.println(p);
          }
          persoane.add(new PerecheNumere(1,2));
          scriere(persoane);
      }
}
