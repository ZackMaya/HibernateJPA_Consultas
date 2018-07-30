package mx.edu.uacm.consultas.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Imparticion {
@Id
private int id;
private Date fecha;
private String titulo;
@ManyToOne
@JoinColumn(name="nombreExperto")
private Experto experto;
 
public Imparticion() {
	// TODO Auto-generated constructor stub
}
 
public Imparticion(int id, Date fecha, String titulo, Experto experto) {
super();
this.id = id;
this.fecha = fecha;
this.titulo = titulo;
this.experto = experto;
}
 
public Experto getExperto() {
return experto;
}
 
public void setExperto(Experto experto) {
this.experto = experto;
}
public int getId() {
return id;
}
 
public void setId(int id) {
this.id = id;
}
 
public Date getFecha() {
return fecha;
}
 
public void setFecha(Date fecha) {
this.fecha = fecha;
}
 
public String getTitulo() {
return titulo;
}
 
public void setTitulo(String titulo) {
this.titulo = titulo;
}

}
