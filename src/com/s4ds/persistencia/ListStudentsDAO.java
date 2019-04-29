package com.s4ds.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.s4ds.entidades.Estudiante;
import com.s4ds.utilidades.conexion;

public class ListStudentsDAO {

	// listar los estudiantes de la tabla ESTUDIANTES
	public ResultSet listarEstudiantes() {

		conexion con = new conexion();
		try {

			PreparedStatement ps = con.obtenerConexion().prepareStatement("SELECT * FROM ESTUDIANTE");
			ResultSet result = ps.executeQuery();
			return result;
		} catch (Exception e) {
			System.out.println("El error fué: " + e.getMessage() + " la causa fué: " + e.getCause());
			return null;
		}

	}

}
