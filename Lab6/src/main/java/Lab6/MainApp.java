package Lab6;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainApp {
    public static void scriere(List<Angajati> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/angajati.json");
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Angajati> citire() {
        try {
            File file=new File("src/main/resources/angajati.json");
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            List<Angajati> angajati = mapper
                    .readValue(file, new TypeReference<List<Angajati>>(){});
            return angajati;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void afisareSalarii2500(List<Angajati> listaAngajati, Predicate<Angajati> p) {
        for(Angajati a: listaAngajati)
            if(p.test(a))
                System.out.println(a);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int optiune;
        List<Angajati> listaAngajati = citire();
       /* listaAngajati.add(new Angajati("Alex", "Director", LocalDate.parse("2000-02-13"), 5000));
        listaAngajati.add(new Angajati("Marius", "Angajat", LocalDate.parse("2020-03-16"), 1000));
        listaAngajati.add(new Angajati("Larisa", "Angajat", LocalDate.parse("2015-11-08"), 1000));
        listaAngajati.add(new Angajati("Cristinel", "Portar", LocalDate.parse("2007-05-06"), 2000));
        listaAngajati.add(new Angajati("Linu", "CEO", LocalDate.parse("2005-09-01"), 6000));
        scriere(listaAngajati);*/

        System.out.println("Introduceti cerinta: ");
        optiune = scanner.nextInt();

        switch (optiune)
        {
            case 1:
                listaAngajati.forEach(System.out::println);
                break;
            case 2:
                listaAngajati
                        .stream()
                        .filter((angajati)->angajati.getSalariu()>=2500)
                        .forEach(System.out::println);
                break;
            case 3:
                Year year = Year.now();
                Year lastYear = year.minusYears(1);
                LocalDate ultimaAprilieInceput = LocalDate.parse(lastYear.toString()+"-04-01");
                LocalDate ultimaAprilieFinal = LocalDate.parse(lastYear.toString()+"-04-30");
                List<Angajati> listaSefi = listaAngajati
                        .stream()
                        .filter((angajat) -> angajat.getPost().equals("sef") || angajat.getPost().equals("director"))

                        .filter((angajat) -> angajat.getData_angajarii().isAfter(ultimaAprilieInceput))
                        .filter((angajat) -> angajat.getData_angajarii().isBefore(ultimaAprilieFinal))
                        .collect(Collectors.toList());

                listaSefi.forEach(System.out::println);
                break;
            case 4:
                listaAngajati.stream()
                        .filter((angajat) -> !angajat.getPost().equals("sef") && !angajat.getPost().equals("director"))
                        .map(Angajati::getSalariu)
                        .sorted((a,b)->b.compareTo(a))
                        .forEach(System.out::println);
                break;
            case 5:
                List<String> numeMaj = listaAngajati
                        .stream()
                        .map(Angajati::getNume)
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());
                numeMaj.forEach(System.out::println);
                break;
            case 6:
                listaAngajati
                        .stream()
                        .filter((angajati -> angajati.getSalariu()<3000))
                        .map(Angajati::getSalariu)
                        .sorted((a,b)->b.compareTo(a))
                        .forEach(System.out::println);
                break;
        }
    }
}
