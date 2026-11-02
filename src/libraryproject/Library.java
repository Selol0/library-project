package libraryproject;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
	private List<Book> books = new ArrayList<>();
	private Map<Integer,Member> members = new HashMap<>();
	private List<Book> barrowedBooks = new ArrayList<>();
	
	public void addBook(Book book) {
		books.add(book);
		System.out.println("Book has been added:"+ book.getBookName());
	}
	public void addMember(Member member) {
		if(member == null) {
			System.out.println("Invalid Member.");
			return;
		}
		if(members.containsKey(member.getMemberId())) {
			System.out.println("A member with this ID already exists"+ member.getMemberId());
			return;
		}
		members.put(member.getMemberId(), member);
		System.out.println("Member Added"+ member.getMemberName());
	}
	public void listBooks() {
		System.out.println("---------- //Book List || ------------");
		
		for(int i = 0 ; i < books.size();i++) {
			System.out.println(books.get(i));
		}
	}
	public Book findBookByBookName(String bookName) {
		for (Book book:books) {
			if(book.getBookName().equalsIgnoreCase(bookName)) {
				return book;
			}
		}
		System.out.println("There is no book by this title:"+ bookName);
		return null;
		}
		public Member findMemberbyId(int memberId) {
			Member member =members.get(memberId);
			if(member == null) {
				System.out.println("Member could not found"+ memberId);
			}
			return member;
		}
		public void barrowBook(int memberId,String bookName) {
			Member member = findMemberbyId(memberId);
			if(member == null) {
				return;// findMemberById printed necessary text;
			}
			Book book = findBookByBookName(bookName);
			if(book == null) {
				return;
			}
			if(book.isBarrowed()) {
				System.out.println("this book is already barrowed:"+ book.getBookName());
			}
			book.setBarrowed(true);
			barrowedBooks.add(book);
			System.out.println(member.getMemberName()+"is barrowed this book" + book.getBookName());
		}
		public void returnBook(int memberId, String bookName) {
			Member member = findMemberbyId(memberId);
			if(member == null) {
				return;
			}
			Book book = findBookByBookName(bookName);
			if(book == null) {
				return;
			}
			if(!book.isBarrowed()) {
				System.out.println("This book is not barrowed,nothing to return: "+ book.getBookName());
				return;
			}
			book.setBarrowed(false);
			barrowedBooks.remove(book);
			System.out.println(member.getMemberName()+" returned :"+ book.getBookName());
		}
		public void listAvailbleBooks() {
			boolean found = false;
			for(Book book : books) {
				if(!book.isBarrowed()) {
					System.out.println(book);
					found = true;
				}
			}
			if(!found) {
				System.out.println("There is no avaible book..");
			}
		}
		
	
}
