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
 * Servlet implementation class MonthlyEmployeeRecordServlet
 */
@WebServlet("/monthlyEmployeeRecord")
public class MonthlyEmployeeRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		Date date1 = Date.valueOf(request.getParameter("date1"));
		Date date2 = Date.valueOf(request.getParameter("date2"));

		try {

			DailyRecordDao dailyRecordDao = DaoFactory.createDailyRecordDao();
			List<DailyRecord>dailyRecordList = dailyRecordDao.findByMonth(name,date1,date2);

			int dlTotal = 0;

			for(DailyRecord dl:dailyRecordList) {
				dlTotal += Integer.parseInt(dl.getTotalWork());
			}



			request.setAttribute("dailyRecordList", dailyRecordList);
			request.getRequestDispatcher("/WEB-INF/view/employeeRecord.jsp").forward(request, response);
		} catch (Exception e) {
		throw new ServletException(e);
		}

	}

}
