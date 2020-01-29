import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Library library;
    private Borrower borrower;

    @Before
    public void before(){
        book1 = new Book("Watchmen", "Alan Moore", "scifi");
        book2 = new Book("The Kite Runner", "Khaled Hosseini", "drama");
        book3 = new Book("The Testaments", "Margaret Attwood", "drama");
        book4 = new Book("Matilda", "Roald Dahl", "kids");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        HashMap<String, Integer>  genreList = new HashMap<>();
        genreList.put("scifi", 1);
        genreList.put("drama", 2);
        genreList.put("kids", 1);
        library = new Library(books, 5, genreList);
        ArrayList<Book> collection = new ArrayList<>();
        borrower = new Borrower("Bob", collection);
    }

    @Test
    public void countBooksInLibrary(){
        assertEquals(4, library.bookCount());
    }

    @Test
    public void addBook(){
        library.addBook(book1);
        assertEquals(5, library.bookCount());
    }

    @Test
    public void fullCapacity(){
        library.addBook(book1);
        library.addBook(book1);
        library.addBook(book1);
        library.addBook(book1);
        assertEquals(5, library.bookCount());
    }

    @Test
    public void canRemoveBook(){
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        assertEquals(book1, library.removeBook(book1));
    }

    @Test
    public void canLendABook(){
        library.lendBook(borrower, book2);
        ArrayList<Book> testArray = new ArrayList<>();
        testArray.add(book2);
        assertEquals(testArray, borrower.getCollection());
        assertEquals(3, library.bookCount());
    }

    @Test
    public void canGetNumberOfBooksByGenre(){
        assertEquals(2, library.getNumberOfBooksByGenre("drama"));
    }

    @Test
    public void genreHashMapUpdatesOnBookAdded(){
        library.addBook(book1);
        assertEquals(2, library.getNumberOfBooksByGenre("drama"));
        assertEquals(2, library.getNumberOfBooksByGenre("scifi"));
    }
}
