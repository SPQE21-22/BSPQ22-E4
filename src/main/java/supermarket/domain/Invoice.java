package supermarket.domain;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Invoice {
    double total = 0.0;
    String text = "";
    List<Product> productList;
    ArrayList<String> words;

    public void crearFacturaPdf(Order order) throws Exception {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Text
            String text2 = "-----------------";
            String textTest = "";
            String text4 = "";

            ArrayList<String> words = new ArrayList<String>();
            List<Product> productos;
            productList = order.getProductList();
            double total = 0.0;
            int i = 50;

            contentStream.beginText();
            contentStream.setFont(PDType1Font.COURIER_BOLD, 22);
            contentStream.newLineAtOffset(200, 500);
            // linea4

            // linea2
            contentStream.showText(text2);
            contentStream.newLineAtOffset(0, 30);
            // linea1

            for (Product product: productList) {
                total = +product.getPrice();
                textTest = product.toText();
                contentStream.showText(textTest);
                contentStream.newLineAtOffset(0, i);
                i = +30;

                words.add(textTest);
            }

            text4 = String.valueOf(total);

            contentStream.showText(text);
            contentStream.newLineAtOffset(0, 30);
            // linea1
            contentStream.showText(text2);

            System.out.println("id"+order.getId());
            String id="";
            id=String.valueOf(order.getId());
            contentStream.newLineAtOffset(150, 300);
            contentStream.showText(id);

            contentStream.endText();

            // imagen textTest
            /*PDImageXObject pdImage = PDImageXObject.createFromFile("src/imagenes/resumen.png", document);
            contentStream.drawImage(pdImage, 20, 700);



            // imagen textTest
            PDImageXObject pdImage2 = PDImageXObject.createFromFile("src/imagenes/logo.png", document);
            contentStream.drawImage(pdImage2, 150, 100);*/

            contentStream.close();

            document.save("invoice_udeusto.pdf");

            System.out.println("PDF CREATED");
        }
    }

}
