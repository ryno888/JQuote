/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ui.invoice;

/**
 *
 * @author Ryno Laptop
 */
import app.config.Constants;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import core.com.date.ComDate;

import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GenerateInvoice {

    private BaseFont bfBold;
    private BaseFont bf;
    private int pageNumber = 0;
    
    
    private String inv_invoice_nr;
    private String inv_account_nr;
    private String inv_company_name;
    
    private String inv_company_add_line1;
    private String inv_company_add_line2;
    private String inv_company_city;
    private String inv_company_suburb;
    private String inv_company_code;
    private String inv_company_country;
    private String inv_date_created;
    private final DecimalFormat formatter = new DecimalFormat("R ###,###,##0.00");
    private Double inv_sub_total;
    private Double inv_total;
    private final ArrayList<Object[]> item_arr = new ArrayList();
    
    //------------------------------------------------------------------------------
    public GenerateInvoice() {
        this.inv_invoice_nr = "";
        this.inv_account_nr = "";
        this.inv_company_name = "";

        this.inv_company_add_line1 = "";
        this.inv_company_add_line2 = "";
        this.inv_company_city = "";
        this.inv_company_suburb = "";
        this.inv_company_code = "";
        this.inv_company_country = "";
        this.inv_date_created = ComDate.getDate(Constants.DATE);
        this.inv_sub_total = 0.00;
        this.inv_total = 0.00;
    }
    //------------------------------------------------------------------------------
    public void additem(Object id, Object description, Object unitprice, Object qty) {
        Double price  = Double.parseDouble(unitprice.toString()) * Double.parseDouble(qty.toString());
        item_arr.add(new Object[]{id, description, qty, formatter.format(unitprice), formatter.format(price)});
    }
    //------------------------------------------------------------------------------
    public String getFileName() {
        return "Invoice - "+this.inv_invoice_nr + ".pdf";
    }
    //------------------------------------------------------------------------------
    public void saveAs() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setSelectedFile(new File(this.getFileName()));
        int returnLatih = jFileChooser.showSaveDialog(null);
        
        jFileChooser.getSelectedFile();
        if (returnLatih == JFileChooser.APPROVE_OPTION) {
            this.createPDF(jFileChooser.getSelectedFile().toString());
            JOptionPane.showMessageDialog(null, "File successfully saved", "Saved", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("File Chooser was cancelled");      
        }
    }
    //------------------------------------------------------------------------------
    public void createPDF(String pdfFilename) {

        Document doc = new Document();
        PdfWriter docWriter = null;
        initializeFonts();
        
        if(pdfFilename == null){ pdfFilename = getFileName(); }

        try {
            docWriter = PdfWriter.getInstance(doc, new FileOutputStream(pdfFilename));
            doc.addAuthor("Ryno van Zyl");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("Prologue");
            doc.addTitle("Invoice - "+this.inv_invoice_nr);
            doc.setPageSize(PageSize.LETTER);

            doc.open();
            PdfContentByte cb = docWriter.getDirectContent();

            boolean beginPage = true;
            int y = 0;

            for (int i = 0; i < item_arr.size(); i++) {
                if (beginPage) {
                    beginPage = false;
                    generateLayout(doc, cb);
                    generateHeader(doc, cb);
                    y = 615;
                }
                generateDetail(doc, cb, i, y, item_arr.get(i));
                y = y - 15;
                if (y < 150) {
                    generateFooter(doc, cb);
                    printPageNumber(cb);
                    doc.newPage();
                    beginPage = true;
                }else{
                    generateFooter(doc, cb);
                }
            }
            printPageNumber(cb);

        } catch (DocumentException dex) {
            dex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (doc != null) {
                doc.close();
            }
            if (docWriter != null) {
                docWriter.close();
            }
        }
    }
    //------------------------------------------------------------------------------
    private void generateLayout(Document doc, PdfContentByte cb) {

        try {

            cb.setLineWidth(1f);

            // Invoice Header box Text Headings 
            createHeadings(cb, 422, 733, "Account No.");
            createHeadings(cb, 422, 713, "Invoice No.");
            createHeadings(cb, 422, 693, "Invoice Date");

            // Invoice Detail box layout 
            cb.rectangle(30, 150, 540, 500);
            cb.moveTo(30, 630);
            cb.lineTo(570, 630);
            cb.moveTo(90, 150);
            cb.lineTo(90, 650);
            cb.moveTo(150, 150);
            cb.lineTo(150, 650);
            cb.moveTo(430, 150);
            cb.lineTo(430, 650);
            cb.moveTo(500, 150);
            cb.lineTo(500, 650);
            cb.stroke();

            // Invoice Detail box Text Headings 
            createHeadings(cb, 32, 633, "Item Code");
            createHeadings(cb, 92, 633, "Quantity");
            createHeadings(cb, 152, 633, "Item Description");
            createHeadings(cb, 432, 633, "Unit Price");
            createHeadings(cb, 502, 633, "Excl. Total");

            //add the images
            Image companyLogo = Image.getInstance(getClass().getResource("/assets/pdf/pdf-header.png"));
            companyLogo.setAbsolutePosition(25, 700);
            companyLogo.scalePercent(40);
            doc.add(companyLogo);

        } catch (DocumentException dex) {
            dex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    //------------------------------------------------------------------------------
    private void generateHeader(Document doc, PdfContentByte cb) {

        try {

            createHeadings(cb, 250, 740, this.inv_company_name);
            createHeadings(cb, 250, 725, this.inv_company_add_line1);
            createHeadings(cb, 250, 710, this.inv_company_add_line2);
            createHeadings(cb, 250, 695, this.inv_company_city + ", " + this.inv_company_suburb + " - " + this.inv_company_code);
            createHeadings(cb, 250, 680, this.inv_company_country);

            createHeadings(cb, 482, 733, this.inv_account_nr);
            createHeadings(cb, 482, 713, this.inv_invoice_nr);
            createHeadings(cb, 482, 693, this.inv_date_created);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    //------------------------------------------------------------------------------
    private void generateFooter(Document doc, PdfContentByte cb) {

        try {
            String subtotal = this.inv_sub_total == 0.00 ? " - " : formatter.format(this.inv_sub_total);
                    
            createContent(cb, 498, 105, "Sub Total", PdfContentByte.ALIGN_RIGHT, 10);
            createContent(cb, 568, 105, subtotal, PdfContentByte.ALIGN_RIGHT, 10);
            createContent(cb, 498, 90, "Total (Excl. VAT)", PdfContentByte.ALIGN_RIGHT, 10);
            createContent(cb, 568, 90, formatter.format(this.inv_total), PdfContentByte.ALIGN_RIGHT, 10);
            
            createContent(cb, 32, 120, "Banking Details:", PdfContentByte.ALIGN_LEFT, 10);
            
            createContent(cb, 32, 105, "Bank:", PdfContentByte.ALIGN_LEFT, 10);
            createContent(cb, 200, 105, "Capitec", PdfContentByte.ALIGN_RIGHT, 10);
            
            createContent(cb, 32, 90, "Branch:", PdfContentByte.ALIGN_LEFT, 10);
            createContent(cb, 200, 90, "470010", PdfContentByte.ALIGN_RIGHT, 10);
            
            createContent(cb, 32, 75, "Account Name:", PdfContentByte.ALIGN_LEFT, 10);
            createContent(cb, 200, 75, "Prologue", PdfContentByte.ALIGN_RIGHT, 10);
            
            createContent(cb, 32, 60, "Account #:", PdfContentByte.ALIGN_LEFT, 10);
            createContent(cb, 200, 60, "132 246 2656", PdfContentByte.ALIGN_RIGHT, 10);
            
            createContent(cb, 32, 45, "Account Type:", PdfContentByte.ALIGN_LEFT, 10);
            createContent(cb, 200, 45, "Savings", PdfContentByte.ALIGN_RIGHT, 10);
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    //------------------------------------------------------------------------------
    private void generateDetail(Document doc, PdfContentByte cb, int index, int y, Object[] obj) {
        DecimalFormat df = new DecimalFormat("0.00");

        try {

            createContent(cb, 36, y, "ITEM" + obj[0].toString(), PdfContentByte.ALIGN_LEFT);
            createContent(cb, 96, y, obj[2].toString(), PdfContentByte.ALIGN_LEFT);
            createContent(cb, 152, y, obj[1].toString(), PdfContentByte.ALIGN_LEFT);

            createContent(cb, 498, y, obj[3].toString(), PdfContentByte.ALIGN_RIGHT);
            createContent(cb, 568, y, obj[4].toString(), PdfContentByte.ALIGN_RIGHT);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    //------------------------------------------------------------------------------
    private void createHeadings(PdfContentByte cb, float x, float y, String text) {

        cb.beginText();
        cb.setFontAndSize(bfBold, 8);
        cb.setTextMatrix(x, y);
        cb.showText(text.trim());
        cb.endText();

    }
    //------------------------------------------------------------------------------
    private void printPageNumber(PdfContentByte cb) {

        cb.beginText();
        cb.setFontAndSize(bfBold, 8);
        cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, "Page No. " + (pageNumber + 1), 570, 25, 0);
        cb.endText();

        pageNumber++;

    }
    //------------------------------------------------------------------------------
    private void createContent(PdfContentByte cb, float x, float y, String text, int align) {
        createContent(cb, x, y, text, align, 8);
    }
    //------------------------------------------------------------------------------
    private void createContent(PdfContentByte cb, float x, float y, String text, int align, int fontSize) {

        cb.beginText();
        cb.setFontAndSize(bf, fontSize);
        cb.showTextAligned(align, text.trim(), x, y, 0);
        cb.endText();

    }
    //------------------------------------------------------------------------------
    private void initializeFonts() {

        try {
            bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //------------------------------------------------------------------------------
    public String getInv_invoice_nr() {
        return inv_invoice_nr;
    }
    //------------------------------------------------------------------------------
    public void setInv_invoice_nr(String inv_invoice_nr) {
        this.inv_invoice_nr = inv_invoice_nr;
    }
    //------------------------------------------------------------------------------
    public String getInv_account_nr() {
        return inv_account_nr;
    }
    //------------------------------------------------------------------------------
    public void setInv_account_nr(String inv_account_nr) {
        this.inv_account_nr = inv_account_nr;
    }
    //------------------------------------------------------------------------------
    public String getInv_company_name() {
        return inv_company_name;
    }
    //------------------------------------------------------------------------------
    public void setInv_company_name(String inv_company_name) {
        this.inv_company_name = inv_company_name;
    }
    //------------------------------------------------------------------------------
    public String getInv_company_add_line1() {
        return inv_company_add_line1;
    }
    //------------------------------------------------------------------------------
    public void setInv_company_add_line1(String inv_company_add_line1) {
        this.inv_company_add_line1 = inv_company_add_line1;
    }
    //------------------------------------------------------------------------------
    public String getInv_company_add_line2() {
        return inv_company_add_line2;
    }
    //------------------------------------------------------------------------------
    public void setInv_company_add_line2(String inv_company_add_line2) {
        this.inv_company_add_line2 = inv_company_add_line2;
    }
    //------------------------------------------------------------------------------
    public String getInv_company_city() {
        return inv_company_city;
    }
    //------------------------------------------------------------------------------
    public void setInv_company_city(String inv_company_city) {
        this.inv_company_city = inv_company_city;
    }
    //------------------------------------------------------------------------------
    public String getInv_company_suburb() {
        return inv_company_suburb;
    }
    //------------------------------------------------------------------------------
    public void setInv_company_suburb(String inv_company_suburb) {
        this.inv_company_suburb = inv_company_suburb;
    }
    //------------------------------------------------------------------------------
    public String getInv_company_code() {
        return inv_company_code;
    }
    //------------------------------------------------------------------------------
    public void setInv_company_code(String inv_company_code) {
        this.inv_company_code = inv_company_code;
    }
    //------------------------------------------------------------------------------
    public String getInv_company_country() {
        return inv_company_country;
    }
    //------------------------------------------------------------------------------
    public void setInv_company_country(String inv_company_country) {
        this.inv_company_country = inv_company_country;
    }
    //------------------------------------------------------------------------------
    public String getInv_date_created() {
        return inv_date_created;
    }
    //------------------------------------------------------------------------------
    public void setInv_date_created(String inv_date_created) {
        this.inv_date_created = inv_date_created;
    }
    //------------------------------------------------------------------------------
    public void setInv_sub_total(Double subtotal) {
        this.inv_sub_total = subtotal;
    }
    //------------------------------------------------------------------------------
    public void setInv_total(Double total) {
        this.inv_total = total;
    }
    //------------------------------------------------------------------------------
}
