package tdt4140.gr1836.app.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class StrengthWorkout implements Serializable{
	public String duration;
	public String date;
	public Map<String,List<String>> excersises;
	public List<Boolean> intensity;
	public String info;

	StrengthWorkout(){
		
	}

	public StrengthWorkout(String value, String string, List<String> bench, List<String> dead, List<String> squat, List<String> hang,
			List<String> press, List<Boolean> intensity2, String text) {
		this.duration=value;
		this.date=string;
		
		this.excersises=new HashMap<>();
		this.excersises.put("Bench Press", bench);
		this.excersises.put("Deadlift", dead);
		this.excersises.put("Squats", squat);
		this.excersises.put("Hangups", hang);
		this.excersises.put("Press", press);
		
		this.intensity=intensity2;
		this.info=text;		
	}
}
