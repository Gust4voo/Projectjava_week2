package mainProject;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class LibraryItem implements Serializable {

	protected String ISBN;
	protected String title;
	protected int publicationYear;
	protected int numberOfPages;
	
	public LibraryItem(String ISBN, String title, int publicationYear, int numberOfPages) {
		this.ISBN = ISBN;
		this.title = title;
		this.publicationYear = publicationYear;
		this.numberOfPages = numberOfPages;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getPublicationYear() {
		return publicationYear;
	}
	
	public int getNumberOfPages() {
		return numberOfPages;
	}
	
}
