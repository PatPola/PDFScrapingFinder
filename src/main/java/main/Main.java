package main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Pdf.PdfUtil.buscarEnPDF;

/**
 * Clase principal
 * Solicita por consola un String y busca coincidencias en los pdf del enlace que se aporta por defecto
 * Si encuentra coincidencias, muestra los enlaces que las contienen al finalizar la búsqueda
 * Almacena en memoria los pdf
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce la url para buscar en sus PDF:");
        String url = input.nextLine();
        System.out.print("Ingrese el texto para buscar en los PDF: ");
        String texto = input.nextLine();
        //"https://www.castillalamancha.es/gobierno/desarrollosostenible/estructura/dgtranene/actuaciones/resoluciones-de-concesi%C3%B3n-y-desestimaci%C3%B3n-ayudas-autoconsumo";

        //Lista para almacenar los enlaces con coincidencias de búsqueda
        List<String> coincidencias = new ArrayList<>();
        try {
            //  Obtenemos todos los enlaces a PDFs en la página
            Document doc = Jsoup.connect(url).get();
            Elements pdfLinks = doc.select("a[href$=.pdf]");
            //Si la página no tiene archivos pdf sale
            if (pdfLinks.isEmpty()) {
                System.out.println("No se encontraron archivos pdf en la página");
                return;
            }
            //recorremos los elementos
            for (Element link : pdfLinks) {
                String pdfUrl = link.absUrl("href");
                System.out.println("Procesando: " + pdfUrl);
                // Buscar el nombre en el PDF
                if (buscarEnPDF(pdfUrl, texto)) {
                    coincidencias.add(pdfUrl);
                }
            }
            System.out.println("""
                    ------------------------------------------------------------------
                                      RESULTADOS DE LA BÚSQUEDA 
                    ------------------------------------------------------------------
                    """);
            // 📢 Mostrar resultados
            if (coincidencias.isEmpty()) {
                System.out.println("No se encontraron coincidencias");
            } else {
                System.out.println("Se encontró: " + texto + " en los siguientes documentos:");
                for (String enlace : coincidencias) {
                    System.out.println("- " + enlace);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al conectar con la página: " + e.getMessage());
        }
    }
}
