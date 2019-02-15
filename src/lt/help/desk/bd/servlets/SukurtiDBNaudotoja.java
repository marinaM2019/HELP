package lt.help.desk.bd.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lt.help.desk.bd.most.important.PatikrintiNaujoUserDuomenys;
import lt.help.desk.bd.service.Naudotojai;

@WebServlet("/SukurtiDBNaudotoja")
public class SukurtiDBNaudotoja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userLoginName = request.getParameter("userLoginName").toLowerCase().trim();
		String passw = request.getParameter("passw");
		String passwConf = request.getParameter("passwConf");
		String userName = request.getParameter("userName");
		String userSurname = request.getParameter("userSurname");
		String email = request.getParameter("email");
		String userSkyrius = request.getParameter("userSkyrius");
		String userPareigos = request.getParameter("userPareigos");
		String userVaidmuo = request.getParameter("userVaidmuo");

		PatikrintiNaujoUserDuomenys atikrintiNaujoUserDuomenys = new PatikrintiNaujoUserDuomenys();

		if (atikrintiNaujoUserDuomenys.uzpildytiNeVisi(userLoginName, email, userPareigos, passw, passwConf,
				userSkyrius, userSurname, userName, userVaidmuo)) {
			throw new RuntimeException("nevisi duomenys užpildyti arba nesutampa slaptažodis");
		} else {
			Naudotojai naudotojai = new Naudotojai();

			naudotojai.sukurtiNauja(userLoginName, passw, userName, userSurname, email, userSkyrius, userPareigos,
					userVaidmuo);

			response.sendRedirect("Administravimas.jsp");
		}

	}

}
