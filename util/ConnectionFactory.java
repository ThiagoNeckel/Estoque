package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionFactory {
	
	private static final String DRIVER ="org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/estoque";
    private static final String USER = "postgres";
    private static final String PASS = "postgres";
    
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            
             return DriverManager.getConnection(URL, USER, PASS);
            
                    } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexao", ex);
            
            
        } 
      
    }
    
    public static void closeConnection(Connection con) {
    	
    	if (con != null) {
    		
    		try {
    			con.close();	
    		}catch (SQLException ex) {
    			System.out.println("Erro con"+ ex);
    		}
    	}
    	closeConnection(con);
    }
    
 public static void closeConnection(Connection con, PreparedStatement stmt) {
    	
    	if (stmt != null) {
    		
    		try {
    			stmt.close();	
    		}catch (SQLException ex) {
    			System.out.println("Erro stmt"+ ex);
    		}
    	}
    	
    	closeConnection(con , stmt);
    }



public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
	
	if (rs != null) {
		
		try {
			rs.close();	
		}catch (SQLException ex) {
			System.out.println("Erro rs"+ ex);
		}
	}
	
	closeConnection(con , stmt, rs);
}


}

