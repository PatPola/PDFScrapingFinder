# PDFScrapingFinder

## Descripción

**PDFScrapingFinder** es una herramienta de consola que permite buscar coincidencias en archivos PDF alojados en una URL proporcionada. Esta aplicación está pensada para facilitar la búsqueda de información en sitios web que publican archivos PDF, como la página de Castilla-La Mancha, donde se encuentran las resoluciones de las subvenciones de autoconsumo la cual no tiene un búscador específico.

La aplicación permite:
- Solicitar una URL y un texto a través de la consola.
- Buscar los archivos PDF disponibles en esa URL.
- Almacenar los archivos PDF en memoria y buscar coincidencias con el texto proporcionado.

Esta herramienta se ha desarrollado debido a la falta de un buscador específico en algunos sitios web que publican múltiples documentos PDF. En lugar de tener que revisar cada archivo manualmente, el programa automatiza la búsqueda y muestra los resultados relevantes.

## Lenguaje y Bibliotecas
- **Java 21**
- **pdfbox 2.0.29**
- **jsoup 1.15.3**

## Ejemplo de uso
Al ejectutar el programa
Introduce la url para buscar en sus PDF:
https://www.castillalamancha.es/gobierno/desarrollosostenible/estructura/dgtranene/actuaciones/resoluciones-de-concesi%C3%B3n-y-desestimaci%C3%B3n-ayudas-autoconsumo
Ingrese el texto para buscar en los PDF:
"María la que no quiere ir buscando por pdf individual"
------------------------------------------------------------------
                  RESULTADOS DE LA BÚSQUEDA 
------------------------------------------------------------------
Se encontró "María la que no quiere ir buscando por pdf individual" en los siguientes documentos:
- https://www.castillalamancha.es/gobierno/desarrollosostenible/estructura/dgtranene/actuaciones/PDFEJEMPLO.pdf
- https://www.castillalamancha.es/gobierno/desarrollosostenible/estructura/dgtranene/actuaciones/PDFEJEMPLO.pdf
