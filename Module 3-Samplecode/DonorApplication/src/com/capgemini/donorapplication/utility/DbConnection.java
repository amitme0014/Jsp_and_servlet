package com.capgemini.donorapplication.utility;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.capgemini.donorapplication.exception.DonorTransactionException;




/**
 * Author 		: CAPGEMINI 
 * Class Name 	: DbConnection
 * Package 		: com.capgemini.donorapplication.utility
 * Date 		: Nov 21, 2016
 */

public class DbConnection {
	public static Connection getConnection() throws DonorTransactionException {
		Connection conn = null;

		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/jdbc/DS");
			conn = ds.getConnection();
		}

		catch (SQLException e) {
			throw new DonorTransactionException("SQL Error:"+e.getMessage());
		} catch (NamingException e) {
			throw new DonorTransactionException("message from DB/NamingExc:"
					+ e.getMessage());
		}
		return conn;
	}
}
