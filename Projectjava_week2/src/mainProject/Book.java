package mainProject;

@SuppressWarnings("serial")
public class Book extends LibraryItem {

	private String author;
	private String genre;
	
	public Book(String ISBN, String title, int publicationYear, int numberOfPages, String author, String genre) {
		super(ISBN, title, publicationYear, numberOfPages);
		this.author = author;
		this.genre = genre;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getGenre() {
		return genre;
	}
	
	@Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", numberOfPages=" + numberOfPages +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
	
}