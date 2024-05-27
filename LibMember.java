import java.util.Arrays;
import java.util.Objects;

public class LibMember {
    private String firstName;
    private String lastName;
    private char gender;
    private long cprNum;
    private String teleNum;
    private Book[] booksIssued;
    private int numBooksIssued;

    //constructor without parameters
    public LibMember()
    {
        firstName = lastName = teleNum = null;
        gender = ' ';
        cprNum = numBooksIssued = 0;
        booksIssued = new Book[10];
    }

    //constructor with parameters
    public LibMember(String firstName, String lastName,char gender,long cpr,String teleNum)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.cprNum = cpr;
        this.teleNum = teleNum;
        numBooksIssued = 0;
        booksIssued = new Book[10];
    }

    //sets methods
    public void setFirstName (String fn){
        firstName = fn;
    }

    public void setLastName (String ln){
        lastName = ln;
    }

    public void setGender (char gen){
        gender = gen;
    }

    public void setCprNum (long cprn){
        cprNum = cprn;
    }

    public void setTeleNum (String tele){
        teleNum = tele;
    }

    public void setBooksIssued (Book[] books){
        booksIssued = books;
    }

    public void setNumBooksIssued (int num){
        numBooksIssued = num;
    }

    //get methods
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public char getGender(){
        return gender;
    }

    public long getCprNum(){
        return cprNum;
    }

    public String getTeleNum(){
        return teleNum;
    }

    public Book[] getBooksIssued(){
        return booksIssued;
    }

    public int getNumBooksIssued(){
        return numBooksIssued;
    }

    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LibMember libMember = (LibMember) o;
        return gender == libMember.gender && cprNum == libMember.cprNum &&
                numBooksIssued == libMember.numBooksIssued &&
                Objects.equals(firstName, libMember.firstName) &&
                Objects.equals(lastName, libMember.lastName) &&
                Objects.equals(teleNum, libMember.teleNum) &&
                Arrays.equals(booksIssued, libMember.booksIssued);
    }

    //print method
    public String toString(){
        return ("Member Info:\n " + "First name: " + firstName + "\n " +
                "Last name: " + lastName + "\n " + "Gender: " + gender + "\n " +
                "CPR: " + cprNum + "\n " + "Telephone: " + teleNum + "\n" +
                "Number of books issued: " + numBooksIssued + "\n " + "Books issued: " + booksIssued);
    }
}//end of class
