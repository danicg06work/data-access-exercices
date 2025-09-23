package com.iesvirgendelcarmen;

import java.io.File;

public class ListarContenidoRecursivo {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Te falta el argumento: la ruta de la carpeta");
            System.exit(1);
        }

        String rutaCarpeta = args[0];
        listarContenidoRecursivo(new File(rutaCarpeta), 0);
    }

    public static void listarContenidoRecursivo(File carpeta, int contador) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < contador; i++) {
            sb.append("      ");
        }

        if (carpeta.isDirectory()) {
            System.out.println(sb + "|-------- Carpeta: " + carpeta.getName());

            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    listarContenidoRecursivo(archivo, contador + 1);
                }
            }

        } else if (carpeta.isFile()) {
            System.out.println(sb + "|-------- Fichero: " + carpeta.getName());
        }
    }
}