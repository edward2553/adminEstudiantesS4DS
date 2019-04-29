package com.s4ds.utilidades;

import java.sql.*;



public class conexion {

	static Connection con = null;

	


	
	public Connection obtenerConexion() {
		
		
		try {
			//driver 
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://s4dstestdb.s4ds.com:3306/ROOKIE_CORE";
			String usuario = "test";
			String contrasena = "test";
			
			con = DriverManager.getConnection(url,usuario,contrasena);
			 
		} catch (Exception e) {
			System.out.println("el error es: " + e.getMessage() + " La causa es: "+ e.getCause());
			e.printStackTrace();
		}
		
	return con;
		
	}
	
	public void desconectar() {
		
		try {
			con.close();
		}catch(SQLException e) {
			System.out.println("Error al desconectar" +e.getMessage()+" la respectivfa causa "+ e.getCause());
		}
	}
	
	
	public static void main(String[] args) {
		
		conexion con = new conexion();
		
		try {
			ResultSet rs = con.obtenerConexion().prepareStatement("select * from ESTUDIANTE").executeQuery();
			
			while(rs.next()) {
				
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getInt(5));
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
}
