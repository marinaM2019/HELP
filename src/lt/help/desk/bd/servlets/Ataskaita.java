package lt.help.desk.bd.servlets;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.PreparedStatement;

import lt.help.desk.bd.gedimai.PatikrintiDuArgumentus;
import lt.help.desk.bd.mySql.connection.MySqlConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;

@WebServlet("/servlets/Ataskaita")
public class Ataskaita extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/pdf");
		OutputStream out = response.getOutputStream();
		HttpSession session = request.getSession(true);
		
		String dataNuo = request.getAttribute("dataNuo").toString();
		String dataIki = request.getAttribute("dataIki").toString();
		
		BaseFont lt = null;
		try {
			lt = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1257, BaseFont.EMBEDDED);
		} catch (DocumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Font cellFont = new Font(lt, 12, Font.NORMAL);

		Font cellFontColorRed = new Font(lt, 12, Font.NORMAL);
		cellFontColorRed.setColor(255, 0, 0);

		Font cellFontColorGreen = new Font(lt, 12, Font.NORMAL);
		cellFontColorGreen.setColor(0, 119, 0);

		Font fontBold = new Font(lt, 12, Font.BOLD);

		Document document = new Document(PageSize.A4.rotate(), 60, 30, 30, 30);
		try {
			PdfWriter.getInstance(document, out);
		} catch (DocumentException e2) {
			throw new RuntimeException();
		}

		document.open();

		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100.0F);
		try {
			table.setWidths(new float[] { 2.0F, 1.0F, 2.0F, 1.0F, 2.0F, 2.0F });
		} catch (DocumentException e2) {
			throw new RuntimeException();
		}

		table.addCell(new Phrase("Pateikimo data", cellFont));
		table.addCell(new Phrase("Tema", cellFont));
		table.addCell(new Phrase("Aprašymas", cellFont));
		table.addCell(new Phrase("Statusas", cellFont));
		table.addCell(new Phrase("Vykdytojas", cellFont));
		table.addCell(new Phrase("Vykdytojo įrašo keitimo data", cellFont));

		Paragraph paragraph = new Paragraph();
		Paragraph paragraph2 = new Paragraph();

		paragraph.setAlignment(Element.ALIGN_CENTER);

		paragraph.add(new Phrase("GEDIMŲ SĄRAŠAS".toUpperCase(), fontBold));
		paragraph2.add(new Phrase(" "));

		
		PatikrintiDuArgumentus patikrintiArgumentus = new PatikrintiDuArgumentus();
		if (patikrintiArgumentus.arPateikti(dataNuo, dataIki)) {

		}
	}

}
