package enteties.impl;

import enteties.Cart;
import enteties.Product;

public class DefaultCart implements Cart {

	private Product [] products;
	private static int DEFAULT_PRODUCT_CAPACITY = 12;
	
	{
		products = new Product[DEFAULT_PRODUCT_CAPACITY];
	}
	
	@Override
	public boolean isEmpty() {
		if (products == null || products.length == 0) {
		return true;
		}
			for(Product product : products) {
				if(product != null) {
					return false;
				}
			}
			return true;	
	}

	@Override
	public void addProduct(Product product) {
		if(product == null) {
			return;
		}
		for(int i = 0; i < DEFAULT_PRODUCT_CAPACITY; i++) {
			if(products[i] == null) {
				products[i] = product;
				return;
			}
		}
	}

	@Override
	public Product[] getProducts() {
		int numProductsInCart = 0;
		for(Product product : products) {
			if(product != null) {
				numProductsInCart++;
			}
		}
		Product [] productsInCart = new Product [numProductsInCart];
			for(int i = 0; i < numProductsInCart; i++) {
				productsInCart[i] = products[i];
			}
		return productsInCart;
	}

	@Override
	public void clear() {
		products = new Product[DEFAULT_PRODUCT_CAPACITY];
	}

}
