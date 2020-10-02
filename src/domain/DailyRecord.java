package domain;

import java.util.Date;

public class DailyRecord {

	private Integer id;
	private Date date;
	private Date startedWork;
	private Date endedWork;
	private Date startedBreak;
	private Date endedBreak;
	private String employeeId;
	private String name;
	private String totalWork;
	private String totalBreak;
	private String allWork;



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
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getTotalWork() {

		long sw = startedWork.getTime();
		long sb = startedBreak.getTime();
		long eb = endedBreak.getTime();;
		long ew = endedWork.getTime();

		long tw = (ew-sw-(eb-sb))/1000/60/60;
		String totalWork = ""+tw;

		return totalWork;
	}
	public void setTotalWork() {


		long sw = startedWork.getTime();
		long sb = startedBreak.getTime();
		long eb = endedBreak.getTime();
		long ew = endedWork.getTime();

		long tw = (ew-sw-sb+eb)/1000/60/60;
		totalWork = ""+tw;

		this.totalWork = totalWork;
	}

	public String getTotalBreak() {

		//long sw = startedWork.getTime();
		long sb = startedBreak.getTime();
		long eb = endedBreak.getTime();;
		//long ew = endedWork.getTime();

		long tb = (eb-sb)/1000/60;
		String totalBreak = ""+tb;
		return totalBreak;
	}
	public void setTotalBreak() {
		//long sw = startedWork.getTime();
				long sb = startedBreak.getTime();
				long eb = endedBreak.getTime();;
				//long ew = endedWork.getTime();

				long tb = (eb-sb)/1000/60;
			    totalBreak = ""+tb;
		this.totalBreak = totalBreak;
	}

	public String getAllWork() {

	   

		return allWork;
	}
	public void setAllWork() {



		this.allWork = allWork;
	}
	@Override
	public String toString() {
		return "DailyRecord [id=" + id + ", date=" + date + ", startedWork=" + startedWork + ", endedWork=" + endedWork
				+ ", startedBreak=" + startedBreak + ", endedBreak=" + endedBreak + ", employeeId=" + employeeId
				+ ", name=" + name + "]";
	}

	// debug用


}
