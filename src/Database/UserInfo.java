package Database;

public class UserInfo {
	static String Username;
	static String Password;

	public UserInfo() {

	}

	public UserInfo(String username, String password) {
		UserInfo.Username = username;
		UserInfo.Password = password;
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
