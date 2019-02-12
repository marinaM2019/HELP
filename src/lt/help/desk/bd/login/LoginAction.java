package lt.help.desk.bd.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lt.help.desk.bd.mySql.connection.LoginUserFromMySql;

//import mySql.connection.LoginUserFromMySql2;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	String name = "";
	String surname = "";
	String skyrius = "";
	String pareigos = "";

	LoginUserFromMySql loginUserFromMySql = new LoginUserFromMySql();
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		// LoginData loginData = new LoginData();
		String loginName = request.getParameter("loginName").toLowerCase().trim();
		String loginPassword = request.getParameter("loginPassword");

		try {
			if (loginUserFromMySql.getSuperAdminLogin(loginName, loginPassword)) {
				try {
					response.sendRedirect("Administravimas.jsp");
					session.setAttribute("loginName", loginName);
					session.setAttribute("name", "super administratorius");
					session.setAttribute("surname", "");
					session.setAttribute("skyrius", "");
					session.setAttribute("pareigos", "");
				} catch (Exception e) {
					session.setAttribute("surname", "");
					session.setAttribute("skyrius", "");
					session.setAttribute("pareigos", "");
				}
				return;
			} else
				try {
					if (loginUserFromMySql.getBossConnection(loginName, loginPassword)) {
						response.sendRedirect("Boss.jsp");
					} else
						try {
							if (loginUserFromMySql.getLocalAdminConnection(loginName, loginPassword)) {
								response.sendRedirect("LocalAdmin.jsp");
							} else
								try {
									if (loginUserFromMySql.getUserConnection(loginName, loginPassword)) {
										response.sendRedirect("Home.jsp");
									} else {
										response.sendRedirect("BadLogin.jsp");
										return;
									}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		session.setAttribute("loginName", loginName);
		session.setAttribute("name", name);
		session.setAttribute("surname", surname);
		session.setAttribute("skyrius", skyrius);
		session.setAttribute("pareigos", pareigos);

	}

}
