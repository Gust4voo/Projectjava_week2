package mainProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BibliographicCatalog {
	
	private List<LibraryItem> catalogItems;
	
	public BibliographicCatalog(LibraryItem item) {
		catalogItems = new ArrayList<>();
		addItem(item);
		
	}
	
	public BibliographicCatalog() {
		   catalogItems = new ArrayList<>();
		}
	
	public void addItem(LibraryItem item) {
		catalogItems.add(item);
	}
	
	public void removeItem(String ISBN) {
		catalogItems.removeIf(item -> item.getISBN().equals(ISBN));
	}
	
	public Optional<LibraryItem> searchByISBN(String ISBN) {
		return catalogItems.stream().filter(item -> item.getISBN().equals(ISBN)).findFirst();
	}
	
	public List<Book> searchByAuthor(String author) {
		return catalogItems.stream().filter(item -> item instanceof Book).map(item -> (Book) item).filter(book -> book.getAuthor().equals(author)).toList();
	}
	
	public List<LibraryItem> searchByYear(int publicationYear) {
		return catalogItems.stream().filter(item -> item.getPublicationYear() == publicationYear).toList();
	}
	
	public void saveToDisk(File file) throws IOException {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
			outputStream.writeObject(catalogItems);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadFromDisk(File file) throws IOException, ClassNotFoundException {
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
			catalogItems = (List<LibraryItem>) inputStream.readObject();
		}
	}
}
