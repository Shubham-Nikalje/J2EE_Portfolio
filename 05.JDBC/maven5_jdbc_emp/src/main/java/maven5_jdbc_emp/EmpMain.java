package maven5_jdbc_emp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpMain {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		Scanner scanner = new Scanner(System.in);
		Emp emp = new Emp();
		EmpCrud empCrud = new EmpCrud();
		boolean condition = true;
		
		do {
			System.out.println("1.INSERT DATA");
			System.out.println("2.UPDATE DATA");
			System.out.println("3.DELETE DATA");
			System.out.println("4.FETCH DATA BY ID");
			System.out.println("5.FETCH ALL DATA");
			
			System.out.println("ENTER THE CHOICE  AS PER DATA REQUIREMENT");
			int choice = scanner.nextInt();
					switch (choice) {
					case 1:
							
					{
						System.out.println("ENTER THE Empno");
						int empno = scanner.nextInt();
						System.out.println("ENTER THE ENAME");
						String ename = scanner.next();
						System.out.println("ENTER THE JOB");
						String job = scanner.next();
						System.out.println("ENTER THE SAL");
						String sal = scanner.next();
						
						emp.setEmpno(empno);
						emp.setEname(ename);
						emp.setJob(job);
						emp.setSal(sal);
						
					}
					  empCrud.saveEmp(emp);
						break;
						
					case 2:
					{
						System.out.println("ENTER THE Empno");
						int empno = scanner.nextInt();
						System.out.println("ENTER THE ENAME");
						String ename = scanner.next();
						System.out.println("ENTER THE JOB");
						String job = scanner.next();
						System.out.println("ENTER THE SAL");
						String sal = scanner.next();
						
						emp.setEmpno(empno);
						emp.setEname(ename);
						emp.setJob(job);
						emp.setSal(sal);
						
					}
					empCrud.updateEmp(emp);
					break;
						
					case 3:
					{
						
						System.out.println("ENTER THE Empno");
						int empno = scanner.nextInt();
						
						emp.setEmpno(empno);
						}
					empCrud.deleteEmp(emp);
						break;	
						
					case 4:
					{
						System.out.println("ENTER THE Empno");
						int empno = scanner.nextInt();
						
						emp.setEmpno(empno);
						
						empCrud.fetchEmp(empno);
					}
						break;
						
					case 5:
					{
						empCrud.fetchAllEmp();	
					}
						break;
						
					default:
						condition=false;
						break;
					}
		} while (condition);
				
			scanner.close();
		}


}
