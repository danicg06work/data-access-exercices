package com.iesvirgendelcarmen;

/**
 * Hello world!
 *
 */
public class App 
{  
    public static void main( String[] args ){
        //Creo el objeto listapersona
        ListaPersona ls = new ListaPersona();

        //Incializo las rutas de los ficheros para que las coja
        ls.loadData("src\\resources\\n" + //
                        "ombre_mujeres.txt", "src\\resources\\n" + //
                                                        "ombre_hombres.txt", "src\\resources\\apellidos.txt", "src\\resources\\all_email.txt");
        
        //Aqui pruebo quee esten bien las rutas:
       // System.out.println(ls.getNombresHombre());
       // System.out.println(ls.getNombresMujer());
       // System.out.println(ls.getDominiosEmail());
       // System.out.println(ls.getApellidos());
        ls.generaPersonas(10);
        System.out.println(ls.toString());

    }

}
