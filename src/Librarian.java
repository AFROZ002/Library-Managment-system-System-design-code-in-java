
public  class Librarian  {
    private  final String id;
    private   final String name;

    public Librarian(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public  String getId(){
        return id;

    }
    public String  getName(){
        return name;

    }
    public  boolean issueBook(Library library , String bookId, String memberId){
        return library.issueBook(bookId, memberId, this);
    }
    public boolean returnBook(Library library, String bookId, String memberId) {
        return library.returnBook(bookId, memberId, this);
    }


    @Override
    public String toString() {
        return "Librarian{" + id + ", " + name + '}';
    }


}