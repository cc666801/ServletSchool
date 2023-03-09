package com.lcpan.m10;

import java.sql.SQLException;

public class ConnFactoryTest {
	public static void main(String[] args) {
		ConnectionFactory conn = new ConnectionFactory();
		try {
			System.out.println(conn.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}