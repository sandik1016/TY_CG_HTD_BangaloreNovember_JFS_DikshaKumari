package com.capgemini.retailermaintenancesystemapplicationdevelopment.service;

import java.util.List;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.OrderBean;

public interface OrderService {
	public boolean addOrder(OrderBean orderBean);

	public OrderBean getOrder(int orderId);

	public List<OrderBean> getAllOrders();
}
