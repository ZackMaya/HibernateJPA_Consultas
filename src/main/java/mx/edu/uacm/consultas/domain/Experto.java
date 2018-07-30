package mx.edu.uacm.consultas.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Experto {
 @Id
 private String nombre;
  
  
 public Experto() {
 super();
 }
 @OneToMany(mappedBy="experto",cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
 private List<Imparticion> imparticiones= new ArrayList<Imparticion>();
  
 public List<Imparticion> getImparticiones() {
 return imparticiones;
 }
 
 public void setImparticiones(List<Imparticion> imparticiones) {
 this.imparticiones = imparticiones;
 }
 
 public String getNombre() {
 return nombre;
 }
 
 public Experto(String nombre) {
 super();
 this.nombre = nombre;
 }
 
 public void setNombre(String nombre) {
 this.nombre = nombre;
 }
 public void addImparticion(Imparticion i) {
  
 imparticiones.add(i);
 }

}