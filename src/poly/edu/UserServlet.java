package poly.edu;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		User user = null;
		String action = request.getParameter("action");
		try {
			if (action == null || action.equals("")) {

				request.setAttribute("LIST_USERS", dao.dumyData());
				RequestDispatcher rd = request.getRequestDispatcher("views/display-user.jsp");
				rd.forward(request, response);
				return;
			}

			switch (action) {
			case "AddOrEdit": {

				String username = request.getParameter("usename");
				user = dao.findByUsername(username);
				if (user == null) {
					user = new User();
				}
				RequestDispatcher rd = request.getRequestDispatcher("views/register.jsp");
				rd.forward(request, response);

				break;

			}
			case "SaveOrUpdate": {
				DateTimeConverter dtc = new DateConverter(new Date());

				dtc.setPattern("dd/MM/yyy");
				ConvertUtils.register(dtc, Date.class);
				user = new User();
				BeanUtils.populate(user, request.getParameterMap());
				
				dao.save(user);
				System.out.println("Insert successful");
				RequestDispatcher rd = request.getRequestDispatcher("views/register.jsp");
				rd.forward(request, response);

				break;
			}
			case "List" : {
				request.setAttribute("LIST_USERS", dao.getAll());
				RequestDispatcher rd = request.getRequestDispatcher("views/display-user.jsp");
				rd.forward(request, response);
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
