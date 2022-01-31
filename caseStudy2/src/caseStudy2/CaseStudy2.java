package caseStudy2;

import java.io.*;
import java.sql.*;
import java.util.*;

public class CaseStudy2 {

	public static void main(String[] args) throws ClassNotFoundException{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Employee Management System");
		
		System.out.println("Enter User ID:");
		String s1 = sc.next();
		
		System.out.println("Enter Password");
		String s2 = sc.next();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","demo");        
	        String queryString = "SELECT UserID, Password FROM Users where UserID=? and Password=?";
	        PreparedStatement stmt = conn.prepareStatement(queryString);
	        stmt.setString(1,s1);
	        stmt.setString(2,s2);
	        ResultSet results = stmt.executeQuery();

	        if (results.next()) {
	        	System.out.println("Logged In");
	        	
	        }else{
	        	System.out.println("Incorrect Credentials");
	        	System.exit(0);
	        } 
	        results.close();
	        conn.close();
			  
		}catch (SQLException e) {
	        System.out.println(e);

	    }
		
		System.out.println("Enter option:");
		System.out.println("1 - Get Details");
		System.out.println("2 - Add Details");
		System.out.println("3 - Update Details");
		System.out.println("4 - Delete Details");
		
		int n = sc.nextInt();
		
		switch(n) {
		
		case 1:
			System.out.println("Enter Employee ID");
			int a = sc.nextInt();
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","demo");
				PreparedStatement stmt =conn.prepareStatement("select * from employees where employee_id = ?");
				stmt.setInt(1,a);
				ResultSet rs=stmt.executeQuery();
				
				while(rs.next()){
					
					System.out.println(rs.getInt(1)+ " " + rs.getString(2) + " " + rs.getString(3)+ " " + rs.getString(4)+ " " + rs.getString(5) + " " + rs.getDate(6)+ " " + rs.getInt(7) + " " + rs.getFloat(8)+ " " + rs.getInt(9)+ " " + rs.getInt(10));
				  
				}
			}catch(Exception e1){
				e1.printStackTrace();
			}
			break;
		case 2:
			System.out.println("Enter Employee ID");
			int a1 = sc.nextInt();
			
			sc.nextLine();
			System.out.println("Enter FirstName");
			String a2 = sc.nextLine();
			
			System.out.println("Enter LastName");
			String a3 = sc.nextLine();
			
			System.out.println("Enter Email");
			String a4 = sc.nextLine();
			
			System.out.println("Enter Phone Number");
			String a5 = sc.nextLine();
			
			System.out.println("Enter Hire Date");
			String a6 = sc.nextLine();
			
			System.out.println("Enter Job ID");
			int a7 = sc.nextInt();
			
			System.out.println("Enter Salary");
			Float a8 = sc.nextFloat();
			
			System.out.println("Enter Manager ID");
			int a9 = sc.nextInt();
			
			System.out.println("Enter Department ID");
			int a10 = sc.nextInt();
			
			try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	  
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","demo");

	            PreparedStatement stmt = conn.prepareStatement("insert into employees values(?,?,?,?,?,?,?,?,?,?)");
	            
	            stmt.setInt(1, a1);
	            stmt.setString(2, a2);
	            stmt.setString(3, a3);
	            stmt.setString(4, a4);
	            stmt.setString(5, a5);
	            stmt.setString(6, a6);
	            stmt.setInt(7, a7);
	            stmt.setFloat(8, a8);
	            stmt.setInt(9, a9);
	            stmt.setInt(10, a10);
	            
	            int result = stmt.executeUpdate();
	            
	            if (result > 0)
	                System.out.println("successfully inserted");
	  
	            else
	                System.out.println("unsucessful insertion ");
	  
