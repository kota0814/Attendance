package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DailyRecordDao;
import dao.DaoFactory;
import domain.DailyRecord;

/**
 * Servlet implementation class DeleteAttendanceservlet
 */
@WebServlet("/deleteAttendance")
public class DeleteAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String strId = request.getParameter("id");
			System.out.println("innerServlet:" + strId);
			DailyRecord dailyRecord = new DailyRecord();
			dailyRecord.setId(Integer.parseInt(strId));
			System.out.println("innerServlet:" + dailyRecord);
			DailyRecordDao dailyRecordDao = DaoFactory.createDailyRecordDao();
			dailyRecordDao.delete(dailyRecord);
			request.getRequestDispatcher("/WEB-INF/view/deleteAttendanceDone.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	//	try {
	//		String strId = request.getParameter("id");
	//		Attendance attendance = new Attendance();
	//		attendance.setId(Integer.parseInt(strId));
	//		AttendanceDao attendanceDao = DaoFactory.createAttendanceDao();
	//		attendanceDao.delete(attendance);
	//		request.getRequestDispatcher("/WEB-INF/view/deleteAttendanceDone.jsp").forward(request, response);
	//	} catch (Exception e) {
	//		throw new ServletException(e);
	//	}
	//}
}
