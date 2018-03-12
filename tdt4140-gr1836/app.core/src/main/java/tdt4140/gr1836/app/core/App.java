package tdt4140.gr1836.app.core;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//import org.apache.log4j.BasicConfigurator;

public class App {
	
	private Database database;
	private User user; 
	private String currentUsername;
	public boolean waitForDatabase;
	
	public App() throws IOException {
		this.database=new Database();
		this.database.init();
		this.user=null;
	}
		
	public void register(String username,String name, int age, String city, String email, String adress,String phone, String password) {
		
		this.user=this.database.register(username, name, age, city, email, adress, phone, password);
	}
	
	public User login(String username, String password) {
		this.waitForDatabase = true;
		int timer=0;
		
		this.database.login(username, password, this);
		//Wait loop while waiting for login, should not last more than 30 seconds before giving error
		while(this.waitForDatabase) {
			try {
				Thread.sleep(300);
				timer+=1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (timer>100) {
				System.out.println("Login took more than 30 seconds, cancel.");
				break;
			}
		}
		return this.user;
	}
	public void deleteUser(String username) {
		this.database.deleteUser(username);
	}
	public void setUser(User user) {
		this.user=user;
	}
	public User getUser() {
		return this.user;
	}

	public void submitStrengthWorkout(String value, String string, List<String> bench, List<String> dead, List<String> squat,
			List<String> hang, List<String> press, List<Boolean> intensity, String text) {
		StrengthWorkout str=new StrengthWorkout(value,string,bench,dead,squat,hang,press,intensity,text);
		this.database.submitStrengthWorkout(str, this);
		
	}

	public void submitCardioWorkout(String text, String string, Map<String, Boolean> activity, List<Boolean> intensity,
			String text2) {
		CardioWorkout cdw=new CardioWorkout(text,string,activity,intensity,text2);
		this.database.submitCardioWorkout(cdw,this);
		
	}
}
