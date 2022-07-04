package jdbcproject;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
class Worker
{
    static void insert() {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahmadbasha","root","Password123");
			PreparedStatement stmt = con.prepareStatement("insert into ahmad values(?,?,?,?,?)");
			Scanner sc=new Scanner(System.in);
			
			System.out.println("enter id:");
			int id=sc.nextInt();
			System.out.println("enter name:");
			String name=sc.next();
			System.out.println("enter age:");
			int age=sc.nextInt();
			System.out.println("enter salary:");
			int salary=sc.nextInt();
			System.out.println("enter Designation:");
			String desig=sc.next();
			
			
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setInt(3, age);
			stmt.setInt(4, salary);
			stmt.setString(5, desig);
			stmt.execute();
			con.close();
			System.out.println("data inserted successfully............!");
			
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}
    	
    }
    static void display() {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahmadbasha","root","Password123");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from ahmad");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getInt(3)+":"+rs.getInt(4)+":"+rs.getString(5));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
    	
    }
    static void update() {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahmadbasha","root","Password123");
			PreparedStatement stmt = con.prepareStatement("update ahmad set salary=? where id=?");
			Scanner sc=new Scanner(System.in);
			
			System.out.println("enter id:");
			int id=sc.nextInt();
			
			System.out.println("enter salary:");
			int salary=sc.nextInt();
			
			
			
			stmt.setInt(1, salary);
			stmt.setInt(2, id);
			stmt.execute();
			con.close();
			System.out.println("data updated successfully............!");
			
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}

    	
    }
    static void delete() {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahmadbasha","root","Password123");
			PreparedStatement stmt = con.prepareStatement("delete from ahmad where id=?");
			Scanner sc=new Scanner(System.in);
			
			System.out.println("enter id:");
			int id=sc.nextInt();
			
			
			
			
			
			stmt.setInt(1, id);
			System.out.println("do you want to delete? yes/no");
			String ch=sc.next();
			if(ch.equalsIgnoreCase("yes")) {
				stmt.execute();
				System.out.println("data deleted");
			}
			else {
				System.out.println("data not deleted");
			}
			
			
			con.close();
			
			
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}
    	
    }
}

public class project {
	public static void main(String args[])
	{
		int ch1=0;
	
		
		
		do{ 
		System.out.println("--------------------------------");
		System.out.println("1.Insert");
		System.out.println("2.Display");
		System.out.println("3.Upadate");
		System.out.println("4.Delete");
		System.out.println("5.exit");
		System.out.println("--------------------------------");
		System.out.println("Enter your Choice: ");
		Scanner sc1=new Scanner(System.in);
		ch1=sc1.nextInt();

		if(ch1==1)
		{
			Worker.insert();
		}
		if(ch1==2)
		{
			Worker.display();
		}
		if(ch1==3)
		{
			Worker.update();
		}
		if(ch1==4)
		{
			Worker.delete();
		}
		}while(ch1!=5);
		
	}
}
