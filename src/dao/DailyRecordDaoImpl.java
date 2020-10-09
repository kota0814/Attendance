package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.DailyRecord;

public class DailyRecordDaoImpl implements DailyRecordDao {

	private DataSource ds;

	public DailyRecordDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<DailyRecord> findAll() throws Exception {
		List<DailyRecord> dailyRecordList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			//String sql = "SELECT attendance.id as id,attendance.employee_id,employee.name,date,GROUP_CONCAT(attendance.started_work) AS started_work,GROUP_CONCAT(attendance.started_break) AS started_break,GROUP_CONCAT(attendance.ended_break) AS ended_break,GROUP_CONCAT(attendance.ended_work) AS ended_work FROM employee JOIN attendance ON employee.id = attendance.employee_id GROUP BY date";
			String sql = "SELECT attendance.id as id,date,started_work,ended_work,started_break,ended_break,employee.id as employee_id,employee.name AS name FROM employee JOIN attendance ON attendance.employee_id = employee.id ORDER BY date DESC";

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				dailyRecordList.add(mapToDailyRecord(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return dailyRecordList;
	}

	@Override
	public DailyRecord findById(Integer id) throws Exception {
		DailyRecord dailyRecord = null;
		try (Connection con = ds.getConnection()) {
			String sql = "select * from attendance where id =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				dailyRecord = mapToDailyRecord(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return dailyRecord;
	}

	@Override
	public void insert(DailyRecord dailyRecord) throws Exception {

	}

	@Override
	public void update(DailyRecord dailyRecord) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(DailyRecord dailyRecord) throws Exception {
		System.out.println("innerDoa:" + (dailyRecord));
		int id = dailyRecord.getId();
		System.out.println("innnerDao:" + id);
		try (Connection con = ds.getConnection()) {
			String sql = "delete from attendance where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public List<DailyRecord> findByName(String name) throws Exception {
		List<DailyRecord> dailyRecordList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = "SELECT attendance.id as id,attendance.employee_id,employee.name,date,GROUP_CONCAT(attendance.started_work) AS started_work,GROUP_CONCAT(attendance.started_break) AS started_break,GROUP_CONCAT(attendance.ended_break) AS ended_break,GROUP_CONCAT(attendance.ended_work) AS ended_work FROM employee JOIN attendance ON employee.id = attendance.employee_id WHERE name = ?  GROUP BY date";
			//String sql = "SELECT attendance.id as id,employee.id as employee_id,employee.name as name,date,@started_w :=attendance.started_work AS started_work,@started_b :=(SELECT t2.started_break FROM attendance t2 WHERE t2.started_break >attendance.started_work ORDER BY date LIMIT 1) AS started_break,@ended_b:= (SELECT t3.ended_break FROM attendance t3 WHERE t3.ended_break >attendance.started_work ORDER BY date LIMIT 1) AS ended_break,@ended_w:= (SELECT t4.ended_work FROM attendance t4 WHERE t4.ended_work >attendance.started_work ORDER BY date LIMIT 1) AS ended_work,timediff(@ended_w,@started_w) AS total_work,timediff(@ended_b,@started_b) AS total_break FROM employee JOIN attendance ON employee.id = attendance.employee_id WHERE name = ? GROUP BY date";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				dailyRecordList.add(mapToDailyRecord(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return dailyRecordList;

	}

	@Override
	public List<DailyRecord> findByDate(Date date) throws Exception {
		List<DailyRecord> dailyRecordList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = "SELECT attendance.id as id,attendance.employee_id,employee.name,date,GROUP_CONCAT(attendance.started_work) AS started_work,GROUP_CONCAT(attendance.started_break) AS started_break,GROUP_CONCAT(attendance.ended_break) AS ended_break,GROUP_CONCAT(attendance.ended_work) AS ended_work FROM employee JOIN attendance ON employee.id = attendance.employee_id WHERE date = ? GROUP BY name";
			//String sql = "SELECT attendance.id as id,date,started_work,ended_work,started_break,ended_break,employee.id as employee_id,employee.name AS name FROM employee JOIN attendance ON attendance.employee_id = employee.id WHERE date=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDate(1, date);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				dailyRecordList.add(mapToDailyRecord(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return dailyRecordList;
	}

	@Override
	public List<DailyRecord> findByMonth(String name, Date date1, Date date2) throws Exception {
		List<DailyRecord> dailyRecordList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT attendance.id as id,attendance.employee_id,employee.name,date,GROUP_CONCAT(attendance.started_work) AS started_work,GROUP_CONCAT(attendance.started_break) AS started_break,GROUP_CONCAT(attendance.ended_break) AS ended_break,GROUP_CONCAT(attendance.ended_work) AS ended_work FROM employee"
					+ " JOIN attendance ON employee.id = attendance.employee_id WHERE date BETWEEN ? AND ? AND name = ?  GROUP BY date";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDate(1, date1);
			stmt.setDate(2, date2);
			stmt.setString(3, name);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				dailyRecordList.add(mapToDailyRecord(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return dailyRecordList;
	}

	private DailyRecord mapToDailyRecord(ResultSet rs) throws Exception {
		DailyRecord dailyRecord = new DailyRecord();
		dailyRecord.setId((Integer) rs.getObject("id"));
		dailyRecord.setEmployeeId(rs.getString("employee_id"));
		dailyRecord.setName(rs.getString("name"));
		dailyRecord.setStartedWork(rs.getTimestamp("started_work"));
		dailyRecord.setEndedWork(rs.getTimestamp("ended_work"));
		dailyRecord.setStartedBreak(rs.getTimestamp("started_break"));
		dailyRecord.setEndedBreak(rs.getTimestamp("ended_break"));
		dailyRecord.setDate(rs.getDate("date"));

		if (dailyRecord.getStartedWork() == null) {
			dailyRecord.setStartedWork(rs.getDate("date"));
		}

		if (dailyRecord.getStartedBreak() == null) {
			dailyRecord.setStartedBreak(rs.getDate("date"));
		}
		if (dailyRecord.getEndedBreak() == null) {
			dailyRecord.setEndedBreak(rs.getDate("date"));
		}

		if (dailyRecord.getEndedWork() == null) {
			dailyRecord.setEndedWork(rs.getDate("date"));
		}

		System.out.println(dailyRecord.getStartedBreak());
		System.out.println(dailyRecord.getEndedBreak());

		dailyRecord.setTotalWork();

		System.out.println("実働時間：" + dailyRecord.getTotalWork());

		if (dailyRecord.getStartedWork() == null) {
			dailyRecord.setStartedWork(rs.getDate("date"));
		}

		if (dailyRecord.getStartedBreak() == null) {
			dailyRecord.setStartedBreak(rs.getDate("date"));
		}
		if (dailyRecord.getEndedBreak() == null) {
			dailyRecord.setEndedBreak(rs.getDate("date"));
		}

		if (dailyRecord.getEndedWork() == null) {
			dailyRecord.setEndedWork(rs.getDate("date"));
		}
		dailyRecord.setTotalBreak();

		return dailyRecord;

	}

}
