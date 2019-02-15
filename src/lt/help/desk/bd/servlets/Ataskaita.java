package lt.help.desk.bd.servlets;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;

import lt.help.desk.bd.gedimai.PatikrintiDuArgumentus;
import lt.help.desk.bd.most.important.GautiPDFAtaskaita;

@WebServlet("/servlets/Ataskaita")
public class Ataskaita extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PatikrintiDuArgumentus patikrintiDuArgumentus = new PatikrintiDuArgumentus();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/pdf");
		OutputStream out = response.getOutputStream();
		String dataNuo = request.getParameter("dataNuo");
		String dataIki = request.getParameter("dataIki");

		if (PatikrintiDuArgumentus.arVisiUzpildyti(dataNuo, dataIki)) {

			try {
				GautiPDFAtaskaita.lentelesPavidalu(dataNuo, dataIki, out);
			} catch (DocumentException e) {
				throw new RuntimeException(e);
			}

		}

	}
}
