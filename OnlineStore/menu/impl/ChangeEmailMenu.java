package menu.impl;

import java.util.Scanner;

import configs.ApplicationContext;
import menu.Menu;

public class ChangeEmailMenu implements Menu {

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();

		Scanner sc = new Scanner(System.in);
		String userInput = sc.next();
		context.getLoggedInUser().setEmail(userInput);
		System.out.println("Your email has been successfully changed");
		context.getMainMenu().start();
				
	}

	@Override
	public void printMenuHeader() {
		System.out.println("*** EMAIL CHANGE MENU ***");
		System.out.print("Please enter your new email: ");
	}

}
