package com.lcpan.m11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.lcpan.bean.EmpBean;

@WebServlet("/InsertJNDI")
public class InsertJNDI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context
					.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();
			String sql = "insert into [employee] (empno, ename, hiredate, salary, deptno, title) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("empno"));
			pstmt.setString(2, request.getParameter("ename"));
			pstmt.setString(3, request.getParameter("hiredate"));
			pstmt.setString(4, request.getParameter("salary"));
			pstmt.setString(5, request.getParameter("deptno"));
			pstmt.setString(6, request.getParameter("title"));
			
			EmpBean emp = new EmpBean();
			emp.setEmpno(request.getParameter("empno"));
			emp.setEname(request.getParameter("ename"));
			emp.setHiredate(request.getParameter("hiredate"));
			emp.setSalary( request.getParameter("salary"));
			emp.setDeptno(request.getParameter("deptno"));
			emp.setTitle(request.getParameter("title"));
			request.setAttribute("emp", emp);
			
			int updateCount = pstmt.executeUpdate();
			request.setAttribute("updateCount", updateCount);
			
			pstmt.close();
			request.getRequestDispatcher("/m11/InsertJNDI.jsp")
				.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