	            conn.close();
	        }
	  
	        catch (SQLException e) {
	            System.out.println(e);

	        }
			break;
			
		case 3:
			System.out.println("Enter Employee ID");
			int g = sc.nextInt();
				
			System.out.println("Choose Update Option");
			System.out.println("1.First Name");
			System.out.println("2. Last Name");
			System.out.println("3.Email");
			System.out.println("4.Phone Number");
			System.out.println("5.Hire Date");
			System.out.println("6.Job ID");
			System.out.println("7.Salary");
			System.out.println("8.Manager ID");
			System.out.println("9.Department ID");
				
			int u = sc.nextInt();
			switch(u) {
				case 1:
					try {
						System.out.println("Enter new First Name:");
						String u1 = sc.next();
						
			            Class.forName("com.mysql.cj.jdbc.Driver");
			  
			            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","demo");

			            PreparedStatement stmt = conn.prepareStatement("update employees set first_name = ? where employee_id = ?");
			            
			            stmt.setString(1, u1);
			            stmt.setInt(2, g);
			            
			            int result = stmt.executeUpdate();
			            
			            if (result > 0)
			                System.out.println("successfully updated");
			  
			            else
			                System.out.println("unsucessful updated ");
			  
			            conn.close();
			        }
			  
			        catch (SQLException e) {
			            System.out.println(e);

			        }
					break;	
				case 2:
					try {
						System.out.println("Enter new Last Name:");
						String u2 = sc.next();
						
			            Class.forName("com.mysql.cj.jdbc.Driver");
			  
			            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","demo");

			            PreparedStatement stmt = conn.prepareStatement("update employees set last_name = ? where employee_id = ?");
			            
			            stmt.setString(1, u2);
			            stmt.setInt(2, g);
			            
			            int result = stmt.executeUpdate();
			            
			            if (result > 0)
			                System.out.println("successfully updated");
			  
			            else
			                System.out.println("unsucessful updated ");
			  
			            conn.close();
			        }
			  
			        catch (SQLException e) {
			            System.out.println(e);

			        }
					break;
				case 3:
					try {
						System.out.println("Enter new Email:");
						String u3 = sc.next();
						
			            Class.forName("com.mysql.cj.jdbc.Driver");
			  
			            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","demo");

			            PreparedStatement stmt = conn.prepareStatement("update employees set email = ? where employee_id = ?");
			            
			            stmt.setString(1, u3);
			            stmt.setInt(2, g);
			            
			            int result = stmt.executeUpdate();
			            
			            if (result > 0)
			                System.out.println("successfully updated");
			  
			            else
			                System.out.println("unsucessful updated ");
			  
			            conn.close();
			        }
			  
			        catch (SQLException e) {
			            System.out.println(e);

			        }
					break;
					
				case 4:
					try {
						System.out.println("Enter new Phone Number:");
						String u4 = sc.next();
						
			            Class.forName("com.mysql.cj.jdbc.Driver");
			  
			            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","demo");

			            PreparedStatement stmt = conn.prepareStatement("update employees set phone_number = ? where employee_id = ?");
			            
			            stmt.setString(1, u4);
			            stmt.setInt(2, g);
			            
			            int result = stmt.executeUpdate();
			            
			            if (result > 0)
			                System.out.println("successfully updated");
			  
			            else
			                System.out.println("unsucessful updated ");
			  
			            conn.close();
			        }
			  
			        catch (SQLException e) {
			            System.out.println(e);

			        }
					break;
					
				case 5:
					try {
						System.out.println("Enter new Hire Date:");
						String u5 = sc.next();
						
			            Class.forName("com.mysql.cj.jdbc.Driver");
			  
			            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","demo");

			            PreparedStatement stmt = conn.prepareStatement("update employees set hire_date = ? where employee_id = ?");
			            
			            stmt.setString(1, u5);
			            stmt.setInt(2, g);
			            
			            int result = stmt.executeUpdate();
			            
			            if (result > 0)
			                System.out.println("successfully updated");
			  
			            else
			                System.out.println("unsucessful updated ");
			  
			            conn.close();
			        }
			  
			        catch (SQLException e) {
			            System.out.println(e);

			        }
					break;
				
				case 6:
					try {
						System.out.println("Enter new Job ID");
						int u6 = sc.nextInt();
						
			            Class.forName("com.mysql.cj.jdbc.Driver");
			  
			            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","demo");

			            PreparedStatement stmt = conn.prepareStatement("update employees set job_id = ? where employee_id = ?");
			            
			            stmt.setInt(1, u6);
			            stmt.setInt(2, g);
			            
			            int result = stmt.executeUpdate();
			            
			            if (result > 0)
			                System.out.println("successfully updated");
			  
			            else
			                System.out.println("unsucessful updated ");
			  
			            conn.close();
		        	}
		  
					catch (SQLException e) {
						System.out.println(e);

					}
					
				case 7:
					try {
						System.out.println("Enter new salary");
						Float u7 = sc.nextFloat();
						
			            Class.forName("com.mysql.cj.jdbc.Driver");
			  
			            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","demo");

			            PreparedStatement stmt = conn.prepareStatement("update employees set salary = ? where employee_id = ?");
			            
			            stmt.setFloat(1, u7);
			            stmt.setInt(2, g);
			            
			            int result = stmt.executeUpdate();
			            
			            if (result > 0)
			                System.out.println("successfully updated");
			  
			            else
			                System.out.println("unsucessful updated ");
			  
			            conn.close();
		        	}
		  
					catch (SQLException e) {
						System.out.println(e);

					}
				case 8:
					try {
						System.out.println("Enter new Manager ID:");
						int u8 = sc.nextInt();
						
			            Class.forName("com.mysql.cj.jdbc.Driver");
			  
			            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","demo");

			            PreparedStatement stmt = conn.prepareStatement("update employees set manager_id = ? where employee_id = ?");
			            
			            stmt.setInt(1, u8);
			            stmt.setInt(2, g);
			            
			            int result = stmt.executeUpdate();
			            
			            if (result > 0)
			                System.out.println("successfully updated");
			  
			            else
			                System.out.println("unsucessful updated ");
			  
			            conn.close();
		        	}
		  
					catch (SQLException e) {
						System.out.println(e);

					}
					
				case 9:
					try {
						System.out.println("Enter new Department ID:");
						int u9 = sc.nextInt();
						
			            Class.forName("com.mysql.cj.jdbc.Driver");
			  
			            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","demo");

			            PreparedStatement stmt = conn.prepareStatement("update employees set department_id = ? where employee_id = ?");
			            
			            stmt.setInt(1, u9);
			            stmt.setInt(2, g);
			            
			            int result = stmt.executeUpdate();
			            
			            if (result > 0)
			                System.out.println("successfully updated");
			  
			            else
			                System.out.println("unsucessful updated ");
			  
			            conn.close();
		        	}
		  
					catch (SQLException e) {
						System.out.println(e);

					}
					
				default:
					System.out.println("Input out of range");
			}
			break;
				
			
		case 4:
			try {
				System.out.println("Enter Employee ID:");
				int i = sc.nextInt();
				
	            Class.forName("com.mysql.cj.jdbc.Driver");
	  
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","demo");

	            PreparedStatement stmt = conn.prepareStatement("delete from employees where employee_id = ?");
	            
	            stmt.setInt(1, i);
	            
	            int result = stmt.executeUpdate();
	            
	            if (result > 0)
	                System.out.println("successfully deleted");
	  
	            else
	                System.out.println("unsucessful deleted ");
	  
	            conn.close();
	        }
	  
	        catch (SQLException e) {
	            System.out.println(e);

	        }
			break;
			
			default:
				System.out.println("Input out of range");
		}

	}

}
