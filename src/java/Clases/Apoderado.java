
package Clases;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Apoderado {
     private int idapoderado;
     private String nombre;
     private String apellido;
     private String dni;

    public int getIdapoderado() {
        return idapoderado;
    }

    public void setIdapoderado(int idapoderado) {
        this.idapoderado = idapoderado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
     
     
}
