package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private DataSource ds;

	public EmployeeDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Employee> findAll() throws Exception {
		List<Employee> employeeList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "select * from employee";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				employeeList.add(mapToEmployee(rs));

			}
		} catch (Exception e) {
			throw e;
		}
		return employeeList;
	}

	@Override
	public Employee findById(Integer id) throws Exception {
		Employee employee = null;
		try (Connection con = ds.getConnection()) {
			String sql = "select * from employee where employee.id =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				employee = mapToEmployee(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return employee;
	}

	@Override
	public void insert(Employee employee) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "insert into employee (name) values(?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, employee.getName());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Employee employee) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE employee SET name=? WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, employee.getName());
			stmt.setInt(2, employee.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Employee employee) throws Exception {
		int id = employee.getId();
		try (Connection con = ds.getConnection()) {
			String sql = "delete from employee where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	private Employee mapToEmployee(ResultSet rs) throws Exception {
		Employee employee = new Employee();
		employee.setId((Integer) rs.getObject("id"));
		employee.setName(rs.getString("name"));
		return employee;
	}

}
