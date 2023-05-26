package application;

import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: findById =====");
		
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: findAll =====");
		
		List<Department> lista = departmentDao.findAll();
		lista.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: insert =====");
		
		dep.setId(null);
		dep.setName("Sports");
		departmentDao.insert(dep);
		System.out.println("Inserted! New id: " + dep.getId());
		
		System.out.println("\n=== TEST 4: update =====");
		
		dep.setId(7);
		dep.setName("Automobiles");
		departmentDao.update(dep);
		System.out.println("Update Completed");
		
		System.out.println("\n=== TEST 5: delete =====");
		
		System.out.print("Enter id for delete test: ");
		int id = scan.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed");
		
		scan.close();
		DB.closeConnection();
	}

}
