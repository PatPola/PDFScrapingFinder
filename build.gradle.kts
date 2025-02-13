plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://jcenter.bintray.com/")

    }

    dependencies {
        //PDFBOX Para leer PDF
        implementation("org.apache.pdfbox:pdfbox:2.0.29")
        //libreria para hacer scraping
        implementation("org.jsoup:jsoup:1.15.3")
        testImplementation(platform("org.junit:junit-bom:5.10.0"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }

    tasks.test {
        useJUnitPlatform()
    }
}