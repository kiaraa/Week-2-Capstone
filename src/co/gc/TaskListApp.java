package co.gc;

import java.util.Scanner;

public class TaskListApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean keepGoing = true;
		
		TaskList taskList = new TaskList();
		System.out.println("Welcome to the task list!");
		while(keepGoing) {
			System.out.println("Please choose an option from the menu below.");
			int input = showMenu(scan);
			keepGoing = handleMenu(input, taskList, scan);
		}

	}

	public static int showMenu(Scanner scan) {
		System.out.println("1. List tasks");
		System.out.println("2. Add task");
		System.out.println("3. Delete task");
		System.out.println("4. Mark task complete");
		System.out.println("5. Quit");
		int input = scan.nextInt();
		scan.nextLine(); //garbage line
		return input;
	}
	
	public static Task getNewTask(Scanner scan) {
		System.out.println("Please enter the team member's name: ");
		String memberName = scan.nextLine();
		
		System.out.println("Please enter a description of the task: ");
		String description = scan.nextLine();
		
		boolean validDate = false;
		String date = "";
		while (validDate == false){
			System.out.println("Please enter the date that the task is due(mm/dd/yyyy): ");
			date = scan.nextLine();
			validDate = validateDate(date);
		}
		Task newTask = new Task(memberName, description, date);
		return newTask;
	}
	
	public static int getTaskToDelete(Scanner scan, TaskList list) {
		list.listTasks();
		System.out.println("Please enter the number of the task you would like to delete.");
		int numToDelete = scan.nextInt() - 1;
		scan.nextLine(); //garbage line
		return numToDelete;
	}
	
	public static int getTaskToComplete(Scanner scan, TaskList list) {
		System.out.println("Congratulations, keep up the good work! Which task did you complete?");
		list.listTasks();
		int numToComplete = scan.nextInt();
		scan.nextLine();//garbage line
		return numToComplete;
	}
	
	public static boolean handleMenu(int selection, TaskList taskList, Scanner scan) {
		switch (selection) {
			case 1:		taskList.listTasks();
						return true;
			
			case 2:		taskList.addTask(getNewTask(scan));
						return true;
						
			case 3:		int taskToDelete = getTaskToDelete(scan, taskList);
						taskList.deleteTask(taskToDelete);
						return true;
						
			case 4:		int completedTask = getTaskToComplete(scan, taskList);
						taskList.getTask(completedTask).setIsComplete(true);
						return true;
						
			case 5:		return false;
			
			default:	System.out.println("Error: Invalid suggestion. Please select from the menu above.");
						return true;
		}
	}
	
	public static boolean validateDate(String date) {
		if (date.matches("\\d{2}\\/\\d{2}\\/\\d{4}")) {
			return true;
		}
		System.out.println("Error: Please enter a date in the mm/dd/yyyy format.");
		return false;
	}
}
