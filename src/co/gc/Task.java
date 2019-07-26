package co.gc;

import java.time.LocalDate;

public class Task {
	private String teamMember;
	private String description;
	private LocalDate date;
	private boolean isComplete;
	
	public Task(String teamMemberName, String description, String date) {
		this.teamMember = teamMemberName;
		this.description = description;
		setDate(date);
		this.isComplete = false;
	}
	
	public void setTeamMember(String teamMemberName) {
		this.teamMember = teamMemberName;
	}
	
	public String getTeamMember() {
		return this.teamMember;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDate(String date) {
		String [] userDate = date.split("/");
		this.date = LocalDate.of(Integer.parseInt(userDate[2]), Integer.parseInt(userDate[0]), Integer.parseInt(userDate[1]));
		//if something doesn't work, check the above line first
	}
	
	public void setIsComplete(boolean complete) {
		isComplete = complete;
	}
	
	public boolean getIsComplete() {
		return this.isComplete;
	}
	
	@Override
	public String toString() {
		String dateString = date.getMonth().getValue() + "/" + date.getDayOfMonth() + "/" + date.getYear();
		return "Team member: " + teamMember + ", Description: " + description + ", Due date: " + dateString + ", Complete: " + isComplete; 
	}
	
	
}
