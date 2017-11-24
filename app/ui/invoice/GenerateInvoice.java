/*
 * Class 
 * @filename GenerateInvoice 
 * @encoding UTF-8
 * @author Liquid Edge Solutions  * 
 * @copyright Copyright Liquid Edge Solutions. All rights reserved. * 
 * @programmer Ryno van Zyl * 
 * @date 23 Nov 2017 * 
 */
package app.ui.invoice;

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
//        sb.append("<div>\n<p align=\"center\">");
        sb.append("<style>"
                + "@font-face {\n" +
"  font-family: SourceSansPro;\n" +
"  src: url(SourceSansPro-Regular.ttf);\n" +
"}\n" +
"\n" +
".clearfix:after {\n" +
"  content: \"\";\n" +
"  display: table;\n" +
"  clear: both;\n" +
"}\n" +
"\n" +
"a {\n" +
"  color: #0087C3;\n" +
"  text-decoration: none;\n" +
"}\n" +
"\n" +
"body {\n" +
"  position: relative;\n" +
"  width: 21cm;  \n" +
"  height: 29.7cm; \n" +
"  margin: 0 auto; \n" +
"  color: #555555;\n" +
"  background: #FFFFFF; \n" +
"  font-family: Arial, sans-serif; \n" +
"  font-size: 14px; \n" +
"  font-family: SourceSansPro;\n" +
"}\n" +
"\n" +
"header {\n" +
"  padding: 10px 0;\n" +
"  margin-bottom: 20px;\n" +
"  border-bottom: 1px solid #AAAAAA;\n" +
"}\n" +
"\n" +
"#logo {\n" +
"  float: left;\n" +
"  margin-top: 8px;\n" +
"}\n" +
"\n" +
"#logo img {\n" +
"  height: 70px;\n" +
"}\n" +
"\n" +
"#company {\n" +
"  float: right;\n" +
"  text-align: right;\n" +
"}\n" +
"\n" +
"\n" +
"#details {\n" +
"  margin-bottom: 50px;\n" +
"}\n" +
"\n" +
"#client {\n" +
"  padding-left: 6px;\n" +
"  border-left: 6px solid #0087C3;\n" +
"  float: left;\n" +
"}\n" +
"\n" +
"#client .to {\n" +
"  color: #777777;\n" +
"}\n" +
"\n" +
"h2.name {\n" +
"  font-size: 1.4em;\n" +
"  font-weight: normal;\n" +
"  margin: 0;\n" +
"}\n" +
"\n" +
"#invoice {\n" +
"  float: right;\n" +
"  text-align: right;\n" +
"}\n" +
"\n" +
"#invoice h1 {\n" +
"  color: #0087C3;\n" +
"  font-size: 2.4em;\n" +
"  line-height: 1em;\n" +
"  font-weight: normal;\n" +
"  margin: 0  0 10px 0;\n" +
"}\n" +
"\n" +
"#invoice .date {\n" +
"  font-size: 1.1em;\n" +
"  color: #777777;\n" +
"}\n" +
"\n" +
"table {\n" +
"  width: 100%;\n" +
"  border-collapse: collapse;\n" +
"  border-spacing: 0;\n" +
"  margin-bottom: 20px;\n" +
"}\n" +
"\n" +
"table th,\n" +
"table td {\n" +
"  padding: 20px;\n" +
"  background: #EEEEEE;\n" +
"  text-align: center;\n" +
"  border-bottom: 1px solid #FFFFFF;\n" +
"}\n" +
"\n" +
"table th {\n" +
"  white-space: nowrap;        \n" +
"  font-weight: normal;\n" +
"}\n" +
"\n" +
"table td {\n" +
"  text-align: right;\n" +
"}\n" +
"\n" +
"table td h3{\n" +
"  color: #57B223;\n" +
"  font-size: 1.2em;\n" +
"  font-weight: normal;\n" +
"  margin: 0 0 0.2em 0;\n" +
"}\n" +
"\n" +
"table .no {\n" +
"  color: #FFFFFF;\n" +
"  font-size: 1.6em;\n" +
"  background: #57B223;\n" +
"}\n" +
"\n" +
"table .desc {\n" +
"  text-align: left;\n" +
"}\n" +
"\n" +
"table .unit {\n" +
"  background: #DDDDDD;\n" +
"}\n" +
"\n" +
"table .qty {\n" +
"}\n" +
"\n" +
"table .total {\n" +
"  background: #57B223;\n" +
"  color: #FFFFFF;\n" +
"}\n" +
"\n" +
"table td.unit,\n" +
"table td.qty,\n" +
"table td.total {\n" +
"  font-size: 1.2em;\n" +
"}\n" +
"\n" +
"table tbody tr:last-child td {\n" +
"  border: none;\n" +
"}\n" +
"\n" +
"table tfoot td {\n" +
"  padding: 10px 20px;\n" +
"  background: #FFFFFF;\n" +
"  border-bottom: none;\n" +
"  font-size: 1.2em;\n" +
"  white-space: nowrap; \n" +
"  border-top: 1px solid #AAAAAA; \n" +
"}\n" +
"\n" +
"table tfoot tr:first-child td {\n" +
"  border-top: none; \n" +
"}\n" +
"\n" +
"table tfoot tr:last-child td {\n" +
"  color: #57B223;\n" +
"  font-size: 1.4em;\n" +
"  border-top: 1px solid #57B223; \n" +
"\n" +
"}\n" +
"\n" +
"table tfoot tr td:first-child {\n" +
"  border: none;\n" +
"}\n" +
"\n" +
"#thanks{\n" +
"  font-size: 2em;\n" +
"  margin-bottom: 50px;\n" +
"}\n" +
"\n" +
"#notices{\n" +
"  padding-left: 6px;\n" +
"  border-left: 6px solid #0087C3;  \n" +
"}\n" +
"\n" +
"#notices .notice {\n" +
"  font-size: 1.2em;\n" +
"}\n" +
"\n" +
"footer {\n" +
"  color: #777777;\n" +
"  width: 100%;\n" +
"  height: 30px;\n" +
"  position: absolute;\n" +
"  bottom: 0;\n" +
"  border-top: 1px solid #AAAAAA;\n" +
"  padding: 8px 0;\n" +
"  text-align: center;\n" +
"}\n" +
""
                + "</style>"
                + "<table>\n" +
"        <thead>\n" +
"          <tr>\n" +
"            <th class=\"service\">SERVICE</th>\n" +
"            <th class=\"desc\">DESCRIPTION</th>\n" +
"            <th>PRICE</th>\n" +
"            <th>QTY</th>\n" +
"            <th>TOTAL</th>\n" +
"          </tr>\n" +
"        </thead>\n" +
"        <tbody>\n" +
"          <tr>\n" +
"            <td class=\"service\">Design</td>\n" +
"            <td class=\"desc\">Creating a recognizable design solution based on the company's existing visual identity</td>\n" +
"            <td class=\"unit\">$40.00</td>\n" +
"            <td class=\"qty\">26</td>\n" +
"            <td class=\"total\">$1,040.00</td>\n" +
"          </tr>\n" +
"          <tr>\n" +
"            <td class=\"service\">Development</td>\n" +
"            <td class=\"desc\">Developing a Content Management System-based Website</td>\n" +
"            <td class=\"unit\">$40.00</td>\n" +
"            <td class=\"qty\">80</td>\n" +
"            <td class=\"total\">$3,200.00</td>\n" +
"          </tr>\n" +
"          <tr>\n" +
"            <td class=\"service\">SEO</td>\n" +
"            <td class=\"desc\">Optimize the site for search engines (SEO)</td>\n" +
"            <td class=\"unit\">$40.00</td>\n" +
"            <td class=\"qty\">20</td>\n" +
"            <td class=\"total\">$800.00</td>\n" +
"          </tr>\n" +
"          <tr>\n" +
"            <td class=\"service\">Training</td>\n" +
"            <td class=\"desc\">Initial training sessions for staff responsible for uploading web content</td>\n" +
"            <td class=\"unit\">$40.00</td>\n" +
"            <td class=\"qty\">4</td>\n" +
"            <td class=\"total\">$160.00</td>\n" +
"          </tr>\n" +
"          <tr>\n" +
"            <td colspan=\"4\" class=\"sub\">SUBTOTAL</td>\n" +
"            <td class=\"sub total\">$5,200.00</td>\n" +
"          </tr>\n" +
"          <tr>\n" +
"            <td colspan=\"4\">TAX 25%</td>\n" +
"            <td class=\"total\">$1,300.00</td>\n" +
"          </tr>\n" +
"          <tr>\n" +
"            <td colspan=\"4\" class=\"grand total\">GRAND TOTAL</td>\n" +
"            <td class=\"grand total\">$6,500.00</td>\n" +
"          </tr>\n" +
"        </tbody>\n" +
"      </table>");
//        sb.append("<font size=\"5\">");
//        sb.append("<b>&nbsp;<font color=\"#32cd32\">My centered Para</font></b>");
//        sb.append("</font>");
//        sb.append("<font color=\"#32cd32\">&nbsp;</font>");
//        sb.append("</p>\n</div>");
 
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
