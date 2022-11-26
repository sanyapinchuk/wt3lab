package by.bsuir.sanyapinchuk.server.DataAccessLayer;

import by.bsuir.sanyapinchuk.server.DataAccessLayer.BookDao.BookDao;
import by.bsuir.sanyapinchuk.server.DataAccessLayer.UserDao.UserDao;

public class DaoFactory {
	
	
	private static UserDao userDao = new UserDao();
	
    private static BookDao bookDao = new BookDao();

    public static UserDao getUserDao()
    {
    	return userDao;
    }
    

    public static BookDao getBookDao()
    {
    	return bookDao;
    }
}
