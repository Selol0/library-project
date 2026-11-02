package libraryproject;

public class Main {
	public static void main(String[] args) {
		Library library = new Library();
		library.addBook(new Book(100,"Çalıkuşu","xxxxxx"));
		library.addMember(new Member("Selo",200));
		library.barrowBook(200, "Çalıkuşu");
		library.returnBook(200,"çalıkuşu");
	}
}
