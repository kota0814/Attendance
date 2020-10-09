package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.EmployeeDao;
import domain.Employee;

/**
 * Servlet implementation class ListEmployeeServlet
 */
@WebServlet("/listEmployee")
public class ListEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			EmployeeDao employeeDao = DaoFactory.createEmployeeDao();
			List<Employee> employeeList = employeeDao.findAll();
			request.setAttribute("employeeList", employeeList);
			request.getRequestDispatcher("/WEB-INF/view/listEmployee.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
