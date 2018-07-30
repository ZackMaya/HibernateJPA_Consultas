package mx.edu.uacm.consultas.dao.test.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import mx.edu.uacm.consultas.HibernateJpaConsultasApplication;
import mx.edu.uacm.consultas.dao.BasicasDAO;
import mx.edu.uacm.consultas.domain.Customer;
import mx.edu.uacm.consultas.domain.Employee;
import mx.edu.uacm.consultas.domain.Experto;
import mx.edu.uacm.consultas.domain.Imparticion;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=HibernateJpaConsultasApplication.class)
public class BasicasDAOImplTest {
	private static final Logger log=LogManager.getLogger();
	@Autowired
	private BasicasDAO basicasDAO;
    @Test
	public void testObtenerClientesTodos() {
		log.debug("Entrando testObtenerClientesTodos");
		List<Customer> clientes=basicasDAO.obtenerClientes();
		Assert.assertThat(clientes, is(not(nullValue())));
		for (Customer customer : clientes) {
			log.debug(customer.getCustomerName());
			
		}
	}
	@Test
	public void testObtenerClientesAlgunasProps() {
		log.debug("Entrando a testObtenerClientesAlgunasProps");
		List<Object[]> clientes=basicasDAO.obtenerClientesAlgunasProps();
		log.debug("Consulta de algunas Propiedades");
		Assert.assertThat(clientes,is(not(nullValue())));
		for (Object[] objects : clientes) {
			log.debug((String)objects[0]+","+
		               (String)objects[1]+","+
					  (String)objects[2]);   
		}
	}
	 @Test
	public void testObtenerEmpleados() {
		log.debug("Obtener Empleados");
		List<Employee> empleados = basicasDAO.obtenerEmpleados();
		Assert.assertThat(empleados, is(not(nullValue())));
		for (Employee employee: empleados) {
			log.debug("Nombre: "+employee.getFirstName());
		}
		
	}
	 @Test
	 public void testObtenerClientesEmpleadosFetch() {
		 log.debug("Entrando al test ObtenerClientesEmpleadosFetch");
		 
		 List<Employee> empleados = basicasDAO.obtenerClientesPorEmpleadoFetch();
		 for (Employee employee: empleados) {
				log.debug("Nombre: "+employee.getFirstName());
			}
		 
	 }
	 
	 @Test
	    public void testObtenerExpertos() {
	        
	        List<Experto> expertos = basicasDAO.obtenerExperto();
	        for (Experto e: expertos) {
	            
	            log.debug(e.getNombre());
	            
	            List<Imparticion> imparticiones= e.getImparticiones();
	            for (Imparticion i :imparticiones) {
	            
	                log.debug(i.getTitulo());
	            }
	        }
	        
	    }
	 
	 
}
