import java.util.ArrayList;

public class Borrower {

    private String name;
    private ArrayList<Book> collection;

    public Borrower(String name, ArrayList<Book> collection) {
        this.name = name;
        this.collection = collection;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getCollection() {
        return collection;
    }

    public int collectionSize() {
        return this.collection.size();
    }

    public void addBook(Book book) {
        this.collection.add(book);
    }

}
