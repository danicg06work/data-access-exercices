package com.iesvirgendelcarmen;

import org.junit.Test;

public class PersonaTest {
   public static void main(String[] args) {
    Persona p1 = new Persona("dani","caza","777467834","hola@gmail.com",Genero.FEMENINO);
    p1.setNombre("albeto");
    System.out.println(p1.toString());

   }

}
