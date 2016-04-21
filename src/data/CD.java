/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author User
 */
public class CD extends Soporte {
    private Autor[] musico;
    private String genero;
    private int duracion;

    public CD(Autor[] musico, String genero, int duracion, String titulo) {
        super(titulo);
        this.musico = musico;
        this.genero = genero;
        this.duracion = duracion;
    }

    public Autor[] getMusico() {
        return musico;
    }

    public void setMusico(Autor[] musico) {
        this.musico = musico;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    @Override
    public String toString(){
       return "CD{" + super.toString() + "Genero="+ genero + "musico(s)=" + musico + ", duracion=" + duracion + '}'; 
    }
}
