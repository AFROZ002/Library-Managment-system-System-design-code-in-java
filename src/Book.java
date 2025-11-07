public  class Book  {


    private  final String title;

    private  final String author;
    private  boolean isIssued;
    private  String issuedToMemberId;


    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
        this.issuedToMemberId = null;
    }
private  final String id;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public String getIssuedToMemberId() {
        return issuedToMemberId;
    }

    public  void issuedTo(String memberId){
        this.isIssued=true;
        this.issuedToMemberId=memberId;

    }

    public  void returned(){
        this.isIssued=false;
        this.issuedToMemberId=null;
    }


    @Override
    public String toString() {
        return "Book{" + id + ", '" + title + '\'' + ", " + author +
                ", issued=" + isIssued + '}';
    }
}


