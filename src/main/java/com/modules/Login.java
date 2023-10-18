package com.modules;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		PrintWriter out = response.getWriter();
		String email =  request.getParameter("email");
		String pwd =  request.getParameter("pwd");
		Connection c = GetConnection.getConnection();	
		String checkUserSql = "select * from assistant where email = ?";

		PreparedStatement ps;
		try {
			ps = c.prepareStatement(checkUserSql);
			ps.setString(1,email);
			ps.addBatch();
			ResultSet rs = ps.executeQuery();
			if(rs.next() && rs.getString("password").equals(pwd)){
				HttpSession session = request.getSession();
				session.setAttribute("name", rs.getString("name"));
				session.setAttribute("aid", rs.getInt("aid"));
				response.sendRedirect("welcome.html");
			}
			else{
				  
				response.setContentType("text/html");  
				out.println("<br><br><br><h1 align=center><font color=\"red\">TRY AGAIN<br>REDIRECTING YOU TO LOGING PAGE</font></h1><script type=\"text/javascript\">");  
				out.println("redirectURL = \"login.html\";setTimeout(\"location.href = redirectURL;\",\"5000\");");  
				out.println("</script>");
			}
			ps.clearBatch();
		} catch (SQLException e) {
			response.setContentType("text/html");  
			out.println("<br><br><br><h1 align=center><font color=\"red\">TRY AGAIN<br>REDIRECTING YOU TO LOGING PAGE</font></h1><script type=\"text/javascript\">");  
			out.println("redirectURL = \"login.html\";setTimeout(\"location.href = redirectURL;\",\"5000\");");  
			out.println("</script>");
			e.printStackTrace();
		}
	}

}
