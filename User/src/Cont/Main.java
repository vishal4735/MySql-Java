package Cont;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");
			String email = request.getParameter("email");

			 System.out.println("The username is " + uname);
			System.out.println("Working 1 ");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Working 2 ");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
			System.out.println("Working 3 ");
			
			String sql = "INSERT INTO utable (Name,Email,Password) VALUES (?,?,?)";
			PreparedStatement stm = con.prepareStatement(sql);
			
			stm.setString(1, uname);
			stm.setString(2, email);
			stm.setString(3, pass);
									
			stm.execute();
			System.out.println("Working 4 ");
		     
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
