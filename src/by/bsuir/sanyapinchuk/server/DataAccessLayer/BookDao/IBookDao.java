package by.bsuir.sanyapinchuk.server.DataAccessLayer.BookDao;

import java.util.ArrayList;
import by.bsuir.sanyapinchuk.models.Book;

public interface IBookDao {
	
	Boolean delete(Book book);
    Boolean save(Book book);
    ArrayList<Book> getBooks();
    ArrayList<Book> getBooksByTitle(String title);
    ArrayList<Book> getBooksByAuthor(String author);
}
