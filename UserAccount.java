package astraeus_v1;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class UserAccount{
	static String password;
	static String username;
	static boolean created;
	static boolean login;
	static boolean loggedin;
	static boolean loginAdmin;
	static boolean loggedinAdmin;

	public void login() {
		try {
			FileReader fr = null;
			String userpass = username+password;
			if(loginGUI.loginUser==true) {
				fr = new FileReader("UserAccountInfo.txt");
			}
			if(loginGUI.loginUser==false) {
				fr = new FileReader("AdminAccountInfo.txt");
			}
			BufferedReader br=new BufferedReader(fr);
			String line = br.readLine();
			
			StringBuilder sb = new StringBuilder();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			if(everything.contains(userpass)) {
				System.out.println(everything);
				System.out.println("true");
				if(loginGUI.loginUser==true) {
				login=true;
				loggedin = true;
				}
				if(loginGUI.loginUser==false) {
					loginAdmin=true;
					loggedinAdmin = true;
				}
			}else {
				login=false;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void logout() {
		login=false;
		loggedin=false;
		loginAdmin=false;
		loggedinAdmin=false;
	}

	public void changePassword() {

	}
	public UserAccount(String username, String password) {	
	}

	public static void createNewAccount(){
		BufferedWriter write = null;
		if(createAccountGUI.selected==false) {
			try{FileWriter fw = new FileWriter("UserAccountInfo.txt", true);
			write = new BufferedWriter(fw);
			write.write(username + password+";");
			write.close();
			created=true;

			}
			catch (IOException e){
				System.out.println("File not found");
				created=false;
			}
			{
				try {
					if (write != null)
						write.close();
				}
				catch (IOException e){
				}
			}
		}else {
			try{FileWriter fw = new FileWriter("AdminAccountInfo.txt", true);
			write = new BufferedWriter(fw);
			write.write(username + password+";");
			write.close();
			created=true;

			}
			catch (IOException e){
				System.out.println("File not found");
				created=false;
			}
			{
				try {
					if (write != null)
						write.close();
				}
				catch (IOException e){
				}
			}
		}
	}
}
