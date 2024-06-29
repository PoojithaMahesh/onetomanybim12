package onetomanybim12.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomanybim12.dto.Company;
import onetomanybim12.dto.Employee;

public class CompanyDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	public void updateCompany(int id, Company company) {
		EntityManager entityManager = getEntityManager();
		Company dbCompany = entityManager.find(Company.class, id);
		if (dbCompany != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			company.setId(id);
			company.setEmployees(dbCompany.getEmployees());
			entityManager.merge(company);
			entityTransaction.commit();
		} else {
			System.out.println("Sorry Id is not present");
		}
	}

	public void findCompany(int id) {
		EntityManager entityManager = getEntityManager();
		Company dbCompany = entityManager.find(Company.class, id);
		if (dbCompany != null) {
			System.out.println(dbCompany);
		} else {
			System.out.println("Sorry Id is not present");
		}
	}

	public void deleteCompany(int id) {
		EntityManager entityManager = getEntityManager();
		Company dbCompany = entityManager.find(Company.class, id);
		if (dbCompany != null) {

			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			List<Employee> employees=dbCompany.getEmployees();
			for(Employee employee:employees) {
				employee.setCompany(null);
			}
			entityManager.remove(dbCompany);
			entityTransaction.commit();
		} else {
			System.out.println("Sorry Id is not present");
		}
	}

}
