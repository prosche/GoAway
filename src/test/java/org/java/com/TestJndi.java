package org.java.com;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.junit.Test;

public class TestJndi {

//	@Test
	public void testJNDI() throws NamingException, SQLException{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/GoAway");
		Connection conn = ds.getConnection();
		System.out.println(conn.isClosed());
	}
	
	@Test
	public void name() {
		try { 
			Context ctx = new InitialContext(); 
			Context envContext = (Context) ctx.lookup("java:/comp/env"); 
			DataSource ds = (DataSource) envContext.lookup("jdbc/GoAway"); 
			Connection conn = ds.getConnection(); 
			System.out.println(conn); 
			conn.close(); 
			} catch (NamingException e) { 
			e.printStackTrace(); 
			} catch (SQLException e) { 
			         e.printStackTrace(); 
			} 
	}
	
}
