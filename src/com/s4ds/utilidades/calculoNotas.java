package com.s4ds.utilidades;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.s4ds.entidades.Estudiante;
import com.s4ds.entidades.Nota;
import com.s4ds.persistencia.EstudianteDAO;
import com.s4ds.persistencia.ListStudentsDAO;
import com.s4ds.persistencia.ListarNotas;

/**
 *
 * @author edwar
 */
public class calculoNotas {

    public double[][] obtenerNotas() {

        double[][] vect_notas;

        try {
            //estudiantes
            ListStudentsDAO obj_listarEst = new ListStudentsDAO();
            ResultSet estudiantes = obj_listarEst.listarEstudiantes();
            //notas
            ListarNotas obj_listarNot = new ListarNotas();
            ResultSet notas = obj_listarNot.listar_notas_estudiantes();
            //calcular la cantidad de estudiantes
            int n_est = 0;
            while (estudiantes.next()) {
                n_est += 1;
            }
            vect_notas = new double[n_est][2];
            estudiantes = null;
            estudiantes = obj_listarEst.listarEstudiantes();
            estudiantes.next();
            notas.next();
            int index_est = 0, index_not = 0;
            double nota = 0;
            double porcentaje = 0;
            if(isResultSetEmpty(notas)) {
            	return vect_notas;
            }
            int notaID = notas.getInt(1);
            int estID = estudiantes.getInt(1);
            double sumaPorcentaje = 0;
            while (estudiantes != null) {
                if (notaID == estID) {
                    nota = notas.getDouble(4);
                    porcentaje = notas.getDouble(3);
                    sumaPorcentaje = sumaPorcentaje + ((nota * porcentaje) / 100);
                    notas.next();
                    //no hay mas notas
                    if (notas.isAfterLast()) {
                        vect_notas[index_est][index_not++] = estID;
                        estudiantes.next();
                        if (estudiantes.isAfterLast()) {
                            vect_notas[index_est][index_not] = sumaPorcentaje;
                            break;
                        }
                        estID = estudiantes.getInt(1);
                        vect_notas[index_est][index_not] = sumaPorcentaje;
                        sumaPorcentaje = 0;
                        index_est += 1;
                        index_not = 0;
                    } else {
                        notaID = notas.getInt(1);
                    }
                } else {
                    vect_notas[index_est][index_not++] = estID;
                    estudiantes.next();
                    if(estudiantes.isAfterLast()){
                    vect_notas[index_est][index_not] = sumaPorcentaje;
                    break;
                    }
                    estID = estudiantes.getInt(1);
                    vect_notas[index_est][index_not] = sumaPorcentaje;
                    sumaPorcentaje = 0;
                    index_est += 1;
                    index_not = 0;
                }
            }

            return vect_notas;

        } catch (Exception e) {
            System.out.println("El error fué: " + e.getMessage() + " la causa fué: " + e.getCause());
            return null;
        }

    }
    
    public static boolean isResultSetEmpty(ResultSet resultSet) {
        try {
			return !resultSet.first();
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
    }

}
