package enteties.impl;

import java.util.Arrays;

import enteties.Order;
import enteties.Product;

public class DefaultOrder implements Order {

	private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;
	
	private String creditCardNumber;
	private Product[] products;
	private int customerId;

	@Override
	public boolean isCreditCardNumberValid(String creditCardNumber) {
		if(creditCardNumber == null) {
			return false;
		}
		if(creditCardNumber.length() != AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER) {
			return false;
		}
			return true;
	}
	

	@Override
	public void setCreditCardNumber(String creditCardNumber) {
		if (creditCardNumber == null) {
			return;
		}
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public void setProducts(Product[] products) {
		this.products = products;
	}

	@Override
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	@Override
	public int getCustomerId() {
		return this.customerId;
	}
	
	@Override
	public String toString() {
		return "Order: customer id - " + this.customerId + "\t" +
				"credit card number - " + this.creditCardNumber + "\t" + 
				"products - " + Arrays.toString(this.products);
	}

	
	
	

}
