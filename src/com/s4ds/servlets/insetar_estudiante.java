package com.s4ds.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.s4ds.entidades.Estudiante;
import com.s4ds.persistencia.EstudianteDAO;


/**
 * Servlet implementation class insetar_estudiante
 */
@WebServlet("/insetar_estudiante")
public class insetar_estudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String nombre = request.getParameter("crearEstudiante_nombre");
		String apellido = request.getParameter("crearEstudiante_apellido");
		String grado = request.getParameter("crearEstudiante_grado");
		Estudiante obj_est = new Estudiante(0, nombre, apellido, grado, null);
		EstudianteDAO estDao = new EstudianteDAO();

			if (estDao.insertarEstudiante(obj_est)) {
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Estudiante registrado correctamente');");
				out.println("location='administrador.jsp';");
				out.println("</script>");
			} else {
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Error: el estudiante no pudo ser registrado');");
				out.println("location='administrador.jsp';");
				out.println("</script>");
			}
		

	}

}
