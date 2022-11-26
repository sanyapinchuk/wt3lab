package by.bsuir.sanyapinchuk.server.DataAccessLayer.UserDao;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import by.bsuir.sanyapinchuk.models.User;

public class UserDao implements IUserDao {
	
	private String fileName;
		
	
	public UserDao()
	{
		fileName = getDatabasePath();
	}

	public Boolean delete(String login){
		int counter = 0;
		Boolean flag = false;
		ArrayList<User> users = getUsers();
		
		for (User currentUser : users) {
			if ( (currentUser.getLogin()).equals(login) && !currentUser.getIsAdministrator() ){	
				flag = true;
				break;
			}
			counter++;
		}
		if (flag)
		{
			users.remove(counter);
			try {
				SerializeUsers(users, fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

    public Boolean save(User user) {
    	Boolean flag = false;
		File f = new File(fileName);	
		User searchUser = null;
		ArrayList<User> users = getUsers();		
		
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		for (User currentUser : users) {
			if (currentUser.equals(user))
			{
				searchUser = currentUser;
				break;
			}
		}
		if (searchUser == null)
		{
			users.add(user);
			flag = true;
				
			try {
				SerializeUsers(users, fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		return flag;
    }

    public User getAuthorizeUser(String login, String password) {
    	ArrayList<User> users = getUsers();
		User result = null;
		
		for (User user : users) {
			if ( (user.getPassword().equals(password)) && (user.getLogin().equals(login)) )
			{
				result = user;
				break;
			}
		}
		return result;
    }

    public ArrayList<User> getUsers(){
    	File f = new File(fileName);
		ArrayList<User> users = new ArrayList<User>();
					
		if(f.exists() && !f.isDirectory()) {			
			try {
				users = DeserializeUsers(fileName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
    	return users;
    }

    private void SerializeUsers(ArrayList<User> users,String fileName) throws IOException {
		FileOutputStream fileStream = new FileOutputStream(fileName);	    
	    XMLEncoder encoder = new XMLEncoder(fileStream);
	    
	    encoder.writeObject(users);
	    encoder.close();
	    fileStream.close();
	}	

	@SuppressWarnings("unchecked")
	private ArrayList<User> DeserializeUsers(String fileName) throws IOException, ClassNotFoundException{
		ArrayList<User> result;
		FileInputStream fileStream = new FileInputStream(fileName);   
		XMLDecoder decoder = new XMLDecoder(fileStream);
		
		result = (ArrayList<User>)decoder.readObject();
		decoder.close();
	    fileStream.close();
	    return result;
	}

    private String getDatabasePath(){
    	return new File("").getAbsolutePath()+"\\src\\by\\bsuir\\sanyapinchuk\\server\\database\\UsersDatabase.xml";
	}    
}

