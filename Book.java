import java.util.Objects;

public class Book {
    private String title;
    private String author1;
    private String author2;
    private String publisher;
    private int yearPublication;
    private String isbn;
    private long accessionNum;
    private LibMember issuedTo;

    //constructor without parameters
    public Book(){
        title = author1 = author2 = publisher = isbn = null;
        yearPublication = 0;
        accessionNum = 0;
        issuedTo = null;
    }

    //constructor with parameters
    public Book(String title, String author1, String author2, String publisher, int yearPublication, String isbn, long accessionNum){
        if (isbn.length() == 13 && accessionNum > 1000){
            this.title = title;
            this.author1 = author1;
            this.author2 = author2;
            this.publisher = publisher;
            this.isbn = isbn;
            this.yearPublication = yearPublication;
            this.accessionNum = accessionNum;
            issuedTo = null;
        }
        else
            System.out.println("Invalid ISBN or AccessionNumber");
    }

    //set methods
    public void setTitle(String ti){
        title = ti;
    }

    public void setAuthor1(String a1){
        author1 = a1;
    }

    public void setAuthor2(String a2)
    {
        author2 = a2;
    }

    public void setPublisher(String pb)
    {
        publisher= pb;
    }

    public void setIsbn(String is)
    {
        if (is.length()==13)
            isbn=is;
        else
            System.out.println("Invalid ISBN!");
    }

    public void setYearPublication(int yp){
        yearPublication = yp;
    }

    public void setAccessionNum(long acc)
    {
        if (acc>1000)
            accessionNum=acc;
        else
            System.out.println("Invalid Accession Number!");

    }

    public void setIssuedTo(LibMember issuedTo)
    {
        this.issuedTo = issuedTo;
    }

    //get methods
    public String getTitle()
    {
        return title;
    }

    public String getAuthor1()
    {
        return author1;
    }

    public String getAuthor2()
    {
        return author2;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public int getYearPublication()
    {
        return yearPublication;
    }

    public long getAccessionNum()
    {
        return accessionNum;
    }

    public LibMember getIssuedTo() {
        return issuedTo;
    }

    public boolean equals(Object ob) {
        if (this == ob) return true;
        if (ob == null || getClass() != ob.getClass()) return false;
        Book book = (Book) ob;
        return yearPublication == book.yearPublication &&
                accessionNum == book.accessionNum &&
                Objects.equals(title, book.title) &&
                Objects.equals(author1, book.author1) &&
                Objects.equals(author2, book.author2) &&
                Objects.equals(publisher, book.publisher) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(issuedTo, book.issuedTo);
    }

    //print method
    public String toString()
    {
        return ("Book Info: \n " +
                "Title: "+title+"\n " +
                "Author 1: "+ author1+"\n " +
                "Author 2: "+author2 +"\n " +
                "Publisher: "+publisher +"\n " +
                "Publication year: "+ yearPublication+"\n " +
                "ISBN: "+isbn+"\n " +
                "Accession Number: "+accessionNum +"\n " +
                "Issued to: "+issuedTo+"\n\n");

    }

}//end of class
