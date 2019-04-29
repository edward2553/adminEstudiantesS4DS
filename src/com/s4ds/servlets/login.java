package com.s4ds.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try{
			
			String usuario = request.getParameter("usu");
			String password = request.getParameter("pass");
	          
	          if(usuario.equalsIgnoreCase("s4ds") && password.equalsIgnoreCase("s4ds2018")){
	                response.sendRedirect("administrador.jsp");
	          }else{
	      		response.setContentType("text/html;charset=UTF-8");
	                out.println("<script type=\"text/javascript\">");
	                out.println("alert('ERROR: usuario o clave incorrecta');");
	                out.println("location='index.jsp';");
	                out.println("</script>");
	          }
			
		}catch(Exception e){
			Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, e);
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
