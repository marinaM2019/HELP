package lt.help.desk.bd.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.PreparedStatement;

import lt.help.desk.bd.login.JDBCConnection;

@WebServlet("/ManoGedimai")
public class ManoGedimai extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/pdf");
		OutputStream out = response.getOutputStream();
		HttpSession session = request.getSession(true);
		String loginName = (String) session.getAttribute("loginName");

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
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}

		document.open();

		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100.0F);

		// table.setWidths(new float[] { 2.0F, 1.0F, 2.0F, 1.0F, 2.0F, 2.0F });

		table.addCell(new Phrase("Pateikimo data", cellFont));
		table.addCell(new Phrase("Tema", cellFont));
		table.addCell(new Phrase("Aprašymas", cellFont));
		table.addCell(new Phrase("Statusas", cellFont));
		table.addCell(new Phrase("Vykdytojas", cellFont));
		table.addCell(new Phrase("Vykdytojo įrašo keitimo data", cellFont));

		Paragraph paragraph = new Paragraph();
		Paragraph paragraph2 = new Paragraph();

		paragraph.setAlignment(Element.ALIGN_CENTER);

		paragraph.add(new Phrase("MANO REGISTRUOTŲ GEDIMŲ SĄRAŠAS".toUpperCase(), fontBold));
		paragraph2.add(new Phrase(" "));

		try {
			Connection connectionPr = (Connection) JDBCConnection.getConnection();
			String sqlPr = "SELECT iraso_data, tema, aprasymas, statusas, vykdytojas, vykdytojo_iraso_data FROM gedimai WHERE gedima_pateike='"
					+ loginName + "' ORDER BY iraso_data DESC";
			PreparedStatement pst = (PreparedStatement) connectionPr.prepareStatement(sqlPr);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String data = rs.getString("iraso_data");
				String tema = rs.getString("tema");
				String aprasymas = rs.getString("aprasymas");
				String statusas = rs.getString("statusas");
				String vykdytojas = rs.getString("vykdytojas");
				String vykdytojoIrasoData = rs.getString("vykdytojo_iraso_data");

				table.addCell(new Paragraph(data, cellFont));
				table.addCell(new Paragraph(tema, cellFont));
				table.addCell(new Paragraph(aprasymas, cellFont));
				if (statusas.equals("atmesta")) {
					table.addCell(new Paragraph(statusas, cellFontColorRed));
				} else if (statusas.equals("ivykdyta")) {
					table.addCell(new Paragraph(statusas, cellFontColorGreen));
				} else {
					table.addCell(new Paragraph(statusas, cellFont));
				}
				table.addCell(new Paragraph(vykdytojas, cellFont));
				table.addCell(new Paragraph(vykdytojoIrasoData, cellFont));

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		try {
			document.add(paragraph);
			document.add(paragraph2);
			document.add(table);
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}

		document.close();

	}

}
