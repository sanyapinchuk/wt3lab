package by.bsuir.sanyapinchuk.server.DataAccessLayer.UserDao;

import java.util.ArrayList;
import by.bsuir.sanyapinchuk.models.User;

public interface IUserDao {
	
	Boolean delete(String login);
    Boolean save(User user);
    User getAuthorizeUser(String login, String password);
    ArrayList<User> getUsers();
}
