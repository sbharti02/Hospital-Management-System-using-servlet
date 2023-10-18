package com.modules;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Servlet implementation class RetrieveDoctor
 */
public class RetrieveDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveDoctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
//		String did = request.getParameter("did");
			PrintWriter out = response.getWriter();
			try {
				
			Connection c = GetConnection.getConnection();
			String sql = "select * from doctor";
			
			PreparedStatement ps = c.prepareStatement(sql);
			ps.addBatch();
			
			ResultSet r = ps.executeQuery();
			ResultSetMetaData rms = r.getMetaData();
			ps.clearBatch();
			
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
			out.println("<th>Patients Under</th>");
			out.println("</td>");
			while(r.next()){
				out.println("<tr>");
				out.println("<td></td>");
				out.println("<td>"+r.getString("did")+"</td>");
				out.println("<td>"+ r.getString("name") +"</td>");
				out.println("<td>"+ r.getString("email") +"</td>");
				out.println("<td>"+ r.getString("phone") +"</td>");
				out.println("<td>"+ r.getString("age") +"</td>");
				out.println("<td>"+ r.getString("joindate") +"</td>");
				out.println("<td>"+ r.getString("salary") +"</td>");
				out.println("<td>"+ r.getString("specialist") +"</td>");
				out.println("<td>"+ r.getString("patients") +"</td>");
				out.println("<td>"+"<form method=\"GET\" action=\"RetrievePatientsDID\"><input hidden value =\""+r.getString("did")+"\" name=\"did\"><input type=\"submit\" value=\"Click\"></form>");
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (SQLException e) { 
			response.setContentType("text/html");  
			out.println("<br><br><br><h1 align=center><font color=\"red\">TRY AGAIN<br></font></h1>");  
			e.printStackTrace();
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
