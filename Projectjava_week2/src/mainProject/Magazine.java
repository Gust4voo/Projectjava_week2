package mainProject;

@SuppressWarnings("serial")
public class Magazine extends LibraryItem {

	private Frequency frequency;
	
	public Magazine(String ISBN, String title, int publicationYear, int numberOfPages, Frequency frequency) {
		super(ISBN, title, publicationYear, numberOfPages);
		this.frequency = frequency;
	}
	
	public Frequency getFrequency() {
		return frequency;
	}
	
    @Override
    public String toString() {
        return "Magazine{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", numberOfPages=" + numberOfPages +
                ", frequency=" + frequency +
                '}';
    }
	
}
