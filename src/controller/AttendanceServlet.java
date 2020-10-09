package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AttendanceDao;
import dao.DaoFactory;
import domain.Attendance;

/**
 * Servlet implementation class Attendance
 */
@WebServlet("/attendance")
public class AttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			AttendanceDao attendanceDao = DaoFactory.createAttendanceDao();
			List<Attendance> attendanceList = attendanceDao.findAll();
			request.setAttribute("attendanceList", attendanceList);
			request.getRequestDispatcher("/WEB-INF/view/attendance.jsp").forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @param con
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//パラメータの取得
		//従業員IDの取得とバリデーション

		String employeeId = request.getParameter("employee_id");

		// ボタンの種別による分岐

		String startedWork = request.getParameter("started_work");
		String endedWork = request.getParameter("ended_work");
		String startedBreak = request.getParameter("started_break");
		String endedBreak = request.getParameter("ended_break");

		//データの追加
		Attendance attendance = new Attendance();
		attendance.setEmployeeId(employeeId);

		if (startedWork != null) {
			try {
				AttendanceDao attendanceDao = DaoFactory.createAttendanceDao();
				attendanceDao.insert1(attendance);
				request.getRequestDispatcher("/WEB-INF/view/attendanceDone.jsp").forward(request, response);

			} catch (Exception e) {
				throw new ServletException(e);
			}

		}

		if (endedWork != null) {
			try {
				AttendanceDao attendanceDao = DaoFactory.createAttendanceDao();
				attendanceDao.insert2(attendance);
				request.getRequestDispatcher("/WEB-INF/view/attendanceDone.jsp").forward(request, response);

			} catch (Exception e) {
				throw new ServletException(e);
			}

		}

		if (startedBreak != null) {
			try {
				AttendanceDao attendanceDao = DaoFactory.createAttendanceDao();
				attendanceDao.insert3(attendance);
				request.getRequestDispatcher("/WEB-INF/view/attendanceDone.jsp").forward(request, response);

			} catch (Exception e) {
				throw new ServletException(e);
			}

		}

		if (endedBreak != null) {
			try {
				AttendanceDao attendanceDao = DaoFactory.createAttendanceDao();
				attendanceDao.insert4(attendance);
				request.getRequestDispatcher("/WEB-INF/view/attendanceDone.jsp").forward(request, response);

			} catch (Exception e) {
				throw new ServletException(e);
			}

		}
	}

}
