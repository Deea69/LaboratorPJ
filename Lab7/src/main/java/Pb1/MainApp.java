/*package Pb1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
    public static void scriere(Map<Integer, Carte> map) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/carti.json");
            mapper.writeValue(file,map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Map<Integer, Carte> citire() {
        try {
            File file=new File("src/main/resources/carti.json");
            ObjectMapper mapper=new ObjectMapper();
            Map<Integer, Carte> map  = mapper
                    .readValue(file, new TypeReference<Map<Integer, Carte>>(){});
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Map<Integer, Carte> map = citire();
        //C1
        System.out.println("Cerinta 1:");
        var entryset=map.entrySet();
        var it=entryset.iterator();
        while(it.hasNext()) {
            var m =it.next();
            int key=m.getKey();
            Carte value=m.getValue();
            System.out.println("Cheie :"+key+" Valaore :"+value.toString());
            //C2
            if(key==1)
                it.remove();
        }
        //C3
        map.putIfAbsent(1, new Carte("Da", "Da", 1950));
        System.out.println(map);
        //C4
        scriere(map);
        //C5
        System.out.println("Cerinta 5");
        Set<Carte> cartiHarari = map.values().stream()
                .filter(carte -> "Yuval Noah Harari".equals(carte.autorul()))
                .collect(Collectors.toSet());
        cartiHarari.forEach(System.out::println);
        //C6
        System.out.println("Cerinta 6");
        cartiHarari.stream()
                .sorted((a,b)->a.titlul().compareTo(b.titlul()))
                .forEach(System.out::println);
        //C7
        System.out.println("Cerinta 7");
        Optional<Carte> carteVeche= cartiHarari.stream()
                .min((a,b)->a.anul()-b.anul());
        carteVeche.ifPresent(System.out::println);
    }
}
*/