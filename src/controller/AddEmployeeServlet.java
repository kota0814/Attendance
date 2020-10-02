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
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/addEmployee.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//エラーフラグ
		boolean isError = false;

		//名前の取得とバリデーション
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		if (name == null || name.isEmpty()) {
			request.setAttribute("nameError", "名前が未入力です。");
			isError = true;
		}
		// エラーが無ければデータの追加
		// エラーが有ればフォームの再表示
		if (!isError) {
			//データの追加
			Employee employee = new Employee();
			employee.setName(name);
			//System.out.println(employee);
			try {
				EmployeeDao employeeDao = DaoFactory.createEmployeeDao();
				employeeDao.insert(employee);
				request.getRequestDispatcher("/WEB-INF/view/addEmployeeDone.jsp").forward(request, response);
			} catch (Exception e) {
				throw new ServletException(e);
			}

		} else {
			//フォームの再表示
			request.getRequestDispatcher("/WEB-INF/view/addEmployee.jsp").forward(request, response);
		}

	}
}
