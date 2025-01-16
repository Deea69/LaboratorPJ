package Pb2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class MainApp {
    public static void scriere(Set<InstrumentMuzical> instrumente) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            File file=new File("src/main/resources/instrumente.json");
            mapper.writeValue(file,instrumente);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Set<InstrumentMuzical> citire() {
        try {
            File file=new File("src/main/resources/instrumente.json");
            ObjectMapper mapper=new ObjectMapper();
            Set<InstrumentMuzical> instrumente  = mapper
                    .readValue(file, new TypeReference<Set<InstrumentMuzical>>(){});
            return instrumente;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        //C1
        Set<InstrumentMuzical> instrumente = new HashSet<InstrumentMuzical>();
        instrumente.add(new Chitara("prod1", 1500, 6,TipChitara.ACUSTICA));
        instrumente.add(new Chitara("prod2", 2500, 5,TipChitara.ELECTRCICA));
        instrumente.add(new Chitara("prod3", 3000,7, TipChitara.CLASICA));
        instrumente.add(new SetTobe("prod4", 3500, TipTobe.ELECTRONCIE, 5, 3));
        instrumente.add(new SetTobe("prod5", 2800, TipTobe.ACUSTICE, 4, 2));
        instrumente.add(new SetTobe("prod6", 2700, TipTobe.ACUSTICE, 6, 4));
        //C2
        scriere(instrumente);
        //C3
        System.out.println("Cerinta 3:");
        Set<InstrumentMuzical> instrumenteBune = citire();
        instrumenteBune.forEach(System.out::println);
        //C4
        System.out.println("Cerinta 4:");
        System.out.println("Implementare folosita: " + instrumenteBune.getClass());
        //C5
        Chitara chitaraDuplicat = new Chitara("prod1", 1500, 6,TipChitara.ACUSTICA);
        if (!instrumente.add(chitaraDuplicat)) {
            System.out.println("Duplicat! Nu e voie");
        }
        //C6
        System.out.println("Cerinta 6:");
        instrumenteBune.removeIf(a->a.pret>3000);
        instrumenteBune.forEach(System.out::println);
        //C7
        System.out.println("Cerinta 7:");
        instrumenteBune.stream()
                .filter(a -> a instanceof Chitara)
                .forEach(System.out::println);
        //C8
        System.out.println("Cerinta 8:");
        instrumenteBune.stream()
                .filter(a -> a.getClass() == SetTobe.class)
                .forEach(System.out::println);
        //C9
        System.out.println("Cerinta 9:");
        Optional<Chitara> chitaraMaxCorzi = instrumente.stream()
                .filter(a -> a instanceof Chitara)
                .map(a -> (Chitara) a)
                .max(Comparator.comparingInt(Chitara::getNr_corzi));
        chitaraMaxCorzi.ifPresent(System.out::println);
        //C10
        System.out.println("Cerinta 10:");
        instrumente.stream()
                .filter(a -> a instanceof SetTobe
                        && ((SetTobe) a).getTip_tobe() == TipTobe.ACUSTICE)
                .map(a -> (SetTobe) a)
                .sorted(Comparator.comparingInt(SetTobe::getNr_tobe))
                .forEach(System.out::println);

    }
}
