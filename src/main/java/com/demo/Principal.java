package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Principal {

    public static void main(String... args) {

        ConcurrentHashMap<String, String> mMap = new ConcurrentHashMap<>();
        mMap.put("1", "1");
        mMap.putAll(Map.of("1", "1", "2", "2", "3", "3"));

        Lugar lugares1 = new Lugar();
        lugares1.setName("MILUGAR1");
        Lugar lugares2 = new Lugar();
        lugares2.setName("MILUGAR2");

        Persona persona1 = new Persona();
        persona1.setNombre("Charlie");
        persona1.getLugares().add(lugares1);
        persona1.getLugares().add(lugares2);

        Lugar lugares3 = new Lugar();
        lugares3.setName("MILUGAR3");
        Lugar lugares4 = new Lugar();
        lugares4.setName("MILUGAR4");

        Persona persona2 = new Persona();
        persona2.setNombre("Char");
        persona2.getLugares().add(lugares3);
        persona2.getLugares().add(lugares4);

        Lugar lugares5 = new Lugar();
        lugares5.setName("MILUGAR5");
        Lugar lugares6 = new Lugar();
        lugares6.setName("MILUGAR6");

        Persona persona3 = new Persona();
        persona3.setNombre("Char");
        persona3.getLugares().add(lugares5);
        persona3.getLugares().add(lugares6);

        List<Persona> personasList = List.of(persona1, persona2, persona3);

        out.println("1ERA SECCION");
        personasList.stream()
                .map(Persona::getLugares)
                .flatMap(List::stream)
                .forEach(out::println);

        out.println("2DA SECCION");
        personasList.stream()
                .map(Persona::getLugares)
                .flatMap(List::stream)
                .map(Lugar::getName)
                .forEach(out::println);


        int[] arr1 = {1,2,3,4};
        int[] arr2 = {5,6,7,8};

        int[] resultArray = Stream.of(arr1, arr2)
                .flatMapToInt(Arrays::stream)
                .toArray();

        out.println("3RA SECCION");
        System.out.println(Arrays.toString(resultArray));

        List<Lugar> list = personasList.stream()
                .map(Persona::getLugares)
                .flatMap(Collection::stream)
                .toList();

        list.forEach(out::println);


        List<String> a = List.of("a", "b", "c");
        List<String> b = List.of("d", "e", "f");

        long initTime = System.currentTimeMillis();
        List<String> c =  new ArrayList<>();
        c.addAll(a);
        c.addAll(b);
        c.forEach(out::println);
        out.println("Tiempo de ejecucion: " + (System.currentTimeMillis() - initTime));

        initTime = System.currentTimeMillis();
        c = Stream.of(a, b)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        c.forEach(out::println);
        out.println("Tiempo de ejecucion: " + (System.currentTimeMillis() - initTime));

    }
}
