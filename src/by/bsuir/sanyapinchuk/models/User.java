package by.bsuir.sanyapinchuk.models;

import java.io.Serializable;

public class User implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	private String login;
	
	
	private String password;
	
	
	private Boolean isAdministrator;
	
	
	public User(){	
		
	}

	public User(String login,String password,Boolean isAdministrator){
		this.login = login;
		this.password = password;
		this.isAdministrator = isAdministrator;
	}

	public String getLogin(){
		return login;
	}
	

	public void setLogin(String value) {
		login = value;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String value) {
		password = value;
	}

	public Boolean getIsAdministrator(){
		return isAdministrator;
	}

	public void setIsAdministrator(Boolean value) {
		isAdministrator = value;
	}

	@Override
	public boolean equals(Object obj) {
		User user;
		
		if (obj == this) 
			return true;
		if (obj == null || obj.getClass() != this.getClass())
            return false;
		user = (User)obj;
        return ( login == user.login ||
            ( login != null && login.equals(user.getLogin()) ) );
	}

	@Override
	public String toString() {
		String type = (isAdministrator)?"Administrator":"User";
		return  "Login: " + login +
                "\nType: "+ type;
	}
	
}

