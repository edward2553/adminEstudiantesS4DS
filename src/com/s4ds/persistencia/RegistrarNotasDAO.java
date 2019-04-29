package com.s4ds.persistencia;

import java.sql.PreparedStatement;

import com.s4ds.entidades.Nota;
import com.s4ds.utilidades.conexion;

public class RegistrarNotasDAO {
	
	conexion con = new conexion();
	
	public boolean RegistrarNota(Nota nota) {
		try {
			PreparedStatement insNota = con.obtenerConexion().prepareStatement("INSERT INTO NOTAS (ID_EST,NOMBRE_NOTA,PORCENTAJE,VALOR) VALUES (?,?,?,?)");
			insNota.setInt(1, nota.getId_est());
			insNota.setString(2, nota.getNombre());
			insNota.setDouble(3, nota.getPorcentaje());
			insNota.setDouble(4, nota.getValor());
			insNota.execute();
		}catch(Exception e) {
			System.out.println("Error en " +e.getMessage()+" la respectiva causa "+ e.getCause());
			return false;
		}
		return true;
	}

}
