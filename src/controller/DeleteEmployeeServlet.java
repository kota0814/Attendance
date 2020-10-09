package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.EmployeeDao;
import domain.Employee;

/**
 * Servlet implementation class DeleteEmployeeServlet
 */
@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String strId = request.getParameter("id");
			Employee employee = new Employee();
			employee.setId(Integer.parseInt(strId));
			EmployeeDao employeeDao = DaoFactory.createEmployeeDao();
			employeeDao.delete(employee);
			request.getRequestDispatcher("/WEB-INF/view/deleteEmployeeDone.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
