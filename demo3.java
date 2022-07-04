package jdbcdemo3;
import java.sql.*;
import java.util.*;

		class Emp
		{
			
		    Emp()
			{
		    	 try
		    	 {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMP","root","Password123");
				PreparedStatement stmt=con.prepareStatement("insert into EMP values(?,?,?,?,?)");
				Scanner sc=new Scanner(System.in);
				System.out.print("Enter Employee Id :");
				int id=sc.nextInt();
				System.out.print("Enter Employee Name :");  
				String name=sc.next();
				System.out.print("Enter Employee Age :");
			    int age=sc.nextInt();
				System.out.print("Enter Employee Salary :");
				int sal=sc.nextInt();
				System.out.print("Enter Employee Designation :");
				String desig=sc.next();
				
				stmt.setInt(1, id);
				stmt.setString(2,name);
				stmt.setInt(3,age);
				stmt.setInt(4,sal);
				stmt.setString(5, desig);
				System.out.println("Data inserted successfully...");
				stmt.execute();
				con.close();
		    	 }
		    	 catch(Exception e)
		    	 {
		    		 System.out.println(e);
		    	 }
		}

		

		}public class demo3 {

			public static void main(String[] args) {
				
				Emp e =new Emp();
			}
		}
				
				
				
				
			
