package menu.impl;

import configs.ApplicationContext;
import java.util.Scanner;
import menu.Menu;

public class ChangePasswordMenu implements Menu {

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		while (true) {

			System.out.println("Please enter your current password");

			Scanner sc = new Scanner(System.in);
			String userInput = sc.next();

			if (userInput.equals(context.getLoggedInUser().getPassword())) {
				
				System.out.println("Please enter your new password");
				
				userInput = sc.next();
				
				context.getLoggedInUser().setPassword(userInput);
				System.out.println("Your password was successfuly changed");
				
				context.getMainMenu().start();
				break;
				
			} else {
				System.out.println("Password Incorrect, try again");
				continue;
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("*** PASSWORD CHANGE MENU ***");
	}

}
