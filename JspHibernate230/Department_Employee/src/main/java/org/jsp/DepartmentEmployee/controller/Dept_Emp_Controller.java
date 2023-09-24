package org.jsp.DepartmentEmployee.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.DepartmentEmployee.dao.DepartmentDao;
import org.jsp.DepartmentEmployee.dao.EmployeeDao;
import org.jsp.DepartmentEmployee.dto.Department;
import org.jsp.DepartmentEmployee.dto.Employee;

public class Dept_Emp_Controller {
	static Scanner sc=new Scanner(System.in);
	static DepartmentDao deptDao=new DepartmentDao();
	static EmployeeDao empDao=new EmployeeDao();
	
	public static void main(String[] args)
	{
		System.out.println("1. save Department");
		System.out.println("2. update department");
		System.out.println("3. save Employee");
		System.out.println("4. update Employee");
		System.out.println("5. find Employee by Department id");
		System.out.println("6. Find Employee by Department Name");
		System.out.println("7. Verify Employee By Id and Password");
		System.out.println("8. Verify Employee By Phone and Password");
		System.out.println("9. Verify Employee By email and password");
		System.out.println("10. Find Department By Id");

	
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:{
			saveDept();
			break;
		}
		case 2:{
			updateDept();
			break;
		}
		case 3:{
saveEmp();
			break;
		}
		case 4:{
			updateEmp();
			break;
		}
		case 5:{
			findEmpsByDeptId();
			break;
		}
		case 6:{
			findEmpsByDeptname();
			break;
		}
		case 7:{
			verifyEmpByIdAndPassword();
			break;
		}
		case 8:{
			verifyEmpByPhoneAndPassword();
			break;
		}
		case 9:{
			verifyEmpByEmailAndPassword();
			break;
		}
		case 10:{
			FindDeptById();
			break;
		}
		
		}
		
		
	}
	
	public static void saveDept()
	{
		System.out.println("Enter the name and Location to save department");
		Department d=new Department();
		d.setName(sc.next());
		d.setLocation(sc.next());
		d= deptDao.saveDepartment(d);
		System.out.println("Department saved with id: "+ d.getId());
	}
	
	public static void updateDept()
	{
		System.out.println("Enter the department id to update");
		int id=sc.nextInt();
		Department d=new Department();
		System.out.println("enter name and location to update deparment");
		d.setName(sc.next());
		d.setLocation(sc.next());
		d=deptDao.updateDepartment(d);
		System.out.println("Deparment Updated");
	}
	
	public static void saveEmp()
	{
		System.out.println("Enter the department id to add Employee");
		int dept_id=sc.nextInt();
		System.out.println("Enter the name, desg, salary,phone,email and password to save Employee");
		Employee e=new Employee();
		e.setName(sc.next());
		e.setDesignation(sc.next());
		e.setSalary(sc.nextDouble());
		e.setPhone(sc.nextLong());
		e.setEmail(sc.next());
		e.setPassword(sc.next());
		e=empDao.saveEmployee(e, dept_id);
		
		if(e!=null)
		{
			System.out.println("Employee saved with Id :"+e.getId());
		}else {
			System.err.println("Invalid Department Id");
		}
	}
	
	public static void updateEmp()
	{
		System.out.println("Enter the department id to update Employee");
		int dept_id=sc.nextInt();
		System.out.println("Enter the id, name, designation, salary,phone,email,and password to update ");
		Employee e=new Employee();
		e.setId(sc.nextInt());
		e.setName(sc.next());
		e.setDesignation(sc.next());
		e.setSalary(sc.nextDouble());
		e.setPhone(sc.nextLong());
		e.setEmail(sc.next());
		e.setPassword(sc.next());
		e=empDao.updateEmployee(e, dept_id);
		if(e!=null) {
		System.out.println("Employee Updated with id: "+e.getId());
		}
		else {
			System.err.println("Invalid Department id");
		}
	}
	
	public static void findEmpsByDeptId()
	{
		System.out.println("Enter the Department id to find Employees");
		int dept_id=sc.nextInt();
		List<Employee> emps=empDao.findEmpsByDeptId(dept_id);
		if(emps.size()>0)
		{
			for(Employee e: emps)
			{
				System.out.println("Employee id: "+e.getId());
				System.out.println("Employee name: "+e.getName());
				System.out.println("Employee Designation: "+e.getDesignation());
				System.out.println("Employee phone number: "+e.getPhone());
				System.out.println("Employee email id: "+e.getEmail());
			}
		}else {
			System.err.println("Invalid Department id");
		}
	}
	
	public static void findEmpsByDeptname()
	{
		System.out.println("Enter the Department name to find Employees");
		String name=sc.next();
		List<Employee> emps=empDao.findEmpsByDeptName(name);
		if(emps.size()>0)
		{
			for(Employee e: emps)
			{
				System.out.println("Employee id: "+e.getId());
				System.out.println("Employee name: "+e.getName());
				System.out.println("Employee Designation: "+e.getDesignation());
				System.out.println("Employee phone number: "+e.getPhone());
				System.out.println("Employee email id: "+e.getEmail());
			}
		}else {
			System.err.println("Invalid Department name");
		}
	}
	
	public static void verifyEmpByIdAndPassword()
	{
		System.out.println("Enter the id and password to verify");
		int dept_id=sc.nextInt();
		String password=sc.next();
		Employee e=empDao.verifyEmployee(dept_id, password);
		if(e!=null)
		{
			System.out.println("Employee id: "+e.getId());
			System.out.println("Employee name: "+e.getName());
			System.out.println("Employee Designation: "+e.getDesignation());
			System.out.println("Employee phone number: "+e.getPhone());
			System.out.println("Employee email id: "+e.getEmail());
		}else {
			System.err.println("Invalid Id or password");
		}
	}
	
	public static void verifyEmpByPhoneAndPassword()
	{
		System.out.println("Enter the phone and password to verify");
		long phone=sc.nextLong();
		String password=sc.next();
		Employee e=empDao.verifyEmployee(phone, password);
		if(e!=null)
		{
			System.out.println("Employee id: "+e.getId());
			System.out.println("Employee name: "+e.getName());
			System.out.println("Employee Designation: "+e.getDesignation());
			System.out.println("Employee phone number: "+e.getPhone());
			System.out.println("Employee email id: "+e.getEmail());
		}else {
			System.err.println("Invalid phone or password");
		}
	}
	
	public static void verifyEmpByEmailAndPassword()
	{
		System.out.println("Enter the Email and password to verify");
		String email=sc.next();
		String password=sc.next();
		Employee e=empDao.verifyEmployee(email, password);
		if(e!=null)
		{
			System.out.println("Employee id: "+e.getId());
			System.out.println("Employee name: "+e.getName());
			System.out.println("Employee Designation: "+e.getDesignation());
			System.out.println("Employee phone number: "+e.getPhone());
			System.out.println("Employee email id: "+e.getEmail());
		}else {
			System.err.println("Invalid email or password");
		}
	}
	
	public static void FindDeptById()
	{
		System.out.println("Enter department id");
		int dept_id=sc.nextInt();
		
		Department d=deptDao.findById(dept_id);
		if(d!=null)
		{
			System.out.println("Department Id : "+ d.getId());
			System.out.println("Department name: "+d.getName());
			System.out.println("Department Location: "+ d.getLocation());
		}else {
			System.err.println("Envalid id");
		}
	}
	
	
	
	
	
	

}
