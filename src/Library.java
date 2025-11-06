
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public  class Library  {
    private final  String name;

    private final  String address;
    private Map<String, Book>books=new HashMap<>();

    private  Map<String , Member>members=new HashMap<>();



    public Library(String address, String name) {
        this.address = address;
        this.name = name;
    }

    public  void addBook(Book b){
        books.put(b.getId(), b);
    }



    public Optional<Book>findBook(String bookId){
        return Optional.ofNullable(books.get(bookId));
    }

    public  void  registerMember(Member m){
        members.put(m.getId(),m);
    }


    public  Optional<Member>findMember(String memberId){
        return Optional.ofNullable(members.get(memberId));
    }

    public  boolean  issueBook(String bookId, String memberId, Librarian librarian){
        Book book=books.get(bookId);
        Member member =members.get(memberId);

        if(book ==null){
            System.out.println("Issue failed: Book not found (" + bookId + ")");
            return false;
        }
        if(member == null){
            System.out.println("Issue failed: Member not found (" + memberId + ")");
            return false;
        }

        if (book.isIssued()) { // check current status
            System.out.println("Issue failed: Book already issued to " + book.getIssuedToMemberId());
            return false;
        }

        // Do the issue: update both Book and Member state
        book.issuedTo(memberId);     // mark book as issued
        member.borrowBook(bookId);  // add bookId to member's borrowed set

        // Log action
        System.out.println("Librarian " + librarian.getName() +
                " issued book '" + book.getTitle() + "' to member " + member.getName());
        return true;
    }



    public  boolean returnBook(String bookId, String memberId,  Librarian librarian){
        Book book=books.get(bookId);
        Member member=members.get(memberId);

        // Validations
        if (book == null) {
            System.out.println("Return failed: Book not found (" + bookId + ")");
            return false;
        }
        if (member == null) {
            System.out.println("Return failed: Member not found (" + memberId + ")");
            return false;
        }
        // Check that book is issued and to this member
        if (!book.isIssued() || !member.getBorrowedBookIds().contains(bookId)) {
            System.out.println("Return failed: This book is not issued to this member.");
            return false;
        }


        // Perform return
        book.returned();            // reset book state
        member.returnBook(bookId);  // remove from member's borrowed set

        // Log action
        System.out.println("Librarian " + librarian.getName() +
                " accepted return of '" + book.getTitle() + "' from member " + member.getName());
        return true;
    }

    public  void listBooks(){
        System.out.println("Books in library:");
        for(Book b:books.values()){
            System.out.println(" "+b);
        }
    }

    // Utility to print list of members
    public void listMembers() {
        System.out.println("Members in library:");
        for (Member m : members.values()) {
            System.out.println("  " + m);
        }
    }










}