import java.util.Scanner;

public class LibraryMain
{
    public static void main(String[]args)
    {
        Scanner kb = new Scanner(System.in);
        LibrarySystem lib = new LibrarySystem();

        Book BookA=new Book("CHEMY","Alaa","Abdulla","UOB",2020,"525241516171",1021);
        Book BookB=new Book("DATA","Rena","Reda","UOB",2021,"323141516172",1032);
        Book BookC=new Book("IT","Faisal","Saleh","UOB",2020,"1213141516173",1043);
        Book BookD=new Book("Science","Ibrahim","Bader","UOB",2020,"1213141516174",1004);
        Book BookE=new Book("English","Masood","Talal","UOB",2020,"1213141516175",1005);

        LibMember MemberA = new LibMember("Tareq","Abdullah",'M', 780608632 , "66889525" );
        LibMember MemberB = new LibMember("Mohammed","Ali",'M', 890708744 , "37358792" );
        LibMember MemberC = new LibMember("Abdulrahman","Mohammed",'M', 910608632 , "33269999" );

        lib.addBook(BookA);
        lib.addBook(BookB);
        lib.addBook(BookC);
        lib.addBook(BookD);
        lib.addBook(BookE);

        lib.addMember(MemberA);
        lib.addMember(MemberB);
        lib.addMember(MemberC);



        System.out.println("(1) Add Book\n " +
                "(2) Delete Book\n " +
                "(3) Add Member\n " +
                "(4) Delete Member\n " +
                "(5) Search Book\n " +
                "(6) Search Member\n " +
                "(7) Check BookList Empty\n " +
                "(8) Check MemberList Empty\n " +
                "(9) BookList Size\n " +
                "(10) MemberList Size\n " +
                "(11) Issue Book\n " +
                "(12) Return Book\n " +
                "(13) Print Book Issued\n " +
                "(14) Check is Book Issued\n " +
                "(0) EXIT");

        System.out.println("Please enter a number to use one of the functions from above:\n");

        int in = 0;
        while (in>=0)
        {
            in=kb.nextInt();
            switch(in)
            {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("\nEnter: Title: ");
                    String t = kb.nextLine();
                    System.out.println("\nAuthor 1: ");
                    String a1 = kb.nextLine();
                    System.out.println("\nAuthor 2: ");
                    String a2 = kb.nextLine();
                    System.out.println("\nPublisher: ");
                    String p = kb.nextLine();
                    System.out.println("\nYear of Publication: ");
                    int y = kb.nextInt();
                    System.out.println("\nISBN: ");
                    String i = kb.nextLine();
                    System.out.println("\nAccession Number: ");
                    long a = kb.nextLong();

                    Book newBook = new Book(t, a1, a2, p, y, i, a);
                    lib.addBook(newBook);
                    break;
                case 2:
                    System.out.println("Enter the accession number");
                    System.out.println(lib.deleteBook(kb.nextLong()));
                    break;
                case 3:
                    System.out.println("\nEnter: First Name: ");
                    String f = kb.nextLine();
                    System.out.println("\nLast Name: ");
                    String l = kb.nextLine();
                    System.out.println("\nGender: (M or F) ");
                    char g = kb.next().charAt(0);
                    System.out.println("\nCPR Number: ");
                    long c = kb.nextLong();
                    System.out.println("\nTelephone Number: ");
                    String tel = kb.nextLine();

                    LibMember newMember = new LibMember(f, l, g, c, tel);
                    lib.addMember(newMember);
                    break;
                case 4:
                    System.out.println("Enter Cpr number");
                    System.out.println(lib.deleteMember(kb.nextLong()));
                    break;
                case 5:
                    System.out.println("Enter the accession number");
                    System.out.println(lib.searchBook(kb.nextLong()));
                    break;
                case 6:
                    System.out.println("Enter the Cpr number");
                    System.out.println(lib.searchMember(kb.nextLong()));
                    break;
                case 7:
                    System.out.println("Is BookList Empty?");
                    System.out.println(lib.isEmptyBookList());
                    break;
                case 8:
                    System.out.println("Is MemberList Empty?");
                    System.out.println(lib.isEmptyMemberList());
                    break;
                case 9:
                    System.out.println("\nThere are " + lib.sizeBooksList() + " books");
                    break;
                case 10:
                    System.out.println("\nThere are " + lib.sizeMembersList() + " members");
                    break;
                case 11:
                    System.out.println("Enter the accession number and Cpr number repectively");
                    System.out.println(lib.issueBook(kb.nextLong(),kb.nextLong()));
                    break;
                case 12:
                    System.out.println("Enter the accession number");
                    System.out.println(lib.returnBook(kb.nextLong()));
                    break;
                case 13:
                    System.out.println("Enter the Cpr number");
                    lib.printBooksIssued(kb.nextLong());
                    break;
                case 14:
                    System.out.println("Enter the accession number");
                    System.out.println(lib.isBookIssued(kb.nextLong()));
                    break;
                default:
                    System.out.println("You entered an invalid number." +
                            "\nPlease choose from the menu or enter 0 to Exit");
                    break;
            }
            System.out.println("Please enter a number to use one of the functions from above:\n");
        }

    }
}
