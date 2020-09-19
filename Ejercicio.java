package com.curso.java.Clase09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.cj.exceptions.RSAException;

public class Ejercicio {
	
	
	enum Documentos{
		
		DNI,CI,PAS,LE
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  final String URL="jdbc:mysql://localhost:3306/cursoJava40544?";
	        final String USER="root";
	        	final String CLAVE="";
	        	
	        	
	        	
	        	//Dejamos la coneccion AFUERA
	        	//Campos de la DB TipoDoc,Documento,RazonSocial,activo
	        	Connection con=null;
	        	try {
					con= DriverManager.getConnection(URL, USER, CLAVE);
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	        	
	        	
	        	
	        	//String opcion= JOptionPane.showInputDialog("Indique el registroa  buscar");
	        	
	        	String [] tDocumento= {
	        			"DNI","PAS","CI","LE"
	        	};
	        	
	        	
	        	Documentos[] varDocumentos= Documentos.values();
	        	
	        	//Combo selecciones
	        	
	        	
	        	//String opcion =(String) JOptionPane.showInputDialog(null, "Selecione una opcion", "Filtro documento", JOptionPane.OK_OPTION, null, tDocumento, tDocumento[0]);
	        	
	        	//Documentos filtro = (Documentos) JOptionPane.showInputDialog(null, "Selecione una opcion", "Filtro documento", JOptionPane.OK_OPTION, null, tDocumento, 0);//0 corresponde a la posicion del ENUM

	        	String opcion =(String) JOptionPane.showInputDialog(null, "Selecione una opcion", "Filtro documento", JOptionPane.OK_OPTION, null, tDocumento, tDocumento[0]);

	        	
	        	try {
					Statement st= con.createStatement();
					
					String query= "SELECT TipoDoc,Documento,RazonSocial,Activo FROM alumnos WHERE TipoDoc = '"+opcion+"' ";
					ResultSet dr =	st.executeQuery(query);
					
					System.out.println(query);//Impirmimos solamente para verificar la query
					if (dr != null) {
						
						while(dr.next()) {
							String tipoDoc= dr.getString("TipoDoc");
							String documento= dr.getString("Documento");
							String razonSocial= dr.getString("RazonSocial");
							int activo= dr.getInt("Activo");
							
							System.out.println("Los valores son " + tipoDoc +documento+razonSocial+activo );
							
						}
						
					}
					
					
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	        	
	        	
	}

}
