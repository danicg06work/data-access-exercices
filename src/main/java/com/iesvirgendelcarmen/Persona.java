package com.iesvirgendelcarmen;

import java.util.regex.Pattern;

import javax.imageio.IIOException;

public class Persona {
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private Genero genero;

    private final Pattern PATRON_EMAIL = Pattern.compile("^[A-Za-z0-9+_.-]"+"+@[A-Za-z0-9-]"+"+.[A-Za-z]{2,}$");
    private final Pattern PATRON_TELEFONO = Pattern.compile("^[+]?[0-9]{5,12}");


    public Persona(String nombre, String apellidos, String telefono, String email, Genero genero) {
        if(!(PATRON_TELEFONO.matcher(telefono).matches())){
            throw new IllegalArgumentException("Formato telefono incorrecto :" + telefono);
        }
        if(!(PATRON_EMAIL.matcher(email).matches())){
            throw new IllegalArgumentException("Formato email incorrecto :" + email);
        }
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.genero = genero;
    }
    

    public Persona() {
    }
     

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "-" +
            " nombre='" + getNombre() + "'" +
            ", apellidos='" + getApellidos() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", email='" + getEmail() + "'" +
            ", genero='" + getGenero() + "'" +
            "-";
    }

}

   