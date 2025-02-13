package Pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.InputStream;
import java.net.URL;
import java.text.Normalizer;

/**
 * Clase util que proporciona métodos para el manejo de archivs pdf
 */
public class PdfUtil {
    /**
     * Este método se encarga de buscar coincidencias en archivos pdf
     * @param pdfUrl en la que vamos a buscar los archivos pdf
     * @param usuario nombre a buscar en los pdf
     * @return false
     */
    public static boolean buscarEnPDF(String pdfUrl, String usuario) {
        try (InputStream in = new URL(pdfUrl).openStream()) {
            PDDocument document = PDDocument.load(in);
            // Rotamos todas las páginas del PDF -- Los nombres de los beneficiarios están en tablas en horizontal
            for (PDPage page : document.getPages()) {
                page.setRotation(90);
            }
            // Extraemos el texto del PDF
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            document.close();
            // Normalizo el texto para evitar problemas con espacios o mayúsculas o acentos
            String textNormalizado = quitarAcentos(text.replaceAll("\\s+", " ").toLowerCase());
            String usuarioNormalizado = quitarAcentos(usuario.toLowerCase());
            return textNormalizado.contains(usuarioNormalizado);
        } catch (Exception e) {
            System.out.println("Error al leer PDF: " + e.getMessage());
            return false;
        }
    }

    /**
     * Método para normalizar el texto , quitar acentos
     * @param texto a buscar
     * @return
     */
    public static String quitarAcentos(String texto) {
        String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return normalizado.replaceAll("[^\\p{ASCII}]", "");
    }
}




