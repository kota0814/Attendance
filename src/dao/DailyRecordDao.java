package dao;

import java.sql.Date;
import java.util.List;

import domain.DailyRecord;

public interface DailyRecordDao {

	List<DailyRecord> findAll() throws Exception;

	DailyRecord findById(Integer id) throws Exception;

	List<DailyRecord> findByName(String name) throws Exception;

	List<DailyRecord> findByDate(Date date) throws Exception;

	List<DailyRecord> findByMonth(String name, Date date1, Date date2) throws Exception;

	void insert(DailyRecord dailyRecord) throws Exception;

	void update(DailyRecord dailyRecord) throws Exception;

	void delete(DailyRecord dailyRecord) throws Exception;

}
