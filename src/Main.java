

public class Main {
    public static void main(String[] args) {
        Library library = new Library("City Library", "MG Road");

        Book b1 = new Book("B001", "Clean Code", "Robert C. Martin");
        Book b2 = new Book("B002", "Effective Java", "Joshua Bloch");
        Book b3 = new Book("B003", "Head First Java", "Kathy Sierra");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        Member m1 = new Member("M001", "Aman");
        Member m2 = new Member("M002", "Riya");
        library.registerMember(m1);
        library.registerMember(m2);

        Librarian lib = new Librarian("L001", "Mr. Sharma");

        library.listBooks();
        library.listMembers();

        System.out.println("\n--- Issuing Book B002 to M001 ---");
        lib.issueBook(library, "B002", "M001");

        System.out.println("\n--- Trying to issue B002 again to M002 (should fail) ---");
        lib.issueBook(library, "B002", "M002");

        System.out.println("\n--- Returning Book B002 from M001 ---");
        lib.returnBook(library, "B002", "M001");

        System.out.println("\n--- Now issuing B002 to M002 (should succeed) ---");
        lib.issueBook(library, "B002", "M002");

        System.out.println("\n--- Final state ---");
        library.listBooks();
        library.listMembers();
    }
}
