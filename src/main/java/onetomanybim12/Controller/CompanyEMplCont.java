package onetomanybim12.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanybim12.dto.Company;
import onetomanybim12.dto.Employee;

public class CompanyEMplCont {
public static void main(String[] args) {
	Company company=new Company();
	company.setId(1);
	company.setName("Infosys");
	company.setGst("info@123");
	
	Employee employee1=new Employee();
	employee1.setId(1);
	employee1.setName("Poojitha");
	employee1.setAddress("Bangalore");
	employee1.setCompany(company);
	
	
	Employee employee2=new Employee();
	employee2.setId(2);
	employee2.setName("Anusha");
	employee2.setAddress("Bangalore");
	employee2.setCompany(company);
	
	
	Employee employee3=new Employee();
	employee3.setId(3);
	employee3.setName("Fahar");
	employee3.setAddress("Bangalore");
	employee3.setCompany(company);
	
	List<Employee> employees=new ArrayList<Employee>();
	employees.add(employee1);
	employees.add(employee2);
	employees.add(employee3);
	
	company.setEmployees(employees);
	
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	
	entityManager.persist(employee1);
	entityManager.persist(employee2);
	entityManager.persist(employee3);
	entityManager.persist(company);
	
	entityTransaction.commit();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
