package pe.edu.cibertec.persona;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id; 

    String nombre;
    String apellido; 
    String dni;
    Integer edad;  

    Persona(){}

    Persona(String nombre, String apellido, String dni, Integer edad){
       this.nombre = nombre;
       this.apellido = apellido;
       this.dni = dni;
       this.edad =edad;
   }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public Integer getEdad() {
        return edad;
    }

    
}
