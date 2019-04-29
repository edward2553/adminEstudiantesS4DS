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
import com.s4ds.utilidades.validations;

/**
 * Servlet implementation class UpdateStudentsData
 */
@WebServlet("/UpdateStudentsData")
public class UpdateStudentsData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int studentID = Integer.parseInt(request.getParameter("idUpdate"));
		String name = request.getParameter("NameUpdate");
		String lastName = request.getParameter("LastNameUpdate");
		String grade = request.getParameter("gradeUpdate");
		validations valid = new validations();
		Estudiante obj_est = new Estudiante(studentID, name, lastName, grade, null);
		EstudianteDAO estDao = new EstudianteDAO();
		
			if (estDao.UpdateStudent(obj_est)) {
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Estudiante actualizado correctamente');");
				out.println("location='administrador.jsp';");
				out.println("</script>");
			} else {
				response.setContentType("text/html;charset=UTF-8");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Error: el estudiante no pudo ser actualizado');");
				out.println("location='administrador.jsp';");
				out.println("</script>");
			}
		

	}

}
