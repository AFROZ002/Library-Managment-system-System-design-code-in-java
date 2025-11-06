import java.util.HashSet;
import java.util.Set;

public  class Member  {


    private  final String id;
    private  final String name;

    private  final Set<String> borrowedBookIds=new HashSet<>();


    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public Set<String> getBorrowedBookIds() {
        return borrowedBookIds;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }


    public  void  borrowBook(String bookId){
        borrowedBookIds.add(bookId);

    }
    public  boolean  returnBook(String bookId){
        return  borrowedBookIds.remove(bookId);
    }




    @Override
    public String toString() {
        return "Member{" + id + ", " + name + ", borrowed=" + borrowedBookIds + '}';
    }

















}