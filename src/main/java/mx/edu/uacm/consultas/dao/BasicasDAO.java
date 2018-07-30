package mx.edu.uacm.consultas.dao;

import java.util.List;

import mx.edu.uacm.consultas.domain.Customer;
import mx.edu.uacm.consultas.domain.Employee;
import mx.edu.uacm.consultas.domain.Experto;

public interface BasicasDAO {
	
	//metodo para obtener clientes
	List<Customer> obtenerClientes();
	//metodo para obtener algunas propiedades
	List<Object[]> obtenerClientesAlgunasProps();
	
	//Método para obtener los empleados
	List<Employee> obtenerEmpleados();
	
	/**
	 * Método para obtener los empleados y clientes por fetch
	 * @return
	 */
	List<Employee> obtenerClientesPorEmpleadoFetch();
	
	List<Experto> obtenerExperto();

}
