package helloworld;
import java.sql.*;  
import java.util.*;


public class Manager {
	static Connection conn = null;
	// Database connection 
	public static Connection connectDB() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","12345678");
			return conn;
		}
		catch(SQLException | ClassNotFoundException e)
		{
			System.out.println(e);
		}
		return conn;
		
		
	
}

public void addEmployee() // Method to add the employee details
{
	Scanner sc = new Scanner(System.in);
	System.out.println("enter employee Id");
	int id = sc.nextInt();
	Scanner sc_fname = new Scanner(System.in);
	System.out.println("enter employee Firstname");
	String fname = sc_fname.nextLine();
	Scanner sc_lname = new Scanner(System.in);
	System.out.println("enter employee Lastname");
	String lname = sc_lname.nextLine();
	Scanner sc_phone = new Scanner(System.in);
	System.out.println("enter employee phone no");
	Double phone = sc_phone.nextDouble();
	Scanner sc_salary = new Scanner(System.in);
	System.out.println("enter employee Salary");
	double salary = sc_salary.nextDouble();
	
try {
	Connection con = Manager.connectDB();
	Statement stmt = con.createStatement();
	stmt.executeUpdate("insert into Employees(Employee_ID,FirstName,Lastname,Phoneno,Salary) values("+id+",'"+fname+"','"+lname+"',"+phone+","+salary+")");
	System.out.println("Record inserted successfully");

} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		

}
public void getEmployee()// Method to get the particular employee details
{
	Scanner s = new Scanner(System.in);
	System.out.println("Enter employee ID");
	int ID = s.nextInt();
	try {
		Connection con = Manager.connectDB();
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from Employees where Employee_ID = '"+ID+"'");  
		System.out.println("********* Employee details are *********");
		while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+ " "+rs.getLong(4)+" "+rs.getBigDecimal(5, 2));  
		con.close();  

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	
}
public void displayEmployee()// Method to get the all employee details
{

	try {
		Connection con = Manager.connectDB();
		
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from Employees");  
		System.out.println("********* All Employee details are *********");
		while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+ " "+rs.getLong(4)+" "+rs.getBigDecimal(5, 2));  
		con.close();  

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  

	
}
public void incrementSalary() //method to increment the salary based on the employee id
{
	Scanner s = new Scanner(System.in);
	System.out.println("Enter Employee ID");
	int ID = s.nextInt();
	Scanner s1 = new Scanner(System.in);
	System.out.println("Enter Amount you want to increment");
	long bonus = s.nextLong();
	try {
		Connection con = Manager.connectDB();
		Statement stmt=con.createStatement();  
		int rs=stmt.executeUpdate("UPDATE employees set salary = salary + '"+bonus+"' where Employee_ID = '"+ID+"'");  
		if(rs ==0)
		{
			System.out.println("enter correct employee id");
		}
		else {
		
		System.out.println("********* record updated successfully *********");}
		
		con.close();  

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
}
public void addBonus() //method to add the bonus amount to all employess
{
	Scanner s = new Scanner(System.in);
	System.out.println("Enter Bonus Amount");
	long bonus = s.nextLong();
	try {
		Connection con = Manager.connectDB();
		Statement stmt=con.createStatement();  
		int rs=stmt.executeUpdate("UPDATE employees set salary = salary + '"+bonus+"'");  
		System.out.println("********* record updated successfully *********");
		
		con.close();  

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
}
public void allEmeployeeSalaries() //Method to get all employee salaries
{
	try {
		Connection con = Manager.connectDB();
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select Salary from Employees");  
		System.out.println("********* Employee Salaries are *********");
		while(rs.next())  
			System.out.println(rs.getBigDecimal(1, 2));  
		con.close();  

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
}
}
