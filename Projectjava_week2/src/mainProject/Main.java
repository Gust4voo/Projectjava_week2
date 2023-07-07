
package mainProject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        // Creazione di alcuni oggetti Libro
        Book book1 = new Book("9780123456789", "Libro 1", 2021, 200, "Autore 1", "Genere 1");
        Book book2 = new Book("9789876543210", "Libro 2", 2022, 150, "Autore 2", "Genere 2");

        // Creazione di alcuni oggetti Rivista
        Magazine magazine1 = new Magazine("1234567890", "Rivista 1", 2021, 50, Frequency.MONTHLY);
        Magazine magazine2 = new Magazine("0987654321", "Rivista 2", 2022, 60, Frequency.WEEKLY);

        // Creazione del catalogo bibliotecario
        BibliographicCatalog catalog = new BibliographicCatalog(book1);

        // Aggiunta degli elementi al catalogo
        catalog.addItem(book2);
        catalog.addItem(magazine1);
        catalog.addItem(magazine2);

        // Ricerca per ISBN
        String searchISBN = "9780123456789";
        Optional<LibraryItem> foundItem = catalog.searchByISBN(searchISBN);
        if (foundItem.isPresent()) {
            System.out.println("Elemento trovato per ISBN " + searchISBN + ":");
            System.out.println(foundItem.get());
        } else {
            System.out.println("Nessun elemento trovato per ISBN " + searchISBN);
        }

        // Ricerca per autore
        String searchAuthor = "Autore 2";
        List<Book> booksByAuthor = catalog.searchByAuthor(searchAuthor);
        if (!booksByAuthor.isEmpty()) {
            System.out.println("Libri trovati per autore " + searchAuthor + ":");
            for (Book book : booksByAuthor) {
                System.out.println(book);
            }
        } else {
            System.out.println("Nessun libro trovato per autore " + searchAuthor);
        }

        // Ricerca per anno di pubblicazione
        int searchYear = 2022;
        List<LibraryItem> itemsByYear = catalog.searchByYear(searchYear);
        if (!itemsByYear.isEmpty()) {
            System.out.println("Elementi trovati per anno di pubblicazione " + searchYear + ":");
            for (LibraryItem item : itemsByYear) {
                System.out.println(item);
            }
        } else {
            System.out.println("Nessun elemento trovato per anno di pubblicazione " + searchYear);
        }

        // Salvataggio del catalogo su disco
        File file = new File("catalog.dat");
        try {
            catalog.saveToDisk(file);
            System.out.println("Catalogo salvato su disco.");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante il salvataggio del catalogo su disco.");
            e.printStackTrace();
        }

        // Caricamento del catalogo dal disco
        try {
            catalog.loadFromDisk(file);
            System.out.println("Catalogo caricato dal disco.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Si è verificato un errore durante il caricamento del catalogo dal disco.");
            e.printStackTrace();
        }
    }
}

