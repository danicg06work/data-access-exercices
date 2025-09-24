package com.iesvirgendelcarmen;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ListaPersona {
    public static List<String> getListaNombres() {
        Path path = Path.of("src\\resources\\n" + //
                        "ombre_hombres.txt");
        List<String> nombres =  new ArrayList<>();
        try {
            nombres=Files.readAllLines(path);
        } catch (Exception e) {
            System.out.println(e);
        }
        return nombres;
    }
}
