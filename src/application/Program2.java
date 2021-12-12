package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;


public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Teste 1: findById ====");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n=== Teste 2: findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste 3: department insert ====");
		Department newDepartment = new Department(null, "Food");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n=== Teste 4: department update ====");
		department = departmentDao.findById(5);
		department.setName("Kitchen");
		departmentDao.update(department);
		System.out.println("Update Completed.");
		
		System.out.println("\n=== Teste 6: department delete ====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed.");
		
		sc.close();
	}

}
