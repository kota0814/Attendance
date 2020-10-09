package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DailyRecordDao;
import dao.DaoFactory;
import domain.DailyRecord;

/**
 * Servlet implementation class DailyRecord
 */
@WebServlet("/Record")
public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			DailyRecordDao dailyRecordDao = DaoFactory.createDailyRecordDao();
			List<DailyRecord> dailyRecordList = dailyRecordDao.findAll();
			request.setAttribute("dailyRecordList", dailyRecordList);
			request.getRequestDispatcher("/WEB-INF/view/RecordList.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//String name = request.getParameter("name");

		//try {

		//	DailyRecordDao dailyRecordDao = DaoFactory.createDailyRecordDao();
		//	List<DailyRecord>dailyRecordList = dailyRecordDao.findByName(name);
		//	request.setAttribute("dailyRecordList", dailyRecordList);
		//	request.getRequestDispatcher("/WEB-INF/view/employeeRecord.jsp").forward(request, response);
		//	} catch (Exception e) {
		//		throw new ServletException(e);
		//}

		Date date = Date.valueOf(request.getParameter("date"));

		try {

			DailyRecordDao dailyRecordDao = DaoFactory.createDailyRecordDao();
			List<DailyRecord> dailyRecordList = dailyRecordDao.findByDate(date);
			request.setAttribute("dailyRecordList", dailyRecordList);
			request.getRequestDispatcher("/WEB-INF/view/dailyRecord.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
