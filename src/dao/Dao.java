/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;                                    //Data acces object - tomar imformacion- Lee el archivo de datos

import Exception.LibroException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import data.Autor;
import data.CD;
import data.Libro;
import data.Soporte;
import data.DVD;

/**
 * @author fabian.giraldo
 * Luego va ser mejorada
 */
public class Dao {
         
    public Autor cargarAutor(Scanner sc) {
	Autor autor = null;
	String nombre = sc.next().trim();
        String apellido = sc.next().trim();
        autor = new Autor(nombre, apellido);
        return autor;
    }
        
    public Libro cargarLibro(Scanner sc) throws LibroException{                 //Retorna el problema hasta la funcion q lo llamo - el no procesa la excepcion la retorna a quien lo llamo
	Libro libro = null;
	String titulo = sc.next().trim();

        if(titulo.length()< 5){
           throw new LibroException("Titulo incorrecto" + titulo);
        }
        Autor autor = cargarAutor(sc);
	String isbn = sc.next().trim();	
        libro = new Libro(isbn, titulo);
        libro.setAutor(autor);
         
        return libro;
    }
    
    public DVD cargarDVD(Scanner sc) throws LibroException{                 //Retorna el problema hasta la funcion q lo llamo - el no procesa la excepcion la retorna a quien lo llamo
	DVD dvd = null;
	String titulo = sc.next().trim();
        Autor autor = cargarAutor(sc);
        Autor[] actor = new Autor[2];
        actor[0] = cargarAutor(sc);
        actor[1] = cargarAutor(sc);
        int duracion = sc.nextInt();
        
        dvd = new DVD(actor, duracion, titulo, autor);
        
        return dvd;
    }
    
    public CD cargarCD(Scanner sc) throws LibroException{
        CD cd = null;
        String titulo = sc.next().trim();
        Autor[] musico = new Autor[2];
        musico[0] = cargarAutor(sc);
        musico[1] = cargarAutor(sc);
        int duracion = sc.nextInt();
        String genero = sc.next();
        
        cd = new CD(musico, genero, duracion, titulo);
        return cd;
    }
    public Soporte leerSoporte(Scanner sc) throws LibroException {              //Retorna el problema hasta la funcion q lo llamo - el no procesa la excepcion la retorna a quien lo llamo - viene desde carar libro
	String type = sc.next().trim();                                         // .nest lee STRING y .trim quita espacios a la derecha y a la izquierda
	if (type.equals("Libro")) return cargarLibro(sc);                       // .equals es ==
        else        
            if (type.equals("DVD")) return cargarDVD(sc);
		return null; //Se debe completar
                
    }
	
    public ArrayList<Soporte> cargarSoportes(String archivo) throws FileNotFoundException, LibroException{
  	ArrayList<Soporte> soportes = new ArrayList<Soporte>();
	Scanner sc;
	sc = new Scanner(new File(archivo));
	sc.useDelimiter(",");                                                   //lee los datos hasta la ( , )
	while (sc.hasNext()) {                                                  //desde que halla datos en el archivo ejecutar
		soportes.add(leerSoporte(sc));
	}
	
	return soportes;
   }
    
}
