import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> books;
    private int capacity;
    private HashMap<String, Integer> booksByGenre;

    public Library(ArrayList<Book> books, int capacity, HashMap<String, Integer> booksByGenre) {
        this.books = books;
        this.capacity = capacity;
        this.booksByGenre = booksByGenre;
    }

    public int bookCount() {
        return this.books.size();
    }

    public void addBook(Book book) {
        if (this.books.size() < this.capacity) {
            this.books.add(book);
            updateGenreHashMap(book);
        }
    }

    public Book getBookByIndex(int index){
        return this.books.get(index);
    }

    public Book removeBook(Book book) {
//        for (int i = 0; i < bookCount(); i++){
//            if (getBookByIndex(i) == book){
//                this.books.remove(i);
                this.books.remove(book);
                return book;
//            }
//        }
//        return null;
    }

    public void lendBook(Borrower borrower, Book book) {
        Book borrowedBook = removeBook(book);
        borrower.addBook(borrowedBook);
    }

    public void updateGenreHashMap(Book book){
        String genre = book.getGenre();
        if(this.booksByGenre.containsKey(genre)){
            int count = booksByGenre.get(genre);
            count++;
            this.booksByGenre.put(genre, count);
        } else {
            this.booksByGenre.put(genre, 1);
        }

    }

    public int getNumberOfBooksByGenre(String genre) {
        return booksByGenre.get(genre);
    }

}
