package com.curso.java.Clase09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Start Program" );
        
        
        final String URL="jdbc:mysql://localhost:3306/cursoJava40544?";
        final String USER="root";
        final String CLAVE="";
        
        
        //Necesitamos un conector de la clase conexion //
        //Conexion al abase DE DATOS
        
        Connection conector=null;
        	//Manegador de conecciones
        	//
        try {
        	//Si usara JAVA 1.7
        	//En el caso que Java fuera un version mas baja
        	// Class.forName("com.mysql.jdbc.Driver");
        	
        	
			conector = DriverManager.getConnection(URL, USER, CLAVE);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //statement crea sentencias DIRECTAS con la base
        //Statement statement = conexion.createStatement();
        //String consulta="Consulta propia"
        //ResultSet var= statement.executeQuery(consulta); EJECUTA Y DEVUELVE un dato
        //------------------------------------------------------------------
        //Lo intanciamos con la conexion que QUERRAMOS
        try {
			
        	Statement st =  conector.createStatement();
			String consulta= "SELECT correo,clave FROM usuarios";
			
			ResultSet miObj=st.executeQuery(consulta);	//Nos retorna el Objeto de la TABLA
			
			if (miObj != null) {
				
				while(miObj.next()) {//Analizamos si tengo un elemento siguiente
					
					String correo= miObj.getString(1);
					String clave = miObj.getString("clave");
					
					System.out.println("Usuario: "+ correo +" Clave: " +clave );
				}
			}
				
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        
        //-----------------Repetimos el proceso para practicar
        
        
        //Inser
       /* try {
			Statement st= conector.createStatement();
			String query= "INSERT INTO usuarios (correo,clave) values ('user6','1234')";
			
			boolean accion=st.execute(query);	//Si se quiere RETORNA Un valor de ejecucion sin EL obojeto
			System.out.println(accion);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        //-----------------------actualizar registros
        
        try {
			Statement st = conector.createStatement();
			String query= "UPDATE usuarios SET clave='853' WHERE correo='user1'";
			st.execute(query);
			System.out.println("Ejecuto correctamente  ");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //--------------Delete
        
        
       
		try {
			 Statement st = conector.createStatement();
			 String query= "DELETE FROM usuarios WHERE correo = 'user4'";
		        st.execute(query);
		        System.out.println("Ejecucion correcta");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }
}
