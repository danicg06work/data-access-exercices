package com.iesvirgendelcarmen;

import java.util.List;

import org.junit.Test;

public class ListaPersonaTest {
    public static void main(String[] args) {
        List<String> nombres = ListaPersona.getListaNombres();
        for(String nombre:nombres){
            System.out.println(nombre+", ");
        }
    }
}
