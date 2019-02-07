package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NaujoNaudotojoSukurimas;

@WebServlet("/SukurtiDBNaudotoja")
public class SukurtiDBNaudotoja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userLoginName = request.getParameter("userLoginName").toLowerCase().trim();
		String passw = request.getParameter("passw");
		String passwConf = request.getParameter("passwConf");
		String userName = request.getParameter("userName");
		String userSurname = request.getParameter("userSurname");
		String email = request.getParameter("email");
		String userSkyrius = request.getParameter("userSkyrius");
		String userPareigos = request.getParameter("userPareigos");
		String userVaidmuo = request.getParameter("userVaidmuo");
		
		if ((userLoginName.isEmpty() || userLoginName.length()>6) || 
				(passw.isEmpty() || passw.length()>10 && (!(passw.equals(passwConf)))) ||
				(userName.isEmpty() || userName.length()>110) ||
				(userSurname.isEmpty() || userSurname.length()>110) ||
				(email.isEmpty() || email.length()>240) ||
				(userSkyrius.equals("-1") || userPareigos.equals("-1") || userVaidmuo.equals("-1")))
		{
			System.out.println("KLAIDA: Nurodytos nevisos reik�m�s arba vir�ijamas leistinas simboli� skai�ius");
			return;
		} 
		
		
		NaujoNaudotojoSukurimas naujoNaudotojoSukurimas = new NaujoNaudotojoSukurimas();
		naujoNaudotojoSukurimas.sukurtiNaudotoja(userLoginName, passw, userName, userSurname, email, userSkyrius, userPareigos, userVaidmuo);
		response.sendRedirect("Administravimas.jsp");
	}

}
