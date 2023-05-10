package services.impl;

import enteties.Order;
import enteties.Product;
import services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

	private static final int DEFAULT_ORDER_CAPACITY = 10;

	private static DefaultOrderManagementService instance;

	private Order[] orders;

	{
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}

	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) {
		if(order == null) {
			return;
		}
		for(int i = 0; i < DEFAULT_ORDER_CAPACITY; i++) {
			if(orders[i] == null) {
				orders[i] = order;
				return;
			}
		}
	}

	@Override
	public Order[] getOrdersByUserId(int userId) {
		int amountOfUserOrders = 0;
		for (Order order : orders) {
			if (order != null && order.getCustomerId() == userId) {
				amountOfUserOrders++;
			}
		}
		Order[] userOrders = new Order[amountOfUserOrders];
		for(int i = 0; i < amountOfUserOrders; i++) {
			userOrders[i] = orders[i];
		}
	return userOrders;
		
		
		
		
	}

	@Override
	public Order[] getOrders() {
		int nonNullOrdersAmount = 0;
		for (Order order : orders) {
			if (order != null) {
				nonNullOrdersAmount++;
			}
		}
		
		Order[] nonNullOrders = new Order[nonNullOrdersAmount];
		for(int i = 0; i < nonNullOrdersAmount; i++) {
			nonNullOrders[i] = orders[i];
		}
	return nonNullOrders;
 	}

	void clearServiceState() {
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}

}
