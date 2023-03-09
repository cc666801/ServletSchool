package com.lcpan.m10;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcpan.bean.EmpBean;

@WebServlet("/GetAllEmp")
public class GetAllEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String sql = "select * from [employee]";
		ArrayList<EmpBean> emps = new ArrayList<>();
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=jdbc;encrypt=false"
					, "Eason1", "1234" );
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			// 移動到cursor1
			while(rs.next()) {
			// Put cursor1 data to new a EmpBean
				EmpBean emp = new EmpBean();
				emp.setEmpno(rs.getString("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSalary(rs.getString("salary"));
				emp.setDeptno(rs.getString("deptno"));
				emp.setTitle(rs.getString("title"));
				emps.add(emp);
			};
			System.out.println(emps.get(1).getEmpno());
			request.setAttribute("emps", emps);
			statement.close();
			request.getRequestDispatcher("/m10/GetAllEmp.jsp")
			.forward(request, response);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
