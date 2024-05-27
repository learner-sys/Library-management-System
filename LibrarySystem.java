import java.util.*;
import java.util.LinkedList;

public class LibrarySystem
{
    private LinkedList<Book> booksList;
    private LinkedList<LibMember> membersList;
    private int booksListSize;
    private int membersListSize;

    public LibrarySystem()
    {
        booksList = new LinkedList <Book>();
        membersList = new LinkedList <LibMember>();
        booksListSize = 0;
        membersListSize = 0;
    }
    
//addBook: inserts a new Bookobject at the end of the booksList
    public boolean addBook(Book book)
    {
        if(searchBook(book.getAccessionNum()) != -1)
        //if already exists
            return false;

        //if doesnt exist then add it
        booksList.add(book);
        booksListSize++;
        return true;
    }
//deleteBook: deletes a Book object from booksList
    public boolean deleteBook(long accessionNumber)
    {
        if (searchBook(accessionNumber) == -1)
        // if the book doesnt exist return false
          return false;

        Iterator<LibMember> iter = membersList.listIterator();

        while(iter.hasNext())
        {
            LibMember lm = iter.next();
            Book[] bookIssued = lm.getBooksIssued();
            for(int i=0; i < lm.getNumBooksIssued(); i++)
            {
                if(bookIssued[i].getAccessionNum() == accessionNumber)
                    return false;
                     //if book is issued to a member then return false
            }
        }
        //delete it if it exist and not issued to any member
        booksList.remove(searchBook(accessionNumber));
        booksListSize--;
        return true;
    }

//addMember: inserts a new LibMember object at the end of the membersList
    public boolean addMember(LibMember lbMem)
    {
        long cpr = lbMem.getCprNum();

        if(searchMember(cpr) != -1)
        //if already exists
            return false;

        //if doesnt exist then add it
        membersList.add(lbMem);
        membersListSize++;
        return true;
    }

//deleteMember: deletes a LibMember object from membersList
    public boolean deleteMember(long cpr)
    {
        int index = searchMember(cpr);//search for the member in the list

        if(index != -1)//if found then
        {
            LibMember member1 = membersList.get(index);

            //and if the member doesnt have any book issued to him delete member and return true
            if(member1.getNumBooksIssued() == 0)
            {
                membersList.remove(index);
                membersListSize--;
               return true;
            }
        }
        //if not then return false
        return false;
    }

//searchBook: searches the booksList by accessionNum
    public int searchBook(long aNum)
    {
        //if the booksList is empty
        if(booksList.isEmpty())
            return -1;

        //initialize an iterator to search through all elemnts
        Iterator <Book> iter = booksList.iterator();
        int index = 0;

        while (iter.hasNext())
        {
            Book b1 = iter.next();
            if (b1.getAccessionNum() == aNum)
                return index; //the location of the book
            index++;
        }

        return -1; //if book doesnt exist

    }

//searchMember: searches the membersList by cprNum
    public int searchMember(long cpr)
    {
        //if membersList is empty
        if(membersList.isEmpty())
            return -1;

        //initialize an iterator to search through all elemnts
        Iterator<LibMember> iter = membersList.iterator();
        int index = 0;

        while (iter.hasNext())
        {
            LibMember member = iter.next();
            if(member.getCprNum() == cpr)
                return index;//the location of the book
            index++;
        }

        return -1; //if member does not exist

    }

    public boolean isEmptyBookList()
    {
        return booksList.isEmpty();
    }

    public boolean isEmptyMemberList()
    {
        return membersList.isEmpty();
    }

    public int sizeBooksList()
    {
        return booksListSize;
    }

    public int sizeMembersList()
    {
        return membersListSize;
    }

//issueBook: accepts accession number of a Book, and the CPR number of the member
    public boolean issueBook(long aNum, long cpr)
    {
        //The Book can be issued to a member only if:
        int bookInd = searchBook(aNum);
        int memberInd = searchMember(cpr);
        if(searchBook(aNum) == -1)//if the book doesnt exist in booksList return false
            return false;

        if(searchMember(cpr) == -1)//if the member doesnt exist in membersList return false
            return false;

        if (isBookIssued(aNum))//if the book is issued to any member return false
            return false;

        LibMember lbMem = membersList.get(memberInd);
        if(lbMem.getNumBooksIssued()>= 10)//if number of books issued to the member 10 or more return false
            return false;

        //if all conditions passed then the book can be issued to the member
        LibMember member1 = membersList.get(memberInd);
        Book b1 = booksList.get(bookInd);
        Book[] booksIssued = member1.getBooksIssued();
        booksIssued[member1.getNumBooksIssued()] = b1;
        member1.setBooksIssued(booksIssued);
        member1.setNumBooksIssued(member1.getNumBooksIssued() + 1);
        b1.setIssuedTo(member1);
        return true;
    }
    
//	returnBook: accepts accession number of a Book
    public boolean returnBook(long aNum)
    {
        //The Book can be returned only if:
        int bookInd = searchBook(aNum);
        
        if(bookInd == -1)//if the book exist in the book list
            return false;


        if(!isBookIssued(aNum))//if the book is issued to a member
            return false;

        //if the book can be returned...

        Book b1 = booksList.get(bookInd);
        LibMember member = b1.getIssuedTo();
        Book[] booksIssued = member.getBooksIssued();
        int bIssuedSize = member.getNumBooksIssued();
        int removeIndex = 0;
        for(int i = 0; i < member.getNumBooksIssued(); i++)
        {
            if(booksIssued[i].equals(booksList.get(bookInd)))
            {
                //shifting and removing
                for(int j = removeIndex; j < bIssuedSize - 1; j++)
                    booksIssued[j] = booksIssued[j+1];
                member.setNumBooksIssued(member.getNumBooksIssued() - 1);
                member.setBooksIssued(booksIssued);
                b1.setIssuedTo(null);
                return true;

            }
            removeIndex++;
        }
        //if the book cannot be returned return false
        return false;
    }

//printBooksIssued: accepts CPR number of a member, and prints details of all the books issued to the member.
    public void printBooksIssued(long cpr)
    {
        int memberInd = searchMember(cpr);
        //check if the member exists then prints details of the books issued to them
        if(memberInd != -1)
        {
            LibMember member1 = membersList.get(memberInd);
            Book[] books = member1.getBooksIssued();
            int booksNum = member1.getNumBooksIssued();

            for(int i=0; i<booksNum; i++)
            {
                Book b1 = books[i];
                System.out.println(b1.toString());
            }
        }
        //if member dose not exist
        else
            System.out.println("Member does not exist.");
    }

//isBookIssued: accepts accession number of the Book
    public boolean isBookIssued(long aNum)
    {
        int bookInd = searchBook(aNum);
        if(bookInd== -1)
            return false; //if doesnt exist in the list return false

        //if issued to a member then return true
        Book b1 = booksList.get(bookInd);
        if(b1.getIssuedTo() != null)
            return true;
        return false;
    }

}
