package accmanager;

import java.util.HashMap;

public class AccountManager {

	private HashMap<String, String> accounts;
	
	public AccountManager(){
		accounts = new HashMap<String, String>();
		accounts.put("Patrick", "1234");
		accounts.put("Molly", "FloPup");
	}
	
	public void addUser(String username, String password){
		accounts.put(username, password);
	}
	
	public String getPassword(String username){
		return accounts.get(username);
	}
	
	public boolean checkAccount(String username){
		return accounts.containsKey(username);
	}
}
