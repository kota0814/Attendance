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
 * Servlet implementation class EditEmployeeServlet
 */
@WebServlet("/editEmployee")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String strId = request.getParameter("id");
			Integer id = Integer.parseInt(strId);
			EmployeeDao employeeDao = DaoFactory.createEmployeeDao();
			Employee employee = employeeDao.findById(id);
			request.setAttribute("name", employee.getName());
			request.getRequestDispatcher("/WEB-INF/view/editEmployee.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//エラーフラグ
		boolean isError = false;
		//パラメータの取得
		//名前の取得とバリデーション
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		if (name == null || name.isEmpty()) {
			request.setAttribute("nameError", "名前が未入力です。");
			isError = true;
		}
		// エラーが無ければデータの更新
		// エラーが有ればフォームの再表示
		if (!isError) {
			//データの更新
			try {
				Integer id = Integer.parseInt(request.getParameter("id"));
				EmployeeDao employeeDao = DaoFactory.createEmployeeDao();
				Employee employee = employeeDao.findById(id);
				employee.setName(name);
				employeeDao.update(employee);
				request.getRequestDispatcher("/WEB-INF/view/editEmployeeDone.jsp").forward(request, response);

			} catch (Exception e) {
				throw new ServletException(e);
			}
		} else {
			//フォームの再表示
			request.getRequestDispatcher("/WEB-INF/view/editEmployee.jsp").forward(request, response);

		}
	}

}
