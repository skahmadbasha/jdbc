package jdbcdemo4;
import java.sql.*;
import java.util.*;


public class demo4 {

		public static void main(String args[])
		{
	    	 try
	    	 {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMP","root","Password123");
			PreparedStatement stmt=con.prepareStatement("Update EMP set salary=? where id=?");
			Scanner sc=new Scanner(System.in);
			
			System.out.print("Enter Employee Id :");
			int id=sc.nextInt();
			
			System.out.print("Enter Employee Salary :");
			int salary=sc.nextInt();
			
			stmt.setInt(1,salary);
			stmt.setInt(2,id);
			
			stmt.execute();
			con.close();
			System.out.println("Data updated successfully...");
			
	    	 }
	    	 catch(Exception e)
	    	 {
	    		 System.out.println(e);
	    	 }
	    }

	}


