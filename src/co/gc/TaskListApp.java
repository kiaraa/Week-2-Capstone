package co.gc;

import java.util.Scanner;

public class TaskListApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		TaskList taskList = new TaskList();
		System.out.println("Welcome to the task list. Please choose an option below.");
		int input = showMenu(scan);
		handleMenu(input, taskList, scan);
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
		
		System.out.println("Please enter the date that the task is due(mm/dd/yyyy): ");
		String date = scan.nextLine();
		Task newTask = new Task(memberName, description, date);
		System.out.println(newTask); // tester line
		return newTask;
	}
	
	public static void handleMenu(int selection, TaskList taskList, Scanner scan) {
		switch (selection) {
			case 1:		taskList.listTasks();
						break;
			
			case 2:		taskList.addTask(getNewTask(scan));
						break;
		}
	}
}
