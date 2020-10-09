package dao;

import java.util.List;

import domain.Attendance;

public interface AttendanceDao {

	List<Attendance> findAll() throws Exception;

	Attendance findById(Integer id) throws Exception;

	void insert1(Attendance attendance) throws Exception;

	void insert2(Attendance attendance) throws Exception;

	void insert3(Attendance attendance) throws Exception;

	void insert4(Attendance attendance) throws Exception;

	void update(Attendance attendance) throws Exception;

	void delete(Attendance attendance) throws Exception;

}
