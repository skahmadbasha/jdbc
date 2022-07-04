package jdbcdemo5;

import java.sql.*;
import java.util.*;
public class demodelete
	{
	public static void main(String args[])
	{
    	 try
    	 {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMP","root","Password123");
		PreparedStatement stmt=con.prepareStatement("Delete from EMP where id=?");
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter Employee Id :");
		int id=sc.nextInt();
		
		
		stmt.setInt(1,id);
		
		System.out.println("Do you really want to delete ? YES/NO");
		String ch=sc.next();
		if(ch.equalsIgnoreCase("yes")) 
		{
		   stmt.execute();
		   System.out.println("Data deleted...");
		}	
		else 
		{
		System.out.println("data not deleted..");
		}
		con.close();
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
    }

}
