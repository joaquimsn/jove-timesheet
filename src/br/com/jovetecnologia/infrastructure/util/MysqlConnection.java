package br.com.jovetecnologia.infrastructure.util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MysqlConnection {
	private Connection conn;

	public MysqlConnection() {

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:jboss/datasources/joveEnderecoDS");

			conn = dataSource.getConnection();
		} catch (Exception e) {
			System.out.println("erro:\n");
			e.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			conn.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the conn
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * @param conn the conn to set
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
