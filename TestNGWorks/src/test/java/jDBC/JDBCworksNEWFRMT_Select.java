package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCworksNEWFRMT_Select {

	public static boolean compareResultSets(ResultSet resultSet1, ResultSet resultSet2) throws SQLException{
		while (resultSet1.next()) {
			resultSet2.next();
			ResultSetMetaData resultSetMetaData = resultSet1.getMetaData();
			int count = resultSetMetaData.getColumnCount();
			for (int i = 1; i <= count; i++) {
				if (!resultSet1.getObject(i).equals(resultSet2.getObject(i))) {
					return false;
				}
			}
		}
		System.out.println("It's TRUEEE!!!");
		return true;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		try {
			//Load the Oracle JDBC driver
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			//Establish a connection to DB
			System.out.println("Opening the connnection...");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Oracle@123!");

			//Prepare Statement
			String sql1 = "Select * from tabThree";
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			
			//execute query
			ResultSet rs = pstmt.executeQuery();

			for(int i=1;i<=2;i++) {

				System.out.print(rs.getMetaData().getColumnName(i)+" ");
				System.out.println(rs.getMetaData().getColumnType(i));
			}

			/*if(compareResultSets(rs1, rs2)){
				System.out.println("The tables are equal");
			}else {
				System.out.println("The tables are NOT equal");
			}*/

			//Close the DB connection
			System.out.println("Closing the connnection...");
			pstmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
