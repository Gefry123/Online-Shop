package menu.impl;

import java.util.Arrays;

import java.util.Scanner;
import configs.ApplicationContext;
import enteties.Product;
import menu.Menu;
import services.ProductManagementService;
import services.impl.DefaultProductManagementService;
import enteties.Cart;
import java.lang.Integer;

public class ProductCatalogMenu implements Menu {

	private static final String CHECKOUT_COMMAND = "checkout";
	private ApplicationContext context;
	private ProductManagementService productManagementService;

	{
		context = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
	}

	@Override
	public void start() {
		Menu menuToNavigate = null;
		
	loop1:while(true) {
			printMenuHeader();
			if (context.getLoggedInUser() == null) {
				System.out.println("You are not logged in. Please, sign in or create new account");
				context.getMainMenu().start();
				break;
			}	
			
			{
			printProductsToConsole();
			}
			
			Scanner sc = new Scanner(System.in);
			String userInput = sc.next();
			
			if(userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
				context.getMainMenu().start();
				break;
			}
			if (userInput.equalsIgnoreCase(CHECKOUT_COMMAND)) {
				Cart sessionCart = context.getSessionCart();
				if (sessionCart == null || sessionCart.isEmpty()) {
					System.out.println("Your cart is empty. Please, add product to cart first and then proceed with checkout");
				}
				else {
					menuToNavigate = new CheckoutMenu();
					break;
				}
			}
			else {
				addProductToCart(Integer.parseInt(userInput));
				continue;
			}
		}
		menuToNavigate.start();
	}
	private void printProductsToConsole() {
		Product[] products = productManagementService.getProducts();
		for (Product product : products) {
			System.out.println(product);
		}
	
	}
	private void addProductToCart(int id) {
		Product productToAddToCart = productManagementService.getProductById(id);
		if(productToAddToCart == null) {
			System.out.println("Please, enter product ID if you want to add product to cart. Or enter 'checkout' if you want to proceed with checkout. Or enter 'menu' if you want to navigate back to the main menu.");
			return;
		}
		context.getSessionCart().addProduct(productToAddToCart);
		System.out.printf("Product %s has been added to your cart. "
				+ "If you want to add a new product - enter the product id. "
				+ "If you want to proceed with checkout - enter word "
				+ "'checkout' to console %n", productToAddToCart.getProductName());
	}
	@Override
	public void printMenuHeader() {
		System.out.println("*** PRODUCT CATALOG ***");
		System.out.println("Enter product id to add it to the cart or 'menu' if you want to navigate back to the main menu");
	}

}
