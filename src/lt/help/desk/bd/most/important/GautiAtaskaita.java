package lt.help.desk.bd.most.important;

import java.io.IOException;

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

import lt.help.desk.bd.gedimai.PatikrintiDuArgumentus;
import lt.help.desk.bd.service.Gedimai;

public class GautiAtaskaita {
	
	public static void lentelesPavidalu (String dataNuo, String dataIki, java.io.OutputStream out) throws DocumentException, IOException {
	Document document = new Document(PageSize.A4.rotate(), 60, 30, 30, 30);

	try {
		PdfWriter.getInstance(document, out);
	} catch (DocumentException e) {
		new RuntimeException(e);
	}

	PdfPTable table = new PdfPTable(6);
	table.setWidthPercentage(100.0F);

	try {
		table.setWidths(new float[] { 2.0F, 1.0F, 2.0F, 1.0F, 2.0F, 2.0F });
	} catch (DocumentException e) {
		new RuntimeException(e);
	}
	

		BaseFont lt = null;
		lt = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1257, BaseFont.EMBEDDED);

	
	Font cellFont = new Font(lt, 12, Font.NORMAL);

	Font cellFontColorRed = new Font(lt, 12, Font.NORMAL);
	cellFontColorRed.setColor(255, 0, 0);

	Font cellFontColorGreen = new Font(lt, 12, Font.NORMAL);
	cellFontColorGreen.setColor(0, 119, 0);

	Font fontBold = new Font(lt, 12, Font.BOLD);

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

	
	if (PatikrintiDuArgumentus.arVisiUzpildyti(dataNuo, dataIki)) {
		Gedimai gedimai = new Gedimai();
		document.open();
		for (int i = 0; i < gedimai.gautiNepaskirtusPagalLaikotarpi(dataNuo, dataIki).size(); i++) {
			table.addCell(new Paragraph(gedimai.gautiNepaskirtusPagalLaikotarpi(dataNuo, dataIki).get(i).getData(),
					cellFont));
			table.addCell(new Paragraph(gedimai.gautiNepaskirtusPagalLaikotarpi(dataNuo, dataIki).get(i).getTema(),
					cellFont));
			table.addCell(new Paragraph(gedimai.gautiNepaskirtusPagalLaikotarpi(dataNuo, dataIki).get(i).getAprasymas(),
					cellFont));
			table.addCell(new Paragraph(
					gedimai.gautiNepaskirtusPagalLaikotarpi(dataNuo, dataIki).get(i).getGedimaPateike(), cellFont));
			
			if (gedimai.gautiNepaskirtusPagalLaikotarpi(dataNuo, dataIki).get(i).getStatusas().equals("atmesta")) {
				table.addCell(new Paragraph(
						gedimai.gautiNepaskirtusPagalLaikotarpi(dataNuo, dataIki).get(i).getStatusas(),
						cellFontColorRed));
			} else if (gedimai.gautiNepaskirtusPagalLaikotarpi(dataNuo, dataIki).get(i).getStatusas()
					.equals("ivykdyta")) {
				table.addCell(new Paragraph(
						gedimai.gautiNepaskirtusPagalLaikotarpi(dataNuo, dataIki).get(i).getStatusas(),
						cellFontColorGreen));
			} else {
				table.addCell(new Paragraph(
						gedimai.gautiNepaskirtusPagalLaikotarpi(dataNuo, dataIki).get(i).getStatusas(), cellFont));
			}
			
			

		}
	}

	try {
		document.add(paragraph);
		document.add(paragraph2);
		document.add(table);
	} catch (DocumentException e) {
		new RuntimeException(e);
	}

	document.close();
	
}
}
