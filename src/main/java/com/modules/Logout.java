package com.modules;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
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
		
		HttpSession sess = request.getSession();
		PrintWriter out = response.getWriter();
		
		sess.removeAttribute("name");
		sess.removeAttribute("aid");
		sess.invalidate();
		
		response.setContentType("text/html");  
		out.println("<br><br><br><h1 align=center><font color=\"green\">YOU ARE LOGGED OUT OF THE SYSTEM<br>REDIRECTING YOU TO<br><br> HOME-PAGE</font></h1><script type=\"text/javascript\">");  
		out.println("redirectURL = \"index.html\";setTimeout(\"location.href = redirectURL;\",\"5000\");");  
		out.println("</script>");
	}

}
