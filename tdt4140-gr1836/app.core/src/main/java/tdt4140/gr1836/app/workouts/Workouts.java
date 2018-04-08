package tdt4140.gr1836.app.workouts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

@SuppressWarnings("serial")
public class Workouts implements Serializable {
	private Map<String, Workout> Running;
	private Map<String, Workout> Biking;
	private Map<String, Workout> Swimming;

	public Workouts() {

	}

	public ArrayList<TempList> getWorkoutsAsList() {
		ArrayList<TempList> temp = new ArrayList<TempList>();
		if (Running != null) {
			for (String s : Running.keySet()) {
				System.out.println(s);
				TempList tmplist = new TempList(s, "Running", Running.get(s).getPulse(), Running.get(s).getDuration());
				temp.add(tmplist);
			}
		}
		if (Swimming != null) {
			for (String s : Swimming.keySet()) {
				System.out.println(s);
				TempList tmplist = new TempList(s, "Swimming", Swimming.get(s).getPulse(), Swimming.get(s).getDuration());
				temp.add(tmplist);
			}
		}
		if (Biking != null) {
			for (String s : Biking.keySet()) {
				System.out.println(s);
				TempList tmplist = new TempList(s, "Biking", Biking.get(s).getPulse(), Biking.get(s).getDuration());
				temp.add(tmplist);
			}
		}
		return temp;
	}
	public void setWorkouts(Map<String, Workout> Running,Map<String, Workout> Swimming,Map<String, Workout> Biking) {
		this.Running=Running;
		this.Biking=Biking;
		this.Swimming=Swimming;
	}
	public void addRunningWorkout(Workout cw) {
		this.Running.put(cw.getDate(), cw);
	}
	public void addBikingWorkout(Workout cw) {
		this.Biking.put(cw.getDate(), cw);
	}
	public void addSwimmingWorkout(Workout cw) {
		this.Swimming.put(cw.getDate(), cw);
	}
	public Map<String, Workout> getBiking(){
		return this.Biking;
	}
	public Map<String, Workout> getRunning(){
		return this.Running;
	}
	public Map<String, Workout> getSwimming(){
		return this.Swimming;
	}
}
