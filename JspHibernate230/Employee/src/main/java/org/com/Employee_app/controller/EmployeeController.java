package org.com.Employee_app.controller;

import java.util.List;
import java.util.Scanner;

import org.com.Employee_app.dao.EmployeeDao;
import org.com.Employee_app.dto.Employee;

public class EmployeeController {
	static Scanner sc = new Scanner(System.in);
	static EmployeeDao dao = new EmployeeDao();

	public static void main(String[] args) {
		System.out.println("1. Save Employee");
		System.out.println("2. Update Employee");
		System.out.println("3. Find Employee By id");
		System.out.println("4. Verify Employee By Phone and Password");
		System.out.println("5. verify Employee By Id and password");
		System.out.println("6. Delete Employee By Id");
		System.out.println("7. Find Employee By designation");

		int choice = sc.nextInt();

		switch (choice) {

		case 1: {
			save();
			break;
		}
		case 3: {
			FindEmpByid();
			break;

		}

		case 2: {
			update();
			break;
		}
		case 4: {
			verifyByPhone();
			break;
		}
		case 5: {
			verifyById();
			break;
		}
		case 6: {
			delete();
			break;
		}
		case 7: {
			FindEmpBydesg();
			break;
		}
		default: {
			System.err.println("You Enterd Invalid Choice");
		}
		}
	}

	public static void save() {
		System.out.println("Enter your Name, desg, salary, phone and password ");
		Employee e = new Employee();
		e.setName(sc.next());
		e.setDesg(sc.next());
		e.setSalary(sc.nextDouble());
		e.setPhone(sc.nextLong());
		e.setPassword(sc.next());
		e = dao.saveEmployee(e);
		System.out.println("Employee saved with Id :" + e.getId());
	}

	private static void update() {

		System.out.println("Enter your id to update ");
		int id = sc.nextInt();
		System.out.println("Enter your Name, desg, salary, phone and password ");
		Employee e = new Employee();
		e.setId(id);
		e.setName(sc.next());
		e.setDesg(sc.next());
		e.setSalary(sc.nextDouble());
		e.setPhone(sc.nextLong());
		e.setPassword(sc.next());
		e = dao.updateEmployee(e);
		System.out.println("Employee Updated with Id :" + e.getId());

	}

	public static void FindEmpByid() {
		System.out.println("Enter your Id");
		int id = sc.nextInt();
		Employee e = dao.findById(id);

		if (e != null) {
			System.out.println("Emplloyee Id :" + e.getId());
			System.out.println("Emplloyee Name :" + e.getName());
			System.out.println("Emplloyee Designetion :" + e.getDesg());
			System.out.println("Emplloyee salary :" + e.getSalary());
			System.out.println("Emplloyee Phone Number:" + e.getPhone());
		} else {
			System.err.println("Invalid Id ");
		}

	}

	private static void verifyByPhone() {

		System.out.println("Enter your Phone And password to verfiy");
		long phone = sc.nextLong();
		String password = sc.next();
		Employee e = dao.verifyEmployee(phone, password);
		if (e != null) {
			System.out.println("Emplloyee Id :" + e.getId());
			System.out.println("Emplloyee Name :" + e.getName());
			System.out.println("Emplloyee Designetion :" + e.getDesg());
			System.out.println("Emplloyee salary :" + e.getSalary());
			System.out.println("Emplloyee Phone Number:" + e.getPhone());
		} else {
			System.err.println("Invalid Phone or Password");
		}
	}

	private static void verifyById() {

		System.out.println("Enter your Id And Password to verfiy");
		int id = sc.nextInt();
		String password = sc.next();
		Employee e = dao.verifyEmployee(id, password);
		if (e != null) {
			System.out.println("Emplloyee Id :" + e.getId());
			System.out.println("Emplloyee Name :" + e.getName());
			System.out.println("Emplloyee Designetion :" + e.getDesg());
			System.out.println("Emplloyee salary :" + e.getSalary());
			System.out.println("Emplloyee Phone Number:" + e.getPhone());
		} else {
			System.err.println("Invalid Id or Password");
		}
	}

	public static void delete() {
		System.out.println("Enter your id to delete the record");
		int id = sc.nextInt();
		boolean deleted = dao.deleteEmployee(id);
		if (deleted == true) {
			System.out.println("employee deleted with id " + id);
		} else {
			System.err.println("Invalid id");
		}
	}

	public static void FindEmpBydesg() {
		System.out.println("Enter your desg");
		String desg = sc.next();
		List<Employee> emp = dao.findBydesg(desg);

		if (emp.size() > 0) {
			for (Employee e : emp) {
				System.out.println("Emplloyee Id :" + e.getId());
				System.out.println("Emplloyee Name :" + e.getName());
				System.out.println("Emplloyee Designetion :" + e.getDesg());
				System.out.println("Emplloyee salary :" + e.getSalary());
				System.out.println("Emplloyee Phone Number:" + e.getPhone());
			}
		} else {
			System.err.println("Invalid Id ");
		}

	}

}
