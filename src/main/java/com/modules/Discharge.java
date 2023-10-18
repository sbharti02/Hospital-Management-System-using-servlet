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
import java.sql.SQLException;

/**
 * Servlet implementation class Discharge
 */
public class Discharge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Discharge() {
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
		
		double total = 0;
		Connection c = GetConnection.getConnection();
		PrintWriter out = response.getWriter();
		String pid = request.getParameter("pid");
		int days = Integer.valueOf(request.getParameter("days"));
		int daycost = Integer.valueOf(request.getParameter("daycost"));
		String medData = request.getParameter("mc");
		String[] mcs = medData.split(";");
		String sq1 = "delete from patient where pid = "+pid;
		try {
			c.createStatement().executeUpdate(sq1);
			for(String mc:mcs){
				String mid = mc.split(",")[0];
				int count = Integer.valueOf(mc.split(",")[1]);
				
				String sq2 = "select price from medicine where mid = "+mid;
				ResultSet rs = c.createStatement().executeQuery("select price from medicine where mid = "+mid);
				rs.next();
				double price = Double.valueOf(rs.getString("price"));
				total += (price * count);
			}
			
			total += (days * daycost);
			response.setContentType("text/html");
			out.println("<h1>TOTAL MONEY TO PAY IS:<br><br><br></h1>");
			out.println("<h3>= "+total+"</h3>");
			
			
		} catch (SQLException e) {
			out.println("<br><br><br><h1 align=center><font color=\"red\">TRY AGAIN! Some problem<br></font></h1>");  
			e.printStackTrace();
			}
	}

}
