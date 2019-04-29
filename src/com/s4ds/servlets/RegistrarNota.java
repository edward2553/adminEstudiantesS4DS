package com.s4ds.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.s4ds.entidades.Nota;
import com.s4ds.persistencia.RegistrarNotasDAO;
import com.s4ds.utilidades.validations;

/**
 * Servlet implementation class RegistrarNota
 */
@WebServlet("/RegistrarNota")
public class RegistrarNota extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int Id_estudiante = Integer.parseInt(request.getParameter("id_estudiante_registrarNota"));
		String nombre_nota = request.getParameter("nombreNota");
		Double porc_nota = Double.parseDouble(request.getParameter("porcentajeNota"));
		Double valor = Double.parseDouble(request.getParameter("valorNota"));
		Nota obj_not = new Nota(Id_estudiante, nombre_nota, porc_nota, valor, null);
		validations valid = new validations();
		RegistrarNotasDAO obj_regNotDAO = new RegistrarNotasDAO();

		if (obj_regNotDAO.RegistrarNota(obj_not)) {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Nota registrada correctamente');");
			out.println("location='administrador.jsp';");
			out.println("</script>");

		} else {
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Error al registrar la nota');");
			out.println("location='administrador.jsp';");
			out.println("</script>");
		}

	}

}
