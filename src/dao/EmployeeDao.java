package dao;

import java.util.List;

import domain.Employee;

public interface EmployeeDao {

	List<Employee> findAll() throws Exception;

	Employee findById(Integer id) throws Exception;

	void insert(Employee employee) throws Exception;

	void update(Employee employee) throws Exception;

	void delete(Employee employee) throws Exception;

}
