package com.s4ds.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.s4ds.entidades.Nota;
import com.s4ds.utilidades.conexion;

public class ListarNotas {

	// listar las notas de cada estudiante

	public ResultSet listar_notas_estudiantes() {
		conexion con = new conexion();
		try {
			PreparedStatement ps = con.obtenerConexion().prepareStatement("SELECT * FROM NOTAS ORDER BY ID_EST");
			ResultSet result = ps.executeQuery();
			return result;
		} catch (Exception e) {
			System.out.println("El error fué: " + e.getMessage() + " la causa fué: " + e.getCause());
			return null;
		}

	}
}
