package com.curso.java.Clase09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.curso.java.Clase09.Ejercicio.Documentos;
import com.mysql.cj.xdevapi.PreparableStatement;

public class Ejercicio2 {

	 enum Documentos{
		 DNI,CI,PAS,LE
		 
	}
	public static void main(String[] args) {
		
		System.out.println("Inicio del programa");
		
		
		
		 final String URL="jdbc:mysql://localhost:3306/cursoJava40544?";
		 final String USER="root";
		 final String CLAVE="";
		 
		 
		 Connection conexion=null;
		 
		 //Abrimos la conexion
		 	try {
				conexion= DriverManager.getConnection(URL, USER,CLAVE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	
		 //-------------------------------------------------
		 	
		 	Documentos[] tipos= Documentos.values();
		 	
		 	Documentos filtroTipo = (Documentos) JOptionPane.showInputDialog(null, "Selecione una opcion", "Filtro documento", JOptionPane.OK_OPTION, null, tipos, 0);//0 corresponde a la posicion del ENUM

		 	String filtroDocumento= JOptionPane.showInputDialog("Indique el registro a buscar");
		//UTIIZAMOS la mejora de statement PreparedStatement => var.preparesTatement(query)
		 	String query="SELECT * FROM ALUMNOS WHERE TipoDoc = ?  AND Documento = ?  ";
		 	try {
				PreparedStatement pst= conexion.prepareStatement(query);
				
				pst.setString(1, filtroTipo.toString());
				pst.setString(2, filtroDocumento);
				
				ResultSet rs= pst.executeQuery();
				
				
				
				while(rs.next()) {
					
					String tipoDoc= rs.getString("TipoDoc");
					String documento= rs.getString("Documento");
					String razonSocial= rs.getString("RazonSocial");
					int activo= rs.getInt("Activo");
					
					System.out.println("Los valores son " + tipoDoc +documento+razonSocial+activo );
					
					
					
				}
				
				
				//-------------------Realizamos otra consulta con el mismo PST
				
				pst.setString(1, filtroTipo.toString());
				pst.setString(2, "segundaconsulta");
				
				 rs= pst.executeQuery();
				
				
				
				while(rs.next()) {
					
					String tipoDoc= rs.getString("TipoDoc");
					String documento= rs.getString("Documento");
					String razonSocial= rs.getString("RazonSocial");
					int activo= rs.getInt("Activo");
					
					System.out.println("Los valores son " + tipoDoc +documento+razonSocial+activo );
					
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		 	
		 	
		 	//------------------------------------------
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	
	}
}
