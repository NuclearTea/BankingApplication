package Database;

public class User {
	static String Username;
	static String Password;

	public User() {

	}

	public User(String username, String password) {
		User.Username = username;
		User.Password = password;
	}

	/**
	 * @return the username
	 */
	public static String getUsername() {
		return Username;
	}

	/**
	 * @param username the username to set
	 */
	public static void setUsername(String username) {
		Username = username;
	}

	/**
	 * @return the password
	 */
	public static String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public static void setPassword(String password) {
		Password = password;
	}

	
	
}
