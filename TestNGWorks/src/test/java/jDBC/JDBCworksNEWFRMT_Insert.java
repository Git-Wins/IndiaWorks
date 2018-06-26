package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCworksNEWFRMT_Insert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		int ret_code;
		Connection conn = null;

		try {
			int[] i_id = {888, 999};
			String[] i_name = {"Pri", "Jef"};

			//Load the Oracle JDBC driver
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			//Establish a connection
			System.out.println("Opening the connnection...");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Oracle@123!");

			String sql1 = "select * from tabThree where id = ?";
			String sql2 = "Insert into tabThree values(?, ?)";
			
			PreparedStatement pStmt1 = conn.prepareStatement(sql1);
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);

			for(int i=0;i<2;i++) {
				pStmt1.setInt(1, i_id[i]);
				ResultSet rs = pStmt1.executeQuery();
				if(rs.next()) {
					System.out.println("The id: "+i_id[i]+" already exists!");
					rs.close();
				}
				else {
				pStmt2.setInt(1, i_id[i]);
				pStmt2.setString(2, i_name[i]);
				}
				pStmt1.close();
				pStmt2.close();
				conn.close();
			}

		} catch (SQLException e) {
			ret_code = e.getErrorCode(); 
			System.err.println(ret_code +" " +e.getMessage()); 
			conn.close();}
	}
}
