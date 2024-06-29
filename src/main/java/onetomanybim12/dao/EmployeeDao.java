package onetomanybim12.dao;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanybim12.dto.Employee;

public class EmployeeDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	public void updateEmployee(int id,Employee employee) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			employee.setId(id);
			employee.setCompany(dbEmployee.getCompany());
			entityManager.merge(employee);
			entityTransaction.commit();
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	
	public void findEmployee(int id) {
		EntityManager entityManager=getEntityManager();
		Employee dbEmployee=entityManager.find(Employee.class, id);
		if(dbEmployee!=null) {
			System.out.println(dbEmployee);
		}else {
			System.out.println("Sorry id is not present");
		}
	}
	
	
	
	
	
}
