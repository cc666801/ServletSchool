package com.lcpan.m10;

import java.io.IOException;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lcpan.bean.EmpBean;

@WebServlet("/GetEmp")
public class GetEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String empno = request.getParameter("empno");
		String sql = "select * from [employee] where empno=?";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=jdbc;encrypt=false"
					, "Eason1", "1234" );
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empno);
			ResultSet rs = pstmt.executeQuery();
			EmpBean emp = new EmpBean();
			// 移動到cursor1
			if(rs.next()) {
			// Put cursor1 data to new a EmpBean
				emp.setEmpno(rs.getString("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSalary(rs.getString("salary"));
				emp.setDeptno(rs.getString("deptno"));
				emp.setTitle(rs.getString("title"));
			};
			System.out.println(emp.getEmpno());
			request.setAttribute("emp", emp);
			pstmt.close();
			request.getRequestDispatcher("/m10/GetEmp.jsp")
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
