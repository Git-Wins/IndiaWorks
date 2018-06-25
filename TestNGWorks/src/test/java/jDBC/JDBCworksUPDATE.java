package jDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCworksUPDATE {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		try {
			//Load the Oracle JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Create connection to DB
			System.out.println("Opening the connnection...");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Oracle@123!");
			
			//preparedStatement

			//Create Statement object
			Statement stmt = con.createStatement();

			//ResultSet rs = stmt.executeQuery("create table tabFour (id number(3), name varchar2(20))");
			/*if(stmt.execute("create table ttt (id number(2), name varchar2(10))")) {
				System.out.println("Query executed :)");
			}else {
				System.out.println("Query failed :(");
			}*/

			/*// INSERTING VALUES
			stmt.executeUpdate("insert into ttt values(11, 'Hi')");
			stmt.executeUpdate("insert into ttt values(22, 'Hello')");*/

			//UPDATING VALUES
			stmt.executeUpdate("update ttt set name='Hey' where id=33");

			//Select & Display values
			ResultSet rs = stmt.executeQuery("Select * from ttt");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+ " " +rs.getString(2));
			}

			//Close the DB connection
			System.out.println("Closing the connnection...");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
