package co.gc;

import java.util.ArrayList;

public class TaskList {
	private ArrayList<Task> taskList;
	
	public TaskList() {
		this.taskList = new ArrayList<Task>();
	}
	
	public ArrayList<Task> getTaskList(){
		return this.taskList;
	}
	
	public void addTask(Task task) {
		this.taskList.add(task);
	}
	
	public Task getTask(int index) {
		return taskList.get(index - 1); //the user will start at 1, not 0, hence the subtraction
	}
	
	public void deleteTask(int index) {
		//int trueIndex = index - 1;
		if (index < taskList.size()) {
			taskList.remove(index);
			System.out.println("Task succesfully deleted.");
		}
		else {
			System.out.println("Error: Index is out of range.");
		}
	}
	
	public void listTasks() {
		int taskCount = 1;
		for (Task task: taskList) {
			System.out.println(taskCount + ". " + task);
			taskCount++;
		}
	}
}
