package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "hr");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public List<Employee> getAllEmployee() throws Exception {
		List<Employee> list = new ArrayList<Employee>();
		Connection con = EmpDao.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from Employee");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Employee emp = new Employee();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setDes(rs.getString(3));
			emp.setSalary(rs.getInt(4));
			list.add(emp);
		}
		return list;
	}

	public List<Employee> getById(int id) {
		List<Employee> list = new ArrayList<Employee>();
		;
		try {
			Connection con = EmpDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from Employee where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setDes(rs.getString(3));
				emp.setSalary(rs.getInt(4));
				list.add(emp);
			}
		} catch (Exception e) {

		}
		return list;
	}

	public int getMaxId() {
		int id = 1;
		Connection con = EmpDao.getConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT Max(id) FROM Employee");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}

	public int addEmpData(Employee emp) {
		int res=0;
		 String sql="insert into Employee(id,name,des,salary) values("+emp.getId()+",'"+emp.getName()+"','"+emp.getDes()+"',"+emp.getSalary()+")"; 
		Connection con = EmpDao.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			 res = ps.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
