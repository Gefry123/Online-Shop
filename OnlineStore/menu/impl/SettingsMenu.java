package menu.impl;

import java.util.Scanner;

import configs.ApplicationContext;
import menu.Menu;
import java.util.Scanner;

public class SettingsMenu implements Menu {

	private static final String SETTINGS = "1. Change Password" + System.lineSeparator() + "2. Change Email";

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		Menu menuToNavigate = null;
		if (context.getLoggedInUser() == null) {
			System.out.println("Please, log in or create new account to see list of your orders");
			context.getMainMenu().start();

		}
		loop1: while (true) {
			printMenuHeader();

			Scanner sc = new Scanner(System.in);
			String userInput = sc.next();

			if (userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
				context.getMainMenu().start();
				break;
			} else {
				int inputToInt = Integer.parseInt(userInput);
				switch (inputToInt) {

				case 1:
					menuToNavigate = new ChangePasswordMenu();
					break loop1;
				case 2:
					menuToNavigate = new ChangeEmailMenu();
					break loop1;
				default:
					System.out.println("Only 1, 2 is allowed. Try one more time");
					continue;
				}

			}
		}
		menuToNavigate.start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("*** SETTINGS ***");
		System.out.println("Enter 'menu' if you want to navigate back to the main menu.");
		System.out.println(SETTINGS);
	}

}
