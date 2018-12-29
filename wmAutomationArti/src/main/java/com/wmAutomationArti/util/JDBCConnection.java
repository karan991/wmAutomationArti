package com.wmAutomationArti.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.jcraft.jsch.Session;

public class JDBCConnection extends SSHConnection {

	
	private static SSHConnection connection = new SSHConnection();
	private static Connection conn = null;
	private static Session session = null;
	private static Statement stmt = null;
	private static String databaseUser = "qa_testing";
	private static String databasePassword = "8Z9sCKDPP5";
	private static int localHostPort = 3366;
	private static String databaseUserMt4 = "qa";
	private static String databasePasswordMt4 = "PdWI6SLX";
	private static int localHostPortMt4 = 3306;
	private static String host = "sky9-slave-db-migrated-new-cluster.cluster-cz1rcbccvawq.ap-northeast-2.rds.amazonaws.com";
	


	public static Statement JDBCCreateStatementSSH() {

		try {

			session = connection.getTunnelledConnection(session);

			//Class.forName("com.mysql.jdbc.Driver");

			// now local host port is forwarded to mysql server
			conn = DriverManager.getConnection("jdbc:mysql://localhost:" + localHostPort, databaseUser,
					databasePassword);

			stmt = conn.createStatement();
			

		}

		catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		return stmt;
		/*finally {
			
			
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			if (session != null && session.isConnected()) {
				System.out.println("Closing SSH Connection by calling session.disconnect() in JDBCCreateStatement finally");
				session.disconnect();
			}
		
		}*/
	}
		
	

	/*public static ResultSet queryResult(String sql) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt("login"));
			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			if (session != null && session.isConnected()) {
				System.out.println("Closing SSH Connection");
				session.disconnect();
			}
		}
		return rs;
	}*/

	public static void closeJDBCConnection() {
		try {
			stmt.close();
			conn.close();

			if (session != null && session.isConnected()) {
				System.out.println("Closing SSH Connection");
				session.disconnect();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			if (session != null && session.isConnected()) {
				System.out.println("Closing SSH Connection");
				session.disconnect();
			}
		}
	}
	
	
	public static Statement JDBCCreateStatement() {

		try {

			
			// now local host port is forwarded to mysql server
			conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + localHostPortMt4, databaseUserMt4,
					databasePasswordMt4);

			stmt = conn.createStatement();
			

		}

		catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		return stmt;
		/*finally {
			
			
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			if (session != null && session.isConnected()) {
				System.out.println("Closing SSH Connection by calling session.disconnect() in JDBCCreateStatement finally");
				session.disconnect();
			}
		
		}*/
	}

}
