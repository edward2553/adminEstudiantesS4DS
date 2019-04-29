package com.s4ds.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.s4ds.entidades.Estudiante;
import com.s4ds.utilidades.conexion;

public class EstudianteDAO {

	Estudiante p, inicio;

	public EstudianteDAO() {
		p = null;
		inicio = null;
	}

	conexion con = new conexion();

	public boolean insertarEstudiante(Estudiante est) {
		try {
			PreparedStatement insEstudiante = con.obtenerConexion()
					.prepareStatement("insert into ESTUDIANTE (ID,NOMBRE,APELLIDO,GRADO,N_NOTAS) values (?,?,?,?,?)");
			insEstudiante.setInt(1, est.getID());
			insEstudiante.setString(2, est.getNombre());
			insEstudiante.setString(3, est.getApellido());
			insEstudiante.setString(4, est.getGrado());
			insEstudiante.setInt(5, 0);
			insEstudiante.execute();
		} catch (Exception e) {
			System.out.println("Error en " + e.getMessage() + " la respectiva causa " + e.getCause());
			return false;
		}
		return true;
	}

	// Deleting a student
	public boolean DeleteStudent(Estudiante est) {
		try {
			PreparedStatement insEstudiante = con.obtenerConexion()
					.prepareStatement("DELETE FROM ESTUDIANTE WHERE ID = ?");
			insEstudiante.setInt(1, est.getID());
			insEstudiante.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en " + e.getMessage() + " la respectiva causa " + e.getCause());
			return false;
		}
		return true;
	}

	// updating an student
	public boolean UpdateStudent(Estudiante est) {
		try {
			PreparedStatement insEstudiante = con.obtenerConexion()
					.prepareStatement("UPDATE ESTUDIANTE SET NOMBRE = ? , APELLIDO = ? , GRADO = ? WHERE ID = ?");
			insEstudiante.setString(1, est.getNombre());
			insEstudiante.setString(2, est.getApellido());
			insEstudiante.setString(3, est.getGrado());
			insEstudiante.setInt(4, est.getID());
			;
			insEstudiante.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en " + e.getMessage() + " la respectiva causa " + e.getCause());
			return false;
		}
		return true;
	}

	public ResultSet SearchStudentByID(String studentID) {
		conexion con = new conexion();
		try {
			PreparedStatement insEstudiante = con.obtenerConexion()
					.prepareStatement("SELECT * FROM ESTUDIANTE where NOMBRE LIKE"+"'%"+studentID+"%'");
			ResultSet result = insEstudiante.executeQuery();

			return result;
		} catch (Exception e) {
			System.out.println("Error en " + e.getMessage() + " la respectiva causa " + e.getCause());
			return null;
		}

	}

}
