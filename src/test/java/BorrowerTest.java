import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

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
        book3 = new Book("The Testaments", "Margaret Attwood", "thriller");
        book4 = new Book("Matilda", "Roald Dahl", "kids");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        HashMap<String, Integer> genreList = new HashMap<>();
        genreList.put("scifi", 1);
        genreList.put("drama", 2);
        genreList.put("kids", 1);
        library = new Library(books, 5, genreList);
        ArrayList<Book> collection = new ArrayList<>();
        borrower = new Borrower("Bob", collection);
    }

    @Test
    public void hasCollectionOfBooks(){
        assertEquals(0, borrower.collectionSize());
    }

    @Test
    public void canAddBookToCollection(){
        borrower.addBook(book1);
        assertEquals(1, borrower.collectionSize());
    }
}
