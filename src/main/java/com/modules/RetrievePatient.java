package com.modules;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class RetrievePatient
 */
public class RetrievePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrievePatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		try {
			
		Connection c = GetConnection.getConnection();
		String sql = "select * from patient";
		
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery(sql);

		response.setContentType("text/html");
		ResultSetMetaData rms = r.getMetaData();
		
		out.println("<table>");
		out.println("<td>");
		out.println("<th>"+rms.getColumnName(1)+"</th>");
		out.println("<th>"+rms.getColumnName(2)+"</th>");
		out.println("<th>"+rms.getColumnName(3)+"</th>");
		out.println("<th>"+rms.getColumnName(4)+"</th>");
		out.println("<th>"+rms.getColumnName(5)+"</th>");
		out.println("<th>"+rms.getColumnName(6)+"</th>");
		out.println("<th>"+rms.getColumnName(7)+"</th>");
		out.println("<th>"+rms.getColumnName(8)+"</th>");
		out.println("<th>"+rms.getColumnName(9)+"</th>");
		out.println("<th>"+rms.getColumnName(10)+"</th>");
		out.println("<th>"+rms.getColumnName(11)+"</th>");
		out.println("</td>");
			while(r.next()){
				out.println("<tr>");
				out.println("<td></td>");
				out.println("<td>"+ r.getString("pid") +"</td>");
				out.println("<td>"+ r.getString("name") +"</td>");
				out.println("<td>"+ r.getString("email") +"</td>");
				out.println("<td>"+ r.getString("phone") +"</td>");
				out.println("<td>"+ r.getString("age") +"</td>");
				out.println("<td>"+ r.getString("gender") +"</td>");
				out.println("<td>"+ r.getString("blood") +"</td>");
				out.println("<td>"+ r.getString("symptom") +"</td>");
				out.println("<td>"+ r.getString("disease") +"</td>");
				out.println("<td>"+ r.getString("doctor") +"</td>");
				out.println("<td>"+ r.getString("visited") +"</td>");
				out.println("</tr>");
			}
		out.print("</table>");
	} catch (SQLException e) { 
		response.setContentType("text/html");  
		out.println("<br><br><br><h1 align=center><font color=\"red\">TRY AGAIN<br></font></h1><script type=\"text/javascript\">");  
		out.println("redirectURL = \"welcome.html\";setTimeout(\"location.href = redirectURL;\",\"5000\");");  
		out.println("</script>");
		e.printStackTrace();
		System.out.println(e);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
