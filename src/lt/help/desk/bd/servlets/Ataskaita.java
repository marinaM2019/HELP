// package lt.help.desk.bd.servlets;
//
// import java.io.IOException;
// import java.io.OutputStream;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import javax.servlet.http.HttpSession;
// import com.itextpdf.text.Document;
// import com.itextpdf.text.Element;
// import com.itextpdf.text.Font;
// import com.itextpdf.text.Paragraph;
// import com.itextpdf.text.Phrase;
// import com.itextpdf.text.pdf.PdfWriter;
// import com.mysql.jdbc.PreparedStatement;
//
// import lt.help.desk.bd.gedimai.PatikrintiDuArgumentus;
// import lt.help.desk.bd.login.MySqlConnect;
//
// import java.sql.Connection;
// import java.sql.Date;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.text.DateFormat;
// import java.text.SimpleDateFormat;
//
// import com.itextpdf.text.DocumentException;
// import com.itextpdf.text.PageSize;
// import com.itextpdf.text.pdf.BaseFont;
// import com.itextpdf.text.pdf.PdfPTable;
//
// @WebServlet("/servlets/Ataskaita")
// public class Ataskaita extends HttpServlet {
// private static final long serialVersionUID = 1L;
//
// PatikrintiDuArgumentus patikrintiDuArgumentus = new PatikrintiDuArgumentus();
//
//
//
// protected void doPost(HttpServletRequest request, HttpServletResponse
// response)
// {
// response.setContentType("application/pdf");
// OutputStream out = response.getOutputStream();
// HttpSession session = request.getSession(true);
// String dataNuo = request.getParameter("dataNuo");
// String dataIki = request.getParameter("dataIki");
//
// DateFormat formatter;
// Date date;
// formatter = new SimpleDateFormat("dd-MMM-yy");
//
//
// BaseFont lt = null;
//
// lt = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1257,
// BaseFont.EMBEDDED);
//
// Font cellFont = new Font(lt, 12, Font.NORMAL);
//
// Font cellFontColorRed = new Font(lt, 12, Font.NORMAL);
// cellFontColorRed.setColor(255, 0, 0);
//
// Font cellFontColorGreen = new Font(lt, 12, Font.NORMAL);
// cellFontColorGreen.setColor(0, 119, 0);
//
// Font fontBold = new Font(lt, 12, Font.BOLD);
//
// Document document = new Document(PageSize.A4.rotate(), 60, 30, 30, 30);
//
// PdfWriter.getInstance(document, out);
//
//
//
//
// PdfPTable table = new PdfPTable(6);
// table.setWidthPercentage(100.0F);
//
// table.setWidths(new float[] { 2.0F, 1.0F, 2.0F, 1.0F, 2.0F, 2.0F });
//
//
// table.addCell(new Phrase("Pateikimo data", cellFont));
// table.addCell(new Phrase("Tema", cellFont));
// table.addCell(new Phrase("Aprašymas", cellFont));
// table.addCell(new Phrase("Statusas", cellFont));
// table.addCell(new Phrase("Vykdytojas", cellFont));
// table.addCell(new Phrase("Vykdytojo įrašo keitimo data", cellFont));
//
// Paragraph paragraph = new Paragraph();
// Paragraph paragraph2 = new Paragraph();
//
// paragraph.setAlignment(Element.ALIGN_CENTER);
//
// paragraph.add(new Phrase("GEDIMŲ SĄRAŠAS".toUpperCase(), fontBold));
// paragraph2.add(new Phrase(" "));
//
// Connection connectionPr;
// try {
// Connection connection = (Connection) getConnection();
// connectionPr = MySqlConnect.getConnection();
// if (patikrintiDuArgumentus.arPateikti(dataNuo, dataIki)) {
// document.open();
//
// String sqlPr = "select * from gedimai where (iraso_data BETWEEN '"+dataNuo+"'
// AND '"+dataIki+"')";
// PreparedStatement pst = (PreparedStatement)
// connectionPr.prepareStatement(sqlPr);
// ResultSet rs = pst.executeQuery();
// while (rs.next()) {
// String data = rs.getString("iraso_data");
// String tema = rs.getString("tema");
// String aprasymas = rs.getString("aprasymas");
// String statusas = rs.getString("statusas");
// String vykdytojas = rs.getString("vykdytojas");
// String vykdytojoIrasoData = rs.getString("vykdytojo_iraso_data");
//
// table.addCell(new Paragraph(data, cellFont));
// table.addCell(new Paragraph(tema, cellFont));
// table.addCell(new Paragraph(aprasymas, cellFont));
// if (statusas.equals("atmesta")) {
// table.addCell(new Paragraph(statusas, cellFontColorRed));
// } else if (statusas.equals("ivykdyta")) {
// table.addCell(new Paragraph(statusas, cellFontColorGreen));
// } else {
// table.addCell(new Paragraph(statusas, cellFont));
// }
// table.addCell(new Paragraph(vykdytojas, cellFont));
// table.addCell(new Paragraph(vykdytojoIrasoData, cellFont));
//
// }
// }
//
//
// } catch (SQLException e) {
// throw new RuntimeException(e);
// }
//
//
// document.add(paragraph);
// document.add(paragraph2);
// document.add(table);
//
//
// document.close();
//
// }
//
// }
