/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea7aalbertocaracuel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author alber
 */
public class Lectura {

    public static void main(String[] args) throws FileNotFoundException, ParseException, IOException {
        // Fichero a leer con datos de ejemplo
        String idFichero = "RelPerCen.csv";
        ArrayList<POJO> lista = new ArrayList<>();
        ArrayList<POJO> listaNueva = new ArrayList<>();

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "ISO-8859-1")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(",");
                POJO n = new POJO();
                for (String string : tokens) {
                    //System.out.print(string + "\t");

                    n.setCoordinador(tokens[8].replace("\"", ""));
                    n.setDni(tokens[2].replace("\"", ""));
                    n.setEmpleadoApellido(tokens[0].replace("\"", ""));
                    n.setEmpleadoNombre(tokens[1].replace("\"", ""));
                    n.setEvaluador(tokens[7].replace("\"", ""));
                    n.setFechaDeCese(tokens[5].replace("\"", ""));
                    n.setFechaDeToma(tokens[4].replace("\"", ""));
                    n.setPuesto(tokens[3].replace("\"", ""));
                    n.setTelefono(tokens[6].replace("\"", ""));

                }
                //System.out.println();
                lista.add(n);
            }
            for (POJO o : lista) {
                System.out.println(o);
            }
            //saber cuantos informaticos hay
            int contadorMaestros = 0;

            for (POJO o : lista) {
                if (o.getPuesto().equals("Informática P.E.S.")) {
                    contadorMaestros++;
                }

            }
            System.out.println("Hay " + contadorMaestros + " de informaticos");
            //saber si hay biologos coordinadores
            for (POJO o : lista) {
                if (o.getPuesto().equals("Biología y Geología P.E.S.") && o.getCoordinador().equals("Sí")) {
                    System.out.println("El profesor " + o.getEmpleadoNombre() + " " + o.getEmpleadoApellido() + " da bilogia y es coordinador");
                }
            }
            //saber cuanta gente hay con dni que acabe en N
            ArrayList<String> listanueva2 = new ArrayList<>();
            for (POJO o : lista) {
                char[] aCaracteres = o.getDni().toCharArray();
                if (aCaracteres[8] == 'N') {
                    listanueva2.add(o.getEmpleadoApellido());

                }
            }
            //ordenar lista e imprimirla
             Collections.sort(listanueva2);
             for (String o : listanueva2) {
                System.out.println(o);
            }
            //saber si hay john
            for (POJO o : lista) {
                if (o.getEmpleadoNombre().equals("John")) {
                    System.out.println("Hay un profesor que se llama john su dni es " + o.getDni());
                }
            }

        }
        //recorrer lista
        //hacer la resta entre las dos fechas
        //y si es mayor que 20 años se añade a la lista nueva
        // Aqui me da este error que no se como solucionar Exception in thread "main" java.lang.IllegalArgumentException: Cannot format given Object as a Date
        for (POJO o : lista) {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String fecha = o.getFechaDeToma();

            Date ahora = new Date();
            Date fechaInicial = null;
            fechaInicial = dateFormat.parse(fecha);
            Date fechaFinal = ahora;

            int dias = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);

            if (dias >= 7300 && o.getFechaDeCese().equals("")) {
                listaNueva.add(o);
            }

        }
//        //escritura del nuevo csv
        String ruta = "Nuevo.csv";
        File f = new File(ruta);
        FileOutputStream fw = new FileOutputStream(f);
        try (ObjectOutputStream escritura = new ObjectOutputStream(fw)) {
            for (POJO o : listaNueva) {

                escritura.writeObject(o.toString() + "\n");

            }
        }

    }

}
