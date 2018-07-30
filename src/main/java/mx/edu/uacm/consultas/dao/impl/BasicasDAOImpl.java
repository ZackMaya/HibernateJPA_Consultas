package mx.edu.uacm.consultas.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import mx.edu.uacm.consultas.dao.BasicasDAO;
import mx.edu.uacm.consultas.domain.Customer;
import mx.edu.uacm.consultas.domain.Employee;
import mx.edu.uacm.consultas.domain.Experto;
@Repository
public class BasicasDAOImpl implements BasicasDAO {
    @PersistenceContext
	private EntityManager em;
	
	/*
	 * (non-Javadoc)
	 * @see mx.edu.uacm.consultas.dao.BasicasDAO#obtenerClientes()
	 */
	@Override
	public List<Customer> obtenerClientes() {
		Query query=em.createQuery("Select c from Customer c");
		List<Customer> customers=query.getResultList();
		return customers;
	}

	/*
	 * (non-Javadoc)
	 * @see mx.edu.uacm.consultas.dao.BasicasDAO#obtenerClientesAlgunasProps()
	 */
	@Override
	public List<Object[]> obtenerClientesAlgunasProps() {
		Query query= em.createQuery("Select c.customerName, c.city, c.country from Customer c");
		List<Object[]> lista=(List<Object[]>)query.getResultList();
		return lista;
	}

	@Override
	public List<Employee> obtenerEmpleados() {
		
		//te ahorras un cas 
		 TypedQuery<Employee> consulta = em.createQuery("select e from Employee e", Employee.class);
		return consulta.getResultList();
	}

	@Override
	public List<Employee> obtenerClientesPorEmpleadoFetch() {
		TypedQuery<Employee> consulta = em.createQuery("select distinct e from Employee e join fetch e.customers",Employee.class);
		return consulta.getResultList();
	}

	@Override
	public List<Experto> obtenerExperto() {
		TypedQuery<Experto> consulta = em.createQuery("select e from Experto e", Experto.class);
		return  consulta.getResultList();
	}

}
