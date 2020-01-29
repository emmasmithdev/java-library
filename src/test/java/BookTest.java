import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;

    @Before
    public void before(){
        book1 = new Book("Watchmen", "Alan Moore", "scifi");
        book2 = new Book("The Kite Runner", "Khaled Hosseini", "drama");
        book3 = new Book("The Testaments", "Margaret Attwood", "thriller");
        book4 = new Book("Matilda", "Roald Dahl", "kids");
    }

    @Test
    public void shouldHaveTitle(){
        assertEquals("Watchmen", book1.getTitle());
    }

    @Test
    public void shouldHaveAuthor(){
        assertEquals("Roald Dahl", book4.getAuthor());
    }

    @Test
    public void shouldHaveGenre(){
        assertEquals("scifi", book1.getGenre());
    }
}
