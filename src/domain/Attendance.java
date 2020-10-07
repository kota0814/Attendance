package domain;

import java.sql.Date;

public class Attendance {

	private Integer id;
	private Date date;
	private Date startedWork;
	private Date endedWork;
	private Date startedBreak;
	private Date endedBreak;
	private Integer employeeId;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getStartedWork() {
		return startedWork;
	}
	public void setStartedWork(Date startedWork) {
		this.startedWork = startedWork;
	}
	public Date getEndedWork() {
		return endedWork;
	}
	public void setEndedWork(Date endedWork) {
		this.endedWork = endedWork;
	}
	public Date getStartedBreak() {
		return startedBreak;
	}
	public void setStartedBreak(Date startedBreak) {
		this.startedBreak = startedBreak;
	}
	public Date getEndedBreak() {
		return endedBreak;
	}

	public void setEndedBreak(Date endedBreak) {
		this.endedBreak = endedBreak;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

}

