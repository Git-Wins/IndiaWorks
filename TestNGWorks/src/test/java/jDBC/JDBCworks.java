package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCworks {

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
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Create connection to DB
			System.out.println("Opening the connnection...");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Oracle@123!");

			//Create Statement object
			Statement stmt = con.createStatement();

			//Execute the query & store it as a 'ResultSet'
			//ResultSet rs = stmt.executeQuery("create table tabFour (id number(3), name varchar2(20))");
			//ResultSet rs = stmt.executeQuery("Insert into tabFour values(333, 'Vij')");
			//ResultSet rs = stmt.executeQuery("select * from emp");
			ResultSet rs1 = stmt.executeQuery("select * from tabThree");
			while(rs1.next())   
				System.out.println(rs1.getInt(1)+"  "+rs1.getString(2));//+"  "+rs.getString(3));

			ResultSet rs2 = stmt.executeQuery("select * from tabFour");
			while(rs2.next())   
				System.out.println(rs2.getInt(1)+"  "+rs2.getString(2));
			System.out.println("///////////");

			
			/*if(compareResultSets(rs1, rs2)){
				System.out.println("The tables are equal");
			}else {
				System.out.println("The tables are NOT equal");
			}*/

			//Close the DB connection
			System.out.println("Closing the connnection...");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
