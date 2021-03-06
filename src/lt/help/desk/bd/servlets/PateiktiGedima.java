package lt.help.desk.bd.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lt.help.desk.bd.gedimai.PatikrintiDuArgumentus;
import lt.help.desk.bd.service.Gedimai;

@WebServlet("/PateiktiGedima")
public class PateiktiGedima extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gedimai gedimai = new Gedimai();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session;
		session = request.getSession(true);
		String loginName = (String) session.getAttribute("loginName");

		String gedimoTema = request.getParameter("gedimoTema").replace("_", " ");
		String gedimoAprasymas = request.getParameter("gedimoAprasymas");

		if (PatikrintiDuArgumentus.arVisiUzpildyti(gedimoTema, gedimoAprasymas)) {

			gedimai.itraukti(gedimoTema, gedimoAprasymas, loginName);
			response.sendRedirect("Home.jsp");

		}
	}

}
