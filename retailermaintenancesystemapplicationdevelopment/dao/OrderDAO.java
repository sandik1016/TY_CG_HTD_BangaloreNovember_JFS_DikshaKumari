package com.capgemini.retailermaintenancesystemapplicationdevelopment.dao;

import java.util.List;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.OrderBean;

public interface OrderDAO {
	public boolean addOrder(OrderBean orderBean);
    public OrderBean getOrder(int orderId);
    public List<OrderBean> getAllOrders();
}
