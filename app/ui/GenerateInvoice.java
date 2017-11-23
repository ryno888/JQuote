/*
 * Class 
 * @filename GenerateInvoice 
 * @encoding UTF-8
 * @author Liquid Edge Solutions  * 
 * @copyright Copyright Liquid Edge Solutions. All rights reserved. * 
 * @programmer Ryno van Zyl * 
 * @date 23 Nov 2017 * 
 */
package app.ui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.ElementList;
import com.itextpdf.tool.xml.XMLWorkerHelper;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Ryno
 */
class GenerateInvoice {
    
    public void createPdf(String file) throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(file));
        // step 3
        document.open();
        // step 4
        StringBuilder sb = new StringBuilder();
        sb.append("<div>\n<p align=\"center\">");
        sb.append("<font size=\"5\">");
        sb.append("<b>&nbsp;<font color=\"#32cd32\">My centered Para</font></b>");
        sb.append("</font>");
        sb.append("<font color=\"#32cd32\">&nbsp;</font>");
        sb.append("</p>\n</div>");
 
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell();
        ElementList list = XMLWorkerHelper.parseToElementList(sb.toString(), null);
        for (Element element : list) {
            cell.addElement(element);
        }
        table.addCell(cell);
        document.add(table);
 
        // step 5
        document.close();
    }
    
}
