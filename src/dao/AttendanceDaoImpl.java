package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Attendance;

public class AttendanceDaoImpl implements AttendanceDao {

	private DataSource ds;

	public AttendanceDaoImpl(DataSource ds) {
		this.ds =ds;
	}

	@Override
	public List<Attendance> findAll() throws Exception {
		List<Attendance>attendanceList = new ArrayList<>();
		try(Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM attendance";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				attendanceList.add(mapToAttendance(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return attendanceList;
	}

	@Override
	public Attendance findById(Integer employeeId) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert1(Attendance attendance) throws Exception {
		try (Connection con = ds.getConnection()){

			//出勤処理
			String sql = "INSERT INTO attendance (employee_id,started_work,date) VALUE(?,NOW(),NOW())";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,attendance.getEmployeeId());
				stmt.executeUpdate();
		}catch (Exception e) {
			}
		}


		@Override
		public void insert2(Attendance attendance) throws Exception {
			try (Connection con = ds.getConnection()){

			//退勤処理
				String sql2 = "INSERT INTO attendance (employee_id,ended_work,date) VALUE(?,NOW(),NOW())";
				PreparedStatement stmt2 = con.prepareStatement(sql2);
				stmt2.setString(1,attendance.getEmployeeId());
				stmt2.executeUpdate();
			}catch (Exception e) {
			}
			}

			@Override
			public void insert3(Attendance attendance) throws Exception {
				try (Connection con = ds.getConnection()){

			//休憩開始処理
				String sql3 = "INSERT INTO attendance (employee_id,started_break,date) VALUE(?,NOW(),NOW())";
				PreparedStatement stmt3 = con.prepareStatement(sql3);
				stmt3.setString(1,attendance.getEmployeeId());
				stmt3.executeUpdate();
				}catch (Exception e) {
				}
				}

			@Override
			public void insert4(Attendance attendance) throws Exception {
				try (Connection con = ds.getConnection()){

			//休憩終了処理
				String sql4 = "INSERT INTO attendance (employee_id,ended_break,date) VALUE(?,NOW(),NOW())";
				PreparedStatement stmt4 = con.prepareStatement(sql4);
				stmt4.setString(1,attendance.getEmployeeId());
				stmt4.executeUpdate();

				}catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void update(Attendance attendance) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Attendance attendance) throws Exception {
		int id = attendance.getId();
		try(Connection con = ds.getConnection()) {
			String sql = "delete from attendance where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	private Attendance mapToAttendance(ResultSet rs) throws Exception {
		Attendance attendance = new Attendance();
		attendance.setId((Integer) rs.getObject("id"));
		attendance.setEmployeeId(rs.getString("employee_id"));
		attendance.setStartedWork(rs.getDate("started_work"));
		attendance.setEndedWork(rs.getDate("ended_work"));
		attendance.setStartedBreak(rs.getDate("started_break"));
		attendance.setEndedBreak(rs.getDate("ended_break"));
		attendance.setDate(rs.getDate("date"));
		return attendance;

	}



	}




