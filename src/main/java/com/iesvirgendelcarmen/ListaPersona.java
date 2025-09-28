package com.iesvirgendelcarmen;

import java.nio.file.Files;
import java.nio.file.Path;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListaPersona {
    private List<Persona> personas;
    private List<String> nombresMujer;
    private List<String> nombresHombre;
    private List<String> apellidos;
    private List<String> dominiosEmail;



    public static List<String> getListaNombres() {
        Path path = Path.of("datos\\n" + //
                        "ombre_hombres.txt");
        List<String> nombres =  new ArrayList<>();
        try {
            nombres=Files.readAllLines(path);
        } catch (Exception e) {
            System.out.println(e);
        }
        return nombres;
    }
    /*Con esto cargo los datos,(le meto datos como obejto)
        No se porque no lo ponemos en el construcotr y ya,
        pero me lo han mandado hacer así.
    */
    public void loadData(String nArchivoM,String nArchivoH,String nApellidos,String dEmail){
        try {
          this.nombresMujer = Files.readAllLines(Path.of(nArchivoM));  
          this.nombresHombre = Files.readAllLines(Path.of(nArchivoH));  
          this.apellidos = Files.readAllLines(Path.of(nApellidos));  
          this.dominiosEmail = Files.readAllLines(Path.of(dEmail));  
        } catch (Exception e) {
            System.out.println("Algun parametro(ruta) esta mal = " + e);
        }
        
    }

    public int dado(int caras){
        Random random = new Random();
        return random.nextInt(caras);
    }

    public void generaPersonas(int nPersonas){
        if(nPersonas<1 || nPersonas > 1000000){
            throw new IllegalArgumentException("Son o muy pocos o mas de un millón , espabila");
        }
        this.personas = new ArrayList<Persona>();
        for(int i= 0;i<nPersonas;i++){
            personas.add(generaPersona());
        }
        
    }

    

    public Persona generaPersona(){
        Persona p= new Persona();

        //Seteo apellido
        p.setApellidos(apellidos.get(dado(apellidos.size())));

        //Seteo genero
        int nG= dado(3);
        p.setGenero(Genero.values()[nG]);

        //Seteo nombre segun genero
        if(nG == 0){
            p.setNombre(nombresHombre.get(dado(nombresHombre.size())));
        }if (nG ==1) {
            p.setNombre(nombresMujer.get(dado(nombresMujer.size())));
        } if(nG==2) {
            if((dado(2)+1)%2==0){
                p.setNombre(nombresHombre.get(dado(nombresHombre.size())));
            }else {
                p.setNombre(nombresMujer.get(dado(nombresMujer.size())));
            }
        }

        //Seteo numero de telefono
        p.setTelefono(String.valueOf(dado(199999999)+600000000));
        

        //Seteo email
        String nombreNormalizado = p.getNombre().toLowerCase().replace(" ", "");
        String apellidoNormalizado = p.getApellidos().toLowerCase().replace(" ", "");
        String dominio = dominiosEmail.get(dado(dominiosEmail.size()));

        String email = nombreNormalizado + "." + apellidoNormalizado + dado(1000) + "@" + dominio;
        p.setEmail(email);
        return p;
        }

    //Getter setters y toString
    public List<Persona> getPersonas() {
        return this.personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<String> getNombresMujer() {
        return this.nombresMujer;
    }

    public void setNombresMujer(List<String> nombresMujer) {
        this.nombresMujer = nombresMujer;
    }

    public List<String> getNombresHombre() {
        return this.nombresHombre;
    }

    public void setNombresHombre(List<String> nombresHombre) {
        this.nombresHombre = nombresHombre;
    }

    public List<String> getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(List<String> apellidos) {
        this.apellidos = apellidos;
    }

    public List<String> getDominiosEmail() {
        return this.dominiosEmail;
    }

    public void setDominiosEmail(List<String> dominiosEmail) {
        this.dominiosEmail = dominiosEmail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Persona persona:personas){
            sb.append(persona.toString()).append(". \n");
        }
        return sb.toString();
    }
    
}