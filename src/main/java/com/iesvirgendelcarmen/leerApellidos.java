package com.iesvirgendelcarmen;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class leerApellidos {
    public static void main(String[] args) {
        System.out.println("Apellidos");
        leerApellidos.showArrayApellidos(getColeccionApellidos());
    }

    public static List<String> getColeccionApellidos(){
        List<String> apellidos= new ArrayList<>();
        Path  archivo = Path.of("src\\resources\\apellidos.txt");
        try {
            apellidos = Files.readAllLines(archivo);
        } catch (Exception e) {
            System.out.println(e);
        }
        return apellidos;
    };

    public static void showArrayApellidos(List<String> apellidos){
        StringBuilder sb = new StringBuilder();
        for (int i= 0;i<apellidos.size();i++ ){
            sb.append(i+1).append(". ");
            sb.append(apellidos.get(i)).append(". \n");
        }
        System.out.println(sb.toString());
    }    
    
}
